package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;


import static java.lang.Boolean.*;

public class UserMealsUtil {


    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );

        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        mealsTo.forEach(System.out::println);

        System.out.println(filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
    }

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with excess. Implement by cycles

        Map<Integer, UserMealWithExcess> map = new HashMap<>();
        List<UserMealWithExcess> mealsFilter = new ArrayList<>();

        for (int i = 0; i < meals.size(); i++) {
            LocalDate data = meals.get(i).getDateTime().toLocalDate();
            int sum = 0;
            for (int j = 0; j < meals.size(); j++) {
                LocalDate data1 = meals.get(j).getDateTime().toLocalDate();

                if (data.equals(data1)) {
                    sum = sum + meals.get(j).getCalories();
                }

                if (sum > caloriesPerDay) {
                    map.put(i, new UserMealWithExcess(
                            meals.get(i).getDateTime(),
                            meals.get(i).getDescription(),
                            meals.get(i).getCalories(),
                            TRUE));
                } else {
                    map.put(i, new UserMealWithExcess(
                            meals.get(i).getDateTime(),
                            meals.get(i).getDescription(),
                            meals.get(i).getCalories(),
                            FALSE));
                }
            }

            UserMealWithExcess userMealWithExcess = map.get(i);
            LocalTime lt = userMealWithExcess.getDateTime().toLocalTime();
            if (TimeUtil.isBetweenHalfOpen(lt, startTime, endTime)) {
                mealsFilter.add(userMealWithExcess);
            }
        }

        return mealsFilter;
    }

    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO Implement by streams


        return null;
    }
}
