package cn.itcast.ssh.web.action;

import cn.itcast.ssh.domain.LeaveBill;
import cn.itcast.ssh.service.ILeaveBillService;
import cn.itcast.ssh.utils.ValueContext;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class LeaveBillAction extends ActionSupport implements ModelDriven<LeaveBill> {

	private LeaveBill leaveBill = new LeaveBill();
	
	@Override
	public LeaveBill getModel() {
		return leaveBill;
	}
	
	private ILeaveBillService leaveBillService;

	public void setLeaveBillService(ILeaveBillService leaveBillService) {
		this.leaveBillService = leaveBillService;
	}

	/**
	 * 请假管理首页显示
	 * @return
	 */
	public String home(){
		//1: 查询所有的请假信息（对应a_leavebill），返回List<LeaveBill>
		List<LeaveBill> list = leaveBillService.findLeaveBillList();
		//放置到上下文对象中
		ValueContext.putValueContext("list", list);
		return "home";
	}
	
	/**
	 * 添加请假申请
	 * @return
	 */
	public String input(){
		//1: 获取请假单ID
		Long id = leaveBill.getId();
		//修改
		if(id!=null){
			//2: 使用请假单ID，查询请假单信息
			LeaveBill bill = leaveBillService.findLeaveBillById(id);
			//3： 将请假单信息放置到栈顶，页面使用struts2的标签，支持表单回显
			ValueContext.putValueStack(bill);
		}
		//新增
		return "input";
	}
	
	/**
	 * 保存/更新，请假申请
	 * 
	 * */
	public String save() {
		//执行保存
		leaveBillService.saveLeaveBill(leaveBill);
		return "save";
	}
	
	/**
	 * 保存/更新，请假申请启动
	 * 
	 * */
	public String save2(){
		//执行保存,保存请假单
		leaveBillService.saveLeaveBill2_1(leaveBill);
		long id = leaveBill.getId();
		//根据请假单id，启动流程实例并完成初始任务
		return "save";
	}
	
	/**
	 * 删除，请假申请
	 * 
	 * */
	public String delete(){
		//1: h获取请假单ID
		Long id = leaveBill.getId();
		//执行删除
		leaveBillService.deleteLeaveBillById(id);
		return "save";
	}
	
	/**
	 * 初始化请假单
	 * 
	 * */
	public String init(){
		//打开input时，生成请假单id，并保存
		leaveBillService.saveLeaveBill(leaveBill);
		return "save";
	}
	
}
