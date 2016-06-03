<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/gyl/common/common.jsp"%>
<link type="text/css" rel="stylesheet" href="css/style_customer.css"/>
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
<script type="text/javascript">
	$(document).ready(function(){
	        //在添加的时候，要弹出一个div框选择商品
			GylUtils.business.add.divProductFrame.divProdctFrameEvent();
			//声明一个事件，弹出的div的确定事件
			GylUtils.business.add.divProductFrame.divProductFrameSureEvent();
			//声明一个事件，在行号一栏单击右键弹出一个菜单
			GylUtils.business.add.addHhContextMenu();
			//声明一个事件 ，在右键菜单中添加一行
			GylUtils.business.add.rMenuClickAdd();
			//声明一个事件 ， 当鼠标移出菜单区域范围  右键菜单隐藏
			GylUtils.business.add.hideMenu()
			//当该事件触发的时候，含税单价、含税金额、税额、折扣额自动计算
			GylUtils.business.add.wsdjBlurEvent();
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#dhrq').datepick({dateFormat: 'yy-mm-dd'}); 
			//$('#sxrq').datepick({dateFormat: 'yy-mm-dd'}); 
			
	});
	
	function data(){
		$('#seek').css("display","block");
	}
	
	function allclose(){
		
		/**
			前提：如果在div弹出框弹出  没有选择相应的商品  当关闭后 在次弹出div框  
			出现问题： div框中会出现很多重复数据
			解决方法  在窗口关闭之前  将div弹出框中填充的数据删除
		*/
		var $tr=$("#seek").find("tr");
		$.each($tr,function(){
			if($(this).attr("class")!='one'){
				$(this).remove();
			}
		});
		//关闭div弹出框
		$('#seek').css("display","none");
	}
	
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
</script>
</head>
<body>
<s:form action="xsyddAction_add.action">
<table id="wrap">
	<tr>
    	<td id="rig_top" >
            <div   style="overflow:auto; height:190px;">
            <table class="content" style="font-size:12px;">
                <tr>
                    <td class="one" style="color:#00F">客户名称</td>
                    <td class="inp"><s:textfield id="sxrq" name="query_zhub.khmc" cssClass="current"></s:textfield></td>
                    <td class="one" style="width:66px;">订货日期</td>
                    <td class="inp"><s:textfield id="dhrq" name="query_zhub.dhrq"></s:textfield></td>
                </tr>
                <tr>
                    <td class="one" style="color:#00F">销售部门</td>
                    <td class="inp"><s:textfield name="query_zhub.xsbm" cssClass="current"></s:textfield></td>
                    <td class="one" style="color:#00F">业务员</td>
                    <td class="inp"><s:textfield name="query_zhub.ywy" cssClass="current"></s:textfield></td>
                </tr>
            </table>
           </div>
		</td>
    </tr>
    <tr>
    	<td id="right_center" >
            <div  style="height:213px; width:1150px; overflow:auto;">
            <table cellspacing="0" cellpadding="0"  id="maintain-right"  style="font-size:12px;" width="5000">
                <tr class="two" align="center">
                    <td field="hh">行号</td>
                    <td field="spmc">商品名称</td>
                    <td field="spbm">商品编码</td>
                    <td field="xh">型号</td>
                    <td field="dw">单位</td>
                    <td field="sl">数量</td>
                    <td field="shulv">税率</td>
                    <td field="dpkl">单品扣率</td>
					<td field="wsdj">无税单价</td>
					<td field="hsdj">含税单价</td>
					<td field="wsje">无税金额</td>
					<td field="hsje">含税金额</td>
					<td field="se">税额</td>
					<td field="zke">折扣额</td>
					<td field="shdw">收货单位</td>
                </tr>
                <input type="hidden" id="zhib" value="xsyddzhibs"/>
                <tr align="center">
                    <td style="width:30px; text-align:center; background:#E2E2E2;" item='hh'><input type="text" style="width:100%;" readonly="true" name="xsyddzhibs[0].hh" value="1"/></td>
                    <td class="inp" item="spmc">
                    	<div class="inp_search">
                    		<input type="text" class="bdnone" readonly="readonly" name="xsyddzhibs[0].spmc"/>
                    		<span class="searRR"></span>
                    	</div>
                    	<div id="seek">
                    	 	<div class="seek_con_top">
	                        	<h5>商品信息</h5>
	                            <span class="seek_close" onclick="allclose()"></span>
	                        </div>
	                        <div class="seek_con">
	                        	<div style="overflow:scroll; overflow-x:hidden; height:275px;border:1px solid #898989;width:800px">
	                        		<table cellpadding="0" cellspacing="0">
	                        			<tr class="one">
	                        				<td width="500" item="radio">选择</td>
	                        			 	<td width="500" item="spmc">商品名称</td>
						                    <td width="300" item="xh">商品型号</td>
						                    <td width="300" item="spbm">商品编码</td>
											<td width="300" item="dw">商品单位</td>
											<td width="300" item="shulv">税率</td>
										</tr>
	                        		</table>
	                        	</div>
	                        	<div class="btns">
                                	<button class="btn">确定</button>
                            	</div>
	                        </div>
                    	 </div>
                    </td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="spbm"><input readonly="readonly" type="text" style="width:100%;" name="xsyddzhibs[0].spbm"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="xh"><input readonly="readonly" type="text" style="width:100%;" name="xsyddzhibs[0].xh"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="dw"><input readonly="readonly" type="text" style="width:100%;" name="xsyddzhibs[0].dw"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="sl"><input type="text" style="width:100%;" name="xsyddzhibs[0].sl"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="shulv"><input readonly="readonly" type="text" style="width:100%;" name="xsyddzhibs[0].shulv"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="dpkl"><input type="text" style="width:100%;" name="xsyddzhibs[0].dpkl"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="wsdj"><input type="text" style="width:100%;" name="xsyddzhibs[0].wsdj"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="hsdj"><input type="text" style="width:100%;" readonly="true" name="xsyddzhibs[0].hsdj"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="wsje"><input type="text" style="width:100%;" name="xsyddzhibs[0].wsje"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="hsje"><input type="text" style="width:100%;" readonly="true" name="xsyddzhibs[0].hsje"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="se"><input type="text" style="width:100%;" readonly="true" name="xsyddzhibs[0].se"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="zke"><input type="text" style="width:100%;" readonly="true" name="xsyddzhibs[0].zke"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="shdw"><input type="text" style="width:100%;" name="xsyddzhibs[0].shdw"/></td>
                </tr>
            </table>
           </div>
    	</td>
    </tr>
    <tr>
    	<td id="right-bot">
            <table style="font-size:12px;">
                <tr>
                    <td class="bot_1" style="color:#00F">制单人</td>
                    <td class="inp_1"><s:textfield name="query_zhub.zdr" cssClass="current"></s:textfield></td>
                    <td class="bot_1" style="color:#00F">修订人</td>
                    <td class="inp_1"><s:textfield name="query_zhub.xgr" cssClass="current"></s:textfield></td>
                    <td class="bot_1">审批人</td>
                    <td class="inp_1"><s:textfield name="query_zhub.spr" cssClass="current"></s:textfield></td>
                    <td  width="77px">审批日期</td>
                    <td class="inp_1"><s:textfield name="query_zhub.spsj"></s:textfield></td>
                </tr>
                <tr>
                    <td>制单时间</td>
                    <td class="inp_2"><s:textfield name="query_zhub.zdsj"></s:textfield></td>
                    <td>修订时间</td>
                    <td class="inp_2"><s:textfield name="query_zhub.xgsj"></s:textfield></td>
                    <td>审批时间</td>
                    <td class="inp_2"><s:textfield name="query_zhub.spsj"></s:textfield></td>
                </tr>
            </table>
        </td>
    </tr>
     <tr class="save">
       <td height="30" align="right" style="padding-right"><input type="submit" value="保存" class="search"/></td>
     </tr>
</table>
</s:form>
<ul id="menu" style="position:absolute;display:none;">
   <li id="addRow">增行</li>
   <li id="deleteRow">删行</li>
 </ul>
</body>
</html>
