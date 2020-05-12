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

package com.liferay.portlet.social.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.social.kernel.model.SocialActivityAchievement;
import com.liferay.social.kernel.model.SocialActivityAchievementModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the SocialActivityAchievement service. Represents a row in the &quot;SocialActivityAchievement&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SocialActivityAchievementModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SocialActivityAchievementImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialActivityAchievementImpl
 * @generated
 */
public class SocialActivityAchievementModelImpl
	extends BaseModelImpl<SocialActivityAchievement>
	implements SocialActivityAchievementModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a social activity achievement model instance should use the <code>SocialActivityAchievement</code> interface instead.
	 */
	public static final String TABLE_NAME = "SocialActivityAchievement";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"activityAchievementId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"createDate", Types.BIGINT},
		{"name", Types.VARCHAR}, {"firstInGroup", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("activityAchievementId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("firstInGroup", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SocialActivityAchievement (mvccVersion LONG default 0 not null,activityAchievementId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,createDate LONG,name VARCHAR(75) null,firstInGroup BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table SocialActivityAchievement";

	public static final String ORDER_BY_JPQL =
		" ORDER BY socialActivityAchievement.activityAchievementId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SocialActivityAchievement.activityAchievementId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.social.kernel.model.SocialActivityAchievement"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.social.kernel.model.SocialActivityAchievement"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.social.kernel.model.SocialActivityAchievement"),
		true);

	public static final long FIRSTINGROUP_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long NAME_COLUMN_BITMASK = 4L;

	public static final long USERID_COLUMN_BITMASK = 8L;

	public static final long ACTIVITYACHIEVEMENTID_COLUMN_BITMASK = 16L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.social.kernel.model.SocialActivityAchievement"));

	public SocialActivityAchievementModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _activityAchievementId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setActivityAchievementId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _activityAchievementId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SocialActivityAchievement.class;
	}

	@Override
	public String getModelClassName() {
		return SocialActivityAchievement.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SocialActivityAchievement, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SocialActivityAchievement, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SocialActivityAchievement, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((SocialActivityAchievement)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SocialActivityAchievement, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SocialActivityAchievement, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SocialActivityAchievement)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SocialActivityAchievement, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SocialActivityAchievement, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, SocialActivityAchievement>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			SocialActivityAchievement.class.getClassLoader(),
			SocialActivityAchievement.class, ModelWrapper.class);

		try {
			Constructor<SocialActivityAchievement> constructor =
				(Constructor<SocialActivityAchievement>)
					proxyClass.getConstructor(InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map
		<String, Function<SocialActivityAchievement, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<SocialActivityAchievement, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<SocialActivityAchievement, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<SocialActivityAchievement, Object>>();
		Map<String, BiConsumer<SocialActivityAchievement, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<SocialActivityAchievement, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", SocialActivityAchievement::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<SocialActivityAchievement, Long>)
				SocialActivityAchievement::setMvccVersion);
		attributeGetterFunctions.put(
			"activityAchievementId",
			SocialActivityAchievement::getActivityAchievementId);
		attributeSetterBiConsumers.put(
			"activityAchievementId",
			(BiConsumer<SocialActivityAchievement, Long>)
				SocialActivityAchievement::setActivityAchievementId);
		attributeGetterFunctions.put(
			"groupId", SocialActivityAchievement::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<SocialActivityAchievement, Long>)
				SocialActivityAchievement::setGroupId);
		attributeGetterFunctions.put(
			"companyId", SocialActivityAchievement::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<SocialActivityAchievement, Long>)
				SocialActivityAchievement::setCompanyId);
		attributeGetterFunctions.put(
			"userId", SocialActivityAchievement::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<SocialActivityAchievement, Long>)
				SocialActivityAchievement::setUserId);
		attributeGetterFunctions.put(
			"createDate", SocialActivityAchievement::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<SocialActivityAchievement, Long>)
				SocialActivityAchievement::setCreateDate);
		attributeGetterFunctions.put(
			"name", SocialActivityAchievement::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<SocialActivityAchievement, String>)
				SocialActivityAchievement::setName);
		attributeGetterFunctions.put(
			"firstInGroup", SocialActivityAchievement::getFirstInGroup);
		attributeSetterBiConsumers.put(
			"firstInGroup",
			(BiConsumer<SocialActivityAchievement, Boolean>)
				SocialActivityAchievement::setFirstInGroup);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@Override
	public long getActivityAchievementId() {
		return _activityAchievementId;
	}

	@Override
	public void setActivityAchievementId(long activityAchievementId) {
		_activityAchievementId = activityAchievementId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public long getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(long createDate) {
		_createDate = createDate;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@Override
	public boolean getFirstInGroup() {
		return _firstInGroup;
	}

	@Override
	public boolean isFirstInGroup() {
		return _firstInGroup;
	}

	@Override
	public void setFirstInGroup(boolean firstInGroup) {
		_columnBitmask |= FIRSTINGROUP_COLUMN_BITMASK;

		if (!_setOriginalFirstInGroup) {
			_setOriginalFirstInGroup = true;

			_originalFirstInGroup = _firstInGroup;
		}

		_firstInGroup = firstInGroup;
	}

	public boolean getOriginalFirstInGroup() {
		return _originalFirstInGroup;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), SocialActivityAchievement.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SocialActivityAchievement toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SocialActivityAchievement>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SocialActivityAchievementImpl socialActivityAchievementImpl =
			new SocialActivityAchievementImpl();

		socialActivityAchievementImpl.setMvccVersion(getMvccVersion());
		socialActivityAchievementImpl.setActivityAchievementId(
			getActivityAchievementId());
		socialActivityAchievementImpl.setGroupId(getGroupId());
		socialActivityAchievementImpl.setCompanyId(getCompanyId());
		socialActivityAchievementImpl.setUserId(getUserId());
		socialActivityAchievementImpl.setCreateDate(getCreateDate());
		socialActivityAchievementImpl.setName(getName());
		socialActivityAchievementImpl.setFirstInGroup(isFirstInGroup());

		socialActivityAchievementImpl.resetOriginalValues();

		return socialActivityAchievementImpl;
	}

	@Override
	public int compareTo(SocialActivityAchievement socialActivityAchievement) {
		long primaryKey = socialActivityAchievement.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialActivityAchievement)) {
			return false;
		}

		SocialActivityAchievement socialActivityAchievement =
			(SocialActivityAchievement)obj;

		long primaryKey = socialActivityAchievement.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		SocialActivityAchievementModelImpl socialActivityAchievementModelImpl =
			this;

		socialActivityAchievementModelImpl._originalGroupId =
			socialActivityAchievementModelImpl._groupId;

		socialActivityAchievementModelImpl._setOriginalGroupId = false;

		socialActivityAchievementModelImpl._originalUserId =
			socialActivityAchievementModelImpl._userId;

		socialActivityAchievementModelImpl._setOriginalUserId = false;

		socialActivityAchievementModelImpl._originalName =
			socialActivityAchievementModelImpl._name;

		socialActivityAchievementModelImpl._originalFirstInGroup =
			socialActivityAchievementModelImpl._firstInGroup;

		socialActivityAchievementModelImpl._setOriginalFirstInGroup = false;

		socialActivityAchievementModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SocialActivityAchievement> toCacheModel() {
		SocialActivityAchievementCacheModel
			socialActivityAchievementCacheModel =
				new SocialActivityAchievementCacheModel();

		socialActivityAchievementCacheModel.mvccVersion = getMvccVersion();

		socialActivityAchievementCacheModel.activityAchievementId =
			getActivityAchievementId();

		socialActivityAchievementCacheModel.groupId = getGroupId();

		socialActivityAchievementCacheModel.companyId = getCompanyId();

		socialActivityAchievementCacheModel.userId = getUserId();

		socialActivityAchievementCacheModel.createDate = getCreateDate();

		socialActivityAchievementCacheModel.name = getName();

		String name = socialActivityAchievementCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			socialActivityAchievementCacheModel.name = null;
		}

		socialActivityAchievementCacheModel.firstInGroup = isFirstInGroup();

		return socialActivityAchievementCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SocialActivityAchievement, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SocialActivityAchievement, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SocialActivityAchievement, Object>
				attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((SocialActivityAchievement)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<SocialActivityAchievement, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SocialActivityAchievement, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SocialActivityAchievement, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((SocialActivityAchievement)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, SocialActivityAchievement>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _activityAchievementId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _createDate;
	private String _name;
	private String _originalName;
	private boolean _firstInGroup;
	private boolean _originalFirstInGroup;
	private boolean _setOriginalFirstInGroup;
	private long _columnBitmask;
	private SocialActivityAchievement _escapedModel;

}