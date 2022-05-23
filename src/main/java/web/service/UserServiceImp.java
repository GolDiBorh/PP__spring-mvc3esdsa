package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{

    private final UserDao userDao;
    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void add(User user) {
        userDao.add(user);

    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User show(long id) {
        return userDao.show(id);
    }

    @Override
    public void update( User user) {
        userDao.update(user);

    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }
}
