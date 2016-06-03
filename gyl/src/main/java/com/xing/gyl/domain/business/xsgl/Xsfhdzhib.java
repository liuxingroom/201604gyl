package com.xing.gyl.domain.business.xsgl;

import java.io.Serializable;
import java.util.Date;

/**
 * 销售出库单子表
 * @author zd
 *
 */
public class Xsfhdzhib implements Serializable{
	private Long xsfhdzhibid;//主键
	private Long hh;//行号
	private String spbm;//商品编码
	private String spmc;//商品名称
	private String xh;//型号
	private String dw;//单位
	private Date scrq;//生产日期
	private Date sxrq;//失效日期
	private Long yfsl;//应发数量
	private Long sfsl;//实发数量
	private Float dj;//单价
	private Float je;//金额
	private Date fhrq;//发货日期
	private String zp;//赠品
	private String ytdjh;//源头单据号  销售订单号
	private String lydjh;//来源单据号  销售订单号
	private Long lyhh;//来源行号           销售订单的子表的行号
	private Long ythh;//源头行号           销售订单的子表的行号
	private Long ljfhsl;//累计发货数量  是给发货人查看的,发货人是看不到销售订单的
	private Boolean isfhgb;//是否发货关闭    如果发货的数量和销售订单中子表的相应的行的数量一致，说明发货完毕，设置发货关闭为true
	
	private Xsfhdzhub xsfhdzhub;
	
	public String getSpbm() {
		return spbm;
	}

	public void setSpbm(String spbm) {
		this.spbm = spbm;
	}

	public String getSpmc() {
		return spmc;
	}

	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}

	public Long getLjfhsl() {
		return ljfhsl;
	}

	public void setLjfhsl(Long ljfhsl) {
		this.ljfhsl = ljfhsl;
	}

	public Date getFhrq() {
		return fhrq;
	}

	public void setFhrq(Date fhrq) {
		this.fhrq = fhrq;
	}

	public String getLydjh() {
		return lydjh;
	}

	public void setLydjh(String lydjh) {
		this.lydjh = lydjh;
	}

	public Long getLyhh() {
		return lyhh;
	}

	public void setLyhh(Long lyhh) {
		this.lyhh = lyhh;
	}

	public Xsfhdzhub getXsfhdzhub() {
		return xsfhdzhub;
	}

	public void setXsfhdzhub(Xsfhdzhub xsfhdzhub) {
		this.xsfhdzhub = xsfhdzhub;
	}

	public Long getXsfhdzhibid() {
		return xsfhdzhibid;
	}

	public void setXsfhdzhibid(Long xsfhdzhibid) {
		this.xsfhdzhibid = xsfhdzhibid;
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

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}


	public Date getScrq() {
		return scrq;
	}

	public void setScrq(Date scrq) {
		this.scrq = scrq;
	}

	public Date getSxrq() {
		return sxrq;
	}

	public void setSxrq(Date sxrq) {
		this.sxrq = sxrq;
	}

	public Long getYfsl() {
		return yfsl;
	}

	public void setYfsl(Long yfsl) {
		this.yfsl = yfsl;
	}

	public Long getSfsl() {
		return sfsl;
	}

	public void setSfsl(Long sfsl) {
		this.sfsl = sfsl;
	}

	public Float getDj() {
		return dj;
	}

	public void setDj(Float dj) {
		this.dj = dj;
	}

	public Float getJe() {
		return je;
	}

	public void setJe(Float je) {
		this.je = je;
	}

	

	public String getZp() {
		return zp;
	}

	public void setZp(String zp) {
		this.zp = zp;
	}

	public String getYtdjh() {
		return ytdjh;
	}

	public void setYtdjh(String ytdjh) {
		this.ytdjh = ytdjh;
	}

	public Long getYthh() {
		return ythh;
	}

	public void setYthh(Long ythh) {
		this.ythh = ythh;
	}


	public Boolean getIsfhgb() {
		return isfhgb;
	}

	public void setIsfhgb(Boolean isfhgb) {
		this.isfhgb = isfhgb;
	}
}
