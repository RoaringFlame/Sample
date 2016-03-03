package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateSessionFactory;
import entity.Student;

public class StudentDao {

	private Session session;
	private Transaction transaction;
	private Query query;

	public Student studentLogin(Student stu) {
		if (stu.getSno() != null && stu.getPassword() != null) {
			try {
				session = HibernateSessionFactory.getSession();
				String hql = "from Student as s where s.sno = :sno and s.password = :password";
				query = session.createQuery(hql);
				query.setParameter("sno", stu.getSno());
				query.setParameter("password", stu.getPassword());
				Student st = (Student) query.uniqueResult();
				if (st != null)
					return st;
			} catch (HibernateException e) {
				e.printStackTrace();
				return null;
			} finally {
				session.close();
			}
		}
		return null;
	}

	public int getStudentAmount() {
		int count = 0;
		try {
			session = HibernateSessionFactory.getSession();
			String hql = "select count(*) from Student";
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
	public List<Student> getAllStudent(int pageNumber) {
		List<Student> allStudent = new ArrayList<Student>();
		try {
			session = HibernateSessionFactory.getSession();
			String hql = "from Student";
			query = session.createQuery(hql);
			query.setFirstResult((pageNumber - 1) * 10);
			query.setMaxResults(10);
			allStudent = query.list();
			return allStudent;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public boolean saveStudent(Student stu) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(stu);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean delStudent(Integer sid) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			Student stu = (Student) session.get(Student.class, sid);
			if (stu != null) {
				session.delete(stu);
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

	public Student getStudentById(Integer sid) {
		try {
			session = HibernateSessionFactory.getSession();
			Student stu = (Student) session.get(Student.class, sid);
			return stu;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public boolean updateStudent(Student stu) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.update(stu);
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
	public List<Student> getAllStudentInCou(Integer cid, int pageNumber) {
		List<Student> list = new ArrayList<Student>();
		try {
			session = HibernateSessionFactory.getSession();
			String hql = "from Student where sid in (select id.sid from Score where id.cid = :cid)";
			query = session.createQuery(hql);
			query.setParameter("cid", cid);
			query.setFirstResult((pageNumber - 1) * 10);
			query.setMaxResults(10);
			list = query.list();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
}
