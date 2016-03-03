package action.admin;

import com.opensymphony.xwork2.ActionSupport;

import dao.CourseDao;
import entity.Course;

public class SaveCourse extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Integer cid;
	private Integer cno;
	private Integer tid;
	private String cname;
	private String cmark;
	private Integer chooseMax;
	private Integer chooseCurNum;
	private String ctime;
	private String roomid;

	private int pageNumber;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCno() {
		return cno;
	}

	public void setCno(Integer cno) {
		this.cno = cno;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCmark() {
		return cmark;
	}

	public void setCmark(String cmark) {
		this.cmark = cmark;
	}

	public Integer getChooseMax() {
		return chooseMax;
	}

	public void setChooseMax(Integer chooseMax) {
		this.chooseMax = chooseMax;
	}

	public Integer getChooseCurNum() {
		return chooseCurNum;
	}

	public void setChooseCurNum(Integer chooseCurNum) {
		this.chooseCurNum = chooseCurNum;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String execute() {
		Course cou = new Course();
		cou.setCno(this.getCno());
		cou.setTid(this.getTid());
		cou.setCname(this.getCname());
		cou.setCmark(this.getCmark());
		cou.setChooseMax(this.getChooseMax());
		cou.setChooseCurNum(0);
		cou.setCtime(this.getCtime());
		cou.setRoomid(this.getRoomid());
		CourseDao cDao = new CourseDao();
		if (cDao.saveCourse(cou)) {
			return SUCCESS;
		}
		return INPUT;
	}

	public String updateCourse() {
		CourseDao cDao = new CourseDao();
		Course cou = cDao.getCourseById(this.cid);
		if (cou != null) {
			cou.setCno(this.getCno());
			cou.setTid(this.getTid());
			cou.setCname(this.getCname());
			cou.setCmark(this.getCmark());
			cou.setChooseMax(this.getChooseMax());
			cou.setCtime(this.getCtime());
			cou.setRoomid(this.getRoomid());
			if (cDao.updateCourse(cou)) {
				return SUCCESS;
			}
			return INPUT;
		}
		return INPUT;
	}
}