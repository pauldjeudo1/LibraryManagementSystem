
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.paul.Admin;
import org.paul.Book;
import org.paul.DVD;
import org.paul.Item;
import org.paul.Library;
import org.paul.Magazine;
import org.paul.Student;
import org.paul.Teacher;
import org.paul.User;
import org.paul.Item.Status;

public class LibraryTest {
    @Test
    @DisplayName("Adding student -> true")
    public void addUserTest1() {
        Library library = new Library();
        Student s1 = new Student("John Doe");
        boolean expected = true;
        boolean actual = library.addUser(s1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Adding teacher -> true")
    public void addUserTest2() {
        Library library = new Library();
        Teacher t1 = new Teacher("Yi Wang");
        boolean expected = true;
        boolean actual = library.addUser(t1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Adding admin -> true")
    public void addUserTest3() {
        Library library = new Library();
        Admin a1 = new Admin("Jane Doe");
        boolean expected = true;
        boolean actual = library.addUser(a1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Adding null -> false")
    public void addUserTest4() {
        Library library = new Library();
        User u1 = null;
        boolean expected = false;
        boolean actual = library.addUser(u1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Removing existing user -> true")
    public void removeUserTest1() {
        Library library = new Library();
        Student s1 = new Student("John Doe");
        library.addUser(s1);
        boolean expected = true;
        boolean actual = library.removeUser(s1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Removing non-existing user -> false")
    public void removeUserTest2() {
        Library library = new Library();
        Teacher t1 = new Teacher("Yi Wang");
        boolean expected = false;
        boolean actual = library.removeUser(t1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Removing null -> false")
    public void removeUserTest3() {
        Library library = new Library();
        User u1 = null;
        boolean expected = false;
        boolean actual = library.removeUser(u1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Adding book -> true")
    public void addItemTest1() {
        Library library = new Library();
        Book b1 = new Book("7 Habits of Highly Effective People", Status.IN_STORE, "Stephen Covey", "12345678", "Self-Help");
        boolean expected = true;
        boolean actual = library.addItem(b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Adding magazine -> true")
    public void addItemTest2() {
        Library library = new Library();
        Magazine m1 = new Magazine("10 Things You Need To Know Before Going to Spain", Status.IN_STORE, "Mike Bradley", 12345678);
        boolean expected = true;
        boolean actual = library.addItem(m1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Adding DVD -> true")
    public void addItemTest3() {
        Library library = new Library();
        DVD d1 = new DVD("1984", Status.IN_STORE, "John Doe", 120);
        boolean expected = true;
        boolean actual = library.addItem(d1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Adding null -> false")
    public void addItemTest4() {
        Library library = new Library();
        Item item1 = null;
        boolean expected = false;
        boolean actual = library.addItem(item1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Removing existing item -> true")
    public void removeItemTest1() {
        Library library = new Library();
        Book b1 = new Book("7 Habits of Highly Effective People", Status.IN_STORE, "Stephen Covey", "12345678", "Self-Help");
        library.addItem(b1);
        boolean expected = true;
        boolean actual = library.removeItem(b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Removing non-existing item -> false")
    public void removeItemTest2() {
        Library library = new Library();
        Book b1 = new Book("7 Habits of Highly Effective People", Status.IN_STORE, "Stephen Covey", "12345678", "Self-Help");
        boolean expected = false;
        boolean actual = library.removeItem(b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Removing null -> false")
    public void removeItemTest3() {
        Library library = new Library();
        Item item1 = null;
        library.addItem(item1);
        boolean expected = false;
        boolean actual = library.removeItem(item1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Student borrowing book under limit -> true")
    public void borrowItemTest1() {
        Library library = new Library();
        Student s1 = new Student("Paul Djeudo");
        Book b1 = new Book("10 Laws of Java", Status.IN_STORE, "Baxate Carter", "12345678", "Programming");
        boolean expected = true;
        boolean actual = library.borrowItem(s1, b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Teacher borrowing item under limit -> true")
    public void borrowItemTest2() {
        Library library = new Library();
        Teacher t1 = new Teacher("Yi Wang");
        Book b1 = new Book("10 Laws of Java", Status.IN_STORE, "Baxate Carter", "12345678", "Programming");
        boolean expected = true;
        boolean actual = library.borrowItem(t1, b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null item -> false")
    public void borrowItemTest3() {
        Library library = new Library();
        Student s1 = new Student("Paul Djeudo");
        boolean expected = false;
        boolean actual = library.borrowItem(s1, (Item)null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null user -> false")
    public void borrowItemTest4() {
        Library library = new Library();
        Book b1 = new Book("10 Laws of Java", Status.IN_STORE, "Baxate Carter", "12345678", "Programming");
        boolean expected = false;
        boolean actual = library.borrowItem((User)null, b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Item already borrowed -> false")
    public void borrowItemTest5() {
        Library library = new Library();
        Student s1 = new Student("Paul Djeudo");
        Book b1 = new Book("10 Laws of Java", Status.BORROWED, "Baxate Carter", "12345678", "Programming");
        boolean expected = false;
        boolean actual = library.borrowItem(s1, b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Student borrowing DVD/magazine -> false")
    public void borrowItemTest6() {
        Library library = new Library();
        Student s1 = new Student("Paul Djeudo");
        DVD d1 = new DVD("1984", Status.IN_STORE, "John Doe", 120);
        boolean expected = false;
        boolean actual = library.borrowItem(s1, d1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Student exceeding limit -> false")
    public void borrowItemTest7() {
        Library library = new Library();
        Student s1 = new Student("Paul Djeudo");

        for(int i = 0; i < 5; ++i) {
            Book book = new Book("Book " + i, Status.IN_STORE, "Author", "12345678", "Genre");
            s1.addBorrowedItem(book);
        }

        Book extraBook = new Book("Extra Book", Status.IN_STORE, "Author", "12345678", "Genre");
        boolean expected = false;
        boolean actual = library.borrowItem(s1, extraBook);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Teacher exceeding limit -> false ")
    public void borrowItemTest8() {
        Library library = new Library();
        Teacher t1 = new Teacher("Yi Wang");

        for(int i = 0; i < 10; ++i) {
            Book book = new Book("Book " + i, Status.IN_STORE, "Author", "12345678", "Genre");
            t1.addBorrowedItem(book);
        }

        Book extraBook = new Book("Extra Book", Status.IN_STORE, "Author", "12345678", "Genre");
        boolean expected = false;
        boolean actual = library.borrowItem(t1, extraBook);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Borrowed item -> true")
    public void returnItemTest1() {
        Library library = new Library();
        Student s1 = new Student("Paul Djeudo");
        Book b1 = new Book("10 Laws of Java", Status.IN_STORE, "Baxate Carter", "12345678", "Programming");
        library.borrowItem(s1, b1);
        boolean expected = true;
        boolean actual = library.returnItem(s1, b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null item -> false")
    public void returnItemTest2() {
        Library library = new Library();
        Student s1 = new Student("Paul Djeudo");
        boolean expected = false;
        boolean actual = library.returnItem(s1, (Item)null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Non-borrowed item -> false")
    public void returnItemTest3() {
        Library library = new Library();
        Student s1 = new Student("Paul Djeudo");
        Book b1 = new Book("10 Laws of Java", Status.IN_STORE, "Baxate Carter", "12345678", "Programming");
        boolean expected = false;
        boolean actual = library.returnItem(s1, b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Returning item from another user's borrowed items list -> false")
    public void returnItemTest4() {
        Library library = new Library();
        Student s1 = new Student("Paul Djeudo");
        Student s2 = new Student("John Doe");
        Book b1 = new Book("10 Laws of Java", Status.IN_STORE, "Baxate Carter", "12345678", "Programming");
        library.borrowItem(s1, b1);
        boolean expected = false;
        boolean actual = library.returnItem(s2, b1);
        Assertions.assertEquals(expected, actual);
    }
}
