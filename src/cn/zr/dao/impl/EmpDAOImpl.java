package cn.zr.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.zr.dao.EmpDAO;
import cn.zr.entity.Emp;

@Repository("empDao")
public class EmpDAOImpl extends HibernateDaoSupport implements EmpDAO {

//    private SessionFactory sessionFactory;
//
//    public void setSessionFactory(SessionFactory sessionFactory){
//       this.sessionFactory = sessionFactory;
//    }
//
//    private Session getCurrentSession(){
//     return sessionFactory.getCurrentSession(); 
//    }
	protected void initDao() {
		//do nothing
	}
	
		@Autowired
	   @Qualifier("sessionFactory")
	   //@Resource("sessionFactory")
	   public void setMySessionFactory(SessionFactory sessionFactory){
		   super.setSessionFactory(sessionFactory);
	   }
 
		
	public void delete(Emp persistentInstance) {
        log.debug("deleting Emp instance");
        try {
        	 super.getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Emp findById( Emp id) {
        log.debug("getting Emp instance with id: " + id);
        try {
            Emp instance = (Emp) super.getHibernateTemplate()
                    .get("cn.zr.entity.Emp", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
  
	@SuppressWarnings("unchecked")
	public List<Emp> findAll() {
		log.debug("finding all Emp instances");
		try {
			String queryString = "from Emp";
//	         Query queryObject = getCurrentSession().createQuery(queryString);
//			 return queryObject.list();
			return  (List<Emp>)super.getHibernateTemplate().find(queryString, null);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Emp merge(Emp detachedInstance) {
        log.debug("merging Emp instance");
        try {
            Emp result = (Emp) super.getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void saveOrUpdate(Emp instance) {
        log.debug("attaching dirty Emp instance");
        try {
        	 super.getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
  
}