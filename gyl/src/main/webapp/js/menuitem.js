var menuitem = {
	setting:{
		isSimpleData: true,
		treeNodeKey: "mid",
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
	loadMenuitemTree:function(){
		$.post("menuitemAction_showMenuitemTree.action",{},function(data){
			$("#tree").zTree(menuitem.setting,data);
		});
	}
};

$().ready(function(){
	menuitem.loadMenuitemTree();
});
