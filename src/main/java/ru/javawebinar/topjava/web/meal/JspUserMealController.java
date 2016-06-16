package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.javawebinar.topjava.model.UserMeal;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
@RequestMapping(value = "/meals")
public class JspUserMealController extends AbstractUserMealController {

    @RequestMapping(method = RequestMethod.GET)
    public String mealList(Model model) {
        model.addAttribute("mealList", super.getAll());
        return "mealList";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest request){
        super.delete(getId(request));
        return "redirect:meals";
    }
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String editForUpdate(HttpServletRequest request, Model model){
        int id = getId(request);
        UserMeal userMeal = super.get(id);
        model.addAttribute("meal",userMeal);
        return "mealEdit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String editForCreate(Model model){
        model.addAttribute("meal", new UserMeal(LocalDateTime.now(), "", 1000));
        return "mealEdit";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createOrUpdate(HttpServletRequest request, Model model){
        String id = request.getParameter("id");
        UserMeal userMeal = new UserMeal(id.isEmpty()? null : Integer.valueOf(id),
                LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.valueOf(request.getParameter("calories")));
        if (userMeal.isNew()){
            super.create(userMeal);
        } else {
            super.update(userMeal, userMeal.getId());
        }
        return "redirect:meals";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filter(HttpServletRequest request, Model model){
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
        LocalTime startTime = LocalTime.parse(request.getParameter("startTime"));
        LocalTime endTime = LocalTime.parse(request.getParameter("endTime"));
        model.addAttribute("mealList", super.getBetween(startDate, startTime, endDate, endTime));
        return "mealList";
    }

    public static int getId(HttpServletRequest request){
        return Integer.valueOf(request.getParameter("id"));
    }
}
