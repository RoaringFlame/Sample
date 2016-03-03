package action.admin;

import com.opensymphony.xwork2.ActionSupport;

import dao.StudentDao;
import entity.Student;

public class SaveStudent extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Integer sid;
	private Integer sno;
	private String name;
	private String sex;
	private String department;
	private String nativePlace;
	private String mark;
	private String email;
	private String tel;
	private Integer maxCourse;
	
	private int pageNumber;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getMaxCourse() {
		return maxCourse;
	}

	public void setMaxCourse(Integer maxCourse) {
		this.maxCourse = maxCourse;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String execute() {
		Student stu = new Student();
		stu.setSno(this.getSno());
		stu.setPassword("2015");
		stu.setName(this.getName());
		stu.setSex(this.getSex());
		stu.setDepartment(this.getDepartment());
		stu.setNativePlace(this.getNativePlace());
		stu.setMark(this.getMark());
		stu.setEmail(this.getEmail());
		stu.setTel(this.getTel());
		stu.setMaxCourse(this.getMaxCourse());
		StudentDao sDao = new StudentDao();
		if (sDao.saveStudent(stu)) {
			return SUCCESS;
		}
		return INPUT;
	}

	public String updateStudent() {
		StudentDao sDao = new StudentDao();
		Student stu = sDao.getStudentById(this.getSid());
		if (stu != null) {
			stu.setName(this.getName());
			stu.setSex(this.getSex());
			stu.setDepartment(this.getDepartment());
			stu.setNativePlace(this.getNativePlace());
			stu.setMark(this.getMark());
			stu.setEmail(this.getEmail());
			stu.setMaxCourse(this.getMaxCourse());
			stu.setTel(this.getTel());
			if (sDao.updateStudent(stu)) {
				return SUCCESS;
			}
			return INPUT;
		}
		return INPUT;
	}
}