package action.userManager;

import com.opensymphony.xwork2.ActionSupport;

import dao.CourseDao;
import dao.StudentDao;
import dao.TeacherDao;

public class PageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private int pageNumber;
	private int totalPage;

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

	public String execute() {
		StudentDao sDao = new StudentDao();
		int studentAmount = sDao.getStudentAmount();
		this.countPage(studentAmount);
		return "allStudent";
	}

	public String allTeacher() {
		TeacherDao tDao = new TeacherDao();
		int teacherAmount = tDao.getTeacherAmount();
		this.countPage(teacherAmount);
		return "allTeacher";
	}

	public String allCourse() {
		CourseDao cDao = new CourseDao();
		int courseAmount = cDao.getCourseAmount();
		this.countPage(courseAmount);
		return "allCourse";
	}

	public String chooseCourse() {
		CourseDao cDao = new CourseDao();
		int courseAmount = cDao.getCourseAmount();
		this.countPage(courseAmount);
		return "allCourse";
	}

	private void countPage(int Amount) {
		this.totalPage = Amount % 10 == 0 ? (Amount / 10) : (Amount / 10 + 1);
		if (this.pageNumber == 0) {
			this.pageNumber = 1;
		}
		if (this.pageNumber < 1) {
			this.pageNumber = 1;
		}
		if (this.pageNumber > this.totalPage) {
			this.pageNumber = this.totalPage;
		}
	}
}