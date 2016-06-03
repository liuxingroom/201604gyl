var roletree={
	/**
	 * 用户存放
	 */
	data:{
		treeNode:"",
		zTreePlugin:''
	},
	setting:{
		isSimpleData:true,
		treeNodeKey:"rid",
		treeNodeParentKey:"pid",
		showLine:true,
		root:{
			isRoot:true,
			nodes:[]		
		},
		callback:{//回调函数  用于右键的监听(即  点击鼠标右键触发该事件)
			 rightClick:function(event, treeId, treeNode){
			 	//设置节点数据信息
				roletree.data.treeNode=treeNode;
			 	//调用显示右键的菜单方法
			 	roletree.showRMenu(event.clientX,event.clientY);
			 }
		}
	},
	loadRoleTree:function(){
		$.post("roleAction_showRoleTree",null,function(data){
			roletree.data.zTreePlugin= $("#roleTree").zTree(roletree.setting,data);
		});
	},
	/**
	 * 显示右键菜单
	 */
	showRMenu:function(x,y){
		//显示隐藏域
		$("#rMenu ul").show();
		//为显示的隐藏域设置样式
		$("#rMenu").css({
			"top":y+"px",
			"left":x+"px",
			"display":"block"
		});
	},
	/**
	 * 添加角色
	 */
	addRole:function(){
		var roleName=window.prompt("请输入角色的名称");
		if(roleName){//如果填写了角色名称
			/**
			 * 在增加一个角色之前，先判断该角色的名字是否可用
			 */
			$.post("roleAction_showRoleByName.action",{
				name:roleName
			},function(data){
				if(data==1){
					var parameter = {
						name: roleName, //设置角色的名字
						pid: roletree.data.treeNode.rid,  //新增加的节点的父节点就是当前的点击节点
						isParent:false //设置该节点是否为父节点  false：表示不是父节点  true：表示是父节点
					};
					/**
					 * 向后台发送请求（往数据库中插入一条记录）
					 */
					$.post("roleAction_add.action",parameter,function(data1){
						var newNode={
							rid:data1.rid,
							name:roleName,
							pid:roletree.data.treeNode.rid,
							isParent:false
						}
						
						/**
						 * roletree.data.zTreePlugin是zTree函数运行后的返回值
						 * roletree.data.treeNode 表示父节点
						 */
						roletree.data.zTreePlugin.addNodes(roletree.data.treeNode,newNode,true);
					});
				}else{
					alert("该角色已经存在");
				}
			});
		}else{//没有填写角色名称
			alert("false");
		}
	},
	/**
	 * 删除角色
	 */
	deleteRole:function(){
		if(window.confirm("您确定删除吗")){
			$.post("roleAction_deleteRole.action",{
				rid:roletree.data.treeNode.rid
			},function(data){
				roletree.data.zTreePlugin.removeNode(roletree.data.treeNode);
			});
		}
	},
	/**
	 * 更新角色信息
	 */
	updateRole:function(){
		var roleName=window.prompt("请填写您要修改的信息",roletree.data.treeNode.name);
		//用来校验角色名是否存在
		if(roletree.data.zTreePlugin.getNodeByParam("name",roleName)){
			alert("该角色名已经存在");
		}else{
			$.post("roleAction_updateRole.action",{
				rid:roletree.data.treeNode.rid,
				name:roleName
			},function(){
				//获取点击的节点
				var node=roletree.data.treeNode;
				//将修改后的值赋值给该节点
				node.name=roleName;
				roletree.data.zTreePlugin.updateNode(node);
				
			});
		}
		
	},
	/**
	 * 增加、修改、删除角色操作添加事件
	 */
	init:{
		initEvent:function(){
			/**
			 * 添加角色事件
			 */
			$("#addRole").unbind("click");
			$("#addRole").bind("click",function(){
				roletree.addRole();
			})
			
			/**
			 * 修改角色事件
			 */
			$("#updateRole").unbind("click");
			$("#updateRole").bind("click",function(){
				roletree.updateRole();
			});
			
			/**
			 * 删除角色事件
			 */
			$("#deleteRole").unbind("click");
			$("#deleteRole").bind("click",function(){
				roletree.deleteRole();
			});
		}
	}
}

$().ready(function(){
	roletree.loadRoleTree();
	$("#rMenu").hover(function(){//进入#rMenu区域的时候做的事情
		
	},function(){//出来该区域的时候做的事情
		//出来右键菜单的区域  右键菜单消失
		//方法一
		$("#rMenu").css("display","none");
		//方法二：
		//$("#rMenu").hide();
	});
	/**
	 * 初始化角色增删改操作
	 */
	roletree.init.initEvent();
});
