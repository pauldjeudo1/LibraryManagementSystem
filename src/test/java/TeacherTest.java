
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.paul.Book;
import org.paul.Item;
import org.paul.Teacher;
import org.paul.Item.Status;

public class TeacherTest {
    @Test
    @DisplayName("Under borrow limit -> true")
    public void canBorrowedItemTest1() {
        Teacher t1 = new Teacher("Yi Wang");
        Book b1 = new Book("10 Laws of Java", Status.IN_STORE, "Baxate Carter", "12345678", "Programming");
        boolean expected = true;
        boolean actual = t1.canBorrowItem(b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Over borrow limit -> false")
    public void canBorrowedItemTest2() {
        Teacher t1 = new Teacher("Yi Wang");

        for (int i = 0; i < 10; i++) {
            Book book = new Book("Book " + i, Status.IN_STORE, "Author", "12345678", "Genre");
            t1.addBorrowedItem(book);
        }

        Book extraBook = new Book("Extra Book", Status.IN_STORE, "Author", "12345678", "Genre");
        boolean expected = false;
        boolean actual = t1.canBorrowItem(extraBook);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null item -> false")
    public void canBorrowedItemTest3() {
        Teacher t1 = new Teacher("Yi Wang");
        boolean expected = false;
        boolean actual = t1.canBorrowItem((Item)null);
        Assertions.assertEquals(expected, actual);
    }

}
