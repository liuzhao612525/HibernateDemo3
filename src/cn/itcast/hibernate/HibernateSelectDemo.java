package cn.itcast.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.entity.User;
import cn.itcast.uitls.HibernateUtils;

public class HibernateSelectDemo {
	
	//事务的规范代码
	@Test
	public void testTx() {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();

			User user = new User();
			user.setUsername("fdfdgfg");
			user.setPassword("5343");
			user.setAddress("7645erfdfdf");
			
			session.save(user);
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}finally {
			//不需要手动关闭
		}
	}
}	
