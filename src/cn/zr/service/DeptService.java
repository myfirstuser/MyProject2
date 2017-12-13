package cn.zr.service;

import java.util.List;

import cn.zr.entity.Dept;

public interface DeptService {
	public List<Dept> findByAll();
	
	public List<Dept> findByPage(int page,int pageSize);
}
