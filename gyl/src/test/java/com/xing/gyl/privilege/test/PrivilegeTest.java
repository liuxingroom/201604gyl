package com.xing.gyl.privilege.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xing.gyl.domain.privilege.Privilege;



public class PrivilegeTest {
	@Test
	public void testAddPrivilege(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/xing/gyl/spring/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		 /**
		  * 根节点
		  */
		Privilege PrivilegeFirst = new Privilege();
		//PrivilegeFirst.setMid(1L);
		PrivilegeFirst.setName("供应链管理系统");
		PrivilegeFirst.setPid(0L);
		PrivilegeFirst.setIsParent(true);
		PrivilegeFirst.setIcon("images/003.gif");
		PrivilegeFirst.setType("1");
		session.save(PrivilegeFirst);
		/**
		 * 基础数据
		 */
		Privilege PrivilegeSecond_basedata = new Privilege();
		PrivilegeSecond_basedata.setIcon("images/003.gif");
		PrivilegeSecond_basedata.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeSecond_basedata.setName("基础数据");
		PrivilegeSecond_basedata.setPid(PrivilegeFirst.getId());
		PrivilegeSecond_basedata.setType("1");
		session.save(PrivilegeSecond_basedata);
		
		/**
		 * 基础数据--》部门
		 */
		Privilege PrivilegeThird_department = new Privilege();
		PrivilegeThird_department.setIcon("images/003.gif");
		PrivilegeThird_department.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeThird_department.setName("部门");
		PrivilegeThird_department.setPid(PrivilegeSecond_basedata.getId());
		PrivilegeThird_department.setType("1");
		session.save(PrivilegeThird_department);
		
		/**
		 * 部门-->部门增加
		 */
		Privilege PrivilegeFourth_department_create = new Privilege();
		PrivilegeFourth_department_create.setIcon("images/002.gif");
		PrivilegeFourth_department_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_department_create.setName("部门增加");
		PrivilegeFourth_department_create.setPid(PrivilegeThird_department.getId());
		PrivilegeFourth_department_create.setType("2");
		session.save(PrivilegeFourth_department_create);
		
		/**
		 * 部门-->部门修改
		 */
		Privilege PrivilegeFourth_department_update = new Privilege();
		PrivilegeFourth_department_update.setIcon("images/002.gif");
		PrivilegeFourth_department_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_department_update.setName("部门修改");
		PrivilegeFourth_department_update.setPid(PrivilegeThird_department.getId());
		PrivilegeFourth_department_update.setType("2");
		session.save(PrivilegeFourth_department_update);
		
		/**
		 * 部门-->部门查询
		 */
		Privilege PrivilegeFourth_department_query = new Privilege();
		PrivilegeFourth_department_query.setIcon("images/002.gif");
		PrivilegeFourth_department_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_department_query.setName("部门增加");
		PrivilegeFourth_department_query.setPid(PrivilegeThird_department.getId());
		PrivilegeFourth_department_query.setType("2");
		session.save(PrivilegeFourth_department_query);
		
		/**
		 * 部门-->部门删除
		 */
		Privilege PrivilegeFourth_department_delete = new Privilege();
		PrivilegeFourth_department_delete.setIcon("images/002.gif");
		PrivilegeFourth_department_delete.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_department_delete.setName("部门删除");
		PrivilegeFourth_department_delete.setPid(PrivilegeThird_department.getId());
		PrivilegeFourth_department_delete.setType("2");
		session.save(PrivilegeFourth_department_delete);
		
		
		/**
		 * 基础数据-->用户
		 */
		Privilege PrivilegeThird_user = new Privilege();
		PrivilegeThird_user.setIcon("images/003.gif");
		PrivilegeThird_user.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeThird_user.setName("用户");
		PrivilegeThird_user.setPid(PrivilegeSecond_basedata.getId());
		PrivilegeThird_user.setType("1");
		session.save(PrivilegeThird_user);
		
		/**
		 * 用户-->用户增加
		 */
		Privilege PrivilegeFourth_user_create = new Privilege();
		PrivilegeFourth_user_create.setIcon("images/002.gif");
		PrivilegeFourth_user_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_user_create.setName("用户增加");
		PrivilegeFourth_user_create.setPid(PrivilegeThird_user.getId());
		PrivilegeFourth_user_create.setType("2");
		session.save(PrivilegeFourth_user_create);
		
		/**
		 * 用户-->用户修改
		 */
		Privilege PrivilegeFourth_user_update = new Privilege();
		PrivilegeFourth_user_update.setIcon("images/002.gif");
		PrivilegeFourth_user_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_user_update.setName("用户修改");
		PrivilegeFourth_user_update.setPid(PrivilegeThird_user.getId());
		PrivilegeFourth_user_update.setType("2");
		session.save(PrivilegeFourth_user_update);
		
		/**
		 * 用户-->用户删除
		 */
		Privilege PrivilegeFourth_user_delete = new Privilege();
		PrivilegeFourth_user_delete.setIcon("images/002.gif");
		PrivilegeFourth_user_delete.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_user_delete.setName("用户删除");
		PrivilegeFourth_user_delete.setPid(PrivilegeThird_user.getId());
		PrivilegeFourth_user_delete.setType("2");
		session.save(PrivilegeFourth_user_delete);
		
		/**
		 * 用户-->用户查询
		 */
		Privilege PrivilegeFourth_user_query = new Privilege();
		PrivilegeFourth_user_query.setIcon("images/002.gif");
		PrivilegeFourth_user_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_user_query.setName("用户查询");
		PrivilegeFourth_user_query.setPid(PrivilegeThird_user.getId());
		PrivilegeFourth_user_query.setType("2");
		session.save(PrivilegeFourth_user_query);
		
		
		/**
		 * 基础数据-->角色
		 */
		Privilege PrivilegeThird_role = new Privilege();
		PrivilegeThird_role.setIcon("images/003.gif");
		PrivilegeThird_role.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeThird_role.setName("角色");
		PrivilegeThird_role.setPid(PrivilegeSecond_basedata.getId());
		PrivilegeThird_role.setType("1");
		session.save(PrivilegeThird_role);
		
		/**
		 * 角色-->角色增加
		 */
		Privilege PrivilegeFourth_role_create = new Privilege();
		PrivilegeFourth_role_create.setIcon("images/002.gif");
		PrivilegeFourth_role_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_role_create.setName("角色增加");
		PrivilegeFourth_role_create.setPid(PrivilegeThird_role.getId());
		PrivilegeFourth_role_create.setType("2");
		session.save(PrivilegeFourth_role_create);
		
		/**
		 * 角色-->角色修改
		 */
		Privilege PrivilegeFourth_role_update = new Privilege();
		PrivilegeFourth_role_update.setIcon("images/002.gif");
		PrivilegeFourth_role_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_role_update.setName("角色修改");
		PrivilegeFourth_role_update.setPid(PrivilegeThird_role.getId());
		PrivilegeFourth_role_update.setType("2");
		session.save(PrivilegeFourth_role_update);
		
		/**
		 * 角色-->角色查询
		 */
		Privilege PrivilegeFourth_role_query = new Privilege();
		PrivilegeFourth_role_query.setIcon("images/002.gif");
		PrivilegeFourth_role_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_role_query.setName("角色增加");
		PrivilegeFourth_role_query.setPid(PrivilegeThird_role.getId());
		PrivilegeFourth_role_query.setType("2");
		session.save(PrivilegeFourth_role_query);
		
		/**
		 * 角色-->角色删除
		 */
		Privilege PrivilegeFourth_role_delete = new Privilege();
		PrivilegeFourth_role_delete.setIcon("images/002.gif");
		PrivilegeFourth_role_delete.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_role_delete.setName("角色删除");
		PrivilegeFourth_role_delete.setPid(PrivilegeThird_role.getId());
		PrivilegeFourth_role_delete.setType("2");
		session.save(PrivilegeFourth_role_delete);
		
		
		/**
		 * 基础数据-->商品档案
		 */
		Privilege PrivilegeThird_product = new Privilege();
		PrivilegeThird_product.setIcon("images/003.gif");
		PrivilegeThird_product.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeThird_product.setName("商品");
		PrivilegeThird_product.setPid(PrivilegeSecond_basedata.getId());
		PrivilegeThird_product.setType("1");
		session.save(PrivilegeThird_product);
		
		/**
		 * 商品-->商品增加
		 */
		Privilege PrivilegeFourth_product_create = new Privilege();
		PrivilegeFourth_product_create.setIcon("images/002.gif");
		PrivilegeFourth_product_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_product_create.setName("商品增加");
		PrivilegeFourth_product_create.setPid(PrivilegeThird_product.getId());
		PrivilegeFourth_product_create.setType("2");
		session.save(PrivilegeFourth_product_create);
		
		/**
		 * 商品-->商品修改
		 */
		Privilege PrivilegeFourth_product_update = new Privilege();
		PrivilegeFourth_product_update.setIcon("images/002.gif");
		PrivilegeFourth_product_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_product_update.setName("商品增加");
		PrivilegeFourth_product_update.setPid(PrivilegeThird_product.getId());
		PrivilegeFourth_product_update.setType("2");
		session.save(PrivilegeFourth_product_update);
		
		/**
		 * 商品-->商品查询
		 */
		Privilege PrivilegeFourth_product_query = new Privilege();
		PrivilegeFourth_product_query.setIcon("images/002.gif");
		PrivilegeFourth_product_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_product_query.setName("商品查询");
		PrivilegeFourth_product_query.setPid(PrivilegeThird_product.getId());
		PrivilegeFourth_product_query.setType("2");
		session.save(PrivilegeFourth_product_query);
		
		
		/**
		 * 商品-->商品删除
		 */
		Privilege PrivilegeFourth_product_delete = new Privilege();
		PrivilegeFourth_product_delete.setIcon("images/002.gif");
		PrivilegeFourth_product_delete.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_product_delete.setName("商品删除");
		PrivilegeFourth_product_delete.setPid(PrivilegeThird_product.getId());
		PrivilegeFourth_product_delete.setType("2");
		session.save(PrivilegeFourth_product_delete);
		
		/**
		 * 基础数据-->仓库
		 */
		Privilege PrivilegeThird_repository = new Privilege();
		PrivilegeThird_repository.setIcon("images/003.gif");
		PrivilegeThird_repository.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeThird_repository.setName("仓库");
		PrivilegeThird_repository.setPid(PrivilegeSecond_basedata.getId());
		PrivilegeThird_repository.setType("1");
		session.save(PrivilegeThird_repository);
		
		/**
		 * 仓库-->仓库增加
		 */
		Privilege PrivilegeFourth_repository_create = new Privilege();
		PrivilegeFourth_repository_create.setIcon("images/002.gif");
		PrivilegeFourth_repository_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_repository_create.setName("仓库增加");
		PrivilegeFourth_repository_create.setPid(PrivilegeThird_repository.getId());
		PrivilegeFourth_repository_create.setType("2");
		session.save(PrivilegeFourth_repository_create);
		
		/**
		 * 仓库-->仓库修改
		 */
		Privilege PrivilegeFourth_repository_update = new Privilege();
		PrivilegeFourth_repository_update.setIcon("images/002.gif");
		PrivilegeFourth_repository_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_repository_update.setName("仓库修改");
		PrivilegeFourth_repository_update.setPid(PrivilegeThird_repository.getId());
		PrivilegeFourth_repository_update.setType("2");
		session.save(PrivilegeFourth_repository_update);
		
		/**
		 * 仓库-->仓库查询
		 */
		Privilege PrivilegeFourth_repository_query = new Privilege();
		PrivilegeFourth_repository_query.setIcon("images/002.gif");
		PrivilegeFourth_repository_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_repository_query.setName("仓库查询");
		PrivilegeFourth_repository_query.setPid(PrivilegeThird_repository.getId());
		PrivilegeFourth_repository_query.setType("2");
		session.save(PrivilegeFourth_repository_query);
		
		/**
		 * 仓库-->仓库删除
		 */
		Privilege PrivilegeFourth_repository_delete = new Privilege();
		PrivilegeFourth_repository_delete.setIcon("images/002.gif");
		PrivilegeFourth_repository_delete.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_repository_delete.setName("仓库删除");
		PrivilegeFourth_repository_delete.setPid(PrivilegeThird_repository.getId());
		PrivilegeFourth_repository_delete.setType("2");
		session.save(PrivilegeFourth_repository_delete);
		
		/**
		 * 基础数据-->客户
		 */
		Privilege PrivilegeThird_customer = new Privilege();
		PrivilegeThird_customer.setIcon("images/003.gif");
		PrivilegeThird_customer.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeThird_customer.setName("客户");
		PrivilegeThird_customer.setPid(PrivilegeSecond_basedata.getId());
		PrivilegeThird_customer.setType("1");
		session.save(PrivilegeThird_customer);
		
		/**
		 * 客户-->客户增加
		 */
		Privilege PrivilegeFourth_customer_create = new Privilege();
		PrivilegeFourth_customer_create.setIcon("images/002.gif");
		PrivilegeFourth_customer_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_customer_create.setName("客户增加");
		PrivilegeFourth_customer_create.setPid(PrivilegeThird_customer.getId());
		PrivilegeFourth_customer_create.setType("2");
		session.save(PrivilegeFourth_customer_create);
		
		/**
		 * 客户-->客户修改
		 */
		Privilege PrivilegeFourth_customer_update = new Privilege();
		PrivilegeFourth_customer_update.setIcon("images/002.gif");
		PrivilegeFourth_customer_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_customer_update.setName("客户修改");
		PrivilegeFourth_customer_update.setPid(PrivilegeThird_customer.getId());
		PrivilegeFourth_customer_update.setType("2");
		session.save(PrivilegeFourth_customer_update);
		
		/**
		 * 客户-->客户查询
		 */
		Privilege PrivilegeFourth_customer_query = new Privilege();
		PrivilegeFourth_customer_query.setIcon("images/002.gif");
		PrivilegeFourth_customer_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_customer_query.setName("客户查询");
		PrivilegeFourth_customer_query.setPid(PrivilegeThird_customer.getId());
		PrivilegeFourth_customer_query.setType("2");
		session.save(PrivilegeFourth_customer_query);
		
		/**
		 * 客户-->客户删除
		 */
		Privilege PrivilegeFourth_customer_delete = new Privilege();
		PrivilegeFourth_customer_delete.setIcon("images/002.gif");
		PrivilegeFourth_customer_delete.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_customer_delete.setName("客户删除");
		PrivilegeFourth_customer_delete.setPid(PrivilegeThird_customer.getId());
		PrivilegeFourth_customer_delete.setType("2");
		session.save(PrivilegeFourth_customer_delete);
		
		/**
		 * 基础数据-->供应商
		 */
		Privilege PrivilegeThird_supplier = new Privilege();
		PrivilegeThird_supplier.setIcon("images/003.gif");
		PrivilegeThird_supplier.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeThird_supplier.setName("供应商");
		PrivilegeThird_supplier.setPid(PrivilegeSecond_basedata.getId());
		PrivilegeThird_supplier.setType("1");
		session.save(PrivilegeThird_supplier);
		
		/**
		 * 供应商-->供应商增加
		 */
		Privilege PrivilegeFourth_supplier_create = new Privilege();
		PrivilegeFourth_supplier_create.setIcon("images/002.gif");
		PrivilegeFourth_supplier_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_supplier_create.setName("供应商增加");
		PrivilegeFourth_supplier_create.setPid(PrivilegeThird_supplier.getId());
		PrivilegeFourth_supplier_create.setType("2");
		session.save(PrivilegeFourth_supplier_create);
		
		/**
		 * 供应商-->供应商修改
		 */
		Privilege PrivilegeFourth_supplier_update = new Privilege();
		PrivilegeFourth_supplier_update.setIcon("images/002.gif");
		PrivilegeFourth_supplier_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_supplier_update.setName("供应商修改");
		PrivilegeFourth_supplier_update.setPid(PrivilegeThird_supplier.getId());
		PrivilegeFourth_supplier_update.setType("2");
		session.save(PrivilegeFourth_supplier_update);
		
		/**
		 * 供应商-->供应商查询
		 */
		Privilege PrivilegeFourth_supplier_query = new Privilege();
		PrivilegeFourth_supplier_query.setIcon("images/002.gif");
		PrivilegeFourth_supplier_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_supplier_query.setName("供应商查询");
		PrivilegeFourth_supplier_query.setPid(PrivilegeThird_supplier.getId());
		PrivilegeFourth_supplier_query.setType("2");
		session.save(PrivilegeFourth_supplier_query);
		
		/**
		 * 供应商-->供应商删除
		 */
		Privilege PrivilegeFourth_supplier_delete = new Privilege();
		PrivilegeFourth_supplier_delete.setIcon("images/002.gif");
		PrivilegeFourth_supplier_delete.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_supplier_delete.setName("供应商删除");
		PrivilegeFourth_supplier_delete.setPid(PrivilegeThird_supplier.getId());
		PrivilegeFourth_supplier_delete.setType("2");
		session.save(PrivilegeFourth_supplier_delete);
		
		
		/**
		 * 权限管理
		 */
		Privilege PrivilegeSecond_privilege = new Privilege();
		PrivilegeSecond_privilege.setIcon("images/003.gif");
		PrivilegeSecond_privilege.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeSecond_privilege.setName("权限管理");
		PrivilegeSecond_privilege.setPid(PrivilegeFirst.getId());
		PrivilegeSecond_privilege.setType("1");
		session.save(PrivilegeSecond_privilege);
		/**
		 * 权限管理-->角色配置 
		 */
		Privilege PrivilegeThird_userrole = new Privilege();
		PrivilegeThird_userrole.setIcon("images/003.gif");
		PrivilegeThird_userrole.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeThird_userrole.setName("角色配置");
		PrivilegeThird_userrole.setPid(PrivilegeSecond_privilege.getId());
		PrivilegeThird_userrole.setType("1");
		session.save(PrivilegeThird_userrole);
		
		/**
		 * 角色配置-->用户匹配角色
		 */
		Privilege PrivilegeFourth_userrole_set = new Privilege();
		PrivilegeFourth_userrole_set.setIcon("images/002.gif");
		PrivilegeFourth_userrole_set.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_userrole_set.setName("用户匹配角色");
		PrivilegeFourth_userrole_set.setPid(PrivilegeThird_userrole.getId());
		PrivilegeFourth_userrole_set.setType("2");
		session.save(PrivilegeFourth_userrole_set);
		
		/**
		 * 权限管理-->权限配置
		 */
		Privilege PrivilegeThird_roleprivilege = new Privilege();
		PrivilegeThird_roleprivilege.setIcon("images/002.gif");
		PrivilegeThird_roleprivilege.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeThird_roleprivilege.setName("权限配置");
		PrivilegeThird_roleprivilege.setPid(PrivilegeSecond_privilege.getId());
		PrivilegeThird_roleprivilege.setType("1");
		session.save(PrivilegeThird_roleprivilege);
		
		/**
		 * 权限配置-->角色匹配权限
		 */
		Privilege PrivilegeFourth_roleprivilege_set = new Privilege();
		PrivilegeFourth_roleprivilege_set.setIcon("images/002.gif");
		PrivilegeFourth_roleprivilege_set.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFourth_roleprivilege_set.setName("角色匹配权限");
		PrivilegeFourth_roleprivilege_set.setPid(PrivilegeThird_roleprivilege.getId());
		PrivilegeFourth_roleprivilege_set.setType("2");
		session.save(PrivilegeFourth_roleprivilege_set);
		/**
		 * 业务
		 */
		Privilege PrivilegeSecond_business = new Privilege();
		PrivilegeSecond_business.setIcon("images/003.gif");
		PrivilegeSecond_business.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeSecond_business.setName("业务");
		PrivilegeSecond_business.setPid(PrivilegeFirst.getId());
		PrivilegeSecond_business.setType("1");
		session.save(PrivilegeSecond_business);
		/**
		 * 业务-->采购管理
		 */
		Privilege PrivilegeThird_purchase = new Privilege();  //采购
		PrivilegeThird_purchase.setIcon("images/003.gif");
		PrivilegeThird_purchase.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeThird_purchase.setName("采购管理");
		PrivilegeThird_purchase.setPid(PrivilegeSecond_business.getId());
		PrivilegeThird_purchase.setType("1");
		session.save(PrivilegeThird_purchase);
		/**
		 * 采购管理-->请购单管理
		 */
		Privilege PrivilegeForth_prepurchase = new Privilege();
		PrivilegeForth_prepurchase.setIcon("images/003.gif");
		PrivilegeForth_prepurchase.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_prepurchase.setName("请购单管理");
		PrivilegeForth_prepurchase.setPid(PrivilegeThird_purchase.getId());
		PrivilegeForth_prepurchase.setType("1");
		session.save(PrivilegeForth_prepurchase);
		/**
		 * 请购单管理-->请购单增加
		 */
		Privilege PrivilegeFifth_prepurchase_create = new Privilege();
		PrivilegeFifth_prepurchase_create.setIcon("images/003.gif");
		PrivilegeFifth_prepurchase_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_prepurchase_create.setName("增加");
		PrivilegeFifth_prepurchase_create.setPid(PrivilegeForth_prepurchase.getId());
		PrivilegeFifth_prepurchase_create.setType("1");
		session.save(PrivilegeFifth_prepurchase_create);
		
		
		/**
		 * 请购单管理-->请购单修改
		 */
		Privilege PrivilegeFifth_prepurchase_update = new Privilege();
		PrivilegeFifth_prepurchase_update.setIcon("images/003.gif");
		PrivilegeFifth_prepurchase_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_prepurchase_update.setName("修改");
		PrivilegeFifth_prepurchase_update.setPid(PrivilegeForth_prepurchase.getId());
		PrivilegeFifth_prepurchase_update.setType("1");
		session.save(PrivilegeFifth_prepurchase_update);
		/**
		 * 请购单管理-->请购单查询
		 */
		Privilege PrivilegeFifth_prepurchase_query = new Privilege();
		PrivilegeFifth_prepurchase_query.setIcon("images/003.gif");
		PrivilegeFifth_prepurchase_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_prepurchase_query.setName("查询");
		PrivilegeFifth_prepurchase_query.setPid(PrivilegeForth_prepurchase.getId());
		PrivilegeFifth_prepurchase_query.setType("1");
		session.save(PrivilegeFifth_prepurchase_query);
		/**
		 * 请购单管理-->请购单审批
		 */
		Privilege PrivilegeFifth_prepurchase_approve = new Privilege();
		PrivilegeFifth_prepurchase_approve.setIcon("images/003.gif");
		PrivilegeFifth_prepurchase_approve.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_prepurchase_approve.setName("审批");
		PrivilegeFifth_prepurchase_approve.setPid(PrivilegeForth_prepurchase.getId());
		PrivilegeFifth_prepurchase_approve.setType("1");
		session.save(PrivilegeFifth_prepurchase_approve);
		/**
		 * 采购管理-->采购订单管理
		 */
		Privilege PrivilegeForth_purchaseorder = new Privilege();
		PrivilegeForth_purchaseorder.setIcon("images/003.gif");
		PrivilegeForth_purchaseorder.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_purchaseorder.setName("请购单管理");
		PrivilegeForth_purchaseorder.setPid(PrivilegeThird_purchase.getId());
		PrivilegeForth_purchaseorder.setType("1");
		session.save(PrivilegeForth_purchaseorder);
		/**
		 * 采购订单管理-->采购订单增加
		 */
		Privilege PrivilegeFifth_purchaseorder_create = new Privilege();
		PrivilegeFifth_purchaseorder_create.setIcon("images/003.gif");
		PrivilegeFifth_purchaseorder_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_purchaseorder_create.setName("增加");
		PrivilegeFifth_purchaseorder_create.setPid(PrivilegeForth_purchaseorder.getId());
		PrivilegeFifth_purchaseorder_create.setType("1");
		session.save(PrivilegeFifth_purchaseorder_create);
		/**
		 * 采购订单管理-->采购订单修改
		 */
		Privilege PrivilegeFifth_purchaseorder_update = new Privilege();
		PrivilegeFifth_purchaseorder_update.setIcon("images/003.gif");
		PrivilegeFifth_purchaseorder_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_purchaseorder_update.setName("修改");
		PrivilegeFifth_purchaseorder_update.setPid(PrivilegeForth_purchaseorder.getId());
		PrivilegeFifth_purchaseorder_update.setType("1");
		session.save(PrivilegeFifth_purchaseorder_update);
		/**
		 * 采购订单管理-->采购订单查询
		 */
		Privilege PrivilegeFifth_purchaseorder_query = new Privilege();
		PrivilegeFifth_purchaseorder_query.setIcon("images/003.gif");
		PrivilegeFifth_purchaseorder_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_purchaseorder_query.setName("查询");
		PrivilegeFifth_purchaseorder_query.setPid(PrivilegeForth_purchaseorder.getId());
		PrivilegeFifth_purchaseorder_query.setType("1");
		session.save(PrivilegeFifth_purchaseorder_query);
		/**
		 * 采购订单管理-->采购订单审批
		 */
		Privilege PrivilegeFifth_purchaseorder_approve = new Privilege();
		PrivilegeFifth_purchaseorder_approve.setIcon("images/003.gif");
		PrivilegeFifth_purchaseorder_approve.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_purchaseorder_approve.setName("审批");
		PrivilegeFifth_purchaseorder_approve.setPid(PrivilegeForth_purchaseorder.getId());
		PrivilegeFifth_purchaseorder_approve.setType("1");
		session.save(PrivilegeFifth_purchaseorder_approve);
		/**
		 * 采购管理-->采购入库单管理
		 */
		Privilege PrivilegeForth_purchaseinrepository = new Privilege();
		PrivilegeForth_purchaseinrepository.setIcon("images/003.gif");
		PrivilegeForth_purchaseinrepository.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_purchaseinrepository.setName("采购入库单管理");
		PrivilegeForth_purchaseinrepository.setPid(PrivilegeThird_purchase.getId());
		PrivilegeForth_purchaseinrepository.setType("1");
		session.save(PrivilegeForth_purchaseinrepository);
		/**
		 *	采购入库单管理-->采购入库增加
		 */
		Privilege PrivilegeFifth_purchaseinrepository_create = new Privilege();
		PrivilegeFifth_purchaseinrepository_create.setIcon("images/003.gif");
		PrivilegeFifth_purchaseinrepository_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_purchaseinrepository_create.setName("增加");
		PrivilegeFifth_purchaseinrepository_create.setPid(PrivilegeForth_purchaseinrepository.getId());
		PrivilegeFifth_purchaseinrepository_create.setType("1");
		session.save(PrivilegeFifth_purchaseinrepository_create);
		/**
		 *	采购入库单管理-->采购入库修改
		 */
		Privilege PrivilegeFifth_purchaseinrepository_update = new Privilege();
		PrivilegeFifth_purchaseinrepository_update.setIcon("images/003.gif");
		PrivilegeFifth_purchaseinrepository_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_purchaseinrepository_update.setName("修改");
		PrivilegeFifth_purchaseinrepository_update.setPid(PrivilegeForth_purchaseinrepository.getId());
		PrivilegeFifth_purchaseinrepository_update.setType("1");
		session.save(PrivilegeFifth_purchaseinrepository_update);
		/**
		 *	采购入库单管理-->采购入库查询
		 */
		Privilege PrivilegeFifth_purchaseinrepository_query = new Privilege();
		PrivilegeFifth_purchaseinrepository_query.setIcon("images/003.gif");
		PrivilegeFifth_purchaseinrepository_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_purchaseinrepository_query.setName("查询");
		PrivilegeFifth_purchaseinrepository_query.setPid(PrivilegeForth_purchaseinrepository.getId());
		PrivilegeFifth_purchaseinrepository_query.setType("1");
		session.save(PrivilegeFifth_purchaseinrepository_query);
		/**
		 *	采购入库单管理-->采购入库审批
		 */
		Privilege PrivilegeFifth_purchaseinrepository_approve = new Privilege();
		PrivilegeFifth_purchaseinrepository_approve.setIcon("images/003.gif");
		PrivilegeFifth_purchaseinrepository_approve.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_purchaseinrepository_approve.setName("审批");
		PrivilegeFifth_purchaseinrepository_approve.setPid(PrivilegeForth_purchaseinrepository.getId());
		PrivilegeFifth_purchaseinrepository_approve.setType("1");
		session.save(PrivilegeFifth_purchaseinrepository_approve);
		/**
		 * 采购管理-->采购发票管理
		 */
		Privilege PrivilegeForth_purchaseinvoice = new Privilege();
		PrivilegeForth_purchaseinvoice.setIcon("images/003.gif");
		PrivilegeForth_purchaseinvoice.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_purchaseinvoice.setName("采购发票管理");
		PrivilegeForth_purchaseinvoice.setPid(PrivilegeThird_purchase.getId());
		PrivilegeForth_purchaseinvoice.setType("1");
		session.save(PrivilegeForth_purchaseinvoice);
		/**
		 * 采购发票管理-->采购发票增加
		 */
		Privilege PrivilegeFifth_purchaseinvoice_create = new Privilege();
		PrivilegeFifth_purchaseinvoice_create.setIcon("images/003.gif");
		PrivilegeFifth_purchaseinvoice_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_purchaseinvoice_create.setName("增加");
		PrivilegeFifth_purchaseinvoice_create.setPid(PrivilegeForth_purchaseinvoice.getId());
		PrivilegeFifth_purchaseinvoice_create.setType("1");
		session.save(PrivilegeFifth_purchaseinvoice_create);
		/**
		 * 采购发票管理-->采购发票修改
		 */
		Privilege PrivilegeFifth_purchaseinvoice_update = new Privilege();
		PrivilegeFifth_purchaseinvoice_update.setIcon("images/003.gif");
		PrivilegeFifth_purchaseinvoice_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_purchaseinvoice_update.setName("修改");
		PrivilegeFifth_purchaseinvoice_update.setPid(PrivilegeForth_purchaseinvoice.getId());
		PrivilegeFifth_purchaseinvoice_update.setType("1");
		session.save(PrivilegeFifth_purchaseinvoice_update);
		/**
		 * 采购发票管理-->采购发票查询
		 */
		Privilege PrivilegeFifth_purchaseinvoice_query = new Privilege();
		PrivilegeFifth_purchaseinvoice_query.setIcon("images/003.gif");
		PrivilegeFifth_purchaseinvoice_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_purchaseinvoice_query.setName("查询");
		PrivilegeFifth_purchaseinvoice_query.setPid(PrivilegeForth_purchaseinvoice.getId());
		PrivilegeFifth_purchaseinvoice_query.setType("1");
		session.save(PrivilegeFifth_purchaseinvoice_query);
		/**
		 * 采购发票管理-->采购发票审批
		 */
		Privilege PrivilegeFifth_purchaseinvoice_approve = new Privilege();
		PrivilegeFifth_purchaseinvoice_approve.setIcon("images/003.gif");
		PrivilegeFifth_purchaseinvoice_approve.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_purchaseinvoice_approve.setName("审批");
		PrivilegeFifth_purchaseinvoice_approve.setPid(PrivilegeForth_purchaseinvoice.getId());
		PrivilegeFifth_purchaseinvoice_approve.setType("1");
		session.save(PrivilegeFifth_purchaseinvoice_approve);
		/**
		 * 业务-->销售管理
		 */
		Privilege PrivilegeThird_sale = new Privilege();
		PrivilegeThird_sale.setIcon("images/003.gif");
		PrivilegeThird_sale.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeThird_sale.setName("销售管理");
		PrivilegeThird_sale.setPid(PrivilegeSecond_business.getId());
		PrivilegeThird_sale.setType("1");
		session.save(PrivilegeThird_sale);
		/**
		 * 销售管理-->销售预订单
		 */
		Privilege PrivilegeForth_presaleorder = new Privilege();
		PrivilegeForth_presaleorder.setIcon("images/003.gif");
		PrivilegeForth_presaleorder.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_presaleorder.setName("销售预订单管理");
		PrivilegeForth_presaleorder.setPid(PrivilegeThird_sale.getId());
		PrivilegeForth_presaleorder.setType("1");
		session.save(PrivilegeForth_presaleorder);
		/**
		 * 销售预订单-->销售预订单增加
		 */
		Privilege PrivilegeFifth_presaleorder_create = new Privilege();
		PrivilegeFifth_presaleorder_create.setIcon("images/003.gif");
		PrivilegeFifth_presaleorder_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_presaleorder_create.setName("增加");
		PrivilegeFifth_presaleorder_create.setPid(PrivilegeForth_presaleorder.getId());
		PrivilegeFifth_presaleorder_create.setType("1");
		session.save(PrivilegeFifth_presaleorder_create);
		/**
		 * 销售预订单-->销售预订单修改
		 */
		Privilege PrivilegeFifth_presaleorder_update = new Privilege();
		PrivilegeFifth_presaleorder_update.setIcon("images/003.gif");
		PrivilegeFifth_presaleorder_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_presaleorder_update.setName("修改");
		PrivilegeFifth_presaleorder_update.setPid(PrivilegeForth_presaleorder.getId());
		PrivilegeFifth_presaleorder_update.setType("1");
		session.save(PrivilegeFifth_presaleorder_update);
		/**
		 * 销售预订单-->销售预订单查询
		 */
		Privilege PrivilegeFifth_presaleorder_query = new Privilege();
		PrivilegeFifth_presaleorder_query.setIcon("images/003.gif");
		PrivilegeFifth_presaleorder_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_presaleorder_query.setName("查询");
		PrivilegeFifth_presaleorder_query.setPid(PrivilegeForth_presaleorder.getId());
		PrivilegeFifth_presaleorder_query.setType("1");
		session.save(PrivilegeFifth_presaleorder_query);
		/**
		 * 销售预订单-->销售预订单审批
		 */
		Privilege PrivilegeFifth_presaleorder_approve = new Privilege();
		PrivilegeFifth_presaleorder_approve.setIcon("images/003.gif");
		PrivilegeFifth_presaleorder_approve.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_presaleorder_approve.setName("审批");
		PrivilegeFifth_presaleorder_approve.setPid(PrivilegeForth_presaleorder.getId());
		PrivilegeFifth_presaleorder_approve.setType("1");
		session.save(PrivilegeFifth_presaleorder_approve);
		/**
		 * 销售管理-->销售订单管理
		 */
		Privilege PrivilegeForth_saleorder = new Privilege();
		PrivilegeForth_saleorder.setIcon("images/003.gif");
		PrivilegeForth_saleorder.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_saleorder.setName("销售订单管理");
		PrivilegeForth_saleorder.setPid(PrivilegeThird_sale.getId());
		PrivilegeForth_saleorder.setType("1");
		session.save(PrivilegeForth_saleorder);
		/**
		 * 销售订单管理-->销售订单增加
		 */
		Privilege PrivilegeFifth_saleorder_create = new Privilege();
		PrivilegeFifth_saleorder_create.setIcon("images/003.gif");
		PrivilegeFifth_saleorder_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_saleorder_create.setName("增加");
		PrivilegeFifth_saleorder_create.setPid(PrivilegeForth_saleorder.getId());
		PrivilegeFifth_saleorder_create.setType("1");
		session.save(PrivilegeFifth_saleorder_create);
		/**
		 * 销售订单管理-->销售订单修改
		 */
		Privilege PrivilegeFifth_saleorder_update = new Privilege();
		PrivilegeFifth_saleorder_update.setIcon("images/003.gif");
		PrivilegeFifth_saleorder_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_saleorder_update.setName("增加");
		PrivilegeFifth_saleorder_update.setPid(PrivilegeForth_saleorder.getId());
		PrivilegeFifth_saleorder_update.setType("1");
		session.save(PrivilegeFifth_saleorder_update);
		/**
		 * 销售订单管理-->销售订单查询
		 */
		Privilege PrivilegeFifth_saleorder_query = new Privilege();
		PrivilegeFifth_saleorder_query.setIcon("images/003.gif");
		PrivilegeFifth_saleorder_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_saleorder_query.setName("查询");
		PrivilegeFifth_saleorder_query.setPid(PrivilegeForth_saleorder.getId());
		PrivilegeFifth_saleorder_query.setType("1");
		session.save(PrivilegeFifth_saleorder_query);
		/**
		 * 销售订单管理-->销售订单审批
		 */
		Privilege PrivilegeFifth_saleorder_approve = new Privilege();
		PrivilegeFifth_saleorder_approve.setIcon("images/003.gif");
		PrivilegeFifth_saleorder_approve.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_saleorder_approve.setName("审批");
		PrivilegeFifth_saleorder_approve.setPid(PrivilegeForth_saleorder.getId());
		PrivilegeFifth_saleorder_approve.setType("1");
		session.save(PrivilegeFifth_saleorder_approve);
		/**
		 * 销售管理-->发货单管理
		 */
		Privilege PrivilegeForth_shippingorder = new Privilege();
		PrivilegeForth_shippingorder.setIcon("images/003.gif");
		PrivilegeForth_shippingorder.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_shippingorder.setName("发货单管理");
		PrivilegeForth_shippingorder.setPid(PrivilegeThird_sale.getId());
		PrivilegeForth_shippingorder.setType("1");
		session.save(PrivilegeForth_shippingorder);
		/**
		 * 发货单管理-->发货单增加
		 */
		Privilege PrivilegeFifth_shippingorder_create = new Privilege();
		PrivilegeFifth_shippingorder_create.setIcon("images/003.gif");
		PrivilegeFifth_shippingorder_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_shippingorder_create.setName("增加");
		PrivilegeFifth_shippingorder_create.setPid(PrivilegeForth_shippingorder.getId());
		PrivilegeFifth_shippingorder_create.setType("1");
		session.save(PrivilegeFifth_shippingorder_create);
		/**
		 * 发货单管理-->发货单修改
		 */
		Privilege PrivilegeFifth_shippingorder_update = new Privilege();
		PrivilegeFifth_shippingorder_update.setIcon("images/003.gif");
		PrivilegeFifth_shippingorder_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_shippingorder_update.setName("修改");
		PrivilegeFifth_shippingorder_update.setPid(PrivilegeForth_shippingorder.getId());
		PrivilegeFifth_shippingorder_update.setType("1");
		session.save(PrivilegeFifth_shippingorder_update);
		/**
		 * 发货单管理-->发货单查询
		 */
		Privilege PrivilegeFifth_shippingorder_query = new Privilege();
		PrivilegeFifth_shippingorder_query.setIcon("images/003.gif");
		PrivilegeFifth_shippingorder_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_shippingorder_query.setName("查询");
		PrivilegeFifth_shippingorder_query.setPid(PrivilegeForth_shippingorder.getId());
		PrivilegeFifth_shippingorder_query.setType("1");
		session.save(PrivilegeFifth_shippingorder_query);
		/**
		 * 发货单管理-->发货单审批
		 */
		Privilege PrivilegeFifth_shippingorder_approve = new Privilege();
		PrivilegeFifth_shippingorder_approve.setIcon("images/003.gif");
		PrivilegeFifth_shippingorder_approve.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_shippingorder_approve.setName("审批");
		PrivilegeFifth_shippingorder_approve.setPid(PrivilegeForth_shippingorder.getId());
		PrivilegeFifth_shippingorder_approve.setType("1");
		session.save(PrivilegeFifth_shippingorder_approve);
		/**
		 * 销售管理-->销售出库单管理
		 */
		Privilege PrivilegeForth_outboundorder = new Privilege();
		PrivilegeForth_outboundorder.setIcon("images/003.gif");
		PrivilegeForth_outboundorder.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_outboundorder.setName("销售出库单管理");
		PrivilegeForth_outboundorder.setPid(PrivilegeThird_sale.getId());
		PrivilegeForth_outboundorder.setType("1");
		session.save(PrivilegeForth_outboundorder);
		/**
		 * 销售出库单管理-->销售出库单增加
		 */
		Privilege PrivilegeFifth_outboundorder_create = new Privilege();
		PrivilegeFifth_outboundorder_create.setIcon("images/003.gif");
		PrivilegeFifth_outboundorder_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_outboundorder_create.setName("增加");
		PrivilegeFifth_outboundorder_create.setPid(PrivilegeForth_outboundorder.getId());
		PrivilegeFifth_outboundorder_create.setType("1");
		session.save(PrivilegeFifth_outboundorder_create);
		/**
		 * 销售出库单管理-->销售出库单修改
		 */
		Privilege PrivilegeFifth_outboundorder_update = new Privilege();
		PrivilegeFifth_outboundorder_update.setIcon("images/003.gif");
		PrivilegeFifth_outboundorder_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_outboundorder_update.setName("修改");
		PrivilegeFifth_outboundorder_update.setPid(PrivilegeForth_outboundorder.getId());
		PrivilegeFifth_outboundorder_update.setType("1");
		session.save(PrivilegeFifth_outboundorder_update);
		/**
		 * 销售出库单管理-->销售出库单查询
		 */
		Privilege PrivilegeFifth_outboundorder_query = new Privilege();
		PrivilegeFifth_outboundorder_query.setIcon("images/003.gif");
		PrivilegeFifth_outboundorder_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_outboundorder_query.setName("查询");
		PrivilegeFifth_outboundorder_query.setPid(PrivilegeForth_outboundorder.getId());
		PrivilegeFifth_outboundorder_query.setType("1");
		session.save(PrivilegeFifth_outboundorder_query);
		/**
		 * 销售出库单管理-->销售出库单审批
		 */
		Privilege PrivilegeFifth_outboundorder_approve = new Privilege();
		PrivilegeFifth_outboundorder_approve.setIcon("images/003.gif");
		PrivilegeFifth_outboundorder_approve.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_outboundorder_approve.setName("审批");
		PrivilegeFifth_outboundorder_approve.setPid(PrivilegeForth_outboundorder.getId());
		PrivilegeFifth_outboundorder_approve.setType("1");
		session.save(PrivilegeFifth_outboundorder_approve);
		/**
		 * 销售管理-->销售开票管理
		 */
		Privilege PrivilegeForth_invoiceorder = new Privilege();
		PrivilegeForth_invoiceorder.setIcon("images/003.gif");
		PrivilegeForth_invoiceorder.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_invoiceorder.setName("销售开票管理");
		PrivilegeForth_invoiceorder.setPid(PrivilegeThird_sale.getId());
		PrivilegeForth_invoiceorder.setType("1");
		session.save(PrivilegeForth_invoiceorder);
		/**
		 * 销售开票管理-->销售开票增加
		 */
		Privilege PrivilegeFifth_invoiceorder_create = new Privilege();
		PrivilegeFifth_invoiceorder_create.setIcon("images/003.gif");
		PrivilegeFifth_invoiceorder_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_invoiceorder_create.setName("增加");
		PrivilegeFifth_invoiceorder_create.setPid(PrivilegeForth_invoiceorder.getId());
		PrivilegeFifth_invoiceorder_create.setType("1");
		session.save(PrivilegeFifth_invoiceorder_create);
		/**
		 * 销售开票管理-->销售开票修改
		 */
		Privilege PrivilegeFifth_invoiceorder_update = new Privilege();
		PrivilegeFifth_invoiceorder_update.setIcon("images/003.gif");
		PrivilegeFifth_invoiceorder_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_invoiceorder_update.setName("修改");
		PrivilegeFifth_invoiceorder_update.setPid(PrivilegeForth_invoiceorder.getId());
		PrivilegeFifth_invoiceorder_update.setType("1");
		session.save(PrivilegeFifth_invoiceorder_update);
		/**
		 * 销售开票管理-->销售开票查询
		 */
		Privilege PrivilegeFifth_invoiceorder_query = new Privilege();
		PrivilegeFifth_invoiceorder_query.setIcon("images/003.gif");
		PrivilegeFifth_invoiceorder_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_invoiceorder_query.setName("查询");
		PrivilegeFifth_invoiceorder_query.setPid(PrivilegeForth_invoiceorder.getId());
		PrivilegeFifth_invoiceorder_query.setType("1");
		session.save(PrivilegeFifth_invoiceorder_query);
		/**
		 * 销售开票管理-->销售开票审批
		 */
		Privilege PrivilegeFifth_invoiceorder_approve = new Privilege();
		PrivilegeFifth_invoiceorder_approve.setIcon("images/003.gif");
		PrivilegeFifth_invoiceorder_approve.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_invoiceorder_approve.setName("审批");
		PrivilegeFifth_invoiceorder_approve.setPid(PrivilegeForth_invoiceorder.getId());
		PrivilegeFifth_invoiceorder_approve.setType("1");
		session.save(PrivilegeFifth_invoiceorder_approve);
		
		/**
		 * 业务-->应收应付管理
		 */
		Privilege PrivilegeThird_paymentcollections = new Privilege(); //应收应付
		PrivilegeThird_paymentcollections.setIcon("images/003.gif");
		PrivilegeThird_paymentcollections.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeThird_paymentcollections.setName("应收应付管理");
		PrivilegeThird_paymentcollections.setPid(PrivilegeSecond_business.getId());
		PrivilegeThird_paymentcollections.setType("1");
		session.save(PrivilegeThird_paymentcollections);
		/**
		 * 应收应付管理-->销售应收单管理
		 */
		Privilege PrivilegeForth_salecollections = new Privilege(); //销售应收单
		PrivilegeForth_salecollections.setIcon("images/003.gif");
		PrivilegeForth_salecollections.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_salecollections.setName("销售应收管理");
		PrivilegeForth_salecollections.setPid(PrivilegeThird_paymentcollections.getId());
		PrivilegeForth_salecollections.setType("1");
		session.save(PrivilegeForth_salecollections);
		/**
		 * 销售应收单管理-->销售应收单增加
		 */
		Privilege PrivilegeFifth_salecollections_create = new Privilege(); 
		PrivilegeFifth_salecollections_create.setIcon("images/003.gif");
		PrivilegeFifth_salecollections_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_salecollections_create.setName("增加");
		PrivilegeFifth_salecollections_create.setPid(PrivilegeForth_salecollections.getId());
		PrivilegeFifth_salecollections_create.setType("1");
		session.save(PrivilegeFifth_salecollections_create);
		/**
		 * 销售应收单管理-->销售应收单修改
		 */
		Privilege PrivilegeFifth_salecollections_update = new Privilege(); 
		PrivilegeFifth_salecollections_update.setIcon("images/003.gif");
		PrivilegeFifth_salecollections_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_salecollections_update.setName("修改");
		PrivilegeFifth_salecollections_update.setPid(PrivilegeForth_salecollections.getId());
		PrivilegeFifth_salecollections_update.setType("1");
		session.save(PrivilegeFifth_salecollections_update);
		/**
		 * 销售应收单管理-->销售应收单查询
		 */
		Privilege PrivilegeFifth_salecollections_query = new Privilege(); 
		PrivilegeFifth_salecollections_query.setIcon("images/003.gif");
		PrivilegeFifth_salecollections_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_salecollections_query.setName("查询");
		PrivilegeFifth_salecollections_query.setPid(PrivilegeForth_salecollections.getId());
		PrivilegeFifth_salecollections_query.setType("1");
		session.save(PrivilegeFifth_salecollections_query);
		/**
		 * 销售应收单管理-->销售应收单审批
		 */
		Privilege PrivilegeFifth_salecollections_approve = new Privilege(); 
		PrivilegeFifth_salecollections_approve.setIcon("images/003.gif");
		PrivilegeFifth_salecollections_approve.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_salecollections_approve.setName("审批");
		PrivilegeFifth_salecollections_approve.setPid(PrivilegeForth_salecollections.getId());
		PrivilegeFifth_salecollections_approve.setType("1");
		session.save(PrivilegeFifth_salecollections_approve);
		
		/**
		 * 应收应付管理-->采购应付单管理
		 */
		Privilege PrivilegeForth_collectionspayment = new Privilege(); //销售应收单
		PrivilegeForth_collectionspayment.setIcon("images/003.gif");
		PrivilegeForth_collectionspayment.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_collectionspayment.setName("采购应付单管理");
		PrivilegeForth_collectionspayment.setPid(PrivilegeThird_paymentcollections.getId());
		PrivilegeForth_collectionspayment.setType("1");
		session.save(PrivilegeForth_collectionspayment);
		/**
		 * 采购应付单管理-->采购应付单增加
		 */
		Privilege PrivilegeFifth_collectionspayment_create = new Privilege(); //销售应收单
		PrivilegeFifth_collectionspayment_create.setIcon("images/003.gif");
		PrivilegeFifth_collectionspayment_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_collectionspayment_create.setName("增加");
		PrivilegeFifth_collectionspayment_create.setPid(PrivilegeForth_collectionspayment.getId());
		PrivilegeFifth_collectionspayment_create.setType("1");
		session.save(PrivilegeFifth_collectionspayment_create);
		/**
		 * 采购应付单管理-->采购应付单修改
		 */
		Privilege PrivilegeFifth_collectionspayment_update = new Privilege(); //
		PrivilegeFifth_collectionspayment_update.setIcon("images/003.gif");
		PrivilegeFifth_collectionspayment_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_collectionspayment_update.setName("修改");
		PrivilegeFifth_collectionspayment_update.setPid(PrivilegeForth_collectionspayment.getId());
		PrivilegeFifth_collectionspayment_update.setType("1");
		session.save(PrivilegeFifth_collectionspayment_update);
		/**
		 * 采购应付单管理-->采购应付单查询
		 */
		Privilege PrivilegeFifth_collectionspayment_query = new Privilege(); //
		PrivilegeFifth_collectionspayment_query.setIcon("images/003.gif");
		PrivilegeFifth_collectionspayment_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_collectionspayment_query.setName("查询");
		PrivilegeFifth_collectionspayment_query.setPid(PrivilegeForth_collectionspayment.getId());
		PrivilegeFifth_collectionspayment_query.setType("1");
		session.save(PrivilegeFifth_collectionspayment_query);
		/**
		 * 采购应付单管理-->采购应付单审批
		 */
		Privilege PrivilegeFifth_collectionspayment_approve = new Privilege(); //
		PrivilegeFifth_collectionspayment_approve.setIcon("images/003.gif");
		PrivilegeFifth_collectionspayment_approve.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_collectionspayment_approve.setName("审批");
		PrivilegeFifth_collectionspayment_approve.setPid(PrivilegeForth_collectionspayment.getId());
		PrivilegeFifth_collectionspayment_approve.setType("1");
		session.save(PrivilegeFifth_collectionspayment_approve);
		
		/**
		 * 业务-->预警管理
		 */
		Privilege PrivilegeThird_warning = new Privilege();//预警
		PrivilegeThird_warning.setIcon("images/003.gif");
		PrivilegeThird_warning.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeThird_warning.setName("预警管理");
		PrivilegeThird_warning.setPid(PrivilegeSecond_business.getId());
		PrivilegeThird_warning.setType("1");
		session.save(PrivilegeThird_warning);
		/**
		 * 预警管理-->采购入库时间预警
		 */
		Privilege PrivilegeForth_warning_inrepositorytime = new Privilege();
		PrivilegeForth_warning_inrepositorytime.setIcon("images/003.gif");
		PrivilegeForth_warning_inrepositorytime.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_warning_inrepositorytime.setName("采购入库时间预警");
		PrivilegeForth_warning_inrepositorytime.setPid(PrivilegeThird_warning.getId());
		PrivilegeThird_warning.setType("1");
		session.save(PrivilegeForth_warning_inrepositorytime);
		/**
		 * 预警管理-->销售发货预警
		 */
		Privilege PrivilegeForth_warning_saleshippingtime = new Privilege();
		PrivilegeForth_warning_saleshippingtime.setIcon("images/003.gif");
		PrivilegeForth_warning_saleshippingtime.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_warning_saleshippingtime.setName("销售发货预警");
		PrivilegeForth_warning_saleshippingtime.setPid(PrivilegeThird_warning.getId());
		PrivilegeForth_warning_saleshippingtime.setType("1");
		session.save(PrivilegeForth_warning_saleshippingtime);
		/**
		 * 预警管理-->销售出库预警
		 */
		Privilege PrivilegeForth_warning_outboundtime = new Privilege();
		PrivilegeForth_warning_outboundtime.setIcon("images/003.gif");
		PrivilegeForth_warning_outboundtime.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_warning_outboundtime.setName("销售出库预警");
		PrivilegeForth_warning_outboundtime.setPid(PrivilegeThird_warning.getId());
		PrivilegeForth_warning_outboundtime.setType("1");
		session.save(PrivilegeForth_warning_outboundtime);
		/**
		 * 业务-->仓库管理
		 */
		Privilege PrivilegeThird_repositorymanagerment = new Privilege();//仓库管理
		//PrivilegeThird_repositorymanagerment.setIcon("images/003.gif");
		PrivilegeThird_repositorymanagerment.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeThird_repositorymanagerment.setName("仓库管理");
		PrivilegeThird_repositorymanagerment.setPid(PrivilegeSecond_business.getId());
		PrivilegeThird_repositorymanagerment.setType("1");
		session.save(PrivilegeThird_repositorymanagerment);
		/**
		 * 仓库管理-->期初管理
		 */
		Privilege PrivilegeForth_repositoryqc = new Privilege();
		PrivilegeForth_repositoryqc.setIcon("images/003.gif");
		PrivilegeForth_repositoryqc.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_repositoryqc.setName("期初");
		PrivilegeForth_repositoryqc.setPid(PrivilegeThird_repositorymanagerment.getId());
		PrivilegeForth_repositoryqc.setType("1");
		session.save(PrivilegeForth_repositoryqc);
		/**
		 * 期初管理-->期初增加
		 */
		Privilege PrivilegeFifth_repositoryqc_create = new Privilege();
		PrivilegeFifth_repositoryqc_create.setIcon("images/003.gif");
		PrivilegeFifth_repositoryqc_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_repositoryqc_create.setName("增加");
		PrivilegeFifth_repositoryqc_create.setPid(PrivilegeForth_repositoryqc.getId());
		PrivilegeFifth_repositoryqc_create.setType("1");
		session.save(PrivilegeFifth_repositoryqc_create);
		/**
		 * 期初管理-->期初修改
		 */
		Privilege PrivilegeFifth_repositoryqc_update = new Privilege();
		PrivilegeFifth_repositoryqc_update.setIcon("images/003.gif");
		PrivilegeFifth_repositoryqc_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_repositoryqc_update.setName("修改");
		PrivilegeFifth_repositoryqc_update.setPid(PrivilegeForth_repositoryqc.getId());
		PrivilegeFifth_repositoryqc_update.setType("1");
		session.save(PrivilegeFifth_repositoryqc_update);
		/**
		 * 期初管理-->期初查询
		 */
		Privilege PrivilegeFifth_repositoryqc_query = new Privilege();
		PrivilegeFifth_repositoryqc_query.setIcon("images/003.gif");
		PrivilegeFifth_repositoryqc_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_repositoryqc_query.setName("查询");
		PrivilegeFifth_repositoryqc_query.setPid(PrivilegeForth_repositoryqc.getId());
		PrivilegeFifth_repositoryqc_query.setType("1");
		session.save(PrivilegeFifth_repositoryqc_query);
		/**
		 * 期初管理-->期初审批
		 */
		Privilege PrivilegeFifth_repositoryqc_approve = new Privilege();
		PrivilegeFifth_repositoryqc_approve.setIcon("images/003.gif");
		PrivilegeFifth_repositoryqc_approve.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_repositoryqc_approve.setName("审批");
		PrivilegeFifth_repositoryqc_approve.setPid(PrivilegeForth_repositoryqc.getId());
		PrivilegeFifth_repositoryqc_approve.setType("1");
		session.save(PrivilegeFifth_repositoryqc_approve);
		/**
		 * 仓库管理-->盘点
		 */
		Privilege PrivilegeForth_repositorypd = new Privilege();
		PrivilegeForth_repositorypd.setIcon("images/003.gif");
		PrivilegeForth_repositorypd.setIsParent(true);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeForth_repositorypd.setName("盘点");
		PrivilegeForth_repositorypd.setPid(PrivilegeThird_repositorymanagerment.getId());
		PrivilegeForth_repositorypd.setType("1");
		session.save(PrivilegeForth_repositorypd);
		/**
		 * 盘点-->盘点增加
		 */
		Privilege PrivilegeFifth_repositorypd_create = new Privilege();
		PrivilegeFifth_repositorypd_create.setIcon("images/003.gif");
		PrivilegeFifth_repositorypd_create.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_repositorypd_create.setName("增加");
		PrivilegeFifth_repositorypd_create.setPid(PrivilegeForth_repositorypd.getId());
		PrivilegeFifth_repositorypd_create.setType("1");
		session.save(PrivilegeFifth_repositorypd_create);
		/**
		 * 盘点-->盘点修改
		 */
		Privilege PrivilegeFifth_repositorypd_update = new Privilege();
		PrivilegeFifth_repositorypd_update.setIcon("images/003.gif");
		PrivilegeFifth_repositorypd_update.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_repositorypd_update.setName("修改");
		PrivilegeFifth_repositorypd_update.setPid(PrivilegeForth_repositorypd.getId());
		PrivilegeFifth_repositorypd_update.setType("1");
		session.save(PrivilegeFifth_repositorypd_update);
		/**
		 * 盘点-->盘点查询
		 */
		Privilege PrivilegeFifth_repositorypd_query = new Privilege();
		PrivilegeFifth_repositorypd_query.setIcon("images/003.gif");
		PrivilegeFifth_repositorypd_query.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_repositorypd_query.setName("查询");
		PrivilegeFifth_repositorypd_query.setPid(PrivilegeForth_repositorypd.getId());
		PrivilegeFifth_repositorypd_query.setType("1");
		session.save(PrivilegeFifth_repositorypd_query);
		/**
		 * 盘点-->盘点审批
		 */
		Privilege PrivilegeFifth_repositorypd_approve = new Privilege();
		PrivilegeFifth_repositorypd_approve.setIcon("images/003.gif");
		PrivilegeFifth_repositorypd_approve.setIsParent(false);
		//PrivilegeSecond_basedata.setMid(2L);
		PrivilegeFifth_repositorypd_approve.setName("审批");
		PrivilegeFifth_repositorypd_approve.setPid(PrivilegeForth_repositorypd.getId());
		PrivilegeFifth_repositorypd_approve.setType("1");
		
		session.save(PrivilegeFifth_repositorypd_approve);
		
		transaction.commit();
		session.close();
	}
}
