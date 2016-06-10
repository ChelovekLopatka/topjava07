package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealService;

import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class UserMealRestController extends AbstractUserMealController{


    @Override
    public Collection<UserMeal> getAll() {
        return super.getAll();
    }

    @Override
    public UserMeal save(UserMeal um) {
        return super.save(um);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public UserMeal get(int id) {
        return super.get(id);
    }

    @Override
    public UserMeal create(UserMeal um) {
        return super.create(um);
    }
}
