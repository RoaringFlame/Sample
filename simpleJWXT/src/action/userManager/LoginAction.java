package action.userManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.AdminDao;
import dao.StudentDao;
import dao.TeacherDao;
import entity.Admin;
import entity.Student;
import entity.Teacher;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private int flag;

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String execute() {
		int index = username.length();
		int no = Integer.parseInt(username);

		if(index == 10){
			Student student = new Student();
			student.setSno(no);
			student.setPassword(password);
			StudentDao sDao = new StudentDao();
			Student stu = sDao.studentLogin(student);
			if(stu!=null){
				this.setFlag(1);
				session.setAttribute("flag", 1);
				session.setAttribute("sid", stu.getSid());
				session.setAttribute("sname", stu.getName());
				return SUCCESS;
			}
		}
		
		if (index == 8) {
			Teacher teacher = new Teacher();
			teacher.setTno(no);
			teacher.setPassword(password);
			TeacherDao tDao = new TeacherDao();
			Teacher tea = tDao.teacherLogin(teacher);
			if (tea != null) {
				this.setFlag(2);
				session.setAttribute("flag", 2);
				session.setAttribute("tid", tea.getTid());
				session.setAttribute("tname", tea.getName());
				return SUCCESS;
			}
		}
		
		if (index == 6) {
			Admin admin = new Admin();
			admin.setAno(no);
			admin.setPassword(password);
			AdminDao aDao = new AdminDao();
			Admin adm = aDao.adminLogin(admin);
			if (adm != null) {
				this.setFlag(3);
				session.setAttribute("flag", 3);
				session.setAttribute("aid", adm.getAid());
				session.setAttribute("aname", adm.getName());
				return SUCCESS;
			}
		}
		
		return INPUT;
	}

	public String quit() {
		if (ActionContext.getContext().getSession() != null)
			ActionContext.getContext().getSession().clear();
		return "quit";
	}
}