package entity;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	
	private Integer sid;
	private Integer sno;
	private String password;
	private String name;
	private String sex;
	private String department;
	private String nativePlace;
	private String mark;
	private String email;
	private String image;
	private String tel;
	private Integer maxCourse;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Integer sid, Integer sno, String password) {
		this.sid = sid;
		this.sno = sno;
		this.password = password;
	}

	/** full constructor */
	public Student(Integer sid, Integer sno, String password, String name,
			String sex, String department, String nativePlace, String mark,
			String email, String image, String tel, Integer maxCourse) {
		this.sid = sid;
		this.sno = sno;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.department = department;
		this.nativePlace = nativePlace;
		this.mark = mark;
		this.email = email;
		this.image = image;
		this.tel = tel;
		this.maxCourse = maxCourse;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getSno() {
		return this.sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
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

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getNativePlace() {
		return this.nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getMaxCourse() {
		return this.maxCourse;
	}

	public void setMaxCourse(Integer maxCourse) {
		this.maxCourse = maxCourse;
	}
}