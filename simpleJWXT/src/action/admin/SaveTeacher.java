package action.admin;

import com.opensymphony.xwork2.ActionSupport;

import dao.TeacherDao;
import entity.Teacher;

public class SaveTeacher extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Integer tid;
	private Integer tno;
	private String name;
	private Integer age;
	private String rank;
	private String email;
	private String tel;

	private int pageNumber;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getTno() {
		return tno;
	}

	public void setTno(Integer tno) {
		this.tno = tno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
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

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String execute() {
		Teacher tea = new Teacher();
		tea.setTno(this.getTno());
		tea.setPassword("2015");
		tea.setName(this.getName());
		tea.setAge(this.getAge());
		tea.setRank(this.getRank());
		tea.setEmail(this.getEmail());
		tea.setTel(this.getTel());
		TeacherDao tDao = new TeacherDao();
		if (tDao.saveTeacher(tea)) {
			return SUCCESS;
		}
		return INPUT;
	}

	public String updateTeacher() {
		TeacherDao tDao = new TeacherDao();
		Teacher tea = tDao.getTeacherById(this.tid);
		if (tea != null) {
			tea.setName(this.getName());
			tea.setAge(this.getAge());
			tea.setRank(this.getRank());
			tea.setEmail(this.getEmail());
			tea.setTel(this.getTel());
			if (tDao.updateTeacher(tea)) {
				return SUCCESS;
			}
			return INPUT;
		}
		return INPUT;
	}
}