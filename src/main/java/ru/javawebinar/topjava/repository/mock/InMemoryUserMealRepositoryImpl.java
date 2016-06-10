package ru.javawebinar.topjava.repository.mock;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.UserMealsUtil;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * GKislin
 * 15.09.2015.
 */
@Repository
@Qualifier
public class InMemoryUserMealRepositoryImpl implements UserMealRepository {
    private Map<Integer, UserMeal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        UserMealsUtil.MEAL_LIST.forEach(this::save);
    }

    @Override
    public UserMeal save(UserMeal userMeal) {
        if (userMeal.isNew()) {
            userMeal.setId(counter.incrementAndGet());
        }
        repository.put(userMeal.getId(), userMeal);
        return userMeal;
    }

    @Override
    public void delete(int id) {
        try{
            ExceptionUtil.check(repository.containsKey(id), id);
            repository.remove(id);
            return;
        }catch (NotFoundException e){
            return;
        }
    }

    @Override
    public UserMeal get(int id) {
        try{
            ExceptionUtil.check(repository.containsKey(id), id);
            return repository.get(id);
        }catch (NotFoundException e){
            return null;
        }
    }

    @Override
    public Collection<UserMeal> getAll() {
        List<UserMeal> notSortedMeals =(List<UserMeal>) repository.values();
        Collections.sort(notSortedMeals, new Comparator<UserMeal>() {
            @Override
            public int compare(UserMeal o1, UserMeal o2) {
                return o1.getDateTime().compareTo(o2.getDateTime());
            }
        });
        return repository.values();
    }
}

