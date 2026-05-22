package com.dupas.fy.util;

public class CustomExceptions {

    public static class ExceptionCaller extends Exception {
        public ExceptionCaller(String message) {
            super(message);
        }
    }

    public static void checkAge(String id) throws ExceptionCaller {
        if (id == " ") {
            throw new ExceptionCaller("Invalid id: You can't use an empty id.");
        }
    }

    // outros casos

    public void checkIdException(String id) {
        try {
            checkAge(id);
        } catch (ExceptionCaller e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
