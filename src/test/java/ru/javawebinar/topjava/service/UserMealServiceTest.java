package ru.javawebinar.topjava.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.DbPopulator;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMealServiceTest {

    @Autowired
    protected UserMealService service;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }

    @Test
    public void testGet() throws Exception {
        UserMeal userMeal = service.get(MealTestData.ADMINS_MEAL.getId(), ADMIN_ID);
        MealTestData.MATCHER.assertEquals(userMeal,MealTestData.ADMINS_MEAL);
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(MealTestData.ADMINS_MEAL.getId(), UserTestData.ADMIN_ID);
        MealTestData.MATCHER.assertCollectionEquals(Arrays.asList(), service.getAll(ADMIN_ID));
    }

    @Test
    public void testGetBetweenDates() throws Exception {

    }

    @Test
    public void testGetBetweenDateTimes() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {
        List<UserMeal> userMeals =(List<UserMeal>) service.getAll(ADMIN_ID);
        MealTestData.MATCHER.assertCollectionEquals(Arrays.asList(MealTestData.ADMINS_MEAL), userMeals);
    }

    @Test
    public void testUpdate() throws Exception {
        MealTestData.TestMeal updatedMeal = new MealTestData.TestMeal(MealTestData.ADMINS_MEAL);
        updatedMeal.setCalories(400);
        updatedMeal.setDescription("UpdatedMeal");
        service.update(updatedMeal, ADMIN_ID);
        MealTestData.MATCHER.assertEquals(updatedMeal, service.get(updatedMeal.getId(), ADMIN_ID));
    }

    @Test
    public void testSave() throws Exception {
        MealTestData.TestMeal testMeal = new MealTestData.TestMeal(null, LocalDateTime.of(2016,6,13,13,32), "Завтрак", 1000, UserTestData.ADMIN_ID);
        UserMeal um = service.save(testMeal.asMeal(), UserTestData.ADMIN_ID);
        testMeal.setId(um.getId());
        MealTestData.MATCHER.assertCollectionEquals(Arrays.asList(MealTestData.ADMINS_MEAL, testMeal), service.getAll(UserTestData.ADMIN_ID));
    }
}