package cn.zr.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.zr.entity.Dept;
import cn.zr.service.DeptService;

public class DeptJson extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6626631621312550353L;
	
	//json数据
	private List<Dept> rows;
	
	private DeptService deptService; 
	
	//总个数
	private int total;
	
	//当前页数
	private int page;
	
	//每页页数
	private int pageSize;
	
	@Override
	public String execute() throws Exception {
		
		pageSize=Integer.parseInt(ServletActionContext.getRequest().getParameter("rows"));
		rows=deptService.findByPage(page, pageSize);
		total=deptService.findByAll().size();
		return SUCCESS;
	}

	public List<Dept> getRows() {
		return rows;
	}
	
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public int getTotal() {
		return total;
	}

	public int getPage() {
		return page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	
}
