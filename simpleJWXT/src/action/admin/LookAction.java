package action.admin;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.CourseDao;
import dao.StudentDao;
import dao.TeacherDao;
import entity.Course;
import entity.Student;
import entity.Teacher;

public class LookAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private int pageNumber;
	private int totalPage;
	private List<Student> allStudent;
	private List<Teacher> allTeacher;
	private List<Course> allCourse;

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

	public List<Student> getAllStudent() {
		return allStudent;
	}

	public void setAllStudent(List<Student> allStudent) {
		this.allStudent = allStudent;
	}

	public List<Teacher> getAllTeacher() {
		return allTeacher;
	}

	public void setAllTeacher(List<Teacher> allTeacher) {
		this.allTeacher = allTeacher;
	}

	public List<Course> getAllCourse() {
		return allCourse;
	}

	public void setAllCourse(List<Course> allCourse) {
		this.allCourse = allCourse;
	}

	public String execute() {
		StudentDao sDao = new StudentDao();
		this.allStudent = sDao.getAllStudent(this.pageNumber);
		if (this.allStudent != null) {
			return SUCCESS;
		}
		return INPUT;
	}

	public String allTeacher() {
		TeacherDao tDao = new TeacherDao();
		this.allTeacher = tDao.getAllTeacher(this.pageNumber);
		if (this.allTeacher != null) {
			return SUCCESS;
		}
		return INPUT;
	}

	public String allCourse() {
		CourseDao cDao = new CourseDao();
		this.allCourse = cDao.getAllCourse(this.pageNumber);
		if (this.allCourse != null) {
			return SUCCESS;
		}
		return INPUT;
	}
}