package com.xing.gyl.business.xsgl.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xing.gyl.business.xsgl.service.XsyddService;
import com.xing.gyl.domain.business.xsgl.Xsyddzhib;
import com.xing.gyl.domain.business.xsgl.Xsyddzhub;
import com.xing.gyl.query.PageResult;
import com.xing.gyl.query.business.xsgl.XsyddzhibQuery;
import com.xing.gyl.query.business.xsgl.XsyddzhubQuery;

@Controller("xsyddAction")
@Scope("prototype")
public class XsyddAction {
	/**
	 * 主表的查询条件
	 */
	private XsyddzhubQuery query_zhub=new XsyddzhubQuery();
	
	/**
	 * 字表的查询条件
	 */
	private XsyddzhibQuery query_zhib=new XsyddzhibQuery();
	
	/**
	 * 在增加的时候，接受页面上字表的表格中的值
	 */
	List<Xsyddzhib> xsyddzhibs=new ArrayList<Xsyddzhib>();
	
	public List<Xsyddzhib> getXsyddzhibs() {
		return xsyddzhibs;
	}
	public void setXsyddzhibs(List<Xsyddzhib> xsyddzhibs) {
		this.xsyddzhibs = xsyddzhibs;
	}
	public XsyddService getXsyddService() {
		return xsyddService;
	}
	public void setXsyddService(XsyddService xsyddService) {
		this.xsyddService = xsyddService;
	}
	public XsyddzhubQuery getQuery_zhub() {
		return query_zhub;
	}
	public void setQuery_zhub(XsyddzhubQuery query_zhub) {
		this.query_zhub = query_zhub;
	}
	public XsyddzhibQuery getQuery_zhib() {
		return query_zhib;
	}
	public void setQuery_zhib(XsyddzhibQuery query_zhib) {
		this.query_zhib = query_zhib;
	}
	//注入 主表字表查询的service
	@Resource(name=XsyddService.SERVICE_NAME)
	XsyddService xsyddService;
	
	/**
	 * 查询销售预订单
	 */
	public String showXsydd(){
		PageResult<Xsyddzhub> pageResult_zhu=this.xsyddService.getEntrties_zhu(query_zhub);
		PageResult<Xsyddzhib> pageResult_zhi=this.xsyddService.getEntrties_zhi(query_zhib);
		
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhu);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhi);
		return "xsyddList";
	}
	/**
	 * 跳转到添加界面
	 * @return
	 */
	public String addUI(){
		
		return "addUI";
	}
	
	/**
	 * 向销售预订单中添加数据
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String add() throws IllegalAccessException, InvocationTargetException{
		Xsyddzhub xsyddzhub=new Xsyddzhub();
		BeanUtils.copyProperties(xsyddzhub,this.query_zhub);
		//建立主表和子表之间的关系
		xsyddzhub.setXsyddzhibs(new HashSet<Xsyddzhib>(this.xsyddzhibs));
		//设置销售预订单的最新的订单号
		xsyddzhub.setDdh(this.xsyddService.getMax());
		//保存预订单信息
		this.xsyddService.saveEntry_zhu(xsyddzhub);
		return "chain";
	}
}
