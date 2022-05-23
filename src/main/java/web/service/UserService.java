package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    public User show(long id);
    void update(User user);
    void delete(long id);

}
