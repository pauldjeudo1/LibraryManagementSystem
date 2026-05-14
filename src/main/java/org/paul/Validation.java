package org.paul;

public class Validation {

    /**
     * Validates whether the given ISBN follows the required format.
     * @param isbn the ISBN to validate
     * @return true if the ISBN is valid, false otherwise
     */
    public static boolean isValidISBN(String isbn) {

        if (isbn == null) {
            return false;
        }

        return isbn.matches("\\d{13}");
    }

    /**
     * Validates whether the given string is not null,
     * empty, or composed only of whitespace.
     *
     * @param str the string to validate
     * @return true if the string is valid, false otherwise
     */
    public static boolean isValidString(String str) {
        return str != null && !str.isBlank();
    }

    /**
     * Validates whether the given duration is positive.
     *
     * @param duration the duration in minutes
     * @return true if the duration is valid, false otherwise
     */
    public static boolean isValidDuration(int duration) {
        return duration > 0;
    }

    /**
     * Validates whether the given magazine issue number is positive.
     *
     * @param issueNumber the issue number to validate
     * @return true if the issue number is valid, false otherwise
     */
    public static boolean isValidIssueNumber(int issueNumber) {
        return issueNumber > 0;
    }

}
