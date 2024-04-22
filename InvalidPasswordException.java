package Lesson16;
// Custom exception class
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

// Main class
public class PasswordValidator {

    // Method to validate password
    public static void validatePassword(String password) throws InvalidPasswordException {
        // Check length
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 characters long");
        }

        // Check for uppercase, lowercase, and digit using regular expressions
        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException("Password must contain at least one uppercase letter");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new InvalidPasswordException("Password must contain at least one lowercase letter");
        }
        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("Password must contain at least one digit");
        }
    }

    // Main method
    public static void main(String[] args) {
        String password = "Password123"; // Change password here to test

        try {
            // Validate password
            validatePassword(password);
            System.out.println("Password is valid");
        } catch (InvalidPasswordException e) {
            // Catch and display error message
            System.out.println("Invalid password: " + e.getMessage());
        }
    }
}
