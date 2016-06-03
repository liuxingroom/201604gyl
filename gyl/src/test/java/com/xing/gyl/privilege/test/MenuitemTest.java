package com.xing.gyl.privilege.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xing.gyl.domain.privilege.Menuitem;



public class MenuitemTest {
	@Test
	public void testAddMenuitem(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/xing/gyl/spring/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		 /**
		  * 根节点
		  */
		Menuitem menuitemFirst = new Menuitem();
		//menuitemFirst.setMid(1L);
		menuitemFirst.setName("供应链管理系统");
		menuitemFirst.setPid(0L);
		menuitemFirst.setIsParent(true);
		menuitemFirst.setIcon("images/003.gif");
		
		session.save(menuitemFirst);
		/**
		 * 基础数据
		 */
		Menuitem menuitemSecond_basedata = new Menuitem();
		menuitemSecond_basedata.setIcon("images/003.gif");
		menuitemSecond_basedata.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemSecond_basedata.setName("基础数据");
		menuitemSecond_basedata.setPid(menuitemFirst.getMid());
		session.save(menuitemSecond_basedata);
		
		/**
		 * 基础数据--》部门
		 */
		Menuitem menuitemThird_department = new Menuitem();
		menuitemThird_department.setIcon("images/003.gif");
		menuitemThird_department.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemThird_department.setName("部门");
		menuitemThird_department.setPid(menuitemSecond_basedata.getMid());
		session.save(menuitemThird_department);
		
		/**
		 * 基础数据-->用户
		 */
		Menuitem menuitemThird_user = new Menuitem();
		menuitemThird_user.setIcon("images/003.gif");
		menuitemThird_user.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemThird_user.setName("用户");
		menuitemThird_user.setPid(menuitemSecond_basedata.getMid());
		session.save(menuitemThird_user);
		/**
		 * 基础数据-->角色
		 */
		Menuitem menuitemThird_role = new Menuitem();
		menuitemThird_role.setIcon("images/003.gif");
		menuitemThird_role.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemThird_role.setName("角色");
		menuitemThird_role.setPid(menuitemSecond_basedata.getMid());
		session.save(menuitemThird_role);
		/**
		 * 基础数据-->商品档案
		 */
		Menuitem menuitemThird_product = new Menuitem();
		menuitemThird_product.setIcon("images/003.gif");
		menuitemThird_product.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemThird_product.setName("商品");
		menuitemThird_product.setPid(menuitemSecond_basedata.getMid());
		session.save(menuitemThird_product);
		/**
		 * 基础数据-->仓库
		 */
		Menuitem menuitemThird_repository = new Menuitem();
		menuitemThird_repository.setIcon("images/003.gif");
		menuitemThird_repository.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemThird_repository.setName("仓库");
		menuitemThird_repository.setPid(menuitemSecond_basedata.getMid());
		session.save(menuitemThird_repository);
		/**
		 * 基础数据-->客户
		 */
		Menuitem menuitemThird_customer = new Menuitem();
		menuitemThird_customer.setIcon("images/003.gif");
		menuitemThird_customer.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemThird_customer.setName("客户");
		menuitemThird_customer.setPid(menuitemSecond_basedata.getMid());
		session.save(menuitemThird_customer);
		/**
		 * 基础数据-->供应商
		 */
		Menuitem menuitemThird_supplier = new Menuitem();
		menuitemThird_supplier.setIcon("images/003.gif");
		menuitemThird_supplier.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemThird_supplier.setName("供应商");
		menuitemThird_supplier.setPid(menuitemSecond_basedata.getMid());
		session.save(menuitemThird_supplier);
		/**
		 * 权限管理
		 */
		Menuitem menuitemSecond_privilege = new Menuitem();
		menuitemSecond_privilege.setIcon("images/003.gif");
		menuitemSecond_privilege.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemSecond_privilege.setName("权限管理");
		menuitemSecond_privilege.setPid(menuitemFirst.getMid());
		session.save(menuitemSecond_privilege);
		/**
		 * 权限管理-->角色配置 
		 */
		Menuitem menuitemThird_userrole = new Menuitem();
		menuitemThird_userrole.setIcon("images/003.gif");
		menuitemThird_userrole.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemThird_userrole.setName("角色配置");
		menuitemThird_userrole.setPid(menuitemSecond_privilege.getMid());
		session.save(menuitemThird_userrole);
		/**
		 * 权限管理-->权限配置
		 */
		Menuitem menuitemThird_roleprivilege = new Menuitem();
		menuitemThird_roleprivilege.setIcon("images/003.gif");
		menuitemThird_roleprivilege.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemThird_roleprivilege.setName("权限配置");
		menuitemThird_roleprivilege.setPid(menuitemSecond_privilege.getMid());
		session.save(menuitemThird_roleprivilege);
		/**
		 * 业务
		 */
		Menuitem menuitemSecond_business = new Menuitem();
		menuitemSecond_business.setIcon("images/003.gif");
		menuitemSecond_business.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemSecond_business.setName("业务");
		menuitemSecond_business.setPid(menuitemFirst.getMid());
		session.save(menuitemSecond_business);
		/**
		 * 业务-->采购管理
		 */
		Menuitem menuitemThird_purchase = new Menuitem();  //采购
		menuitemThird_purchase.setIcon("images/003.gif");
		menuitemThird_purchase.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemThird_purchase.setName("采购管理");
		menuitemThird_purchase.setPid(menuitemSecond_business.getMid());
		session.save(menuitemThird_purchase);
		/**
		 * 采购管理-->请购单管理
		 */
		Menuitem menuitemForth_prepurchase = new Menuitem();
		menuitemForth_prepurchase.setIcon("images/003.gif");
		menuitemForth_prepurchase.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_prepurchase.setName("请购单管理");
		menuitemForth_prepurchase.setPid(menuitemThird_purchase.getMid());
		session.save(menuitemForth_prepurchase);
		/**
		 * 请购单管理-->请购单增加
		 */
		Menuitem menuitemFifth_prepurchase_create = new Menuitem();
		menuitemFifth_prepurchase_create.setIcon("images/003.gif");
		menuitemFifth_prepurchase_create.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_prepurchase_create.setName("增加");
		menuitemFifth_prepurchase_create.setPid(menuitemForth_prepurchase.getMid());
		session.save(menuitemFifth_prepurchase_create);
		/**
		 * 请购单管理-->请购单修改
		 */
		Menuitem menuitemFifth_prepurchase_update = new Menuitem();
		menuitemFifth_prepurchase_update.setIcon("images/003.gif");
		menuitemFifth_prepurchase_update.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_prepurchase_update.setName("修改");
		menuitemFifth_prepurchase_update.setPid(menuitemForth_prepurchase.getMid());
		session.save(menuitemFifth_prepurchase_update);
		/**
		 * 请购单管理-->请购单查询
		 */
		Menuitem menuitemFifth_prepurchase_query = new Menuitem();
		menuitemFifth_prepurchase_query.setIcon("images/003.gif");
		menuitemFifth_prepurchase_query.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_prepurchase_query.setName("查询");
		menuitemFifth_prepurchase_query.setPid(menuitemForth_prepurchase.getMid());
		session.save(menuitemFifth_prepurchase_query);
		/**
		 * 请购单管理-->请购单审批
		 */
		Menuitem menuitemFifth_prepurchase_approve = new Menuitem();
		menuitemFifth_prepurchase_approve.setIcon("images/003.gif");
		menuitemFifth_prepurchase_approve.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_prepurchase_approve.setName("审批");
		menuitemFifth_prepurchase_approve.setPid(menuitemForth_prepurchase.getMid());
		session.save(menuitemFifth_prepurchase_approve);
		/**
		 * 采购管理-->采购订单管理
		 */
		Menuitem menuitemForth_purchaseorder = new Menuitem();
		menuitemForth_purchaseorder.setIcon("images/003.gif");
		menuitemForth_purchaseorder.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_purchaseorder.setName("请购单管理");
		menuitemForth_purchaseorder.setPid(menuitemThird_purchase.getMid());
		session.save(menuitemForth_purchaseorder);
		/**
		 * 采购订单管理-->采购订单增加
		 */
		Menuitem menuitemFifth_purchaseorder_create = new Menuitem();
		menuitemFifth_purchaseorder_create.setIcon("images/003.gif");
		menuitemFifth_purchaseorder_create.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_purchaseorder_create.setName("增加");
		menuitemFifth_purchaseorder_create.setPid(menuitemForth_purchaseorder.getMid());
		session.save(menuitemFifth_purchaseorder_create);
		/**
		 * 采购订单管理-->采购订单修改
		 */
		Menuitem menuitemFifth_purchaseorder_update = new Menuitem();
		menuitemFifth_purchaseorder_update.setIcon("images/003.gif");
		menuitemFifth_purchaseorder_update.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_purchaseorder_update.setName("修改");
		menuitemFifth_purchaseorder_update.setPid(menuitemForth_purchaseorder.getMid());
		session.save(menuitemFifth_purchaseorder_update);
		/**
		 * 采购订单管理-->采购订单查询
		 */
		Menuitem menuitemFifth_purchaseorder_query = new Menuitem();
		menuitemFifth_purchaseorder_query.setIcon("images/003.gif");
		menuitemFifth_purchaseorder_query.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_purchaseorder_query.setName("查询");
		menuitemFifth_purchaseorder_query.setPid(menuitemForth_purchaseorder.getMid());
		session.save(menuitemFifth_purchaseorder_query);
		/**
		 * 采购订单管理-->采购订单审批
		 */
		Menuitem menuitemFifth_purchaseorder_approve = new Menuitem();
		menuitemFifth_purchaseorder_approve.setIcon("images/003.gif");
		menuitemFifth_purchaseorder_approve.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_purchaseorder_approve.setName("审批");
		menuitemFifth_purchaseorder_approve.setPid(menuitemForth_purchaseorder.getMid());
		session.save(menuitemFifth_purchaseorder_approve);
		/**
		 * 采购管理-->采购入库单管理
		 */
		Menuitem menuitemForth_purchaseinrepository = new Menuitem();
		menuitemForth_purchaseinrepository.setIcon("images/003.gif");
		menuitemForth_purchaseinrepository.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_purchaseinrepository.setName("采购入库单管理");
		menuitemForth_purchaseinrepository.setPid(menuitemThird_purchase.getMid());
		session.save(menuitemForth_purchaseinrepository);
		/**
		 *	采购入库单管理-->采购入库增加
		 */
		Menuitem menuitemFifth_purchaseinrepository_create = new Menuitem();
		menuitemFifth_purchaseinrepository_create.setIcon("images/003.gif");
		menuitemFifth_purchaseinrepository_create.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_purchaseinrepository_create.setName("增加");
		menuitemFifth_purchaseinrepository_create.setPid(menuitemForth_purchaseinrepository.getMid());
		session.save(menuitemFifth_purchaseinrepository_create);
		/**
		 *	采购入库单管理-->采购入库修改
		 */
		Menuitem menuitemFifth_purchaseinrepository_update = new Menuitem();
		menuitemFifth_purchaseinrepository_update.setIcon("images/003.gif");
		menuitemFifth_purchaseinrepository_update.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_purchaseinrepository_update.setName("修改");
		menuitemFifth_purchaseinrepository_update.setPid(menuitemForth_purchaseinrepository.getMid());
		session.save(menuitemFifth_purchaseinrepository_update);
		/**
		 *	采购入库单管理-->采购入库查询
		 */
		Menuitem menuitemFifth_purchaseinrepository_query = new Menuitem();
		menuitemFifth_purchaseinrepository_query.setIcon("images/003.gif");
		menuitemFifth_purchaseinrepository_query.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_purchaseinrepository_query.setName("查询");
		menuitemFifth_purchaseinrepository_query.setPid(menuitemForth_purchaseinrepository.getMid());
		session.save(menuitemFifth_purchaseinrepository_query);
		/**
		 *	采购入库单管理-->采购入库审批
		 */
		Menuitem menuitemFifth_purchaseinrepository_approve = new Menuitem();
		menuitemFifth_purchaseinrepository_approve.setIcon("images/003.gif");
		menuitemFifth_purchaseinrepository_approve.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_purchaseinrepository_approve.setName("审批");
		menuitemFifth_purchaseinrepository_approve.setPid(menuitemForth_purchaseinrepository.getMid());
		session.save(menuitemFifth_purchaseinrepository_approve);
		/**
		 * 采购管理-->采购发票管理
		 */
		Menuitem menuitemForth_purchaseinvoice = new Menuitem();
		menuitemForth_purchaseinvoice.setIcon("images/003.gif");
		menuitemForth_purchaseinvoice.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_purchaseinvoice.setName("采购发票管理");
		menuitemForth_purchaseinvoice.setPid(menuitemThird_purchase.getMid());
		session.save(menuitemForth_purchaseinvoice);
		/**
		 * 采购发票管理-->采购发票增加
		 */
		Menuitem menuitemFifth_purchaseinvoice_create = new Menuitem();
		menuitemFifth_purchaseinvoice_create.setIcon("images/003.gif");
		menuitemFifth_purchaseinvoice_create.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_purchaseinvoice_create.setName("增加");
		menuitemFifth_purchaseinvoice_create.setPid(menuitemForth_purchaseinvoice.getMid());
		session.save(menuitemFifth_purchaseinvoice_create);
		/**
		 * 采购发票管理-->采购发票修改
		 */
		Menuitem menuitemFifth_purchaseinvoice_update = new Menuitem();
		menuitemFifth_purchaseinvoice_update.setIcon("images/003.gif");
		menuitemFifth_purchaseinvoice_update.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_purchaseinvoice_update.setName("修改");
		menuitemFifth_purchaseinvoice_update.setPid(menuitemForth_purchaseinvoice.getMid());
		session.save(menuitemFifth_purchaseinvoice_update);
		/**
		 * 采购发票管理-->采购发票查询
		 */
		Menuitem menuitemFifth_purchaseinvoice_query = new Menuitem();
		menuitemFifth_purchaseinvoice_query.setIcon("images/003.gif");
		menuitemFifth_purchaseinvoice_query.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_purchaseinvoice_query.setName("查询");
		menuitemFifth_purchaseinvoice_query.setPid(menuitemForth_purchaseinvoice.getMid());
		session.save(menuitemFifth_purchaseinvoice_query);
		/**
		 * 采购发票管理-->采购发票审批
		 */
		Menuitem menuitemFifth_purchaseinvoice_approve = new Menuitem();
		menuitemFifth_purchaseinvoice_approve.setIcon("images/003.gif");
		menuitemFifth_purchaseinvoice_approve.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_purchaseinvoice_approve.setName("审批");
		menuitemFifth_purchaseinvoice_approve.setPid(menuitemForth_purchaseinvoice.getMid());
		session.save(menuitemFifth_purchaseinvoice_approve);
		/**
		 * 业务-->销售管理
		 */
		Menuitem menuitemThird_sale = new Menuitem();
		menuitemThird_sale.setIcon("images/003.gif");
		menuitemThird_sale.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemThird_sale.setName("销售管理");
		menuitemThird_sale.setPid(menuitemSecond_business.getMid());
		session.save(menuitemThird_sale);
		/**
		 * 销售管理-->销售预订单
		 */
		Menuitem menuitemForth_presaleorder = new Menuitem();
		menuitemForth_presaleorder.setIcon("images/003.gif");
		menuitemForth_presaleorder.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_presaleorder.setName("销售预订单管理");
		menuitemForth_presaleorder.setPid(menuitemThird_sale.getMid());
		session.save(menuitemForth_presaleorder);
		/**
		 * 销售预订单-->销售预订单增加
		 */
		Menuitem menuitemFifth_presaleorder_create = new Menuitem();
		menuitemFifth_presaleorder_create.setIcon("images/003.gif");
		menuitemFifth_presaleorder_create.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_presaleorder_create.setName("增加");
		menuitemFifth_presaleorder_create.setPid(menuitemForth_presaleorder.getMid());
		session.save(menuitemFifth_presaleorder_create);
		/**
		 * 销售预订单-->销售预订单修改
		 */
		Menuitem menuitemFifth_presaleorder_update = new Menuitem();
		menuitemFifth_presaleorder_update.setIcon("images/003.gif");
		menuitemFifth_presaleorder_update.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_presaleorder_update.setName("修改");
		menuitemFifth_presaleorder_update.setPid(menuitemForth_presaleorder.getMid());
		session.save(menuitemFifth_presaleorder_update);
		/**
		 * 销售预订单-->销售预订单查询
		 */
		Menuitem menuitemFifth_presaleorder_query = new Menuitem();
		menuitemFifth_presaleorder_query.setIcon("images/003.gif");
		menuitemFifth_presaleorder_query.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_presaleorder_query.setName("查询");
		menuitemFifth_presaleorder_query.setPid(menuitemForth_presaleorder.getMid());
		session.save(menuitemFifth_presaleorder_query);
		/**
		 * 销售预订单-->销售预订单审批
		 */
		Menuitem menuitemFifth_presaleorder_approve = new Menuitem();
		menuitemFifth_presaleorder_approve.setIcon("images/003.gif");
		menuitemFifth_presaleorder_approve.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_presaleorder_approve.setName("审批");
		menuitemFifth_presaleorder_approve.setPid(menuitemForth_presaleorder.getMid());
		session.save(menuitemFifth_presaleorder_approve);
		/**
		 * 销售管理-->销售订单管理
		 */
		Menuitem menuitemForth_saleorder = new Menuitem();
		menuitemForth_saleorder.setIcon("images/003.gif");
		menuitemForth_saleorder.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_saleorder.setName("销售订单管理");
		menuitemForth_saleorder.setPid(menuitemThird_sale.getMid());
		session.save(menuitemForth_saleorder);
		/**
		 * 销售订单管理-->销售订单增加
		 */
		Menuitem menuitemFifth_saleorder_create = new Menuitem();
		menuitemFifth_saleorder_create.setIcon("images/003.gif");
		menuitemFifth_saleorder_create.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_saleorder_create.setName("增加");
		menuitemFifth_saleorder_create.setPid(menuitemForth_saleorder.getMid());
		session.save(menuitemFifth_saleorder_create);
		/**
		 * 销售订单管理-->销售订单修改
		 */
		Menuitem menuitemFifth_saleorder_update = new Menuitem();
		menuitemFifth_saleorder_update.setIcon("images/003.gif");
		menuitemFifth_saleorder_update.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_saleorder_update.setName("增加");
		menuitemFifth_saleorder_update.setPid(menuitemForth_saleorder.getMid());
		session.save(menuitemFifth_saleorder_update);
		/**
		 * 销售订单管理-->销售订单查询
		 */
		Menuitem menuitemFifth_saleorder_query = new Menuitem();
		menuitemFifth_saleorder_query.setIcon("images/003.gif");
		menuitemFifth_saleorder_query.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_saleorder_query.setName("查询");
		menuitemFifth_saleorder_query.setPid(menuitemForth_saleorder.getMid());
		session.save(menuitemFifth_saleorder_query);
		/**
		 * 销售订单管理-->销售订单审批
		 */
		Menuitem menuitemFifth_saleorder_approve = new Menuitem();
		menuitemFifth_saleorder_approve.setIcon("images/003.gif");
		menuitemFifth_saleorder_approve.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_saleorder_approve.setName("审批");
		menuitemFifth_saleorder_approve.setPid(menuitemForth_saleorder.getMid());
		session.save(menuitemFifth_saleorder_approve);
		/**
		 * 销售管理-->发货单管理
		 */
		Menuitem menuitemForth_shippingorder = new Menuitem();
		menuitemForth_shippingorder.setIcon("images/003.gif");
		menuitemForth_shippingorder.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_shippingorder.setName("发货单管理");
		menuitemForth_shippingorder.setPid(menuitemThird_sale.getMid());
		session.save(menuitemForth_shippingorder);
		/**
		 * 发货单管理-->发货单增加
		 */
		Menuitem menuitemFifth_shippingorder_create = new Menuitem();
		menuitemFifth_shippingorder_create.setIcon("images/003.gif");
		menuitemFifth_shippingorder_create.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_shippingorder_create.setName("增加");
		menuitemFifth_shippingorder_create.setPid(menuitemForth_shippingorder.getMid());
		session.save(menuitemFifth_shippingorder_create);
		/**
		 * 发货单管理-->发货单修改
		 */
		Menuitem menuitemFifth_shippingorder_update = new Menuitem();
		menuitemFifth_shippingorder_update.setIcon("images/003.gif");
		menuitemFifth_shippingorder_update.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_shippingorder_update.setName("修改");
		menuitemFifth_shippingorder_update.setPid(menuitemForth_shippingorder.getMid());
		session.save(menuitemFifth_shippingorder_update);
		/**
		 * 发货单管理-->发货单查询
		 */
		Menuitem menuitemFifth_shippingorder_query = new Menuitem();
		menuitemFifth_shippingorder_query.setIcon("images/003.gif");
		menuitemFifth_shippingorder_query.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_shippingorder_query.setName("查询");
		menuitemFifth_shippingorder_query.setPid(menuitemForth_shippingorder.getMid());
		session.save(menuitemFifth_shippingorder_query);
		/**
		 * 发货单管理-->发货单审批
		 */
		Menuitem menuitemFifth_shippingorder_approve = new Menuitem();
		menuitemFifth_shippingorder_approve.setIcon("images/003.gif");
		menuitemFifth_shippingorder_approve.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_shippingorder_approve.setName("审批");
		menuitemFifth_shippingorder_approve.setPid(menuitemForth_shippingorder.getMid());
		session.save(menuitemFifth_shippingorder_approve);
		/**
		 * 销售管理-->销售出库单管理
		 */
		Menuitem menuitemForth_outboundorder = new Menuitem();
		menuitemForth_outboundorder.setIcon("images/003.gif");
		menuitemForth_outboundorder.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_outboundorder.setName("销售出库单管理");
		menuitemForth_outboundorder.setPid(menuitemThird_sale.getMid());
		session.save(menuitemForth_outboundorder);
		/**
		 * 销售出库单管理-->销售出库单增加
		 */
		Menuitem menuitemFifth_outboundorder_create = new Menuitem();
		menuitemFifth_outboundorder_create.setIcon("images/003.gif");
		menuitemFifth_outboundorder_create.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_outboundorder_create.setName("增加");
		menuitemFifth_outboundorder_create.setPid(menuitemForth_outboundorder.getMid());
		session.save(menuitemFifth_outboundorder_create);
		/**
		 * 销售出库单管理-->销售出库单修改
		 */
		Menuitem menuitemFifth_outboundorder_update = new Menuitem();
		menuitemFifth_outboundorder_update.setIcon("images/003.gif");
		menuitemFifth_outboundorder_update.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_outboundorder_update.setName("修改");
		menuitemFifth_outboundorder_update.setPid(menuitemForth_outboundorder.getMid());
		session.save(menuitemFifth_outboundorder_update);
		/**
		 * 销售出库单管理-->销售出库单查询
		 */
		Menuitem menuitemFifth_outboundorder_query = new Menuitem();
		menuitemFifth_outboundorder_query.setIcon("images/003.gif");
		menuitemFifth_outboundorder_query.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_outboundorder_query.setName("查询");
		menuitemFifth_outboundorder_query.setPid(menuitemForth_outboundorder.getMid());
		session.save(menuitemFifth_outboundorder_query);
		/**
		 * 销售出库单管理-->销售出库单审批
		 */
		Menuitem menuitemFifth_outboundorder_approve = new Menuitem();
		menuitemFifth_outboundorder_approve.setIcon("images/003.gif");
		menuitemFifth_outboundorder_approve.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_outboundorder_approve.setName("审批");
		menuitemFifth_outboundorder_approve.setPid(menuitemForth_outboundorder.getMid());
		session.save(menuitemFifth_outboundorder_approve);
		/**
		 * 销售管理-->销售开票管理
		 */
		Menuitem menuitemForth_invoiceorder = new Menuitem();
		menuitemForth_invoiceorder.setIcon("images/003.gif");
		menuitemForth_invoiceorder.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_invoiceorder.setName("销售开票管理");
		menuitemForth_invoiceorder.setPid(menuitemThird_sale.getMid());
		session.save(menuitemForth_invoiceorder);
		/**
		 * 销售开票管理-->销售开票增加
		 */
		Menuitem menuitemFifth_invoiceorder_create = new Menuitem();
		menuitemFifth_invoiceorder_create.setIcon("images/003.gif");
		menuitemFifth_invoiceorder_create.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_invoiceorder_create.setName("增加");
		menuitemFifth_invoiceorder_create.setPid(menuitemForth_invoiceorder.getMid());
		session.save(menuitemFifth_invoiceorder_create);
		/**
		 * 销售开票管理-->销售开票修改
		 */
		Menuitem menuitemFifth_invoiceorder_update = new Menuitem();
		menuitemFifth_invoiceorder_update.setIcon("images/003.gif");
		menuitemFifth_invoiceorder_update.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_invoiceorder_update.setName("修改");
		menuitemFifth_invoiceorder_update.setPid(menuitemForth_invoiceorder.getMid());
		session.save(menuitemFifth_invoiceorder_update);
		/**
		 * 销售开票管理-->销售开票查询
		 */
		Menuitem menuitemFifth_invoiceorder_query = new Menuitem();
		menuitemFifth_invoiceorder_query.setIcon("images/003.gif");
		menuitemFifth_invoiceorder_query.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_invoiceorder_query.setName("查询");
		menuitemFifth_invoiceorder_query.setPid(menuitemForth_invoiceorder.getMid());
		session.save(menuitemFifth_invoiceorder_query);
		/**
		 * 销售开票管理-->销售开票审批
		 */
		Menuitem menuitemFifth_invoiceorder_approve = new Menuitem();
		menuitemFifth_invoiceorder_approve.setIcon("images/003.gif");
		menuitemFifth_invoiceorder_approve.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_invoiceorder_approve.setName("审批");
		menuitemFifth_invoiceorder_approve.setPid(menuitemForth_invoiceorder.getMid());
		session.save(menuitemFifth_invoiceorder_approve);
		
		/**
		 * 业务-->应收应付管理
		 */
		Menuitem menuitemThird_paymentcollections = new Menuitem(); //应收应付
		menuitemThird_paymentcollections.setIcon("images/003.gif");
		menuitemThird_paymentcollections.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemThird_paymentcollections.setName("应收应付管理");
		menuitemThird_paymentcollections.setPid(menuitemSecond_business.getMid());
		session.save(menuitemThird_paymentcollections);
		/**
		 * 应收应付管理-->销售应收单管理
		 */
		Menuitem menuitemForth_salecollections = new Menuitem(); //销售应收单
		menuitemForth_salecollections.setIcon("images/003.gif");
		menuitemForth_salecollections.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_salecollections.setName("销售应收管理");
		menuitemForth_salecollections.setPid(menuitemThird_paymentcollections.getMid());
		session.save(menuitemForth_salecollections);
		/**
		 * 销售应收单管理-->销售应收单增加
		 */
		Menuitem menuitemFifth_salecollections_create = new Menuitem(); 
		menuitemFifth_salecollections_create.setIcon("images/003.gif");
		menuitemFifth_salecollections_create.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_salecollections_create.setName("增加");
		menuitemFifth_salecollections_create.setPid(menuitemForth_salecollections.getMid());
		session.save(menuitemFifth_salecollections_create);
		/**
		 * 销售应收单管理-->销售应收单修改
		 */
		Menuitem menuitemFifth_salecollections_update = new Menuitem(); 
		menuitemFifth_salecollections_update.setIcon("images/003.gif");
		menuitemFifth_salecollections_update.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_salecollections_update.setName("修改");
		menuitemFifth_salecollections_update.setPid(menuitemForth_salecollections.getMid());
		session.save(menuitemFifth_salecollections_update);
		/**
		 * 销售应收单管理-->销售应收单查询
		 */
		Menuitem menuitemFifth_salecollections_query = new Menuitem(); 
		menuitemFifth_salecollections_query.setIcon("images/003.gif");
		menuitemFifth_salecollections_query.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_salecollections_query.setName("查询");
		menuitemFifth_salecollections_query.setPid(menuitemForth_salecollections.getMid());
		session.save(menuitemFifth_salecollections_query);
		/**
		 * 销售应收单管理-->销售应收单审批
		 */
		Menuitem menuitemFifth_salecollections_approve = new Menuitem(); 
		menuitemFifth_salecollections_approve.setIcon("images/003.gif");
		menuitemFifth_salecollections_approve.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_salecollections_approve.setName("审批");
		menuitemFifth_salecollections_approve.setPid(menuitemForth_salecollections.getMid());
		session.save(menuitemFifth_salecollections_approve);
		
		/**
		 * 应收应付管理-->采购应付单管理
		 */
		Menuitem menuitemForth_collectionspayment = new Menuitem(); //销售应收单
		menuitemForth_collectionspayment.setIcon("images/003.gif");
		menuitemForth_collectionspayment.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_collectionspayment.setName("采购应付单管理");
		menuitemForth_collectionspayment.setPid(menuitemThird_paymentcollections.getMid());
		session.save(menuitemForth_collectionspayment);
		/**
		 * 采购应付单管理-->采购应付单增加
		 */
		Menuitem menuitemFifth_collectionspayment_create = new Menuitem(); //销售应收单
		menuitemFifth_collectionspayment_create.setIcon("images/003.gif");
		menuitemFifth_collectionspayment_create.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_collectionspayment_create.setName("增加");
		menuitemFifth_collectionspayment_create.setPid(menuitemForth_collectionspayment.getMid());
		session.save(menuitemFifth_collectionspayment_create);
		/**
		 * 采购应付单管理-->采购应付单修改
		 */
		Menuitem menuitemFifth_collectionspayment_update = new Menuitem(); //
		menuitemFifth_collectionspayment_update.setIcon("images/003.gif");
		menuitemFifth_collectionspayment_update.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_collectionspayment_update.setName("修改");
		menuitemFifth_collectionspayment_update.setPid(menuitemForth_collectionspayment.getMid());
		session.save(menuitemFifth_collectionspayment_update);
		/**
		 * 采购应付单管理-->采购应付单查询
		 */
		Menuitem menuitemFifth_collectionspayment_query = new Menuitem(); //
		menuitemFifth_collectionspayment_query.setIcon("images/003.gif");
		menuitemFifth_collectionspayment_query.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_collectionspayment_query.setName("查询");
		menuitemFifth_collectionspayment_query.setPid(menuitemForth_collectionspayment.getMid());
		session.save(menuitemFifth_collectionspayment_query);
		/**
		 * 采购应付单管理-->采购应付单审批
		 */
		Menuitem menuitemFifth_collectionspayment_approve = new Menuitem(); //
		menuitemFifth_collectionspayment_approve.setIcon("images/003.gif");
		menuitemFifth_collectionspayment_approve.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_collectionspayment_approve.setName("审批");
		menuitemFifth_collectionspayment_approve.setPid(menuitemForth_collectionspayment.getMid());
		session.save(menuitemFifth_collectionspayment_approve);
		
		/**
		 * 业务-->预警管理
		 */
		Menuitem menuitemThird_warning = new Menuitem();//预警
		menuitemThird_warning.setIcon("images/003.gif");
		menuitemThird_warning.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemThird_warning.setName("预警管理");
		menuitemThird_warning.setPid(menuitemSecond_business.getMid());
		session.save(menuitemThird_warning);
		/**
		 * 预警管理-->采购入库时间预警
		 */
		Menuitem menuitemForth_warning_inrepositorytime = new Menuitem();
		menuitemForth_warning_inrepositorytime.setIcon("images/003.gif");
		menuitemForth_warning_inrepositorytime.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_warning_inrepositorytime.setName("采购入库时间预警");
		menuitemForth_warning_inrepositorytime.setPid(menuitemThird_warning.getMid());
		session.save(menuitemForth_warning_inrepositorytime);
		/**
		 * 预警管理-->销售发货预警
		 */
		Menuitem menuitemForth_warning_saleshippingtime = new Menuitem();
		menuitemForth_warning_saleshippingtime.setIcon("images/003.gif");
		menuitemForth_warning_saleshippingtime.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_warning_saleshippingtime.setName("销售发货预警");
		menuitemForth_warning_saleshippingtime.setPid(menuitemThird_warning.getMid());
		session.save(menuitemForth_warning_saleshippingtime);
		/**
		 * 预警管理-->销售出库预警
		 */
		Menuitem menuitemForth_warning_outboundtime = new Menuitem();
		menuitemForth_warning_outboundtime.setIcon("images/003.gif");
		menuitemForth_warning_outboundtime.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_warning_outboundtime.setName("销售出库预警");
		menuitemForth_warning_outboundtime.setPid(menuitemThird_warning.getMid());
		session.save(menuitemForth_warning_outboundtime);
		/**
		 * 业务-->仓库管理
		 */
		Menuitem menuitemThird_repositorymanagerment = new Menuitem();//仓库管理
		menuitemThird_repositorymanagerment.setIcon("images/003.gif");
		menuitemThird_repositorymanagerment.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemThird_repositorymanagerment.setName("仓库管理");
		menuitemThird_repositorymanagerment.setPid(menuitemSecond_business.getMid());
		session.save(menuitemThird_repositorymanagerment);
		/**
		 * 仓库管理-->期初管理
		 */
		Menuitem menuitemForth_repositoryqc = new Menuitem();
		menuitemForth_repositoryqc.setIcon("images/003.gif");
		menuitemForth_repositoryqc.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_repositoryqc.setName("期初");
		menuitemForth_repositoryqc.setPid(menuitemThird_repositorymanagerment.getMid());
		session.save(menuitemForth_repositoryqc);
		/**
		 * 期初管理-->期初增加
		 */
		Menuitem menuitemFifth_repositoryqc_create = new Menuitem();
		menuitemFifth_repositoryqc_create.setIcon("images/003.gif");
		menuitemFifth_repositoryqc_create.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_repositoryqc_create.setName("增加");
		menuitemFifth_repositoryqc_create.setPid(menuitemForth_repositoryqc.getMid());
		session.save(menuitemFifth_repositoryqc_create);
		/**
		 * 期初管理-->期初修改
		 */
		Menuitem menuitemFifth_repositoryqc_update = new Menuitem();
		menuitemFifth_repositoryqc_update.setIcon("images/003.gif");
		menuitemFifth_repositoryqc_update.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_repositoryqc_update.setName("修改");
		menuitemFifth_repositoryqc_update.setPid(menuitemForth_repositoryqc.getMid());
		session.save(menuitemFifth_repositoryqc_update);
		/**
		 * 期初管理-->期初查询
		 */
		Menuitem menuitemFifth_repositoryqc_query = new Menuitem();
		menuitemFifth_repositoryqc_query.setIcon("images/003.gif");
		menuitemFifth_repositoryqc_query.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_repositoryqc_query.setName("查询");
		menuitemFifth_repositoryqc_query.setPid(menuitemForth_repositoryqc.getMid());
		session.save(menuitemFifth_repositoryqc_query);
		/**
		 * 期初管理-->期初审批
		 */
		Menuitem menuitemFifth_repositoryqc_approve = new Menuitem();
		menuitemFifth_repositoryqc_approve.setIcon("images/003.gif");
		menuitemFifth_repositoryqc_approve.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_repositoryqc_approve.setName("审批");
		menuitemFifth_repositoryqc_approve.setPid(menuitemForth_repositoryqc.getMid());
		session.save(menuitemFifth_repositoryqc_approve);
		/**
		 * 仓库管理-->盘点
		 */
		Menuitem menuitemForth_repositorypd = new Menuitem();
		menuitemForth_repositorypd.setIcon("images/003.gif");
		menuitemForth_repositorypd.setIsParent(true);
		//menuitemSecond_basedata.setMid(2L);
		menuitemForth_repositorypd.setName("盘点");
		menuitemForth_repositorypd.setPid(menuitemThird_repositorymanagerment.getMid());
		session.save(menuitemForth_repositorypd);
		/**
		 * 盘点-->盘点增加
		 */
		Menuitem menuitemFifth_repositorypd_create = new Menuitem();
		menuitemFifth_repositorypd_create.setIcon("images/003.gif");
		menuitemFifth_repositorypd_create.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_repositorypd_create.setName("增加");
		menuitemFifth_repositorypd_create.setPid(menuitemForth_repositorypd.getMid());
		session.save(menuitemFifth_repositorypd_create);
		/**
		 * 盘点-->盘点修改
		 */
		Menuitem menuitemFifth_repositorypd_update = new Menuitem();
		menuitemFifth_repositorypd_update.setIcon("images/003.gif");
		menuitemFifth_repositorypd_update.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_repositorypd_update.setName("修改");
		menuitemFifth_repositorypd_update.setPid(menuitemForth_repositorypd.getMid());
		session.save(menuitemFifth_repositorypd_update);
		/**
		 * 盘点-->盘点查询
		 */
		Menuitem menuitemFifth_repositorypd_query = new Menuitem();
		menuitemFifth_repositorypd_query.setIcon("images/003.gif");
		menuitemFifth_repositorypd_query.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_repositorypd_query.setName("查询");
		menuitemFifth_repositorypd_query.setPid(menuitemForth_repositorypd.getMid());
		session.save(menuitemFifth_repositorypd_query);
		/**
		 * 盘点-->盘点审批
		 */
		Menuitem menuitemFifth_repositorypd_approve = new Menuitem();
		menuitemFifth_repositorypd_approve.setIcon("images/003.gif");
		menuitemFifth_repositorypd_approve.setIsParent(false);
		//menuitemSecond_basedata.setMid(2L);
		menuitemFifth_repositorypd_approve.setName("审批");
		menuitemFifth_repositorypd_approve.setPid(menuitemForth_repositorypd.getMid());
		
		session.save(menuitemFifth_repositorypd_approve);
		
		transaction.commit();
		session.close();
	}
}
