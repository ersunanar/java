package homework2.ersunanar.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import homework2.ersunanar.entity.User;
import homework2.ersunanar.utils.IT526Utillty;

@Stateless
public class UserService {
	
	@PersistenceContext //birden fazla schema varsa persistence.xml'inde (unitName=it526U) olarak ayrıca belirtilmeli xml'de de <persistence-unit></persistence-unit> tag arası kopyalanır.
	//web.xml'de de <datasource> etiketi arası kopyalanır.
	private EntityManager entityManager;

	public User checkUser(String username, String password) {
		
		password = IT526Utillty.hash(password);
		System.out.println("User Input password (from textbox) hashed --> "+password);
		
		 List<User> users = entityManager.createQuery("select u from User u where u.username=?1 and u.password=?2",User.class)
				 .setParameter(1, username)
				 .setParameter(2, password)
				 .getResultList();	
		if (users.size()==1)
		{
			System.out.println("User password ( from DB ) hashed --> "+password);
			return users.get(0);
		}
		return null;
	}

}
