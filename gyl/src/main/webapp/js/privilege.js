var privilege = {
	setting:{
		isSimpleData: true,
		treeNodeKey: "id",
		treeNodeParentKey: "pid",
		showLine: true,
		root:{ 
			isRoot:true,
			nodes:[]
		}
	},
	/**
	 * 加载树
	 */
	loadPrivilegeTree:function(){
		$.post("privilegeAction_showMenuitemTreeByUid.action",null,function(data){
			$("#tree").zTree(privilege.setting,data);
		});
	}
};

$().ready(function(){
	privilege.loadPrivilegeTree();
});
