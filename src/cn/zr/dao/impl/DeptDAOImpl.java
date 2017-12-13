package cn.zr.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.zr.dao.DeptDAO;
import cn.zr.entity.Dept;

   @Repository("deptDao")
public class DeptDAOImpl extends HibernateDaoSupport implements DeptDAO {
	   
//    private SessionFactory sessionFactory;
//
//    public void setSessionFactory(SessionFactory sessionFactory){
//       this.sessionFactory = sessionFactory;
//    }
//
//    private Session getCurrentSession(){
//     return sessionFactory.getCurrentSession(); 
//    }
    	//sessionFactory注入
	   @Autowired
	   @Qualifier("sessionFactory")
	   //@Resource("sessionFactory")
	   public void setMySessionFactory(SessionFactory sessionFactory){
		   super.setSessionFactory(sessionFactory);
	   }
	   
	protected void initDao() {
		//do nothing
	}
    
    public void save(Dept transientInstance) {
        log.debug("saving Dept instance");
        try {
            super.getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Dept persistentInstance) {
        log.debug("deleting Dept instance");
        try {
        	 super.getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Dept findById( java.math.BigDecimal id) {
        log.debug("getting Dept instance with id: " + id);
        try {
            Dept instance = (Dept) super.getHibernateTemplate()
                    .get("cn.zr.entity.Dept", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    


	@SuppressWarnings("unchecked")
	public List<Dept> findAll() {
		log.debug("finding all Dept instances");
		try {
			String queryString = "from Dept";
//	         Query queryObject = getCurrentSession().createQuery(queryString);
//			 return queryObject.list();
			 return (List<Dept>)super.getHibernateTemplate().find(queryString, null);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Dept merge(Dept detachedInstance) {
        log.debug("merging Dept instance");
        try {
            Dept result = (Dept)  super.getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void saveOrUpdate(Dept instance) {
        log.debug("attaching dirty Dept instance");
        try {
        	 super.getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> findByPage(int page, int pageSize) {
		log.debug("finding by page Dept instances");
		try {
			DetachedCriteria dc=DetachedCriteria.forClass(Dept.class);
			 return (List<Dept>)super.getHibernateTemplate().findByCriteria(dc, (page-1)*pageSize,pageSize);
		} catch (RuntimeException re) {
			log.error("find by page failed", re);
			throw re;
		}
	}
    
    
	
}