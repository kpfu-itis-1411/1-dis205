package ru.kpfu.itis.repository;

import java.util.List;

public interface CrudRepository<T> {
    void save(T model);
    List<T> findAll();
}
