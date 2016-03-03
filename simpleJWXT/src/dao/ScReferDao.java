package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entity.Course;
import entity.ScRefer;
import entity.Score;
import entity.Student;

public class ScReferDao {
	StudentCourseDao scDao = new StudentCourseDao();

	public List<ScRefer> getRefScoreBySId(Integer sid) {
		try {
			List<ScRefer> list = new ArrayList<ScRefer>();
			List<Score> scList = scDao.getScByStu(sid);
			CourseDao cDao = new CourseDao();
			for (Iterator<Score> it = scList.iterator(); it.hasNext();) {
				Score itc = (Score) it.next();
				int cid = itc.getId().getCid();
				Course c = cDao.getCourseById(cid);
				String score = "";
				if (itc.getScore() != null) {
					score = itc.getScore();
				}
				ScRefer s = new ScRefer();
				s.setSid(sid);
				s.setSno(0);
				s.setSname("default");
				s.setDepartment("default");
				s.setCid(cid);
				s.setCno(c.getCno());
				s.setCname(c.getCname());
				s.setCmark(c.getCmark());
				s.setScore(score);
				list.add(s);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ScRefer> getRefScoreByCId(Integer cid, int pageNumber) {
		try {
			List<ScRefer> list = new ArrayList<ScRefer>();
			List<Score> scList = scDao.getScByCou(cid, pageNumber);
			StudentDao sDao = new StudentDao();
			for (Iterator<Score> it = scList.iterator(); it.hasNext();) {
				Score itc = (Score) it.next();
				int sid = itc.getId().getSid();
				String score = "";
				if (itc.getScore() != null) {
					score = itc.getScore();
				}
				ScRefer s = new ScRefer();
				Student stu = sDao.getStudentById(sid);
				s.setSid(stu.getSid());
				s.setSno(stu.getSno());
				s.setSname(stu.getName());
				s.setDepartment(stu.getDepartment());
				s.setCid(cid);
				s.setCno(0);
				s.setCname("default");
				s.setCmark("");
				s.setScore(score);
				list.add(s);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
