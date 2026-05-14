import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.paul.Validation;

public class ValidationTest {

    @Test
    @DisplayName("Valid ISBN -> true")
    public void isValidISBNTest1() {

        boolean expected = true;
        boolean actual = Validation.isValidISBN("1234567890123");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("ISBN shorter than 13 digits -> false")
    public void isValidISBNTest2() {

        boolean expected = false;
        boolean actual = Validation.isValidISBN("12345");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("ISBN longer than 13 digits -> false")
    public void isValidISBNTest3() {

        boolean expected = false;
        boolean actual = Validation.isValidISBN("123456789012345");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("ISBN containing letters -> false")
    public void isValidISBNTest4() {

        boolean expected = false;
        boolean actual = Validation.isValidISBN("12345ABCDE678");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null ISBN -> false")
    public void isValidISBNTest5() {

        boolean expected = false;
        boolean actual = Validation.isValidISBN(null);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Valid string -> true")
    public void isValidStringTest1() {

        boolean expected = true;
        boolean actual = Validation.isValidString("Paul");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Empty string -> false")
    public void isValidStringTest2() {

        boolean expected = false;
        boolean actual = Validation.isValidString("");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Whitespace string -> false")
    public void isValidStringTest3() {

        boolean expected = false;
        boolean actual = Validation.isValidString("     ");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null string -> false")
    public void isValidStringTest4() {

        boolean expected = false;
        boolean actual = Validation.isValidString(null);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Positive duration -> true")
    public void isValidDurationTest1() {

        boolean expected = true;
        boolean actual = Validation.isValidDuration(120);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Zero duration -> false")
    public void isValidDurationTest2() {

        boolean expected = false;
        boolean actual = Validation.isValidDuration(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Negative duration -> false")
    public void isValidDurationTest3() {

        boolean expected = false;
        boolean actual = Validation.isValidDuration(-50);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Positive issue number -> true")
    public void isValidIssueNumberTest1() {

        boolean expected = true;
        boolean actual = Validation.isValidIssueNumber(12);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Zero issue number -> false")
    public void isValidIssueNumberTest2() {

        boolean expected = false;
        boolean actual = Validation.isValidIssueNumber(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Negative issue number -> false")
    public void isValidIssueNumberTest3() {

        boolean expected = false;
        boolean actual = Validation.isValidIssueNumber(-8);

        Assertions.assertEquals(expected, actual);
    }

}
