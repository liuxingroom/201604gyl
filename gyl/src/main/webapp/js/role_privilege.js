var role_privilege={
	/**
	 * 存放数据
	 */
	data:{
		role:{
			rid:'',
			name:''
		},
		zTreePlugin:''
		
	},
	/**
	 * 存放操作
	 */
	opt:{
		/**
		 * 存放div操作
		 */
		divopt:{
			/*
			 * 显示div隐藏的div
			 */
			showDiv:function(){
				$("div:hidden").show();
			}
		},
		/**
		 * 角色的操作
		 */
		roleopt:{
			/**
			 * 动态加载角色名称
			 */
			showRoleName:function(){
				$("#roleImage").text("角色："+role_privilege.data.role.name);
			}
		},
		/**
		 * 权限树的操作
		 */
		privilege:{
			
			setting:{
				isSimpleData:true,
				treeNodeKey:'id',
				treeNodeParentKey:"pid",
				showLine: true,
				root:{
					isRoot: true,
					nodes: []
				},
				checkable:true
			},
			/**
			 * 加载权限树
			 */
			loadPrivilegeTree:function(){
				/**
                 * 第三个参数为回调函数
                 *    该回调函数是由服务器端触发的，并且是在readyState的值为4,status的值为200的情况下触发的
                 * @param {Object} data 
                 */
				$.post("privilegeAction_showPrivilegeTree.action",{
					rid:role_privilege.data.role.rid
				},function(data){
					role_privilege.data.zTreePlugin=$("#privilegeTree").zTree(role_privilege.opt.privilege.setting,data);
					/**
					 * 等权限树加载完之后  隐藏正在加载的图表  显示权限树的容器
					 */
					$("#loading").hide();
					$("#privilegeTree").show();
					//在权限树加载完之后      全选复选框就可以选择啦
					$("#allchecked").attr("disabled","");
					
					/**
					 * 为全选复选框设置初值 即： 如果权限树上的复选框被全部选中 则全选复选框选中 反之则不选中
					 * $(role_privilege.opt.privilege.isAllCheckedOnPrivilegeTree())为true  
					 * 表示没有权限树没哟被全部选中
					 */
					if($(role_privilege.opt.privilege.isAllCheckedOnPrivilegeTree())){
						$("#allchecked").attr("check",false);
						
					}else{
						$("#allchecked").attr("checked",true);
					}
				});
			},
			/**
			 * 判断权限树上的复选框是否被全部选中
			 */
			isAllCheckedOnPrivilegeTree:function(){
				//获取所有没有被选中的节点
				var array=role_privilege.data.zTreePlugin.getCheckedNodes(false);
				if(array.length==0){
					return true;
				}else{
					return false;
				}
			},
			/**
			 * 保存数据（建立角色和权限的关系）
			 */
			savePrivilege:function(){
				//获取被选中的节点
				var checkNode=role_privilege.data.zTreePlugin.getCheckedNodes(true);
				var checkedStr='';
				//遍历选中的节点   并获取该节点的id
				for(var i=0;i<checkNode.length;i++){
					if(i==checkNode.length-1){
						checkedStr+=checkNode[i].id;
					}else{
						checkedStr+=checkNode[i].id+","
					}
				}
				
				var parameter={
					rid:role_privilege.data.role.rid,
					checkedStr:checkedStr
				}
				
				$.post("privilegeAction_savePrivilege.action",parameter,function(data){
					alert("保存成功");
				});
			}
			
		}
	},
	/**
	 *初始化 
	 */
	init:{
		/**
		 * 初始化数据
		 */
		initData:function(){
			/**
			 * 获取数据角色的数据信息  并放到存放数据的地方
			 */
			var name=$(this).parent().siblings().first("td").text();
			var rid=$(this).parent().siblings("input[type='hidden']").attr("value");
			role_privilege.data.role.rid=rid;
			role_privilege.data.role.name=name;
		},
		/**
		 * 初始换事件
		 */
		initEvent:function(){
			/**
			 * 给设置权限添加click事件
			 */
			$("a").each(function(){
				if($(this).text()=="设置权限"){
					//设置样式  即鼠标放到超链接上箭头变成小手
					$(this).css("cursor","pointer");
					/**
					 * 添加事件
					 */
					$(this).unbind("click");
					$(this).bind("click",function(){
						/**
						 * 1.显示被隐藏的div
						 * 2.加载权限树
						 * 5.对角色原来有的权限进行回显
						 */
						//调用显示div操作
						role_privilege.opt.divopt.showDiv();
						//调用initData方法给role的name和rid赋值
						role_privilege.init.initData.call(this);
						//动态显示角色名称
						role_privilege.opt.roleopt.showRoleName();
						//在加载权限树之前要显示的内容
						$("#loading").show();
						$("#privilegeTree").hide();
						//在树记载完成之前   全选复选框是不能选择的
						$("#allchecked").attr("disabled","disabled");
						//动态加载权限数
						role_privilege.opt.privilege.loadPrivilegeTree();
					});
				}
			});
			/**
			 * 全选复选框事件
		 	*/
			$("#allchecked").unbind("change");
			$("#allchecked").bind("change",function(){
				//如果全选按钮被选中
				if($(this).attr("checked")){//选中树节点上的所有复选框
					role_privilege.data.zTreePlugin.checkAllNodes(true);
				}else{//树上所有的复选框取消选中
					role_privilege.data.zTreePlugin.checkAllNodes(false);
				}
			});
			
			/**
			 * 给保存添加一个click事件
			 */
			$("#savePrivilege").unbind("click");
			$("#savePrivilege").bind("click",function(){
				role_privilege.opt.privilege.savePrivilege();
			});
		}
		
	}
	
};

$().ready(function(){
	role_privilege.init.initEvent();
});
