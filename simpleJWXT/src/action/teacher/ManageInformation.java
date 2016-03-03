package action.teacher;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.TeacherDao;
import entity.Teacher;

public class ManageInformation extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private TeacherDao tDao = new TeacherDao();
	private Teacher tea;
	private Integer tid;
	private Integer age;
	private String email;
	private String tel;

	public Teacher getTea() {
		return tea;
	}

	public void setTea(Teacher tea) {
		this.tea = tea;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
		tid = (Integer)ActionContext.getContext().getSession().get("tid");
		Teacher te = tDao.getTeacherById(tid);
		if(te!=null){
			this.setTea(te);
			return "information";
		}
		return ERROR;
	}
	
	public String changeInfo(){
		if(tid == null){
			tid = (Integer)ActionContext.getContext().getSession().get("tid");
		}
		Teacher te = tDao.getTeacherById(tid);
		if(te!=null){
			this.setTea(te);
			return "changeInfo";
		}
		return ERROR;
	}
	
	public String saveInfo(){
		Teacher tea = tDao.getTeacherById(this.tid);
		if (tea != null) {
			tea.setAge(this.getAge());
			tea.setEmail(this.getEmail());
			tea.setTel(this.getTel());
			if (tDao.updateTeacher(tea)) {
				return "saveSuccess";
			}
			return ERROR;
		}
		return ERROR;
	}
}