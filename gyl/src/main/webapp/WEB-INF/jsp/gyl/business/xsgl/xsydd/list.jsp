<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/gyl/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<!--
    jquery日期样式的导入
-->
<link rel="stylesheet" href="js/jquery.datepick.css" type="text/css">
<script type="text/javascript" src="js/jquery.datepick.js"></script>
<script type="text/javascript" src="js/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript" src="js/GylUtils.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
			$("body").data("url","xsyddAction_showXsydd.action?query_zhib.xsyddzhubid=");
			//点击主表中的某一行加载子表
			GylUtils.business.zhubTRClick();
			GylUtils.business.disPage.zhubDispageEvent();
			GylUtils.business.disPage.zhibDispageEvent();
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#dhrq').datepick({dateFormat: 'yy-mm-dd'}); 
			//$('#sxrq').datepick({dateFormat: 'yy-mm-dd'}); 
	});
	$(function(){
		$('.tab li').mouseover(function(){
			var num = $(this).index()-1;
			$(this).addClass('current').siblings().removeClass();
			$('this:eq(num)').remove('span');
		})
	})
	$(function(){
		$('li').mouseover(function(){
			$(this).addClass('current').siblings().removeClass('current');
		})
	})
	function data(){
		window.open("customer.html",100,200);
	}
</script>
</head>
<body>
<table id="wrap">
	<s:form action="xsyddAction_showXsydd.action">
	<tr>
    	<td id="rig_top" >
            <div   style="overflow:auto; height:190px; width:1150px;">
            <table class="content" style="font-size:12px;">
                <tr>
                    <td class="one" style="color:#00F;">单据号</td>
                    <td class="inp"><s:textfield name="query_zhub.ddh"/></td>
                    <td class="one" style="width:66px;">订货日期</td>
                    <td class="inp"><s:textfield name="query_zhub.dhrq" id="dhrq"></s:textfield></td>
                </tr>
                <tr>
                    <td style="color:#00F">客户名称</td>
                    <td class="inp"><s:textfield name="query_zhub.khmc"/></td>
                </tr>
                <tr>
                    <td class="one" style="color:#00F">销售部门</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                    <td class="one" style="color:#00F">业务员</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                </tr>
                <tr>
                    <td class="one" style="color:#00F">审批人</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
					<td class="one" style="width:66px;">审批日期</td>
                    <td class="inp"><input type="text" id='dhrq'/></td>
                </tr>
				<tr>
					<td class="one" style="color:#00F">制单人</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
					<td class="one" style="width:66px;">制单日期</td>
                    <td class="inp"><input type="text"/></td>
					<td class="one" style="color:#00F">修改人</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
				</tr>
				<tr>
					<td class="one" style="width:66px;">修改日期</td>
                    <td class="inp"><input type="text"/></td>
				</tr>
				<tr>
                	<td colspan="5"></td>
                    <td height="40" align="center"><input type="submit" value="查询" class="search"/></td>
                </tr>
            </table>
           </div>
		</td>
    </tr>
	<tr>
    	<td id="rig_top" >
            <div   style="overflow:auto; height:230px; width:1150px;">
            <table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="2000"  style="font-size:12px;">
                <tr class="one">
                    <td width="100">单据号</td>
                    <td width="90">订货日期</td>
                    <td width="180">客户名称</td>
                    <td style="color:#00F;" width="90">销售部门</td>
                    <td  width="90">业务员</td>
					<td  width="180">预订单状态</td>
                </tr>
                <!-- 
                	pageResult_zhub.rows  List<Xsyddzhub>
                 -->
                <s:iterator value="#pageResult_zhub.rows" status="st">
                	<!-- 
                		field属性是用来确认是主表的tr
                	 -->
	                <tr field="item_zhub" id="${xsyddzhubid}">
	                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="ddh"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="dhrq"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="khmc"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="xsbm"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="ywy"/></td>
					   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="state"/></td>
	                </tr>
                </s:iterator>
                <tr>
                   <td style="border:0"></td>
                </tr>
              </table>
               <p style="width:1800px; height:20px;font-size:12px;">
	<span class="page" style="float:right">
		<input type="button" param="1" flag="zhub_firstPage" value="首页"/>&nbsp;<input type="button" flag="zhub_prePage" param="${pageResult_zhub.currentPage-1}" value="上一页" />&nbsp;<input type="button" param="${pageResult_zhub.currentPage+1}" flag="zhub_nextPage" last="${pageResult_zhub.totalPages}"  value="下一页"/>&nbsp;<input type="button" param="${pageResult_zhub.totalPages}" flag="zhub_lastPage" value="尾页"/>&nbsp;<span>转到第<input name="query_zhub.currentPage" id="pageNo" type="text" value="${pageResult_zhub.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 </span>&nbsp;&nbsp;<input type="button" value="转" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${pageResult_zhub.totalRows}条记录，当前第 ${pageResult_zhub.currentPage}/${pageResult_zhub.totalPages}页</p>
           </div>
		</td>
    </tr>
    
    <tr>
    	<td id="right_center" >
            <div  style="height:213px; width:1150px; overflow:auto;">
            <table cellspacing="0" cellpadding="0"  id="maintain-right"  style="font-size:12px;" width="2000">
                <tr class="two" align="center">
                  	<td style="width:10px; border-right:0">&nbsp;</td>
                    <td width="50">行号</td>
                    <td style="color:#00F;border:1px solid #9EB6CE; border-left:0;"" width="100">商品编码</td>
                    <td width="200">商品名称</td>
                    <td width="100">型号</td>
                    <td width="100">单位</td>
                    <td width="100">数量</td>
                    <td width="100">税率</td>
                    <td width="100">单品扣率</td>
					<td width="100">无税单价</td>
					<td width="100">含税单价</td>
					<td width="100">无税金额</td>
					<td width="100">含税金额</td>
					<td width="100">税额</td>
					<td width="200">折扣额</td>
					<td width="200">收货单位</td>
                </tr>
               
               
               <!-- 
               		创建一个隐藏域,保存点击的主表的id
                -->
                <s:hidden name="query_zhib.xsyddzhubid"></s:hidden>
                <s:iterator value="#pageResult_zhib.rows" status="st1">
                <!-- 
                	当点击主表中的某一行的时候，加载子表中的内容，当对子表加载上一页或者下一页的时候，应该针对主表中的某一行加载
                	所以在子表分页的时候，应该传递一个参数：主表的id
                 -->
                <tr class="other">
                   <td align="center" style="background:#E2E2E2;height:19px; border:0; border-right:1px solid #9EB6CE; border-bottom:1px solid #9EB6CE;"><s:property value="#st1.index"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="hh"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="spbm"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="spmc"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="xh"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="jldw"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="sl"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="shulv"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="dpkl"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="wsdj"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="hsdj"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="wsje"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="hsje"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="se"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="zke"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="shdw"/></td>
                </tr>
                </s:iterator>
                
                <tr class="other">
                   <td style="border:0"></td>
                </tr>
            </table>
            <p style="width:1800px; height:20px;font-size:12px;">
	<span class="page" style="float:right">
		<input type="button" param="1" flag="zhib_firstPage" value="首页"/>&nbsp;<input type="button" flag="zhib_prePage" param="${pageResult_zhib.currentPage-1}" value="上一页" />&nbsp;<input type="button" flag="zhib_nextPage" param="${pageResult_zhib.currentPage+1}" last="${pageResult_zhib.totalPages}" value="下一页"/>&nbsp;<input type="button" flag="zhib_lastPage" param="${pageResult_zhib.totalPages}"  value="尾页"/>&nbsp;<span>转到第<input name="query_zhib.currentPage" id="pageNo_zhib" type="text" value="${pageResult_zhib.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 </span>&nbsp;&nbsp;<input type="button" value="转" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${pageResult_zhib.totalRows}条记录，当前第 ${pageResult_zhib.currentPage}/${pageResult_zhib.totalPages}页</p>
           </div>
    	</td>
    </tr>
    </s:form>
    <tr>
    	<td id="mantain-bot">
            <div class="last"></div>
        </td>
    </tr>
</table>
</body>
</html>
