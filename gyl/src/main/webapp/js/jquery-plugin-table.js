/**
 * 该js插件的任务  动态的填充一个表格
 */
(function($){
	$.fn.GridPanel={
		/**
		 * 默认的参数的配置
		 */
		defaultConfig:{
			url:'',
			fields:'' //代表表格有多少列（即： 含有属性item的列对象组成的集合）
		},
		
		/**
		 * 创建表格
		 */
		createTable:function(config){
			/**
			 * 把config中的内容赋值到$.fn.GridPanel.defaultConfig
			 */
			
			$.extend($.fn.GridPanel.defaultConfig,config);
			$.post($.fn.GridPanel.defaultConfig.url,{},function(data){
				$.fn.GridPanel.createTR(data);
			});
			
		},
		
		/**
		 * 创建tr
		 */
		createTR:function(data){
			$.each(data,function(){
				var row=this;
				var $tr=$("<tr/>");
				var fields=$.fn.GridPanel.defaultConfig.fields;
				$.each(fields,function(){
					var $td=$.fn.GridPanel.createTD(this,row);
					$tr.append($td);
				});
				$("#seek table").append($tr);
			});
		},
		createTD:function(field,row){
			if($(field).attr('item')=='radio'){
				var $radio=$("<input/>").attr("type","radio").attr('name',$(field).attr('item'));
				return $("<td/>").attr('item',$(field).attr('item')).append($radio);
			}else{
				return $("<td/>").attr("item",$(field).attr('item')).text(row[$(field).attr('item')]);
			}
		}
	}
	
})($);
