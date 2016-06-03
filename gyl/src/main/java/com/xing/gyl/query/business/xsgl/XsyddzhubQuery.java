package com.xing.gyl.query.business.xsgl;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.xing.gyl.query.BaseQuery;



/**
 * 销售预订单的主表query
 * @author zd
 *
 */
public class XsyddzhubQuery extends BaseQuery {
	private String ddh;// 订单号
	private Date dhrq;// 订货日期
	private Date sxrq;// 失效日期
	private String khmc;// 客户名称
	private Float zdkl;// 整单扣率
	private String sxbm;// 销售部门
	private String ywy;// 业务员
	private String kpdw;// 开票单位
	private String shdq;// 收货地区
	private String shdz;// 收货地址
	private String spr;// 审批人
	private Date sprq;// 审批日期
	private String zdr;// 制单人
	private Date zdrq;// 制单日期
	private String xgr;// 修改人
	private Date xgrq;// 修改日期
	private String state;// 状态
	private Long xsyddzhubid;// 销售预订单主表ID

	private String type;// 判断表的类型，是主表还是子表 1为主表 2为子表

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getXsyddzhubid() {
		return xsyddzhubid;
	}

	public void setXsyddzhubid(Long xsyddzhubid) {
		this.xsyddzhubid = xsyddzhubid;
	}

	public String getDdh() {
		return ddh;
	}

	public void setDdh(String ddh) {
		this.ddh = ddh;
	}

	public Date getDhrq() {
		return dhrq;
	}

	public void setDhrq(Date dhrq) {
		this.dhrq = dhrq;
	}

	public Date getSxrq() {
		return sxrq;
	}

	public void setSxrq(Date sxrq) {
		this.sxrq = sxrq;
	}

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public Float getZdkl() {
		return zdkl;
	}

	public void setZdkl(Float zdkl) {
		this.zdkl = zdkl;
	}

	public String getSxbm() {
		return sxbm;
	}

	public void setSxbm(String sxbm) {
		this.sxbm = sxbm;
	}

	public String getYwy() {
		return ywy;
	}

	public void setYwy(String ywy) {
		this.ywy = ywy;
	}

	public String getKpdw() {
		return kpdw;
	}

	public void setKpdw(String kpdw) {
		this.kpdw = kpdw;
	}

	public String getShdq() {
		return shdq;
	}

	public void setShdq(String shdq) {
		this.shdq = shdq;
	}

	public String getShdz() {
		return shdz;
	}

	public void setShdz(String shdz) {
		this.shdz = shdz;
	}

	public String getSpr() {
		return spr;
	}

	public void setSpr(String spr) {
		this.spr = spr;
	}

	public Date getSprq() {
		return sprq;
	}

	public void setSprq(Date sprq) {
		this.sprq = sprq;
	}

	public String getZdr() {
		return zdr;
	}

	public void setZdr(String zdr) {
		this.zdr = zdr;
	}

	public Date getZdrq() {
		return zdrq;
	}

	public void setZdrq(Date zdrq) {
		this.zdrq = zdrq;
	}

	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

	public Date getXgrq() {
		return xgrq;
	}

	public void setXgrq(Date xgrq) {
		this.xgrq = xgrq;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public Map<String, Object> buildWhere() {
		if (StringUtils.isNotBlank(ddh)) {
			this.keyValues.put("ddh", ddh);
		}
		if (dhrq != null) {
			this.keyValues.put("dhrq", dhrq);
			
		}
		if (sxrq != null) {
			this.keyValues.put("sxrq", sxrq);
		}
		if (StringUtils.isNotBlank(khmc)) {
			this.keyValues.put("khmc", khmc);
		}
		if (zdkl != null) {
			this.keyValues.put("zdkl", zdkl);
		}
		if (StringUtils.isNotBlank(sxbm)) {
			this.keyValues.put("sxbm", sxbm);
		}
		if (StringUtils.isNotBlank(ywy)) {
			this.keyValues.put("ywy", ywy);
		}
		if (StringUtils.isNotBlank(kpdw)) {
			this.keyValues.put("kpdw", kpdw);
		}
		if (StringUtils.isNotBlank(shdq)) {
			this.keyValues.put("shdq","shdq");
		}
		if (StringUtils.isNotBlank(shdz)) {
			this.keyValues.put("shdz", shdz);
		}
		if (StringUtils.isNotBlank(spr)) {
			this.keyValues.put("spr", spr);
		}
		if (sprq != null) {
			this.keyValues.put("sprq", sprq);
		}
		if (StringUtils.isNotBlank(zdr)) {
			this.keyValues.put("zdr", zdr);
		}
		if (zdrq != null) {
			this.keyValues.put("sprq", sprq);
		}
		if (StringUtils.isNotBlank(xgr)) {
			this.keyValues.put("xgr", xgr);
		}
		if (xgrq != null) {
			this.keyValues.put("xgrq", xgrq);
		}
		if (StringUtils.isNotBlank(state)) {
			this.keyValues.put("state", state);
		}
		return this.keyValues;
	}
}
