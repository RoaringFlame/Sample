package action.student;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.StudentDao;
import entity.Student;

public class ManageInformation extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Student stu;
	private Integer sid;
	private String email;
	private String tel;

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
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

	public String execute() {
		sid = (Integer) ActionContext.getContext().getSession().get("sid");
		StudentDao sDao = new StudentDao();
		Student st = sDao.getStudentById(this.sid);
		if (st != null) {
			this.setStu(st);
			return "information";
		}
		return ERROR;
	}

	public String changeInfo() {
		if (sid == null) {
			sid = (Integer) ActionContext.getContext().getSession().get("sid");
		}
		StudentDao sDao = new StudentDao();
		Student st = sDao.getStudentById(this.sid);
		if (st != null) {
			this.setStu(st);
			return "changeInfo";
		}
		return ERROR;
	}

	public String saveInfo() {
		StudentDao sDao = new StudentDao();
		Student stu = sDao.getStudentById(this.getSid());
		if (stu != null) {
			stu.setEmail(this.getEmail());
			stu.setTel(this.getTel());
			if (sDao.updateStudent(stu)) {
				return "saveSuccess";
			}
			return ERROR;
		}
		return ERROR;
	}
}