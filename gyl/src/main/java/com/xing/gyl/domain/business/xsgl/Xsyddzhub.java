package com.xing.gyl.domain.business.xsgl;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 销售预订单主表
 * @author zd
 *
 */
public class Xsyddzhub implements Serializable{
	private Long xsyddzhubid;//主键
	private String ddh;//订单号
	private Date dhrq;//订货日期
	private String khmc;//客户名称
	private String sxbm;//销售部门
	private String ywy;//业务员
	private String spr;//审批人
	private Date sprq;//审批日期
	private String zdr;//制单人
	private Date zdrq;//制单日期
	private String xgr;//修改人
	private Date xgrq;//修改日期
	private String state;//状态
	
	private Set<Xsyddzhib> xsyddzhibs;

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

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
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

	public Set<Xsyddzhib> getXsyddzhibs() {
		return xsyddzhibs;
	}

	public void setXsyddzhibs(Set<Xsyddzhib> xsyddzhibs) {
		this.xsyddzhibs = xsyddzhibs;
	}
}
