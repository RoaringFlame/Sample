package action.admin;

import com.opensymphony.xwork2.ActionSupport;

import dao.CourseDao;
import dao.StudentDao;
import dao.TeacherDao;
import entity.Course;
import entity.Student;
import entity.Teacher;

public class GetAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Integer sid;
	private Integer tid;
	private Integer cid;
	private int pageNumber;

	private Student stu;
	private Teacher tea;
	private Course cou;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public Teacher getTea() {
		return tea;
	}

	public void setTea(Teacher tea) {
		this.tea = tea;
	}

	public Course getCou() {
		return cou;
	}

	public void setCou(Course cou) {
		this.cou = cou;
	}

	public String execute() {
		StudentDao sDao = new StudentDao();
		Student st = sDao.getStudentById(this.sid);
		if (st != null) {
			this.setStu(st);
			return "student";
		}
		return ERROR;
	}

	public String getStudent() {
		StudentDao sDao = new StudentDao();
		Student st = sDao.getStudentById(this.sid);
		if (st != null) {
			this.setStu(st);
			return "getStudent";
		}
		return ERROR;
	}

	public String teacher() {
		TeacherDao tDao = new TeacherDao();
		Teacher te = tDao.getTeacherById(this.tid);
		if (te != null) {
			this.setTea(te);
			return "teacher";
		}
		return ERROR;
	}
	
	public String course(){
		CourseDao cDao = new CourseDao();
		Course co = cDao.getCourseById(this.cid);
		if(co!=null){
			this.setCou(co);
			return"course";
		}
		return ERROR;
	}
}