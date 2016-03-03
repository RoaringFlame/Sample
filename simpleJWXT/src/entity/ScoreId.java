package entity;

/**
 * ScoreId entity. @author MyEclipse Persistence Tools
 */

public class ScoreId implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;

	private Integer sid;
	private Integer cid;

	// Constructors

	/** default constructor */
	public ScoreId() {
	}

	/** full constructor */
	public ScoreId(Integer sid, Integer cid) {
		this.sid = sid;
		this.cid = cid;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ScoreId))
			return false;
		ScoreId castOther = (ScoreId) other;

		return ((this.getSid() == castOther.getSid()) || (this.getSid() != null
				&& castOther.getSid() != null && this.getSid().equals(
				castOther.getSid())))
				&& ((this.getCid() == castOther.getCid()) || (this.getCid() != null
						&& castOther.getCid() != null && this.getCid().equals(
						castOther.getCid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSid() == null ? 0 : this.getSid().hashCode());
		result = 37 * result
				+ (getCid() == null ? 0 : this.getCid().hashCode());
		return result;
	}

}