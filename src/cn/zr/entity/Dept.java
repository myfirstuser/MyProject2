package cn.zr.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * Dept entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="DEPT",schema="system")
public class Dept  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 3478021825649656208L;
	@Id
	@Column(name="DEPTNO")
	@GeneratedValue(generator="SEQ_DEPT",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="SEQ_DEPT",sequenceName="SEQ_DEPT")
	private Long deptno;
	@Column(name="DNAME")
     private String dname;
	@Column(name="DLOC")
     private String dloc;
     @SuppressWarnings({ "unchecked", "rawtypes" })
     @OneToMany(cascade={CascadeType.ALL},mappedBy="dept",targetEntity=Emp.class)
	private Set<Emp> emps = new HashSet(0);


    // Constructors

    /** default constructor */
    public Dept() {
    }

	/** minimal constructor */
    public Dept(Long deptno) {
        this.deptno = deptno;
    }
    
    /** full constructor */
    public Dept(Long deptno, String dname, String dloc, Set<Emp> emps) {
        this.deptno = deptno;
        this.dname = dname;
        this.dloc = dloc;
        this.emps = emps;
    }

   
    // Property accessors

    public Long getDeptno() {
        return this.deptno;
    }
    
    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return this.dname;
    }
    
    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDloc() {
        return this.dloc;
    }
    
    public void setDloc(String dloc) {
        this.dloc = dloc;
    }

    public Set<Emp> getEmps() {
        return this.emps;
    }
    
    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }
   








}