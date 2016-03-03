package action.teacher;

import com.opensymphony.xwork2.ActionSupport;

import dao.StudentCourseDao;

public class TPageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private StudentCourseDao scDao = new StudentCourseDao();
	
	private int pageNumber;
	private int totalPage;
	private Integer cid;
	
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
		int studentAmount = scDao.countStuInCs(cid);
		this.countPage(studentAmount);
		return SUCCESS;
	}
	
	public String showStudent(){
		int studentAmount = scDao.countStuInCs(cid);
		this.countPage(studentAmount);
		return "allStudentScore";
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