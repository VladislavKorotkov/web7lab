package com.bsuir.web7lab.builder;

import com.bsuir.web7lab.exception.RepositoryException;

import java.sql.ResultSet;

public interface Builder<T> {
    T build(ResultSet resultSet) throws RepositoryException;
}