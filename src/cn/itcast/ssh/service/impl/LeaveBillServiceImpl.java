package cn.itcast.ssh.service.impl;

import java.util.List;

import cn.itcast.ssh.dao.ILeaveBillDao;
import cn.itcast.ssh.domain.LeaveBill;
import cn.itcast.ssh.service.ILeaveBillService;
import cn.itcast.ssh.utils.SessionContext;

public class LeaveBillServiceImpl implements ILeaveBillService {

	private ILeaveBillDao leaveBillDao;
	
	public void setLeaveBillDao(ILeaveBillDao leaveBillDao) {
		this.leaveBillDao = leaveBillDao;
	}
	
	/**查询自己的请假单的数据*/
	@Override
	public List<LeaveBill> findLeaveBillList() {
		List<LeaveBill> list = leaveBillDao.findLeaveBillList();
		return list;
	}
	
	/**保存请假单*/
	@Override
	public void saveLeaveBill(LeaveBill leaveBill) {
		//获取请假单ID
		Long id = leaveBill.getId();
		if(id==null){
			/**保存*/
			//1： 从Session中获取当前用户对象，将LeaveBill对象中user与Session中获取的用户对象进行关联
			leaveBill.setUser(SessionContext.get());//建立关联关系
			//2： 保存请假单表，添加一条数据
			leaveBillDao.saveLeaveBill(leaveBill);
		}
		/**更新保存*/
		else{
			//1: 执行update的操作，完成更新
			leaveBillDao.updateLeaveBill(leaveBill);
		}
		
				
	}
	
	/**保存请假单,启动流程实例*/
	@Override
	public void saveLeaveBill2_1(LeaveBill leaveBill) {
		//获取请假单ID
		Long id = leaveBill.getId();
		if(id==null){
			/**保存*/
			//1： 从Session中获取当前用户对象，将LeaveBill对象中user与Session中获取的用户对象进行关联
			leaveBill.setUser(SessionContext.get());//建立关联关系
			//2： 保存请假单表，添加一条数据
			leaveBillDao.saveLeaveBill(leaveBill);
		}
		/**更新保存*/
		else{
			//1: 执行update的操作，完成更新
			leaveBillDao.updateLeaveBill(leaveBill);
		}		
	}
	
	@Override
	public void saveLeaveBill2_2(Long id) {
		
	}
	
	/**使用请假单ID，查询请假单的对象*/
	@Override
	public LeaveBill findLeaveBillById(Long id) {
		LeaveBill bill = leaveBillDao.findLeaveBillById(id);
		return bill;
	}
	
	/**使用请假单ID，删除请假单*/
	@Override
	public void deleteLeaveBillById(Long id) {
		leaveBillDao.deleteLeaveBillById(id);
		
	}

}
