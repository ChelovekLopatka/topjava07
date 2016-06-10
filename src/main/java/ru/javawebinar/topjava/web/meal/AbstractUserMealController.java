package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealService;

import java.util.Collection;


public class AbstractUserMealController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMealService service;

    public Collection<UserMeal> getAll() {
        LOG.info("getAll");
        return service.getAll();
    }

    public UserMeal save(UserMeal um){
        LOG.info("save");
        service.save(um);
        return um;
    }

    public void delete(int id){
        LOG.info("delete " + id);
        service.delete(id);
    }

    public UserMeal get(int id){
        LOG.info("get " + id);
        return service.get(id);
    }

    public UserMeal create(UserMeal um){
        um.setId(null);
        LOG.info("create " + um);
        service.save(um);
        return um;
    }
}
