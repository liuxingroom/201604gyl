package com.xing.gyl.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.xing.gyl.query.BaseQuery;

public class DepartmentQuery extends BaseQuery{
	private String name;
	private String description;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Map<String, Object> buildWhere() {
		if(StringUtils.isNotBlank(this.name)){//name属性的值不为空
			this.getKeyValues().put("name", this.name);
		}
		if(StringUtils.isNotBlank(this.description)){//description属性的值不为空
			this.getKeyValues().put("description", this.description);
		}
		return this.getKeyValues();
	}
	
}
