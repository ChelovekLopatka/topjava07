package ru.javawebinar.topjava.web.meal;

import org.junit.Test;
import org.springframework.http.MediaType;
import ru.javawebinar.topjava.TestUtil;
import ru.javawebinar.topjava.web.AbstractControllerTest;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserMealRestControllerTest  extends AbstractControllerTest{
    private static final String REST_MEAL_URL = UserMealRestController.REST_MEALS_URL + "/";
    @Test
    public void testGetAll() throws Exception {
        TestUtil.print(mockMvc.perform(get(REST_MEAL_URL)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testGetBetween() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testCreateWithLocation() throws Exception {

    }
}