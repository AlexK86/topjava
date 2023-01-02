package ru.javawebinar.topjava.model;

public abstract class AbstractBaseEntity {
    private Integer id;

    private Integer userId;

    protected AbstractBaseEntity(Integer id, Integer userId) {
        this.id = id;
        this.userId = userId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isNew() {
        return this.id == null && this.userId == null;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": id=" + id + " userId=" + userId;
    }
}