package cn.zr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.zr.dao.DeptDAO;
import cn.zr.entity.Dept;
import cn.zr.service.DeptService;
@Service("deptService")
public class DeptServiceImpl implements DeptService {

	
	private DeptDAO deptDao; 
	
	
	@Override
	public List<Dept> findByAll() {
		return deptDao.findAll();
	}
	
	
	@Override
	public List<Dept> findByPage(int page, int pageSize) {
		return deptDao.findByPage(page, pageSize);
	}

	@Autowired
	@Qualifier("deptDao")
	public void setDeptDao(DeptDAO deptDao) {
		this.deptDao = deptDao;
	}


}
