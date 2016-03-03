package action.userManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.AdminDao;
import dao.StudentDao;
import dao.TeacherDao;
import entity.Admin;
import entity.Student;
import entity.Teacher;

public class ChangePassword extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String password;
	private String password1;
	private String password2;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String execute() {
		if (password1.equals(password2)) {
			int flag = (Integer) ActionContext.getContext().getSession()
					.get("flag");
			if (flag == 1) {
				Integer sid = (Integer) ActionContext.getContext().getSession()
						.get("sid");
				StudentDao sDao = new StudentDao();
				Student stu = sDao.getStudentById(sid);
				if (stu.getPassword().equals(password)) {
					stu.setPassword(password1);
					if (sDao.updateStudent(stu))
						return SUCCESS;
				}
			}
			
			if (flag == 2) {
				Integer tid = (Integer) ActionContext.getContext().getSession()
						.get("tid");
				TeacherDao tDao = new TeacherDao();
				Teacher tea = tDao.getTeacherById(tid);
				if (tea.getPassword().equals(password)) {
					tea.setPassword(password1);
					if (tDao.updateTeacher(tea))
						return SUCCESS;
				}
			}
			
			if (flag == 3) {
				Integer aid = (Integer) ActionContext.getContext().getSession()
						.get("aid");
				AdminDao aDao = new AdminDao();
				Admin adm = aDao.getAdminById(aid);
				if (adm.getPassword().equals(password)) {
					adm.setPassword(password1);
					if (aDao.updateAdmin(adm))
						return SUCCESS;
				}
			}
		}		
		return INPUT;
	}
}