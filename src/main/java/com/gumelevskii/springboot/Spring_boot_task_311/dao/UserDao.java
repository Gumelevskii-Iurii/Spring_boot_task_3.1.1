package com.gumelevskii.springboot.Spring_boot_task_311.dao;

import com.gumelevskii.springboot.Spring_boot_task_311.model.User;


import java.util.List;

public interface UserDao {

    public List<User> listUsers();

    public void addUser(User user);

    public User deleteUser(long id);

    public User changeUser(User user);

    public User getUserById(long id);

}
