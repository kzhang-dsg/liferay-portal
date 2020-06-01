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

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Adolfo Pérez
 */
public class JSONPortletResponseUtil {

	public static void writeJSON(
			PortletRequest portletRequest, MimeResponse mimeResponse,
			Object jsonObject)
		throws IOException {

		mimeResponse.setContentType(_getContentType(portletRequest));

		PortletResponseUtil.write(mimeResponse, jsonObject.toString());

		mimeResponse.flushBuffer();
	}

	public static void writeJSON(
			PortletRequest portletRequest, PortletResponse portletResponse,
			Object jsonObject)
		throws IOException {

		HttpServletResponse httpServletResponse =
			PortalUtil.getHttpServletResponse(portletResponse);

		httpServletResponse.setContentType(_getContentType(portletRequest));

		ServletResponseUtil.write(httpServletResponse, jsonObject.toString());

		httpServletResponse.flushBuffer();
	}

	private static String _getContentType(PortletRequest portletRequest) {
		String contentType = ContentTypes.APPLICATION_JSON;

		if (BrowserSnifferUtil.isIe(
				PortalUtil.getHttpServletRequest(portletRequest))) {

			contentType = ContentTypes.TEXT_PLAIN;
		}

		return contentType;
	}

}