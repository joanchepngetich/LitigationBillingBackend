package com.example.BillingBackend.Controllers;

public class CustomExeption extends Throwable {
    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String invoiceNotFound) {
        }
    }

    public static class ErrorResponse {
        public ErrorResponse(String s) {
        }
    }
    public static class StaffNotFoundException extends RuntimeException {

        public StaffNotFoundException(String message) {
            super(message);
        }
    }

    public static class CaseNotFoundException extends RuntimeException {

        public CaseNotFoundException(String message) {
            super(message);
        }
    }
}
