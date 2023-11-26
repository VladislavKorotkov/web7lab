package com.bsuir.web7lab.repository.dbconstans;

public enum PersonTableConstants {
    ID("id"),
    NAME("pname"),
    PHONE("phone"),
    EMAIL("email");

    private String fieldName;

    private PersonTableConstants(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}