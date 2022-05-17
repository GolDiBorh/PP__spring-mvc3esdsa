package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager em;


    @Override
    public void add(User user) {
        em.persist(user);

    }
    @Override
    public List<User> listUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    public User show(long id){
        return listUsers().stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void update(long id, User user) {
        User user1 = show(id);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setAge(user.getAge());
    }

    @Override
    public void delete(long id) {
        em.remove(show(id));
    }


}





