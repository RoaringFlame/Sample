package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateSessionFactory;
import entity.Teacher;

public class TeacherDao {

	private Session session;
	private Transaction transaction;
	private Query query;

	public Teacher teacherLogin(Teacher teacher) {
		if (teacher.getTno() != null && teacher.getPassword() != null) {
			try {
				session = HibernateSessionFactory.getSession();
				String hql = "from Teacher as t where t.tno = :tno and t.password = :password";
				query = session.createQuery(hql);
				query.setParameter("tno", teacher.getTno());
				query.setParameter("password", teacher.getPassword());
				Teacher tea = (Teacher) query.uniqueResult();
				if (tea != null)
					return tea;
			} catch (HibernateException e) {
				e.printStackTrace();
				return null;
			} finally {
				session.close();
			}
		}
		return null;
	}

	public int getTeacherAmount() {
		int count = 0;
		try {
			session = HibernateSessionFactory.getSession();
			String hql = "select count(*) from Teacher";
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
	public List<Teacher> getAllTeacher(int pageNumber) {
		List<Teacher> allTeacher = new ArrayList<Teacher>();
		try {
			session = HibernateSessionFactory.getSession();
			String hql = "from Teacher";
			query = session.createQuery(hql);
			query.setFirstResult((pageNumber - 1) * 10);
			query.setMaxResults(10);
			allTeacher = query.list();
			return allTeacher;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public boolean saveTeacher(Teacher tea) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(tea);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean delTeacher(Integer tid) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			Teacher tea = (Teacher) session.get(Teacher.class, tid);
			if (tea != null) {
				session.delete(tea);
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

	public Teacher getTeacherById(Integer tid) {
		try {
			session = HibernateSessionFactory.getSession();
			Teacher tea = (Teacher) session.get(Teacher.class, tid);
			return tea;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public boolean updateTeacher(Teacher tea) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.update(tea);
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
