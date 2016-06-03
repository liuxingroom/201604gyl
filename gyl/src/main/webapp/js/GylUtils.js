var GylUtils={
	/**
	 * 基础数据模块
	 */
	basedata:{
		/**
		 * 基础数据模块的查询页面的的修改的js处理
		 */
		updateObj:{
			updateFunction:function(config){
			
				$.updateEvent(config)
				
			}
		},
		/**
		 * 基础数据模块的查询页面的删除功能的js处理
		 */
		deleteObj:{
			/**
			 * 当页面上的复选框被选中后，点击删除按钮要做的事情
			 */
			deleteFunction:function(config){
				//删除多行
				$.deleteObj(config);
			}
		},
		
		/**
		 * 分页的逻辑
		 */
		dispage:{
			/**
			 * 当点击首页、上一页、下一页、尾页的时候，跳转到的action
			 */
			linkNextPage:function(){
				/**
				 * this为当前的按钮
				 */
				var currentPage=$(this).attr("param");
				//从数据缓存中取出url的值
				var url=$("body").data("url");
				window.location.href=url+"?currentPage="+currentPage;
			}
		},
		/**
		 *初始化事件 
		 */
		initEvent:function(){
			/**
			 * 给首页添加点击事件
			 */
			$("input[flag='firstPage']").unbind("click");
			$("input[flag='firstPage']").bind("click",function(){
				/**
				 * this代表当前的按钮 通过call()   使linkNextPage()方法中的this转变为当前按钮
				 */
				GylUtils.basedata.dispage.linkNextPage.call(this);
			});
			
			/**
			 * 给上一页添加事件
			 */
			$("input[flag='prePage']").unbind("click");
			$("input[flag='prePage']").bind("click",function(){
				if($(this).attr("param")==0){
					alert("已经是第一页啦");
				}else{
					/**
				 	* this代表当前的按钮 通过call()   使linkNextPage()方法中的this转变为当前按钮
				 	*/
					GylUtils.basedata.dispage.linkNextPage.call(this);
				}
				
			});
			
			/**
			 * 给下一页添加事件
			 */
			$("input[flag='nextPage']").unbind("click");
			$("input[flag='nextPage']").bind("click",function(){
				
				if($(this).attr("param")>$(this).attr("last")){
					alert("已经是最后一页啦");
				}else{
					/**
				 	* this代表当前的按钮 通过call()   使linkNextPage()方法中的this转变为当前按钮
				 	*/
					GylUtils.basedata.dispage.linkNextPage.call(this);
				}
			});
			
			/**
			 * 给尾页添加事件
			 */
			$("input[flag='lastPage']").unbind("click");
			$("input[flag='lastPage']").bind("click",function(){
				/**
				 * this代表当前的按钮 通过call()   使linkNextPage()方法中的this转变为当前按钮
				 */
				GylUtils.basedata.dispage.linkNextPage.call(this);
			});
		}
	},
	/**
	 * 权限模块
	 */
	privilege:{
		
	},
	/**
	 * 业务模块
	 */
	business:{
		/**
		 * 所有的业务模块中的add操作
		 */
		add:{
			/**
			 * 计算含税单价、含税金额等
			 */
			accountMoney:function(){
				//数量
				var sl = $(this).parent().siblings("td[item='sl']").children("input").attr("value");
				//税率
				var shulv = $(this).parent().siblings("td[item='shulv']").children("input").attr("value");
				//单品扣率
				var dpkl = $(this).parent().siblings("td[item='dpkl']").children("input").attr("value");
				//无税单价
				var wsdj = $(this).attr("value");
				
				//含税单价
				var hsdj = parseFloat(wsdj)*(1+parseFloat(shulv));
				$(this).parent().siblings("td[item='hsdj']").children("input").attr("value",hsdj);
				
				//无税金额
				var wsje = parseInt(sl)*parseFloat(wsdj);
				$(this).parent().siblings("td[item='wsje']").children("input").attr("value",wsje);
				
				//含税金额
				var hsje = parseFloat(hsdj)*parseInt(sl);
				$(this).parent().siblings("td[item='hsje']").children("input").attr("value",hsje)
				
				//税额
				var se = hsje-wsje;
				$(this).parent().siblings("td[item='se']").children("input").attr("value",se);
				
				//折扣额
				var zke = parseFloat(dpkl)*hsje;
				$(this).parent().siblings("td[item='zke']").children("input").attr("value",zke);
			},
			
			/**
			 * 给无税单价中的td下面的input添加blur事件
			 * 	当该事件触发的时候，含税单价、含税金额、税额、折扣额自动计算
			 */
			wsdjBlurEvent:function(){
				$("td[item='wsdj']").delegate("input","blur",function(){
					GylUtils.business.add.accountMoney.call(this);
				});
			},
			
			/**
			 * 删除一行
			 */
			deleteRow:function(){
				
				if($("#maintain-right").children().children("tr").length>2){
					var $deltr=GylUtils.business.add.divopt.delTr;
					var $nexttr=$deltr.nextAll();
					//如果删除的是最后一个  就直接删除
					if($deltr.children().children("input").attr("value")==$("#maintain-right").children().children("tr").length){
						GylUtils.business.add.divopt.delTr.remove();
					}else{//如果删除的不是不是最后一个
						//遍历删除行一下的所有兄弟节点 使他们的行号减一
						$.each($nexttr,function(){
							//获取行号所对应的输入框（input）
							var $inputHH=$(this).children("td[item='hh']").children("input");
							//使行号减一
							$inputHH.attr("value",parseInt($inputHH.attr("value"))-1);
							
							/**
							 * 修改tr下面的td的name:xsyddzhibs[0].spbm-->xsyddzhibs[1].spbm
							 */
							$(this).children("td").each(function(){
								//如果该列是  商品名称（即item==spmc）
								if($(this).attr("item")=='spmc'){
									var $input=$(this).children("div").children("input");
									//oldNameValue为原来name的值
									var oldNameValue=$input.attr("name");
									var preNameValue=oldNameValue.split("[")[0];
									var midNameValue=oldNameValue.split("[")[1].split("]")[0];
									var nextNameValue=oldNameValue.split("[")[1].split("]")[1];
									var midNameValue=parseInt(midNameValue)-1;
									$input.attr("name",preNameValue+"["+midNameValue+"]"+nextNameValue);
									
								}else{
									var $input=$(this).children("input");
									//原来的name属性值
									var oldNameValue=$input.attr("name");
									var preNameValue=oldNameValue.split("[")[0];
									var midNameValue=oldNameValue.split("[")[1].split("]")[0];
									var nextNameValue=oldNameValue.split("[")[1].split("]")[1];
									var midNameValue=parseInt(midNameValue)-1;
									$input.attr("name",preNameValue+"["+midNameValue+"]"+nextNameValue);
								}
							});
						});
					}
					GylUtils.business.add.divopt.delTr.remove();
				}else{
					alert("只有最后一行，不能再删除啦")
				}
				
			},
			
			/**
			 * 点击添加一行 
			 */
			addRow:function(){
				/**
				 * 修改trClone中的td（行号的）值加1
				 */
				var $trClone=GylUtils.business.add.divopt.trClone;
				//获取行号所对应的输入框（input）
				var $inputHH=$trClone.children("td[item='hh']").children("input");
				//每添加一行行号加1
				$inputHH.attr("value",$("#maintain-right").children().children("tr").length);
				
				/**
				 * 修改tr下面的td的name:xsyddzhibs[0].spbm-->xsyddzhibs[1].spbm
				 */
				//遍历克隆后的tr下的td
				$trClone.children("td").each(function(){
					//如果该列是  商品名称（即item==spmc）
					if($(this).attr("item")=='spmc'){
						var $input=$(this).children("div").children("input");
						//oldNameValue为原来name的值
						var oldNameValue=$input.attr("name");
						var preNameValue=oldNameValue.split("[")[0];
					//	var midNameValue=oldNameValue.split("[")[1].split("]")[0];
						var nextNameValue=oldNameValue.split("[")[1].split("]")[1];
						var midNameValue=parseInt($("#maintain-right").children().children("tr").length-1);
						$input.attr("name",preNameValue+"["+midNameValue+"]"+nextNameValue);
						
					}else{
						var $input=$(this).children("input");
						//原来的name属性值
						var oldNameValue=$input.attr("name");
						var preNameValue=oldNameValue.split("[")[0];
				//		var midNameValue=oldNameValue.split("[")[1].split("]")[0];
						var nextNameValue=oldNameValue.split("[")[1].split("]")[1];
						var midNameValue=parseInt($("#maintain-right").children().children("tr").length-1);
						$input.attr("name",preNameValue+"["+midNameValue+"]"+nextNameValue);
					}
				});
				
				/**
				 * 在table下添加一行
				 */
				$("#right_center table tbody").append(GylUtils.business.add.divopt.trClone);
				//右键菜单隐藏
				$("#menu").hide();
			},
			
			/**
			 * 给右键菜单添加click事件（添加一行）
			 */
			rMenuClickAdd:function(){
				/**
				 * 设置增行点击事件
				 */
				$("#addRow").unbind("click");
				$("#addRow").bind("click",function(){
					GylUtils.business.add.addRow();
				});
				
				/**
				 * 设置删行点击事件
				 */
				$("#deleteRow").unbind("click");
				$("#deleteRow").bind("click",function(){
					GylUtils.business.add.deleteRow();
				});
				
			},
			
			/**
			 * 当鼠标移除菜单区域时  菜单隐藏
			 */
			hideMenu:function(){
				$("#menu").hover(function(){
					
				},function(){
					$("#menu").hide();
				});	
			},
			
			/**
			 * 显示右键菜单
			 */
			showMenu:function(e){
				$("#menu").css("left",e.clientX-50);
				$("#menu").css("top",e.clientY-50);
				$("#menu").show();
			},
				
			/**
			 * 给子表添加右键操作
			 */
			addHhContextMenu:function(){
				/*
				 * 每添加一行 该功能都要填充上去 
				 * 所以使用  delegate()方法
				 */
				$("body").delegate("td[item='hh']","contextmenu",function(e){
					//显示右键菜单
					GylUtils.business.add.showMenu(e);
					//给要删除的行赋值
					GylUtils.business.add.divopt.delTr=$(this).parent();
					return false;
				});
			},
			
			/**
			 * 弹出div框的操作
			 */
			divopt:{
				/**
				 * 用来记住你要删除哪一行
				 */
				delTr:'',
				
				/**
				 * 用于记住你在子表中点击的哪一行
				 */
				tr:'',
				
				/**
				 * 对比tr的克隆
				 */
				trClone:'',
				
				/**
				 * 显示div
				 */
				showDiv:function(){
					
					$("#seek").show();
					$.fn.GridPanel.createTable({
						url:"productJSONAction_showProduct.action",
						//$("#seek *[item]") 获取id为seek 以及含有属性item的所有子元素
						fields:$("#seek *[item]")
					});
				},
				/**
				 * 获取选中的radio，把radio所在的哪行的值填充到主表对应的改行
				 */
				fillValueToField:function(){
					var $radio=$(":radio:checked");//被选中的radio
					//获取改行的所有td对象
					var $td=$radio.parent().siblings("td");//被选中的radio所在的td的所有兄弟节点
					//获取数据要显示哪一行的位置
					var $tr=GylUtils.business.add.divopt.tr;
					$.each($td,function(){//遍历每一个td节点
						var $item=$(this).attr("item");//获取该节点的item属性名
						if($item=='spmc'){//判断是否是第一个td
							$tr.children("[item='"+$item+"']").children("div").children("input").attr("value",$(this).text());
						}else{
							$tr.children("[item='"+$item+"']").children("input").attr("value",$(this).text());
						}
					});
					
					
					
					/*
					 *删除div弹出框中的数据
					 */
					var $tr=$("#seek").find("tr");
					$.each($tr,function(){
						if($(this).attr("class")!='one'){
							$(this).remove();
						}
					});
					
					//在数据填充完  div弹出框关闭
					$("#seek").hide();
				}
			},
			
			/**
			 * 对div弹出框进行初始化事件
			 */
			divProductFrame:{
				/**
				 * 点击商品名称的查询，弹出一个div框
				 */
				divProdctFrameEvent:function(){
					
					$(".searRR").unbind("click");
					$(".searRR").bind("click",function(){
						/**
						 * 在显示div之前克隆该行  为添加一行做准备
						 */
					//	GylUtils.business.add.divOpt.trClone = $(this).parent().parent().parent().clone(true);
						GylUtils.business.add.divopt.trClone=$(this).parent().parent().parent().clone(true);
						/**
						 * 在弹出div框以后，要选择某一个radio，然后把选择的数据回显到字表中，
						 * 所以必须确定子表中的某一行
						 */
						GylUtils.business.add.divopt.showDiv();
						
						/**
						 * 找到要回显到子表中的数据的那一行
						 */
						GylUtils.business.add.divopt.tr=$(this).parent().parent().parent();
					});
//					$("#maintain-right").delegate(".searRR","click",function(){
//						/**
//						 * 在显示div之前克隆该行  为添加一行做准备
//						 */
//						GylUtils.business.add.divopt.trClone=$(this).parent().parent().parent().clone(true)
//						
//						/**
//						 * 在弹出div框以后，要选择某一个radio，然后把选择的数据回显到字表中，
//						 * 所以必须确定子表中的某一行
//						 */
//						GylUtils.business.add.divopt.showDiv();
//						
//						/**
//						 * 找到要回显到子表中的数据的那一行
//						 */
//						GylUtils.business.add.divopt.tr=$(this).parent().parent().parent();
//					});
					
				},
				/**
				 * 给弹出的div框中的确定添加事件
				 */
				divProductFrameSureEvent:function(){
					$(".btn").unbind("click");
					$(".btn").bind("click",function(){
						GylUtils.business.add.divopt.fillValueToField();
						return false;
					});
				}	
			}
		},
		
		/**
		 * 当点击主表中的某一行的处理逻辑
		 */
		getZhiByZhuID:function(){
			var zhuid=$(this).attr("id");
			/**
			 * 把当前点击的主表中的某一行的主表ID赋值给<s:hidden name="query_zhib.xsyddzhubid"></s:hidden>
			 * 当点击子表中的分页的时候，把主表中该行的id的值传递到后台
			 */
			/**
			 * 此处改行可有可无  下边连接只要一提交 值栈栈顶存放的就有query_zhub  query_zhib 两个对象
			 * 下面连接 提交的参数正好为query_zhib 的参数（query_zhib.xsyddzhubid）赋值
			 * 若是字表下次进行分页操作要用到 主表id时  只需要在页面添加一个隐藏域  <s:hidden name="query_zhib.xsyddzhubid"></s:hidden>
			 * 该隐藏域中的值是从值栈中获取的
			 */
		//	$("input[name='query_zhib.xsyddzhubid']").attr("value",zhuid);
			window.location.href=$("body").data("url")+zhuid;
		},
		/**
		 * 给主表中的查询添加click事件
		 */
		zhubTRClick:function(){
			$("tr[field='item_zhub']").unbind("click");
			$("tr[field='item_zhub']").bind("click",function(){
				GylUtils.business.getZhiByZhuID.call(this);
			});
		},
		/**
		 * 业务模块关于分页的事件
		 */
		disPage:{
			/**
			 * 点击主表分页的上一页、下一页、首页、尾页要做的事情
			 */
			zhubLinkHref:function(){
				//获取要跳转的页数
				var currentPage=$(this).attr("param");
				//将当前页赋值给分页控件的表单元素
				$("#pageNo").attr("value",currentPage);
				document.forms[0].submit();
			},
			/**
			 * 点击字表分页的上一页、下一页、首页、尾页要做的事情
			 */
			zhibLinkHref:function(){
				//获取要跳转的页数
				var currentPage=$(this).attr("param");
				//将当前页赋值给分页控件的表单元素
				$("#pageNo_zhib").attr("value",currentPage);
				document.forms[0].submit();
			},
			/**
			 * 主表分页事件
			 */
			zhubDispageEvent:function(){
				/**
				 * 首页
				 */
				$("input[flag='zhub_firstPage']").unbind("click");
				$("input[flag='zhub_firstPage']").bind("click",function(){
					GylUtils.business.disPage.zhubLinkHref.call(this);
				});
				
				/**
				 * 上一页
				 */
				$("input[flag='zhub_prePage']").unbind("click");
				$("input[flag='zhub_prePage']").bind("click",function(){
					if($(this).attr("param")==0){
						alert("已经是第一页啦")
					}else{
						GylUtils.business.disPage.zhubLinkHref.call(this);
					}
					
				});
				
				/**
				 * 下一页 
				 */
				$("input[flag='zhub_nextPage']").unbind("click");
				$("input[flag='zhub_nextPage']").bind("click",function(){
					if($(this).attr("param")>$(this).attr("last")){//判断是否为最后一页
						alert("已经是最后一页啦");
					}else{
						GylUtils.business.disPage.zhubLinkHref.call(this);
					}
				});
				
				/**
				 * 尾页
				 */
				$("input[flag='zhub_lastPage']").unbind("click");
				$("input[flag='zhub_lastPage']").bind("click",function(){
					GylUtils.business.disPage.zhubLinkHref.call(this);
				});
				
			},
			/**
			 * 字表分页事件
			 */
			zhibDispageEvent:function(){
				/**
				 * 首页
				 */
				$("input[flag='zhib_firstPage']").unbind("click");
				$("input[flag='zhib_firstPage']").bind("click",function(){
					GylUtils.business.disPage.zhibLinkHref.call(this);
				});
				
				/**
				 * 上一页
				 */
				$("input[flag='zhib_prePage']").unbind("click");
				$("input[flag='zhib_prePage']").bind("click",function(){
					//判断是是否为第一页
					if($(this).attr("param")==0){
						alert("已经是上一页啦");
					}else{
						GylUtils.business.disPage.zhibLinkHref.call(this);
					}
				});
				
				/**
				 * 下一页
				 */
				$("input[flag='zhib_nextPage']").unbind("click");
				$("input[flag='zhib_nextPage']").bind("click",function(){
					//判断是否为最后一页
					if($(this).attr("param")>$(this).attr("last")){//如果是最后一页
						alert("已经是最后一页啦");
					}else{
						GylUtils.business.disPage.zhibLinkHref.call(this);
					}
				});
				
				/**
				 * 尾页
				 */
				$("input[flag='zhib_lastPage']").unbind("click");
				$("input[flag='zhib_lastPage']").bind("click",function(){
					GylUtils.business.disPage.zhibLinkHref.call(this);
				});
			}
		}
		
	}
};
