package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class crudUtilImpl implements crudUtil {
    private Map<Integer, UserMealWithExceed> dataBase = new ConcurrentHashMap<>();
    private int count = 0;
    {
        for(UserMealWithExceed meal : UserMealsUtil.getWhatINeed()){
            meal.setId(count);
            dataBase.put(meal.getId(), meal);
            count+=1;
        }
    }

    @Override
    public void create(UserMealWithExceed um) {
        dataBase.put(count+=1, um);
    }

    @Override
    public UserMealWithExceed get(Integer id) {
        return dataBase.get(id);
    }

    @Override
    public Collection<UserMealWithExceed> getAll() {
        return dataBase.values();
    }

    @Override
    public void update(UserMealWithExceed um, Integer id) {
        int localId;
        UserMealWithExceed existingMeal = dataBase.get(id);
        existingMeal.setCalories(um.getCalories());
        existingMeal.setDateTime(um.getDateTime());
        existingMeal.setDescription(um.getDescription());
        localId = um.getId();
        existingMeal.setId(localId);

        dataBase.remove(id);
        dataBase.put(localId, existingMeal);

    }

    @Override
    public void delete(Integer id) {
        dataBase.remove(id);
    }
}
