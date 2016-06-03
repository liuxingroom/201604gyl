package com.xing.gyl.basedata.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xing.gyl.base.action.BaseAction;
import com.xing.gyl.basedata.service.ProductService;
import com.xing.gyl.domain.basedata.Product;

@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product>{
	Product product=this.getModel();
	
	//注入商品的Service
	@Resource(name=ProductService.SERVICE_NAME)
	ProductService productService;
	
	public String showProduct(){
		List<Product> products= this.productService.findEntrys();
		ActionContext.getContext().getValueStack().push(products);
		return "SUCCESS";
	}
}
