package cn.zr.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="EMP",schema="system")
public class Emp  implements java.io.Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 2447046968100880653L;
	// Fields    
	@Id
	@Column(name="EMPNO")
	private Long empno;
	@Column(name="ENAME")
    private String ename;
	@Column(name="EJOB")
    private String ejob;
	@Transient
    private String esex;
	@Column(name="EAGE")
    private Long eage;
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER,targetEntity=Dept.class)
	@JoinColumn(name="DEPTNO")
	private Dept dept;
	@Column(name="ESAL")
    private Long esal;

    public Emp() {
		super();
	}
	public Emp(Long empno, String ename, String ejob, String esex, Long eage, Dept dept, Long esal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.ejob = ejob;
		this.esex = esex;
		this.eage = eage;
		this.dept = dept;
		this.esal = esal;
	}
	public Long getEmpno() {
		return empno;
	}
	public void setEmpno(Long empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEjob() {
		return ejob;
	}
	public void setEjob(String ejob) {
		this.ejob = ejob;
	}
	public String getEsex() {
		return esex;
	}
	public void setEsex(String esex) {
		this.esex = esex;
	}
	public Long getEage() {
		return eage;
	}
	public void setEage(Long eage) {
		this.eage = eage;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Long getEsal() {
		return esal;
	}
	public void setEsal(Long esal) {
		this.esal = esal;
	}




}