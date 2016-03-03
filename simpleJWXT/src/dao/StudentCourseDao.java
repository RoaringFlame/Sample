package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateSessionFactory;
import entity.Score;
import entity.ScoreId;

public class StudentCourseDao {
	private Session session;
	private Transaction transaction;
	private Query query;

	public int countCourseByStu(int sid) {
		int Amount = 0;
		try {
			session = HibernateSessionFactory.getSession();
			String hql = "select count(*) from Score where id.sid = :sid";
			query = session.createQuery(hql);
			query.setParameter("sid", sid);
			long count = (Long) query.uniqueResult();
			Amount = (int) count;
			return Amount;
		} catch (HibernateException e) {
			e.printStackTrace();
			return Amount;
		} finally {
			session.close();
		}
	}

	public int countStuInCs(int cid) {
		int Amount = 0;
		try {
			session = HibernateSessionFactory.getSession();
			String hql = "select count(*) from Score where id.cid = :cid";
			query = session.createQuery(hql);
			query.setParameter("cid", cid);
			long count = (Long) query.uniqueResult();
			Amount = (int) count;
			return Amount;
		} catch (HibernateException e) {
			e.printStackTrace();
			return Amount;
		} finally {
			session.close();
		}
	}

	public boolean isStudentInCourse(int sid, int cid) {
		try {
			session = HibernateSessionFactory.getSession();
			Score sc = (Score) session.get(Score.class, new ScoreId(sid, cid));
			if (sc != null)
				return true;
			return false;
		} catch (HibernateException e) {
			e.printStackTrace();
			return true;
		} finally {
			session.close();
		}
	}

	public boolean addStudent(int sid, int cid) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			Score sc = new Score();
			sc.setId(new ScoreId(sid, cid));
			sc.setScore(null);
			session.save(sc);
			transaction.commit();
			this.freshNum(cid);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	private void freshNum(int cid) {
		int count = countStuInCs(cid);
		CourseDao cDao = new CourseDao();
		cDao.updateCurNum(cid, count);
	}

	@SuppressWarnings("unchecked")
	public List<Score> getScByStu(int sid) {
		List<Score> list = new ArrayList<Score>();
		try {
			session = HibernateSessionFactory.getSession();
			String hql = "from Score where id.sid = :sid";
			query = session.createQuery(hql);
			query.setParameter("sid", sid);
			list = query.list();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return list;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Score> getScByCou(int cid, int pageNumber) {
		List<Score> list = new ArrayList<Score>();
		try {
			session = HibernateSessionFactory.getSession();
			String hql = "from Score where id.cid = :cid";
			query = session.createQuery(hql);
			query.setParameter("cid", cid);
			query.setFirstResult((pageNumber - 1) * 10);
			query.setMaxResults(10);
			list = query.list();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return list;
		} finally {
			session.close();
		}
	}

	public boolean isHaveScore(Integer sid, Integer cid) {
		try {
			session = HibernateSessionFactory.getSession();
			Score cs = (Score) session.get(Score.class, new ScoreId(sid, cid));
			if (cs != null && cs.getScore() != null) {
				return true;
			} else
				return false;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean delStudent(Integer sid, Integer cid) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			Score sc = new Score();
			sc.setId(new ScoreId(sid, cid));
			sc.setScore(null);
			session.delete(sc);
			transaction.commit();
			this.freshNum(cid);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateScore(int sid, int cid, String score) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			Score sc = (Score) session.get(Score.class, new ScoreId(sid, cid));
			if (sc != null) {
				sc.setScore(score);
				session.update(sc);
				transaction.commit();
				return true;
			} else
				return false;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}
}
