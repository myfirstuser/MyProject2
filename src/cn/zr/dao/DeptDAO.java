package cn.zr.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.zr.entity.Dept;
 
public interface DeptDAO  {
	public static final Logger log = LoggerFactory.getLogger(DeptDAO.class);
		//property constants
	public static final String DNAME = "dname";
	public static final String DLOC = "dloc";


	public void delete(Dept persistentInstance);
    
    public Dept findById( java.math.BigDecimal id);

	public List<Dept> findAll();
  
    public void saveOrUpdate(Dept instance);
    
    public List<Dept> findByPage(int page,int pageSize);
}