package com.citymapper.traversal.errors;

public class NotFoundError extends Exception {
    public NotFoundError(String filePath) {
        super(String.format("The origin %s was not found", filePath));
    }

}
