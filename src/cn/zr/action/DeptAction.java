package cn.zr.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.zr.entity.Dept;
import cn.zr.service.DeptService;
@Scope("prototype")
@Controller
public class DeptAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7758898517726659786L;

	private List<Dept> depts;
	
	private DeptService deptServiceImpl;

	public List<Dept> getDepts() {
		return depts;
	}

	@Autowired
	@Qualifier("deptService")
	public void setDeptServiceImpl(DeptService deptServiceImpl) {
		this.deptServiceImpl = deptServiceImpl;
	}
	
	@Action(value="deptShowAll",results={
		@Result(name="success",location="/success.jsp"),
		@Result(name="input",location="login.jsp")
		
	})
	@Override
	public String execute() throws Exception {
		depts=deptServiceImpl.findByAll();
		return SUCCESS;
	}
	
	
	
}
