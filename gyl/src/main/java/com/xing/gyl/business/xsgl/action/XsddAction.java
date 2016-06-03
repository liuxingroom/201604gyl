package com.xing.gyl.business.xsgl.action;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xing.gyl.business.xsgl.service.XsddService;
import com.xing.gyl.domain.business.xsgl.Xsddzhib;
import com.xing.gyl.domain.business.xsgl.Xsddzhub;
import com.xing.gyl.query.PageResult;
import com.xing.gyl.query.business.xsgl.XsddzhibQuery;
import com.xing.gyl.query.business.xsgl.XsddzhubQuery;

@Controller("xsddAction")
@Scope("prototype")
public class XsddAction {
	@Resource(name=XsddService.SERVICE_NAME)
	XsddService xsddService;
	
	/**
	 * 接受主表中的数据
	 */
	private XsddzhubQuery query_zhub=new XsddzhubQuery();
	private XsddzhibQuery query_zhib=new XsddzhibQuery();
	
	/**
	 * 接收销售订单子表的数据
	 * 
	 */
	private List<Xsddzhib> xsddzhibs;
	
	public List<Xsddzhib> getXsddzhibs() {
		return xsddzhibs;
	}
	public void setXsddzhibs(List<Xsddzhib> xsddzhibs) {
		this.xsddzhibs = xsddzhibs;
	}
	public XsddzhubQuery getQuery_zhub() {
		return query_zhub;
	}
	public void setQuery_zhub(XsddzhubQuery query_zhub) {
		this.query_zhub = query_zhub;
	}
	public XsddzhibQuery getQuery_zhib() {
		return query_zhib;
	}
	public void setQuery_zhib(XsddzhibQuery query_zhib) {
		this.query_zhib = query_zhib;
	}
	
	/**
	 * 显示订单
	 */
	public String showXsdd(){
		PageResult<Xsddzhub> pageResult_zhu = this.xsddService.getEntrties_zhu(query_zhub);
		PageResult<Xsddzhib> pageResult_zhi = this.xsddService.getEntrties_zhi(query_zhib);
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhu);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhi);
		return "xsddList";
	}
	

	/**
	 * 跳转到添加界面
	 */
	public String addUI(){
		return "addUI";
	}
	
	/**
	 * 销售订单的添加
	 * @return
	 */
	public String add(){
		Xsddzhub xsddzhub = new Xsddzhub();
		BeanUtils.copyProperties(this.query_zhub, xsddzhub);
		//产生订单号
		xsddzhub.setDdh(this.xsddService.getMax());
		//建立主表和子表的关联
		xsddzhub.setXsddzhibs(new HashSet<Xsddzhib>(this.xsddzhibs));
		this.xsddService.saveEntry_zhu(xsddzhub);
		return "chain";
	}
}
