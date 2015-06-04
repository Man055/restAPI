package restapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

public class UserDAOInh implements UserDAO {

	private SessionFactory sessionFactory;
	public User getRecords(User user) {
		
		Session session = this.sessionFactory.openSession();
		Query query= session.createQuery("select s.Email,s.FirstName,s.LastName,s.UserID from User s where UserID=:UserId");
		query.setProperties(Projections.property("Email"));
		query.setProperties(Projections.property("FirstName"));
		
		query.setParameter("UserId", user.getUserID());
		List <Object[]> list = (List<Object[]>)query.list();
		session.close();
		for(Object[] res: list){
			user.setEmail(res[0].toString());
			user.setFirstName(res[1].toString());
			user.setLastName(res[2].toString());
			user.setUserID(Integer.parseInt(res[3].toString()));
			
	     }
		return user;
		
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

}
