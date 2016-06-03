package com.xing.gyl.query.business.xsgl;

import java.util.Map;

import com.xing.gyl.query.BaseQuery;

public class XsyddzhibQuery extends BaseQuery{
	private Long xsyddzhubid;// 销售预订单主表ID
	
	public Long getXsyddzhubid() {
		return xsyddzhubid;
	}

	public void setXsyddzhubid(Long xsyddzhubid){
		this.xsyddzhubid = xsyddzhubid;
	}

	@Override
	public Map<String, Object> buildWhere() {
		if (xsyddzhubid != null) {
			this.keyValues.put("xsyddzhub.xsyddzhubid", this.xsyddzhubid);
		}
		return this.keyValues;
	}
}
