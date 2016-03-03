package action.student;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.CourseDao;
import dao.StudentCourseDao;
import dao.StudentDao;
import entity.Course;
import entity.Student;

public class ChooseCourse extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private StudentDao sDao = new StudentDao();
	private StudentCourseDao scDao = new StudentCourseDao();
	private CourseDao cDao = new CourseDao();

	public Integer sid;
	public Integer cid;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String execute() {
		int sid = 0;
		int s_course = 0;
		int c_student = 0;
		int s_max = 0;
		int c_max = 0;

		sid = (Integer) ActionContext.getContext().getSession().get("sid");
		if (scDao.isStudentInCourse(sid, cid))
			return "haveChoose";

		Student student = sDao.getStudentById(sid);
		s_max = student.getMaxCourse();
		s_course = scDao.countCourseByStu(sid);
		if (s_max <= s_course)
			return "chooseMax";

		Course curCourse = cDao.getCourseById(cid);
		c_max = curCourse.getChooseMax();
		c_student = scDao.countStuInCs(cid);
		if (c_max <= c_student)
			return "courseFill";
		
		if (scDao.addStudent(sid, cid))
			return SUCCESS;
		else
			return ERROR;
	}
	
	public String cancelCourse(){
		if( ! scDao.isHaveScore(sid, cid)){
		    if (scDao.delStudent(sid, cid))
			     return SUCCESS;
		    }else{
		    	return ERROR;
	}
		return INPUT;
	}
}