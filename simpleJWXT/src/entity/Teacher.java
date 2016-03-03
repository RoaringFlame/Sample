package entity;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	
	private Integer tid;
	private Integer tno;
	private String password;
	private String name;
	private Integer age;
	private String rank;
	private String email;
	private String tel;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Integer tid, Integer tno, String password) {
		this.tid = tid;
		this.tno = tno;
		this.password = password;
	}

	/** full constructor */
	public Teacher(Integer tid, Integer tno, String password, String name,
			Integer age, String rank, String email, String tel) {
		this.tid = tid;
		this.tno = tno;
		this.password = password;
		this.name = name;
		this.age = age;
		this.rank = rank;
		this.email = email;
		this.tel = tel;
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getTno() {
		return this.tno;
	}

	public void setTno(Integer tno) {
		this.tno = tno;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRank() {
		return this.rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}