package action.student;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.CourseDao;
import dao.StudentCourseDao;
import dao.StudentDao;
import entity.Course;
import entity.Student;

public class CourseInit extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Course> courseList;
	private int chooseNumber;
	private Student stu;
	private Course cou;

	private int pageNumber;
	private int totalPage;
	private Integer cid;

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public int getChooseNumber() {
		return chooseNumber;
	}

	public void setChooseNumber(int chooseNumber) {
		this.chooseNumber = chooseNumber;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public Course getCou() {
		return cou;
	}

	public void setCou(Course cou) {
		this.cou = cou;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String execute() {
		CourseDao cDao = new CourseDao();
		this.courseList = cDao.getAllCourse(this.pageNumber);
		Integer sid = (Integer) ActionContext.getContext().getSession()
				.get("sid");
		StudentCourseDao scDao = new StudentCourseDao();
		this.chooseNumber = scDao.countCourseByStu(sid);
		StudentDao sDao = new StudentDao();
		this.stu = sDao.getStudentById(sid);
		return "allCourse";
	}
	
	public String detail(){
		CourseDao cDao = new CourseDao();
		this.cou = cDao.getCourseById(this.cid);
		return "showDetail";
	}
	
	public String haveChoose(){
		Integer sid = (Integer) ActionContext.getContext().getSession()
				.get("sid");
		CourseDao cDao = new CourseDao();
		this.courseList = cDao.stuAllCourse(sid);
		StudentDao sDao = new StudentDao();
		this.stu = sDao.getStudentById(sid);
		return "myCourse";
	}
}