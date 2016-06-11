/**
 * @author liuzhuanghong
 */
package com.steven.tutorial.web.domain;

import java.util.List;

/**
 * 表格对象类，用于学习复合型的Json转换操作
 * 
 * @author liuzhuanghong
 * @param <T>
 *
 */
public class TableData<T> {
	private String tableName;

	private List<T> tableData;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<T> getTableData() {
		return tableData;
	}

	public void setTableData(List<T> tableData) {
		this.tableData = tableData;
	}
}
