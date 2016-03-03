package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateSessionFactory;
import entity.Course;

public class CourseDao {

	private Session session;
	private Transaction transaction;
	private Query query;

	public int getCourseAmount() {
		int count = 0;
		try {
			session = HibernateSessionFactory.getSession();
			String hql = "select count(*) from Course";
			query = session.createQuery(hql);
			long Count = (Long) query.uniqueResult();
			count = (int) Count;
			return count;
		} catch (HibernateException e) {
			e.printStackTrace();
			return count;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Course> getAllCourse(int pageNumber) {
		List<Course> allCourse = new ArrayList<Course>();
		try {
			session = HibernateSessionFactory.getSession();
			String hql = "from Course";
			query = session.createQuery(hql);
			query.setFirstResult((pageNumber - 1) * 10);
			query.setMaxResults(10);
			allCourse = query.list();
			return allCourse;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public boolean saveCourse(Course cou) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(cou);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean delCourse(Integer cid) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			Course cou = (Course) session.get(Course.class, cid);
			if (cou != null) {
				session.delete(cou);
				transaction.commit();
			}
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public Course getCourseById(Integer cid) {
		try {
			session = HibernateSessionFactory.getSession();
			Course cou = (Course) session.get(Course.class, cid);
			return cou;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public boolean updateCourse(Course cou) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.update(cou);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Course> stuAllCourse(Integer sid) {
		List<Course> list = new ArrayList<Course>();
		try {
			session = HibernateSessionFactory.getSession();
			String hql = "from Course where cid in(select id.cid from Score where id.sid = :sid)";
			query = session.createQuery(hql);
			query.setParameter("sid", sid);
			list = query.list();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Course> teaAllCourse(Integer tid) {
		List<Course> list = new ArrayList<Course>();
		try {
			session = HibernateSessionFactory.getSession();
			String hql = "from Course where tid = :tid";
			query = session.createQuery(hql);
			query.setParameter("tid", tid);
			list = query.list();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public boolean updateCurNum(int cid, int count) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			Course c = (Course) session.get(Course.class, new Integer(cid));
			c.setChooseCurNum(count);
			session.update(c);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

}
