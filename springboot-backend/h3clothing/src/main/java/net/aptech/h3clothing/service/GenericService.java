package net.aptech.h3clothing.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {
    List<T> getAll();
    T save(T t);
    Optional<T> getById(int id);
    void remove(int id);
}
