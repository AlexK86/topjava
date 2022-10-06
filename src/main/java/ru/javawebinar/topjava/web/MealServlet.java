package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.MealTo;
import org.slf4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
import static ru.javawebinar.topjava.util.MealsUtil.*;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("request meal");

        List<MealTo> mealsTo = filteredByStreams(meals, LocalTime.MIN, LocalTime.MAX, CALORIES_PER_DAY);

        request.setAttribute("meals", mealsTo);
        getServletContext().getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}