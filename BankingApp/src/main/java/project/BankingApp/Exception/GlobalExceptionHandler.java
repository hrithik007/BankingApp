package project.BankingApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle AccountNotFoundException and respond with 404 Not Found
    @ExceptionHandler(BankingExceptions.class)
    public ResponseEntity<String> handleAccountNotFoundException(BankingExceptions ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Optionally, handle other exceptions (e.g., generic exceptions)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        // Log the exception details for debugging (optional)
        // e.g., log.error("An unexpected error occurred", ex);
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
