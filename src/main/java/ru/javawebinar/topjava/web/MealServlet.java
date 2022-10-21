package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDaoStorageInMemory;
import ru.javawebinar.topjava.model.Meal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private static final String ADD_OR_EDIT = "/editmeal.jsp";
    private static final String LIST_MEAL = "/meals.jsp";
    private static MealDaoStorageInMemory dao = new MealDaoStorageInMemory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("request Get meal");

        String forward = "";
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);
            forward = LIST_MEAL;
            request.setAttribute("meals", dao.getAll());
            log.debug("request Get Delete meal id = " + id);
        } else if (action.equalsIgnoreCase("update")) {
            forward = ADD_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("action", "Update");
            request.setAttribute("editMealBack", dao.getById(id));
            log.debug("request Get Update editMealBack = " + dao.getById(id).toString());
        } else if (action.equalsIgnoreCase("add")) {
            forward = ADD_OR_EDIT;
            Meal meal = new Meal(0, null, "", 0);
            request.setAttribute("action", "Add");
            request.setAttribute("editMealBack", meal);
            log.debug("request Get Add editMealBack = " + meal.toString());
        } else {
            forward = LIST_MEAL;
            request.setAttribute("meals", dao.getAll());
            log.debug("request Get Else");
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("request Post meal");

        req.setCharacterEncoding("UTF-8");

        String forward = "";
        String action = req.getParameter("actionForm");

        if (action == null) {
            action = "";
        }

        Meal meal = new Meal(
                Integer.parseInt(req.getParameter("mealId")),
                LocalDateTime.parse(req.getParameter("datetime-local")),
                req.getParameter("description"),
                Integer.parseInt(req.getParameter("calories"))
        );

        log.debug("request Post Update/Add Form = " + meal.toString());

        if (action.equalsIgnoreCase("update")) {
            forward = LIST_MEAL;
            dao.update(((Object) meal));
            req.setAttribute("meals", dao.getAll());
            log.debug("request Post Update Form = " + meal.toString());
        } else if (action.equalsIgnoreCase("Add")) {
            forward = LIST_MEAL;
            dao.add(((Object) meal));
            req.setAttribute("meals", dao.getAll());
            log.debug("request Post Add Form = " + meal.toString());
        } else {
            forward = LIST_MEAL;
            req.setAttribute("meals", dao.getAll());
            log.debug("request Post Else Form = " + meal.toString());
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(forward);
        requestDispatcher.forward(req, resp);
    }
}