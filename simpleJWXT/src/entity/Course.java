package entity;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

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

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(Integer cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Course(Integer cid, Integer cno, Integer tid, String cname,
			String cmark, Integer chooseMax, Integer chooseCurNum,
			String ctime, String roomid) {
		this.cid = cid;
		this.cno = cno;
		this.tid = tid;
		this.cname = cname;
		this.cmark = cmark;
		this.chooseMax = chooseMax;
		this.chooseCurNum = chooseCurNum;
		this.ctime = ctime;
		this.roomid = roomid;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCno() {
		return this.cno;
	}

	public void setCno(Integer cno) {
		this.cno = cno;
	}

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCmark() {
		return this.cmark;
	}

	public void setCmark(String cmark) {
		this.cmark = cmark;
	}

	public Integer getChooseMax() {
		return this.chooseMax;
	}

	public void setChooseMax(Integer chooseMax) {
		this.chooseMax = chooseMax;
	}

	public Integer getChooseCurNum() {
		return this.chooseCurNum;
	}

	public void setChooseCurNum(Integer chooseCurNum) {
		this.chooseCurNum = chooseCurNum;
	}

	public String getCtime() {
		return this.ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getRoomid() {
		return this.roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

}