package ru.javawebinar.topjava.interfaces;

import ru.javawebinar.topjava.model.Meal;

public interface ICrudable<T> {
    int add(T obj);

    void update(T obj);

    void delete(int id);

    T getById(int id);

    T getAll();
}