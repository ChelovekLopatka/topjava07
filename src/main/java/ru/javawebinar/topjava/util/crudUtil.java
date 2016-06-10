package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.util.Collection;
import java.util.List;


public interface crudUtil {

    void create(UserMealWithExceed um);
    UserMealWithExceed get(Integer id);
    Collection<UserMealWithExceed> getAll();
    void update(UserMealWithExceed um, Integer id);
    void delete(Integer id);


}
