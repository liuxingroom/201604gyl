package com.xing.gyl.business.xsgl;

import org.junit.Test;

import com.xing.gyl.business.xsgl.service.XsyddService;
import com.xing.gyl.domain.business.xsgl.Xsyddzhib;
import com.xing.gyl.domain.business.xsgl.Xsyddzhub;
import com.xing.gyl.query.PageResult;
import com.xing.gyl.query.business.xsgl.XsyddzhibQuery;
import com.xing.gyl.query.business.xsgl.XsyddzhubQuery;
import com.xing.gyl.test.utils.SpringUtils;


public class XsyddTest extends SpringUtils{
	@Test
	public void testQuery(){
		XsyddService xsyddService = (XsyddService)context.getBean(XsyddService.SERVICE_NAME);
//		XsyddzhubQuery baseQuery = new XsyddzhubQuery();
//		baseQuery.setKhmc("asdf");
//		//baseQuery.setCurrentPage(2);
//		PageResult<Xsyddzhub> pageResult_zhu = xsyddService.getEntrties_zhu(baseQuery);
//		System.out.println(pageResult_zhu.getRows().size());
		
		XsyddzhibQuery xsyddzhibQuery = new XsyddzhibQuery();
		xsyddzhibQuery.setXsyddzhubid(1L);
		//xsyddzhibQuery.setCurrentPage(1);
		PageResult<Xsyddzhib> pageResult = xsyddService.getEntrties_zhi(xsyddzhibQuery);
		System.out.println(pageResult.getRows().size());
	}
}
