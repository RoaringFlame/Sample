package dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateSessionFactory;
import entity.Admin;

public class AdminDao {

	private Session session;
	private Query query;
	private Transaction transaction;

	public Admin adminLogin(Admin admin) {
		if (admin.getAno() != null && admin.getPassword() != null) {
			try {
				session = HibernateSessionFactory.getSession();
				String hql = "from Admin as a where a.ano = :ano and a.password = :password";
				query = session.createQuery(hql);
				query.setParameter("ano", admin.getAno());
				query.setParameter("password", admin.getPassword());
				Admin adm = (Admin) query.uniqueResult();
				if (adm != null)
					return adm;
			} catch (HibernateException e) {
				e.printStackTrace();
				return null;
			} finally {
				session.close();
			}
		}
		return null;
	}

	public Admin getAdminById(Integer aid) {
		try {
			session = HibernateSessionFactory.getSession();
			Admin adm = (Admin) session.get(Admin.class, aid);
			return adm;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public boolean updateAdmin(Admin adm) {
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.update(adm);
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
