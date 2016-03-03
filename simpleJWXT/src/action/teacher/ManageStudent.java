package action.teacher;

import com.opensymphony.xwork2.ActionSupport;

import dao.StudentCourseDao;

public class ManageStudent extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private StudentCourseDao scDao = new StudentCourseDao();

	private int sid;
	private int cid;
	private String score;
	private int pageNumber;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String delStudent() {
		if (scDao.delStudent(sid, cid))
			return "allStudent";
		else
			return INPUT;
	}

	public String logScore() {
		if (scDao.updateScore(sid, cid, score))
			return "allScore";
		else
			return INPUT;
	}
}