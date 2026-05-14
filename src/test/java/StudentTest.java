
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.paul.Book;
import org.paul.DVD;
import org.paul.Magazine;
import org.paul.Student;
import org.paul.Item.Status;

public class StudentTest {
    @Test
    @DisplayName("Borrowing book under limit -> true")
    public void canBorrowedItemTest1() {
        Student s1 = new Student("Paul Djeudo");
        Book b1 = new Book("Book", Status.IN_STORE, "John Doe", "1234567890123", "Genre");
        boolean expected = true;
        boolean actual = s1.canBorrowItem(b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Borrowing DVD -> false")
    public void canBorrowedItemTest2() {
        Student s1 = new Student("Paul Djeudo");
        DVD d1 = new DVD("DVD", Status.IN_STORE, "John Doe", 120);
        boolean expected = false;
        boolean actual = s1.canBorrowItem(d1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Borrowing magazine -> false")
    public void canBorrowedItemTest3() {
        Student s1 = new Student("Paul Djeudo");
        Magazine m1 = new Magazine("Tech Monthly", Status.IN_STORE, "Tech Publisher", 1);
        boolean expected = false;
        boolean actual = s1.canBorrowItem(m1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Student over borrow limit -> false")
    public void canBorrowedItemTest4() {
        Student s1 = new Student("Paul Djeudo");

        for (int i = 0; i < 5; i++) {
            Book book = new Book("Book " + i, Status.IN_STORE, "Author", "1234567890123", "Genre");
            s1.addBorrowedItem(book);
        }

        Book extraBook = new Book("Extra Book", Status.IN_STORE, "Author", "1234567890123", "Genre");
        boolean expected = false;
        boolean actual = s1.canBorrowItem(extraBook);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Borrowing null item -> false")
    public void canBorrowedItemTest5() {
        Student s1 = new Student("Paul Djeudo");
        boolean expected = false;
        boolean actual = s1.canBorrowItem(null);
        Assertions.assertEquals(expected, actual);
    }

}
