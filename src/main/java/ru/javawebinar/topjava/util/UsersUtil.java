package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static ru.javawebinar.topjava.model.Role.ADMIN;
import static ru.javawebinar.topjava.model.Role.USER;

public class UsersUtil {

    public static final List<User> users = Arrays.asList(
            new User(1, "Admin", "admin@gmail.com", "admin", 1900, true, ADMIN),
            new User(2, "User", "user@yandex.ru", "password", 2100, true, USER)
    );

    public static List<User> listSortedUsers() {
        return users.stream().sorted(
                        comparing(User::getName)
                                .thenComparing(comparing(User::getEmail)))
                .collect(toList()
                );
    }
}


