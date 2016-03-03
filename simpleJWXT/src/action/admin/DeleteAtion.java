package action.admin;

import com.opensymphony.xwork2.ActionSupport;

import dao.CourseDao;
import dao.StudentDao;
import dao.TeacherDao;

public class DeleteAtion extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Integer sid;
	private Integer tid;
	private Integer cid;
	private int pageNumber;

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

	// 所有的删除记得更新数据表，如删除学生,还要删除成绩
	public String execute() {
		StudentDao sDao = new StudentDao();
		if (sDao.delStudent(this.sid))
			return SUCCESS;
		return INPUT;
	}

	public String delTeacher() {
		TeacherDao tDao = new TeacherDao();
		if (tDao.delTeacher(this.tid))
			return SUCCESS;
		return INPUT;
	}

	public String delCourse() {
		CourseDao cDao = new CourseDao();
		if (cDao.delCourse(this.cid))
			return SUCCESS;
		return INPUT;
	}
}