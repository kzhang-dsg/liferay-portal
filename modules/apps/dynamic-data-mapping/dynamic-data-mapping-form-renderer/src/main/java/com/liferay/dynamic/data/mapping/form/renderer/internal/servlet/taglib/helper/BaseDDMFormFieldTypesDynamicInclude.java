/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.dynamic.data.mapping.form.renderer.internal.servlet.taglib.helper;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeServicesTracker;
import com.liferay.dynamic.data.mapping.form.renderer.internal.servlet.taglib.DDMFormFieldTypesDynamicInclude;
import com.liferay.dynamic.data.mapping.io.DDMFormFieldTypesSerializer;
import com.liferay.dynamic.data.mapping.io.DDMFormFieldTypesSerializerSerializeRequest;
import com.liferay.dynamic.data.mapping.io.DDMFormFieldTypesSerializerSerializeResponse;
import com.liferay.dynamic.data.mapping.io.DDMFormFieldTypesSerializerTracker;
import com.liferay.frontend.js.loader.modules.extender.npm.JSModule;
import com.liferay.frontend.js.loader.modules.extender.npm.JSPackage;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMRegistry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.taglib.BaseDynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.aui.ScriptData;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import java.net.URL;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bruno Basto
 */
public abstract class BaseDDMFormFieldTypesDynamicInclude
	extends BaseDynamicInclude {

	@Activate
	protected void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;
	}

	protected Set<String> getFieldTypesModules(
		List<DDMFormFieldType> ddmFormFieldTypes) {

		Stream<DDMFormFieldType> ddmFormFieldTypeStream =
			ddmFormFieldTypes.stream();

		Set<String> javaScriptPackageNames = ddmFormFieldTypeStream.map(
			this::getJavaScriptPackageName
		).filter(
			this::isValidPackageName
		).collect(
			Collectors.toSet()
		);

		Collection<JSPackage> resolvedJSPackages =
			npmRegistry.getResolvedJSPackages();

		Stream<JSPackage> jsPackagesStream =
			resolvedJSPackages.parallelStream();

		return jsPackagesStream.filter(
			jsPackage -> javaScriptPackageNames.contains(jsPackage.getName())
		).flatMap(
			this::getModulesIdStream
		).collect(
			Collectors.toSet()
		);
	}

	protected String getJavaScriptPackageName(Bundle bundle) throws Exception {
		JSONObject jsonObject = getPackageJSONObject(bundle);

		if (jsonObject == null) {
			return null;
		}

		return jsonObject.getString("name");
	}

	protected String getJavaScriptPackageName(
		DDMFormFieldType ddmFormFieldType) {

		Map<String, Object> ddmFormFieldTypeProperties =
			ddmFormFieldTypeServicesTracker.getDDMFormFieldTypeProperties(
				ddmFormFieldType.getName());

		long bundleId = GetterUtil.getLong(
			ddmFormFieldTypeProperties.get("service.bundleid"), -1L);

		Bundle bundle = _bundleContext.getBundle(bundleId);

		try {
			return getJavaScriptPackageName(bundle);
		}
		catch (Exception e) {
			return StringPool.BLANK;
		}
	}

	protected String getModuleId(JSModule jsModule) {
		return jsModule.getResolvedId();
	}

	protected Stream<String> getModulesIdStream(JSPackage jsPackage) {
		Collection<JSModule> jsModules = jsPackage.getJSModules();

		Stream<JSModule> stream = jsModules.stream();

		return stream.map(this::getModuleId);
	}

	protected JSONObject getPackageJSONObject(Bundle bundle) throws Exception {
		URL url = bundle.getEntry("package.json");

		if (url == null) {
			return null;
		}

		String json = StringUtil.read(url.openStream());

		return JSONFactoryUtil.createJSONObject(json);
	}

	protected void include(HttpServletResponse response) throws IOException {
		ScriptData scriptData = new ScriptData();

		DDMFormFieldTypesSerializer ddmFormFieldTypesSerializer =
			ddmFormFieldTypesSerializerTracker.getDDMFormFieldTypesSerializer(
				"json");

		List<DDMFormFieldType> ddmFormFieldTypes =
			ddmFormFieldTypeServicesTracker.getDDMFormFieldTypes();

		DDMFormFieldTypesSerializerSerializeRequest.Builder builder =
			DDMFormFieldTypesSerializerSerializeRequest.Builder.newBuilder(
				ddmFormFieldTypes);

		DDMFormFieldTypesSerializerSerializeResponse
			ddmFormFieldTypesSerializerSerializeResponse =
				ddmFormFieldTypesSerializer.serialize(builder.build());

		Map<String, String> values = new HashMap<>();

		values.put(
			"fieldTypes",
			ddmFormFieldTypesSerializerSerializeResponse.getContent());

		Set<String> fieldTypesModules = getFieldTypesModules(ddmFormFieldTypes);

		values.put(
			"javaScriptTemplateDependencies",
			jsonFactory.looseSerialize(
				ListUtil.fromCollection(fieldTypesModules)));

		scriptData.append(
			null,
			StringUtil.replaceToStringBundler(
				_TMPL_CONTENT, StringPool.POUND, StringPool.POUND, values),
			_MODULES, ScriptData.ModulesType.AUI);

		scriptData.writeTo(response.getWriter());
	}

	protected boolean isValidPackageName(String packageName) {
		return Validator.isNotNull(packageName);
	}

	@Reference
	protected DDMFormFieldTypeServicesTracker ddmFormFieldTypeServicesTracker;

	@Reference
	protected DDMFormFieldTypesSerializerTracker
		ddmFormFieldTypesSerializerTracker;

	@Reference
	protected JSONFactory jsonFactory;

	@Reference
	protected NPMRegistry npmRegistry;

	private static final String _MODULES =
		"liferay-ddm-form-renderer-types,liferay-ddm-soy-template-util";

	private static final String _TMPL_CONTENT = StringUtil.read(
		DDMFormFieldTypesDynamicInclude.class,
		"/META-INF/resources/dynamic_include/field_types.tmpl");

	private BundleContext _bundleContext;

}