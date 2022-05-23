package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository

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
    public void update( User user) {
        em.merge(user);
    }

    @Override
    public void delete(long id) {
        em.remove(show(id));
    }


}





