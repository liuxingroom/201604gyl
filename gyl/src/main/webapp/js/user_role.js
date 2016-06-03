var user_role = {
    /**
     * 数据
     */
    data: {
        user: {
            username: '',
            uid: ''
        },
        checkedStr: '',//被选中的权限树上的复选框的id
        zTreePlugin: ''
    },
    /**
     * 存放操作
     */
    opt: {
        /**
         * 关于div的操作
         */
        divOpt: {
            /*
             * 显示被隐藏的div
             */
            showDiv: function(){
                $("div:hidden").show();
            }
        },
        /**
         * 关于角色的操作
         */
        userOpt: {
            showUserName: function(){
                $("#userImage").text("用户:" + user_role.data.user.username);
            }
        },
        /**
         * 关于权限树
         */
        roleTree: {
            setting: {
                isSimpleData: true,
                treeNodeKey: "rid",
                treeNodeParentKey: "pid",
                showLine: true,
                root: {
                    isRoot: true,
                    nodes: []
                },
                checkable: true,
                callback: {
                    change: function(){
                        if (user_role.opt.roleTree.isAllCheckedOnRoleTree()) {//全部被选中
                            //设置全选复选框的状态为选中
                            $("#allchecked").attr("checked", true);
                        }
                        else {
                            $("#allchecked").attr("checked", false);
                        }
                    }
                }
            },
            loadRoleTree: function(){
                /**
                 * 第三个参数为回调函数
                 *    该回调函数是由服务器端触发的，并且是在readyState的值为4,status的值为200的情况下触发的
                 * @param {Object} data
                 */
                $.post("roleAction_showRoleByUid.action", {
					uid:user_role.data.user.uid
				}, function(data){
                    user_role.data.zTreePlugin = $("#roleTree").zTree(user_role.opt.roleTree.setting, data);
                    /**
                     * 设置显示loading，隐藏权限树
                     */
                    $("#loading").hide();
                    $("#roleTree").show();
                    
                    /**
                     * 设置全选复选框初始化的状态值
                     */
                    if (user_role.opt.roleTree.isAllCheckedOnRoleTree()) {//全部被选中
                        //设置全选复选框的状态为选中
                        $("#allchecked").attr("checked", true);
                    }
                    else {
                        $("#allchecked").attr("checked", false);
                    }
                    
					//设置全选复选框为可用
					$("#allchecked").attr("disabled","");
                });
            },
            /**
             * 判断权限树上的复选框是否被全部选中
             */
            isAllCheckedOnRoleTree: function(){
                var array = user_role.data.zTreePlugin.getCheckedNodes(false);
                if (array.length == 0) {//说明全部被选中
                    return true;
                }
                else {//没有被全部选中
                    return false;
                }
            },
			/**
			 * 建立角色与权限之间的关系
			 */
			saveRole:function(){
				//得到被选中的权限
				var checkedNodes = user_role.data.zTreePlugin.getCheckedNodes(true);
				var checkedStr = "";
				for(var i=0;i<checkedNodes.length;i++){
					if(i==checkedNodes.length-1){
						checkedStr = checkedStr + checkedNodes[i].rid;
					}else{
						checkedStr = checkedStr + checkedNodes[i].rid+",";
					}
				}
				var parameter = {
					uid:user_role.data.user.uid,
					checkedStr:checkedStr
				};
				$.post("roleAction_saveRole.action",parameter,function(data){
					alert("保存成功");
				});
			}
        }
    },
    /**
     * 初始化
     */
    init: {
        //初始化数据
        initData: function(){
            var name = $(this).parent().siblings("td:first").text();
            var uid = $(this).parent().siblings("input[type='hidden']").attr("value");
            user_role.data.user.username = name;
            user_role.data.user.uid = uid;
        },
        //初始化事件
        initEvent: function(){
            /**
             * 给设置权限添加click事件
             */
            $("a").each(function(){
                if ($(this).text() == "设置角色") {
                    $(this).css("cursor", "pointer");
                    $(this).unbind("click");
                    $(this).bind("click", function(){
                        /**
                         * 1、显示被隐藏的div
                         * 2、加载权限树
                         * 3、对角色原来有的权限进行回显
                         */
                        //显示div
                        user_role.opt.divOpt.showDiv();
                        //调用initData方法给role的name和rid赋值
                        user_role.init.initData.call(this);
                        //动态显示角色名称
                        user_role.opt.userOpt.showUserName();
						//设置全选复选框为不可用
						$("#allchecked").attr("disabled","disabled");
                        /**
                         * 设置显示loading，隐藏权限树
                         */
                        $("#loading").show();
                        $("#roleTree").hide();
                        //加载权限树
                        user_role.opt.roleTree.loadRoleTree();
                    });
                }
            });
            
            /**
             * 全选复选框的事件
             */
            $("#allchecked").unbind("change");
            $("#allchecked").bind("change", function(){
                if ($(this).attr("checked")) {//被选中
                    user_role.data.zTreePlugin.checkAllNodes(true);
                }
                else {//未被选中
                    user_role.data.zTreePlugin.checkAllNodes(false);
                }
            });
			
			/**
			 * 给保存按钮添加一个click事件
			 */
			$("#saveRole").unbind("click");
			$("#saveRole").bind("click",function(){
				user_role.opt.roleTree.saveRole();
			});
        }
    }
};

$().ready(function(){
    user_role.init.initEvent();
});
