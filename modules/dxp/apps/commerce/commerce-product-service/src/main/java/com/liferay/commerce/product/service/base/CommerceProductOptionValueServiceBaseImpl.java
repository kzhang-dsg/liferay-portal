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

package com.liferay.commerce.product.service.base;

import com.liferay.commerce.product.model.CommerceProductOptionValue;
import com.liferay.commerce.product.service.CommerceProductOptionValueService;
import com.liferay.commerce.product.service.persistence.CommerceProductDefinitionOptionRelPersistence;
import com.liferay.commerce.product.service.persistence.CommerceProductDefinitionOptionValueRelPersistence;
import com.liferay.commerce.product.service.persistence.CommerceProductDefinitionPersistence;
import com.liferay.commerce.product.service.persistence.CommerceProductInstancePersistence;
import com.liferay.commerce.product.service.persistence.CommerceProductOptionPersistence;
import com.liferay.commerce.product.service.persistence.CommerceProductOptionValuePersistence;

import com.liferay.expando.kernel.service.persistence.ExpandoRowPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the commerce product option value remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.product.service.impl.CommerceProductOptionValueServiceImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see com.liferay.commerce.product.service.impl.CommerceProductOptionValueServiceImpl
 * @see com.liferay.commerce.product.service.CommerceProductOptionValueServiceUtil
 * @generated
 */
public abstract class CommerceProductOptionValueServiceBaseImpl
	extends BaseServiceImpl implements CommerceProductOptionValueService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.commerce.product.service.CommerceProductOptionValueServiceUtil} to access the commerce product option value remote service.
	 */

	/**
	 * Returns the commerce product definition local service.
	 *
	 * @return the commerce product definition local service
	 */
	public com.liferay.commerce.product.service.CommerceProductDefinitionLocalService getCommerceProductDefinitionLocalService() {
		return commerceProductDefinitionLocalService;
	}

	/**
	 * Sets the commerce product definition local service.
	 *
	 * @param commerceProductDefinitionLocalService the commerce product definition local service
	 */
	public void setCommerceProductDefinitionLocalService(
		com.liferay.commerce.product.service.CommerceProductDefinitionLocalService commerceProductDefinitionLocalService) {
		this.commerceProductDefinitionLocalService = commerceProductDefinitionLocalService;
	}

	/**
	 * Returns the commerce product definition remote service.
	 *
	 * @return the commerce product definition remote service
	 */
	public com.liferay.commerce.product.service.CommerceProductDefinitionService getCommerceProductDefinitionService() {
		return commerceProductDefinitionService;
	}

	/**
	 * Sets the commerce product definition remote service.
	 *
	 * @param commerceProductDefinitionService the commerce product definition remote service
	 */
	public void setCommerceProductDefinitionService(
		com.liferay.commerce.product.service.CommerceProductDefinitionService commerceProductDefinitionService) {
		this.commerceProductDefinitionService = commerceProductDefinitionService;
	}

	/**
	 * Returns the commerce product definition persistence.
	 *
	 * @return the commerce product definition persistence
	 */
	public CommerceProductDefinitionPersistence getCommerceProductDefinitionPersistence() {
		return commerceProductDefinitionPersistence;
	}

	/**
	 * Sets the commerce product definition persistence.
	 *
	 * @param commerceProductDefinitionPersistence the commerce product definition persistence
	 */
	public void setCommerceProductDefinitionPersistence(
		CommerceProductDefinitionPersistence commerceProductDefinitionPersistence) {
		this.commerceProductDefinitionPersistence = commerceProductDefinitionPersistence;
	}

	/**
	 * Returns the commerce product definition option rel local service.
	 *
	 * @return the commerce product definition option rel local service
	 */
	public com.liferay.commerce.product.service.CommerceProductDefinitionOptionRelLocalService getCommerceProductDefinitionOptionRelLocalService() {
		return commerceProductDefinitionOptionRelLocalService;
	}

	/**
	 * Sets the commerce product definition option rel local service.
	 *
	 * @param commerceProductDefinitionOptionRelLocalService the commerce product definition option rel local service
	 */
	public void setCommerceProductDefinitionOptionRelLocalService(
		com.liferay.commerce.product.service.CommerceProductDefinitionOptionRelLocalService commerceProductDefinitionOptionRelLocalService) {
		this.commerceProductDefinitionOptionRelLocalService = commerceProductDefinitionOptionRelLocalService;
	}

	/**
	 * Returns the commerce product definition option rel remote service.
	 *
	 * @return the commerce product definition option rel remote service
	 */
	public com.liferay.commerce.product.service.CommerceProductDefinitionOptionRelService getCommerceProductDefinitionOptionRelService() {
		return commerceProductDefinitionOptionRelService;
	}

	/**
	 * Sets the commerce product definition option rel remote service.
	 *
	 * @param commerceProductDefinitionOptionRelService the commerce product definition option rel remote service
	 */
	public void setCommerceProductDefinitionOptionRelService(
		com.liferay.commerce.product.service.CommerceProductDefinitionOptionRelService commerceProductDefinitionOptionRelService) {
		this.commerceProductDefinitionOptionRelService = commerceProductDefinitionOptionRelService;
	}

	/**
	 * Returns the commerce product definition option rel persistence.
	 *
	 * @return the commerce product definition option rel persistence
	 */
	public CommerceProductDefinitionOptionRelPersistence getCommerceProductDefinitionOptionRelPersistence() {
		return commerceProductDefinitionOptionRelPersistence;
	}

	/**
	 * Sets the commerce product definition option rel persistence.
	 *
	 * @param commerceProductDefinitionOptionRelPersistence the commerce product definition option rel persistence
	 */
	public void setCommerceProductDefinitionOptionRelPersistence(
		CommerceProductDefinitionOptionRelPersistence commerceProductDefinitionOptionRelPersistence) {
		this.commerceProductDefinitionOptionRelPersistence = commerceProductDefinitionOptionRelPersistence;
	}

	/**
	 * Returns the commerce product definition option value rel local service.
	 *
	 * @return the commerce product definition option value rel local service
	 */
	public com.liferay.commerce.product.service.CommerceProductDefinitionOptionValueRelLocalService getCommerceProductDefinitionOptionValueRelLocalService() {
		return commerceProductDefinitionOptionValueRelLocalService;
	}

	/**
	 * Sets the commerce product definition option value rel local service.
	 *
	 * @param commerceProductDefinitionOptionValueRelLocalService the commerce product definition option value rel local service
	 */
	public void setCommerceProductDefinitionOptionValueRelLocalService(
		com.liferay.commerce.product.service.CommerceProductDefinitionOptionValueRelLocalService commerceProductDefinitionOptionValueRelLocalService) {
		this.commerceProductDefinitionOptionValueRelLocalService = commerceProductDefinitionOptionValueRelLocalService;
	}

	/**
	 * Returns the commerce product definition option value rel remote service.
	 *
	 * @return the commerce product definition option value rel remote service
	 */
	public com.liferay.commerce.product.service.CommerceProductDefinitionOptionValueRelService getCommerceProductDefinitionOptionValueRelService() {
		return commerceProductDefinitionOptionValueRelService;
	}

	/**
	 * Sets the commerce product definition option value rel remote service.
	 *
	 * @param commerceProductDefinitionOptionValueRelService the commerce product definition option value rel remote service
	 */
	public void setCommerceProductDefinitionOptionValueRelService(
		com.liferay.commerce.product.service.CommerceProductDefinitionOptionValueRelService commerceProductDefinitionOptionValueRelService) {
		this.commerceProductDefinitionOptionValueRelService = commerceProductDefinitionOptionValueRelService;
	}

	/**
	 * Returns the commerce product definition option value rel persistence.
	 *
	 * @return the commerce product definition option value rel persistence
	 */
	public CommerceProductDefinitionOptionValueRelPersistence getCommerceProductDefinitionOptionValueRelPersistence() {
		return commerceProductDefinitionOptionValueRelPersistence;
	}

	/**
	 * Sets the commerce product definition option value rel persistence.
	 *
	 * @param commerceProductDefinitionOptionValueRelPersistence the commerce product definition option value rel persistence
	 */
	public void setCommerceProductDefinitionOptionValueRelPersistence(
		CommerceProductDefinitionOptionValueRelPersistence commerceProductDefinitionOptionValueRelPersistence) {
		this.commerceProductDefinitionOptionValueRelPersistence = commerceProductDefinitionOptionValueRelPersistence;
	}

	/**
	 * Returns the commerce product instance local service.
	 *
	 * @return the commerce product instance local service
	 */
	public com.liferay.commerce.product.service.CommerceProductInstanceLocalService getCommerceProductInstanceLocalService() {
		return commerceProductInstanceLocalService;
	}

	/**
	 * Sets the commerce product instance local service.
	 *
	 * @param commerceProductInstanceLocalService the commerce product instance local service
	 */
	public void setCommerceProductInstanceLocalService(
		com.liferay.commerce.product.service.CommerceProductInstanceLocalService commerceProductInstanceLocalService) {
		this.commerceProductInstanceLocalService = commerceProductInstanceLocalService;
	}

	/**
	 * Returns the commerce product instance remote service.
	 *
	 * @return the commerce product instance remote service
	 */
	public com.liferay.commerce.product.service.CommerceProductInstanceService getCommerceProductInstanceService() {
		return commerceProductInstanceService;
	}

	/**
	 * Sets the commerce product instance remote service.
	 *
	 * @param commerceProductInstanceService the commerce product instance remote service
	 */
	public void setCommerceProductInstanceService(
		com.liferay.commerce.product.service.CommerceProductInstanceService commerceProductInstanceService) {
		this.commerceProductInstanceService = commerceProductInstanceService;
	}

	/**
	 * Returns the commerce product instance persistence.
	 *
	 * @return the commerce product instance persistence
	 */
	public CommerceProductInstancePersistence getCommerceProductInstancePersistence() {
		return commerceProductInstancePersistence;
	}

	/**
	 * Sets the commerce product instance persistence.
	 *
	 * @param commerceProductInstancePersistence the commerce product instance persistence
	 */
	public void setCommerceProductInstancePersistence(
		CommerceProductInstancePersistence commerceProductInstancePersistence) {
		this.commerceProductInstancePersistence = commerceProductInstancePersistence;
	}

	/**
	 * Returns the commerce product option local service.
	 *
	 * @return the commerce product option local service
	 */
	public com.liferay.commerce.product.service.CommerceProductOptionLocalService getCommerceProductOptionLocalService() {
		return commerceProductOptionLocalService;
	}

	/**
	 * Sets the commerce product option local service.
	 *
	 * @param commerceProductOptionLocalService the commerce product option local service
	 */
	public void setCommerceProductOptionLocalService(
		com.liferay.commerce.product.service.CommerceProductOptionLocalService commerceProductOptionLocalService) {
		this.commerceProductOptionLocalService = commerceProductOptionLocalService;
	}

	/**
	 * Returns the commerce product option remote service.
	 *
	 * @return the commerce product option remote service
	 */
	public com.liferay.commerce.product.service.CommerceProductOptionService getCommerceProductOptionService() {
		return commerceProductOptionService;
	}

	/**
	 * Sets the commerce product option remote service.
	 *
	 * @param commerceProductOptionService the commerce product option remote service
	 */
	public void setCommerceProductOptionService(
		com.liferay.commerce.product.service.CommerceProductOptionService commerceProductOptionService) {
		this.commerceProductOptionService = commerceProductOptionService;
	}

	/**
	 * Returns the commerce product option persistence.
	 *
	 * @return the commerce product option persistence
	 */
	public CommerceProductOptionPersistence getCommerceProductOptionPersistence() {
		return commerceProductOptionPersistence;
	}

	/**
	 * Sets the commerce product option persistence.
	 *
	 * @param commerceProductOptionPersistence the commerce product option persistence
	 */
	public void setCommerceProductOptionPersistence(
		CommerceProductOptionPersistence commerceProductOptionPersistence) {
		this.commerceProductOptionPersistence = commerceProductOptionPersistence;
	}

	/**
	 * Returns the commerce product option value local service.
	 *
	 * @return the commerce product option value local service
	 */
	public com.liferay.commerce.product.service.CommerceProductOptionValueLocalService getCommerceProductOptionValueLocalService() {
		return commerceProductOptionValueLocalService;
	}

	/**
	 * Sets the commerce product option value local service.
	 *
	 * @param commerceProductOptionValueLocalService the commerce product option value local service
	 */
	public void setCommerceProductOptionValueLocalService(
		com.liferay.commerce.product.service.CommerceProductOptionValueLocalService commerceProductOptionValueLocalService) {
		this.commerceProductOptionValueLocalService = commerceProductOptionValueLocalService;
	}

	/**
	 * Returns the commerce product option value remote service.
	 *
	 * @return the commerce product option value remote service
	 */
	public CommerceProductOptionValueService getCommerceProductOptionValueService() {
		return commerceProductOptionValueService;
	}

	/**
	 * Sets the commerce product option value remote service.
	 *
	 * @param commerceProductOptionValueService the commerce product option value remote service
	 */
	public void setCommerceProductOptionValueService(
		CommerceProductOptionValueService commerceProductOptionValueService) {
		this.commerceProductOptionValueService = commerceProductOptionValueService;
	}

	/**
	 * Returns the commerce product option value persistence.
	 *
	 * @return the commerce product option value persistence
	 */
	public CommerceProductOptionValuePersistence getCommerceProductOptionValuePersistence() {
		return commerceProductOptionValuePersistence;
	}

	/**
	 * Sets the commerce product option value persistence.
	 *
	 * @param commerceProductOptionValuePersistence the commerce product option value persistence
	 */
	public void setCommerceProductOptionValuePersistence(
		CommerceProductOptionValuePersistence commerceProductOptionValuePersistence) {
		this.commerceProductOptionValuePersistence = commerceProductOptionValuePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the expando row local service.
	 *
	 * @return the expando row local service
	 */
	public com.liferay.expando.kernel.service.ExpandoRowLocalService getExpandoRowLocalService() {
		return expandoRowLocalService;
	}

	/**
	 * Sets the expando row local service.
	 *
	 * @param expandoRowLocalService the expando row local service
	 */
	public void setExpandoRowLocalService(
		com.liferay.expando.kernel.service.ExpandoRowLocalService expandoRowLocalService) {
		this.expandoRowLocalService = expandoRowLocalService;
	}

	/**
	 * Returns the expando row persistence.
	 *
	 * @return the expando row persistence
	 */
	public ExpandoRowPersistence getExpandoRowPersistence() {
		return expandoRowPersistence;
	}

	/**
	 * Sets the expando row persistence.
	 *
	 * @param expandoRowPersistence the expando row persistence
	 */
	public void setExpandoRowPersistence(
		ExpandoRowPersistence expandoRowPersistence) {
		this.expandoRowPersistence = expandoRowPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommerceProductOptionValueService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceProductOptionValue.class;
	}

	protected String getModelClassName() {
		return CommerceProductOptionValue.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = commerceProductOptionValuePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.commerce.product.service.CommerceProductDefinitionLocalService.class)
	protected com.liferay.commerce.product.service.CommerceProductDefinitionLocalService commerceProductDefinitionLocalService;
	@BeanReference(type = com.liferay.commerce.product.service.CommerceProductDefinitionService.class)
	protected com.liferay.commerce.product.service.CommerceProductDefinitionService commerceProductDefinitionService;
	@BeanReference(type = CommerceProductDefinitionPersistence.class)
	protected CommerceProductDefinitionPersistence commerceProductDefinitionPersistence;
	@BeanReference(type = com.liferay.commerce.product.service.CommerceProductDefinitionOptionRelLocalService.class)
	protected com.liferay.commerce.product.service.CommerceProductDefinitionOptionRelLocalService commerceProductDefinitionOptionRelLocalService;
	@BeanReference(type = com.liferay.commerce.product.service.CommerceProductDefinitionOptionRelService.class)
	protected com.liferay.commerce.product.service.CommerceProductDefinitionOptionRelService commerceProductDefinitionOptionRelService;
	@BeanReference(type = CommerceProductDefinitionOptionRelPersistence.class)
	protected CommerceProductDefinitionOptionRelPersistence commerceProductDefinitionOptionRelPersistence;
	@BeanReference(type = com.liferay.commerce.product.service.CommerceProductDefinitionOptionValueRelLocalService.class)
	protected com.liferay.commerce.product.service.CommerceProductDefinitionOptionValueRelLocalService commerceProductDefinitionOptionValueRelLocalService;
	@BeanReference(type = com.liferay.commerce.product.service.CommerceProductDefinitionOptionValueRelService.class)
	protected com.liferay.commerce.product.service.CommerceProductDefinitionOptionValueRelService commerceProductDefinitionOptionValueRelService;
	@BeanReference(type = CommerceProductDefinitionOptionValueRelPersistence.class)
	protected CommerceProductDefinitionOptionValueRelPersistence commerceProductDefinitionOptionValueRelPersistence;
	@BeanReference(type = com.liferay.commerce.product.service.CommerceProductInstanceLocalService.class)
	protected com.liferay.commerce.product.service.CommerceProductInstanceLocalService commerceProductInstanceLocalService;
	@BeanReference(type = com.liferay.commerce.product.service.CommerceProductInstanceService.class)
	protected com.liferay.commerce.product.service.CommerceProductInstanceService commerceProductInstanceService;
	@BeanReference(type = CommerceProductInstancePersistence.class)
	protected CommerceProductInstancePersistence commerceProductInstancePersistence;
	@BeanReference(type = com.liferay.commerce.product.service.CommerceProductOptionLocalService.class)
	protected com.liferay.commerce.product.service.CommerceProductOptionLocalService commerceProductOptionLocalService;
	@BeanReference(type = com.liferay.commerce.product.service.CommerceProductOptionService.class)
	protected com.liferay.commerce.product.service.CommerceProductOptionService commerceProductOptionService;
	@BeanReference(type = CommerceProductOptionPersistence.class)
	protected CommerceProductOptionPersistence commerceProductOptionPersistence;
	@BeanReference(type = com.liferay.commerce.product.service.CommerceProductOptionValueLocalService.class)
	protected com.liferay.commerce.product.service.CommerceProductOptionValueLocalService commerceProductOptionValueLocalService;
	@BeanReference(type = CommerceProductOptionValueService.class)
	protected CommerceProductOptionValueService commerceProductOptionValueService;
	@BeanReference(type = CommerceProductOptionValuePersistence.class)
	protected CommerceProductOptionValuePersistence commerceProductOptionValuePersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = com.liferay.expando.kernel.service.ExpandoRowLocalService.class)
	protected com.liferay.expando.kernel.service.ExpandoRowLocalService expandoRowLocalService;
	@ServiceReference(type = ExpandoRowPersistence.class)
	protected ExpandoRowPersistence expandoRowPersistence;
}