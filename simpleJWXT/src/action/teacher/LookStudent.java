package action.teacher;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.CourseDao;
import dao.ScReferDao;
import dao.StudentDao;
import entity.Course;
import entity.ScRefer;
import entity.Student;

public class LookStudent extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private int pageNumber;
	private int totalPage;
	private int cid;
	private String cname;
	private List<Student> allStudent;
	private List<ScRefer> s;

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

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Student> getAllStudent() {
		return allStudent;
	}

	public void setAllStudent(List<Student> allStudent) {
		this.allStudent = allStudent;
	}

	public List<ScRefer> getS() {
		return s;
	}

	public void setS(List<ScRefer> s) {
		this.s = s;
	}

	public String execute() {
		StudentDao sDao = new StudentDao();
		allStudent = sDao.getAllStudentInCou(cid, pageNumber);
		return SUCCESS;
	}

	public String studentScore() {
		if(cname==null){
			CourseDao cDao = new CourseDao();
			Course cou = cDao.getCourseById(cid);
			cname = cou.getCname();
		}
		ScReferDao srDao = new ScReferDao();
		this.s = srDao.getRefScoreByCId(cid, pageNumber);
		return SUCCESS;
	}
}