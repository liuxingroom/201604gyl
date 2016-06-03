(function(jQuery){
	/**
	 * 可以删除多行  如果页面上的删除采用<input type="button" value="删除">这种形式
	 * 删除的插件 
	 * 在jQuery原型上添加事件（添加的是全局事件）
	 */
	$.deleteObj=function(config){
		/**
		 * config.id代表删除按钮id的值
		 */
		$("#"+config.id).unbind("click");
		$("#"+config.id).bind("click",function(){
			if($("input[name='"+config.checkboxname+"']:checked").length==0){
				alert("请先选中在删除");	
			}else{
				if(window.confirm("您确定删除吗？")){
					//选中的所有复选框
					var checkedNodes=$("input[name='"+config.checkboxname+"']:checked");
					var checkedStr="";
					for(var i=0;i<checkedNodes.length;i++){
						if(i==checkedNodes.length-1){
							checkedStr=checkedStr+$(checkedNodes[i]).attr("value");
						}else{
							checkedStr=checkedStr+$(checkedNodes[i]).attr("value")+",";
						}
					}
					window.location.href=config.url+"?checkedStr="+checkedStr;
				}
			}
		});
		
		/**
		 * 触发最上面的checkbox事件
		 * 	如果该checkbox被选中，则下面的所有的checkbox被选中
		 *  如果该checkbox没有被选中，下面的所有checkbox不被选中
		 */
		$("#"+config.controlCheckBox).unbind("click");
		$("#"+config.controlCheckBox).bind("click",function(){
			$("input[name='"+config.checkboxname+"']").attr("checked",$("#"+config.controlCheckBox).attr("checked"));
		});
		
		/**
		 * 表格中checked事件
		 */
		$("input[name='"+config.checkboxname+"']").unbind("click");
		$("input[name='"+config.checkboxname+"']").bind("click",function(){
			if($("input[name="+config.checkboxname+"]:not(:checked)").length==0){//表格中的checkbox被全部选中
				$("#"+config.controlCheckBox).attr("checked",true);
			}else{
				$("#"+config.controlCheckBox).attr("checked",false);
			}
		});
	}
	/**
	 * 可以删除多行  如果页面上的删除采用<input type="submit" value="删除">这种形式
	 */
	$.deleteObjectForm=function(){
		$("input[type='submit']").unbind("click");
		$("input[type='submit']").bind("click",function(){
			if(window.confirm("您确定删除吗?")){
				return true; //返回true表单提交
			}else{
				return false; //返回false表单不提交
			}
		});
	}
	/**
	 *	删除指定的一行
	 * @param {Object} config
	 */
	$.deleteEvent=function(config){
		$("input[value='删除']").unbind("click");
		$("input[value='删除']").bind("click",function(){
			if(window.confirm("您确定删除吗？")){
				//获取点击修改改行的id值
				var id=$(this).parent().siblings().first().children(":input").attr("value");
				window.location.href=config.url+"?"+config.id+"="+id;
			}
		});
	}
})(jQuery);