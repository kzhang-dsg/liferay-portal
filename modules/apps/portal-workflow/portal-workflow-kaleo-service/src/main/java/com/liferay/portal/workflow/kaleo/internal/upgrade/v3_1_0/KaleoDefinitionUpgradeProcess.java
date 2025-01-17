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

package com.liferay.portal.workflow.kaleo.internal.upgrade.v3_1_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.workflow.constants.WorkflowDefinitionConstants;
import com.liferay.portal.workflow.kaleo.internal.upgrade.v3_1_0.util.KaleoDefinitionTable;

import java.sql.PreparedStatement;

/**
 * @author Inácio Nery
 */
public class KaleoDefinitionUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasColumn("KaleoDefinition", "scope")) {
			alter(
				KaleoDefinitionTable.class,
				new AlterTableAddColumn("scope", "VARCHAR(75) null"));

			try (PreparedStatement ps = connection.prepareStatement(
					"update KaleoDefinition set scope = ?")) {

				ps.setString(1, WorkflowDefinitionConstants.SCOPE_ALL);

				ps.execute();
			}
		}
	}

}