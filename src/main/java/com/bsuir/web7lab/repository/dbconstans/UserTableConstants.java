package com.bsuir.web7lab.repository.dbconstans;

public enum UserTableConstants {

    ID("id"),
    LOGIN("login"),

    PASSWORD("passw");

    private String fieldName;

    private UserTableConstants(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}