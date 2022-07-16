package com.gumelevskii.springboot.Spring_boot_task_311.dao;

import com.gumelevskii.springboot.Spring_boot_task_311.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public User deleteUser(long id) {
        User user = getUserById(id);
        entityManager.remove(user);
        return user;
    }

    @Override
    @Transactional
    public User changeUser(User user) {
        return entityManager.merge(user);
    }

}

