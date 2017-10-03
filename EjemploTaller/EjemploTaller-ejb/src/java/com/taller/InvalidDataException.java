package com.taller;

public class InvalidDataException extends Exception {
    
    private String field;
    
    public InvalidDataException(String field, String message) {
        super(field + " - " + message);
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
    
}
