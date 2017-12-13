package cn.zr.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.zr.entity.Emp;

public interface EmpDAO  {
	public static final Logger log = LoggerFactory.getLogger(EmpDAO.class);
		//property constants
   
	public void delete(Emp persistentInstance);
    
    public Emp findById(Emp id);
   
	public List<Emp> findAll();
   
    public void saveOrUpdate(Emp instance);
    
   
}