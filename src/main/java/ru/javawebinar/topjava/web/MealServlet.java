package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.UserMealWithExceed;
import ru.javawebinar.topjava.util.crudUtilImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


public class MealServlet extends HttpServlet {
    static final Logger LOG = LoggerFactory.getLogger(MealServlet.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        crudUtilImpl impl = new crudUtilImpl();
        Collection<UserMealWithExceed> userMeals = impl.getAll();

        request.setAttribute("userMeals", userMeals);
        request.getRequestDispatcher("mealList.jsp").forward(request, response);
    }
}
