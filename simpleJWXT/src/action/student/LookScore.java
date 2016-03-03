package action.student;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.ScReferDao;
import entity.ScRefer;

public class LookScore extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<ScRefer> s;

	public List<ScRefer> getS() {
		return s;
	}

	public void setS(List<ScRefer> s) {
		this.s = s;
	}

	public String execute() {
		Integer sid = (Integer)ActionContext.getContext().getSession().get("sid");
		ScReferDao srDao = new ScReferDao();
		this.s = srDao.getRefScoreBySId(sid);
		return SUCCESS;
	}
}