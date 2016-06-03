package com.xing.gyl.domain.business.xsgl;

import java.io.Serializable;
/**
 * 销售预订单子表
 * @author zd
 *
 */
public class Xsyddzhib implements Serializable{
	private Long xsyddzhibid;//主键
	private Long hh;//行号
	private String spmc;//商品名称
	private String spbm;//商品编码
	private String xh;//型号
	private String jldw;//计量单位
	private Long sl;//数量
	private Float shulv;//税率
	private Float dpkl;//单品扣率
	private Float wsdj;//无税单价
	private Float hsdj;//含税单价
	private Float wsje;//无税金额
	private Float hsje;//含税金额
	private Float se;//税额
	private Float zke;//折扣额
	private String shdw;//收货单位
	
	private Xsyddzhub xsyddzhub;//商品预订单主表

	public String getSpmc() {
		return spmc;
	}

	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}

	public String getSpbm() {
		return spbm;
	}

	public void setSpbm(String spbm) {
		this.spbm = spbm;
	}

	public Long getXsyddzhibid() {
		return xsyddzhibid;
	}

	public void setXsyddzhibid(Long xsyddzhibid) {
		this.xsyddzhibid = xsyddzhibid;
	}

	public Long getHh() {
		return hh;
	}

	public void setHh(Long hh) {
		this.hh = hh;
	}

	
	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getJldw() {
		return jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw;
	}

	public Long getSl() {
		return sl;
	}

	public void setSl(Long sl) {
		this.sl = sl;
	}

	public Float getShulv() {
		return shulv;
	}

	public void setShulv(Float shulv) {
		this.shulv = shulv;
	}

	public Float getDpkl() {
		return dpkl;
	}

	public void setDpkl(Float dpkl) {
		this.dpkl = dpkl;
	}

	public Float getWsdj() {
		return wsdj;
	}

	public void setWsdj(Float wsdj) {
		this.wsdj = wsdj;
	}

	public Float getHsdj() {
		return hsdj;
	}

	public void setHsdj(Float hsdj) {
		this.hsdj = hsdj;
	}

	public Float getWsje() {
		return wsje;
	}

	public void setWsje(Float wsje) {
		this.wsje = wsje;
	}

	public Float getHsje() {
		return hsje;
	}

	public void setHsje(Float hsje) {
		this.hsje = hsje;
	}

	public Float getSe() {
		return se;
	}

	public void setSe(Float se) {
		this.se = se;
	}

	public Float getZke() {
		return zke;
	}

	public void setZke(Float zke) {
		this.zke = zke;
	}

	
	

	public String getShdw() {
		return shdw;
	}

	public void setShdw(String shdw) {
		this.shdw = shdw;
	}

	public Xsyddzhub getXsyddzhub() {
		return xsyddzhub;
	}

	public void setXsyddzhub(Xsyddzhub xsyddzhub) {
		this.xsyddzhub = xsyddzhub;
	}
}
