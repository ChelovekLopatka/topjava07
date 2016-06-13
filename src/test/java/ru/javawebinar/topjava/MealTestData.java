package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDateTime;

/**
 * GKislin
 * 13.03.2015.
 */
public class MealTestData {

    public static final ModelMatcher<UserMeal, String> MATCHER = new ModelMatcher<>(UserMeal::toString);

    public static final UserMeal USERS_MEAL = new UserMeal(100000, LocalDateTime.of(2016,6,13,13,32),"Завтрак", 1000,UserTestData.USER_ID);
    public static final UserMeal ADMINS_MEAL = new UserMeal(100001, LocalDateTime.of(2016,6,13,13,32), "Завтрак Админа", 414, UserTestData.ADMIN_ID);

    public static class TestMeal extends UserMeal {

        public TestMeal(UserMeal um) {
            this(um.getId(), um.getDateTime(), um.getDescription(), um.getCalories(), um.getUserId());
        }

        public TestMeal( LocalDateTime dateTime, String description, int calories, int userId) {
            this(null, dateTime, description, calories, userId);
        }

        public TestMeal(Integer id, LocalDateTime dateTime, String description, int calories, int userId) {
            super(id, dateTime, description, calories, userId);
        }

        public UserMeal asMeal() {
            return new UserMeal(this);
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public boolean equals(Object o) {
            return super.equals(o);
        }
    }


}
