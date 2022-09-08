package homework2.ersunanar.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import homework2.ersunanar.entity.Kategori;
import homework2.ersunanar.entity.Urun;
import homework2.ersunanar.entity.User;
import homework2.ersunanar.utils.IT526Utillty;

@Stateless
public class UserService {
	
	@PersistenceContext //birden fazla schema varsa persistence.xml'inde (unitName=it526U) olarak ayrıca belirtilmeli xml'de de <persistence-unit></persistence-unit> tag arası kopyalanır.
	//web.xml'de de <datasource> etiketi arası kopyalanır.
	private EntityManager entityManager;

	public User checkUser(String username, String password) {
		
		password = IT526Utillty.hash(password);
		
		 List<User> users = entityManager.createQuery("select u from User u where u.username=?1 and u.password=?2",User.class)
				 .setParameter(1, username)
				 .setParameter(2, password)
				 .getResultList();	
		if (users.size()>=1)
		{
			//System.out.println("User password ( from DB ) hashed --> "+password);
			return users.get(0);
		}
		return null;
	}
	
	
	public void addUser()
	{
		User admin = new User("ersun", "anar", "admin", "admin","admin");
		User user1 = new User("name1", "lastname1", "user1", "user1","customer");
		User user2 = new User("name2", "lastname2", "user2", "user2","customer");
		User user3 = new User("name3", "lastname3", "user3", "user3","customer");
		
		
		
		entityManager.persist(admin);
		entityManager.persist(user1);
		entityManager.persist(user2);
		entityManager.persist(user3);
		
	}
	
	public List<User> getUsers()
	{
		return entityManager.createQuery("select a from Urun a",User.class).getResultList();
	}
	
	

}
