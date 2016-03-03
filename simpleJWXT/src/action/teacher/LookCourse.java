package action.teacher;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.CourseDao;
import entity.Course;

public class LookCourse extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private CourseDao cDao = new CourseDao();
	
	private List<Course> courseList;

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public String execute() {
		Integer tid = (Integer)ActionContext.getContext().getSession().get("tid");
		courseList = cDao.teaAllCourse(tid);
		return "allCourse";
	}
	
	public String registCourse(){
		Integer tid = (Integer)ActionContext.getContext().getSession().get("tid");
		courseList = cDao.teaAllCourse(tid);
		return "registCourse";
	}
}