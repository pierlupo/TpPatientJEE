package com.example.tppatientjee._interface;

public interface Repository<T> {

    boolean create(T element);

    boolean update(T element);

    boolean delete(T element);

    T findById(int id);
}
