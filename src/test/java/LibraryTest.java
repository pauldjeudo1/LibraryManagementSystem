
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

import java.util.ArrayList;
import java.util.List;

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
        Book b1 = new Book("7 Habits of Highly Effective People", Status.IN_STORE, "Stephen Covey",
                "1234567890123", "Self-Help");
        boolean expected = true;
        boolean actual = library.addItem(b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Adding magazine -> true")
    public void addItemTest2() {
        Library library = new Library();
        Magazine m1 = new Magazine("10 Things You Need To Know Before Going to Spain", Status.IN_STORE,
                "Mike Bradley", 1);
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
        Book b1 = new Book("7 Habits of Highly Effective People", Status.IN_STORE, "Stephen Covey",
                "1234567890123", "Self-Help");
        library.addItem(b1);
        boolean expected = true;
        boolean actual = library.removeItem(b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Removing non-existing item -> false")
    public void removeItemTest2() {
        Library library = new Library();
        Book b1 = new Book("7 Habits of Highly Effective People", Status.IN_STORE, "Stephen Covey",
                "1234567890123", "Self-Help");
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
        Book b1 = new Book("10 Laws of Java", Status.IN_STORE, "Baxate Carter", "1234567890123",
                "Programming");
        boolean expected = true;
        boolean actual = library.borrowItem(s1, b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Teacher borrowing item under limit -> true")
    public void borrowItemTest2() {
        Library library = new Library();
        Teacher t1 = new Teacher("Yi Wang");
        Book b1 = new Book("10 Laws of Java", Status.IN_STORE, "Baxate Carter", "1234567890123",
                "Programming");
        boolean expected = true;
        boolean actual = library.borrowItem(t1, b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null item -> throws IllegalArgumentException")
    public void borrowItemTest3() {

        Library library = new Library();
        Student s1 = new Student("Paul Djeudo");

        Assertions.assertThrows(IllegalArgumentException.class, () -> library.borrowItem(s1, null));
    }

    @Test
    @DisplayName("Null user -> throws IllegalArgumentException")
    public void borrowItemTest4() {

        Library library = new Library();

        Book b1 = new Book(
                "10 Laws of Java",
                Status.IN_STORE,
                "Baxate Carter",
                "1234567890123",
                "Programming"
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> library.borrowItem(null, b1));
    }

    @Test
    @DisplayName("Item already borrowed -> false")
    public void borrowItemTest5() {
        Library library = new Library();
        Student s1 = new Student("Paul Djeudo");
        Book b1 = new Book("10 Laws of Java", Status.BORROWED, "Baxate Carter", "1234567890123",
                "Programming");
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
            Book book = new Book("Book " + i, Status.IN_STORE, "Author", "1234567890123",
                    "Genre");
            s1.addBorrowedItem(book);
        }

        Book extraBook = new Book("Extra Book", Status.IN_STORE, "Author", "1234567890123",
                "Genre");
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
            Book book = new Book("Book " + i, Status.IN_STORE, "Author", "1234567890123",
                    "Genre");
            t1.addBorrowedItem(book);
        }

        Book extraBook = new Book("Extra Book", Status.IN_STORE, "Author", "1234567890123",
                "Genre");
        boolean expected = false;
        boolean actual = library.borrowItem(t1, extraBook);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Borrowed item -> true")
    public void returnItemTest1() {
        Library library = new Library();
        Student s1 = new Student("Paul Djeudo");
        Book b1 = new Book("10 Laws of Java", Status.IN_STORE, "Baxate Carter", "1234567890123",
                "Programming");
        library.borrowItem(s1, b1);
        boolean expected = true;
        boolean actual = library.returnItem(s1, b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null item -> throws IllegalArgumentException")
    public void returnItemTest2() {

        Library library = new Library();
        Student s1 = new Student("Paul Djeudo");

        Assertions.assertThrows(IllegalArgumentException.class, () -> library.returnItem(s1, null));
    }

    @Test
    @DisplayName("Non-borrowed item -> false")
    public void returnItemTest3() {
        Library library = new Library();
        Student s1 = new Student("Paul Djeudo");
        Book b1 = new Book("10 Laws of Java", Status.IN_STORE, "Baxate Carter", "1234567890123",
                "Programming");
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
        Book b1 = new Book("10 Laws of Java", Status.IN_STORE, "Baxate Carter", "1234567890123",
                "Programming");
        library.borrowItem(s1, b1);
        boolean expected = false;
        boolean actual = library.returnItem(s2, b1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Recursive title search with one matched item -> matching item is returned in a list")
    public void searchItemsByTitleRecursiveTest1() {

        Library library = new Library();

        Book b1 = new Book("Java Basics",
                Item.Status.IN_STORE,
                "John Smith",
                "1234567890123",
                "Programming");

        library.addItem(b1);

        List<Item> results = library.searchItemsByTitleRecursive("Java Basics");

        Assertions.assertEquals(1, results.size());
        Assertions.assertTrue(results.contains(b1));
    }

    @Test
    @DisplayName("Recursive title search with multiple matches -> matching items returned in a list")
    public void searchItemsByTitleRecursiveTest2() {

        Library library = new Library();

        Book b1 = new Book("Java Basics",
                Item.Status.IN_STORE,
                "Author1",
                "1234567890123",
                "Programming");

        DVD d1 = new DVD("Java Basics",
                Item.Status.IN_STORE,
                "Director",
                120);

        library.addItem(b1);
        library.addItem(d1);

        List<Item> results = library.searchItemsByTitleRecursive("Java Basics");

        Assertions.assertEquals(2, results.size());
    }

    @Test
    @DisplayName("Recursive title search with no match -> empty list")
    public void searchItemsByTitleRecursiveTest3() {

        Library library = new Library();

        List<Item> expected = new ArrayList<>();
        List<Item> results = library.searchItemsByTitleRecursive("Unknown");

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Recursive title search with null title -> empty list")
    public void searchItemsByTitleRecursiveTest4() {

        Library library = new Library();

        List<Item> expected = new ArrayList<>();
        List<Item> results = library.searchItemsByTitleRecursive(null);

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Uppercase title and lowercase keyword -> matching item returned in a list")
    public void searchItemsByTitleRecursiveTest5() {

        Library library = new Library();

        Book b1 = new Book("JAVA BASICS",
                Item.Status.IN_STORE,
                "Author",
                "1234567890123",
                "Programming");

        library.addItem(b1);

        List<Item> expected = List.of(b1);
        List<Item> results = library.searchItemsByTitleRecursive("java basics");

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Stream title search with one match -> matching item returned in a list")
    public void searchItemsByTitleStreamTest1() {

        Library library = new Library();

        Book b1 = new Book("Java Basics",
                Item.Status.IN_STORE,
                "Author",
                "1234567890123",
                "Programming");

        library.addItem(b1);

        List<Item> expected = List.of(b1);
        List<Item> results = library.searchItemsByTitleStream("Java Basics");

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Stream title search with multiple matches -> matching items returned in a list")
    public void searchItemsByTitleStreamTest2() {

        Library library = new Library();

        Book b1 = new Book("Java Basics",
                Item.Status.IN_STORE,
                "Author1",
                "1234567890123",
                "Programming");

        DVD d1 = new DVD("Java Basics",
                Item.Status.IN_STORE,
                "Director",
                120);

        library.addItem(b1);
        library.addItem(d1);

        List<Item> expected = List.of(b1, d1);
        List<Item> results = library.searchItemsByTitleStream("Java Basics");

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Stream title search with no match -> empty list")
    public void searchItemsByTitleStreamTest3() {

        Library library = new Library();

        List<Item> expected = new ArrayList<>();
        List<Item> results = library.searchItemsByTitleStream("Unknown");

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Stream title search with null title -> empty list")
    public void searchItemsByTitleStreamTest4() {

        Library library = new Library();

        List<Item> expected = new ArrayList<>();
        List<Item> results = library.searchItemsByTitleStream(null);

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Uppercase title and lowercase keyword -> matching item returned in a list")
    public void searchItemsByTitleStreamTest5() {

        Library library = new Library();

        Book b1 = new Book("JAVA BASICS",
                Item.Status.IN_STORE,
                "Author",
                "1234567890123",
                "Programming");

        library.addItem(b1);

        List<Item> expected = List.of(b1);
        List<Item> results = library.searchItemsByTitleStream("java basics");

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Recursive author search with one match -> matching item returned in a list")
    public void searchItemsByAuthorRecursiveTest1() {

        Library library = new Library();

        Book b1 = new Book("Book1",
                Item.Status.IN_STORE,
                "Stephen King",
                "1234567890123",
                "Horror");

        library.addItem(b1);

        List<Item> expected = List.of(b1);
        List<Item> results = library.searchItemsByAuthorRecursive("Stephen King");

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Recursive author search with multiple matches -> matching items returned in a list")
    public void searchItemsByAuthorRecursiveTest2() {

        Library library = new Library();

        Book b1 = new Book("Book1",
                Item.Status.IN_STORE,
                "Stephen King",
                "1234567890123",
                "Horror");

        Book b2 = new Book("Book2",
                Item.Status.IN_STORE,
                "Stephen King",
                "9876543210123",
                "Horror");

        library.addItem(b1);
        library.addItem(b2);

        List<Item> expected = List.of(b1, b2);
        List<Item> results = library.searchItemsByAuthorRecursive("Stephen King");

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Recursive author search with no match -> empty list")
    public void searchItemsByAuthorRecursiveTest3() {

        Library library = new Library();

        List<Item> expected = new ArrayList<>();
        List<Item> results = library.searchItemsByAuthorRecursive("Unknown");

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Recursive author search with null author -> empty list")
    public void searchItemsByAuthorRecursiveTest4() {

        Library library = new Library();

        List<Item> expected = new ArrayList<>();
        List<Item> results = library.searchItemsByAuthorRecursive(null);

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Uppercase title and lowercase keyword -> matching item returned in a list")
    public void searchItemsByAuthorRecursiveTest5() {

        Library library = new Library();

        Book b1 = new Book("Book1",
                Item.Status.IN_STORE,
                "Stephen King",
                "1234567890123",
                "Horror");

        library.addItem(b1);

        List<Item> expected = List.of(b1);
        List<Item> results = library.searchItemsByAuthorRecursive("stephen king");

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Non-book items -> empty list")
    public void searchItemsByAuthorRecursiveTest6() {

        Library library = new Library();

        DVD d1 = new DVD("Movie",
                Item.Status.IN_STORE,
                "Director",
                120);

        library.addItem(d1);

        List<Item> expected = new ArrayList<>();
        List<Item> results = library.searchItemsByAuthorRecursive("Director");

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Stream author search with one match -> matching item returned in a list")
    public void searchItemsByAuthorStreamTest1() {

        Library library = new Library();

        Book b1 = new Book("Book1",
                Item.Status.IN_STORE,
                "Stephen King",
                "1234567890123",
                "Horror");

        library.addItem(b1);

        List<Item> expected = List.of(b1);
        List<Item> results = library.searchItemsByAuthorStream("Stephen King");

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Stream author search with multiple matches -> matching items returned in a list")
    public void searchItemsByAuthorStreamTest2() {

        Library library = new Library();

        Book b1 = new Book("Book1",
                Item.Status.IN_STORE,
                "Stephen King",
                "1234567890123",
                "Horror");

        Book b2 = new Book("Book2",
                Item.Status.IN_STORE,
                "Stephen King",
                "9876543210123",
                "Horror");

        library.addItem(b1);
        library.addItem(b2);

        List<Item> expected = List.of(b1, b2);
        List<Item> results = library.searchItemsByAuthorStream("Stephen King");

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Stream author search with no match -> empty list")
    public void searchItemsByAuthorStreamTest3() {

        Library library = new Library();

        List<Item> expected = new ArrayList<>();
        List<Item> results = library.searchItemsByAuthorStream("Unknown");

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Stream author search with null author -> empty list")
    public void searchItemsByAuthorStreamTest4() {

        Library library = new Library();

        List<Item> expected = new ArrayList<>();
        List<Item> results = library.searchItemsByAuthorStream(null);

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Uppercase title and lowercase keyword -> matching item returned in a list")
    public void searchItemsByAuthorStreamTest5() {

        Library library = new Library();

        Book b1 = new Book("Book1",
                Item.Status.IN_STORE,
                "Stephen King",
                "1234567890123",
                "Horror");

        library.addItem(b1);

        List<Item> expected = List.of(b1);
        List<Item> results = library.searchItemsByAuthorStream("stephen king");

        Assertions.assertEquals(expected, results);
    }

    @Test
    @DisplayName("Non-book item -> empty list")
    public void searchItemsByAuthorStreamTest6() {

        Library library = new Library();

        DVD d1 = new DVD("Movie",
                Item.Status.IN_STORE,
                "Director",
                120);

        library.addItem(d1);

        List<Item> expected = new ArrayList<>();
        List<Item> results = library.searchItemsByAuthorStream("Director");

        Assertions.assertEquals(expected, results);
    }


    @Test
    @DisplayName("Successful report -> true")
    public void reportLostTest1() {

        Library library = new Library();

        Book book = new Book(
                "Title",
                Item.Status.BORROWED,
                "Author",
                "1234567890123",
                "Genre"
        );

        library.addItem(book);

        boolean expected = true;
        boolean result = library.reportLost(book);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("In store item -> false")
    public void reportLostTest2() {

        Library library = new Library();

        Book book = new Book(
                "Title",
                Item.Status.IN_STORE,
                "Author",
                "1234567890123",
                "Genre"
        );

        library.addItem(book);

        boolean expected = false;
        boolean result = library.reportLost(book);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Already lost item -> false")
    public void reportLostTest3() {

        Library library = new Library();

        Book book = new Book(
                "Title",
                Item.Status.LOST,
                "Author",
                "1234567890123",
                "Genre"
        );

        library.addItem(book);

        boolean expected = false;
        boolean result = library.reportLost(book);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Item not in library -> false")
    public void reportLostTest4() {

        Library library = new Library();

        Book book = new Book(
                "Title",
                Item.Status.BORROWED,
                "Author",
                "1234567890123",
                "Genre"
        );

        boolean expected = false;
        boolean result = library.reportLost(book);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Null item -> false")
    public void reportLost_NullItem_ReturnsFalse() {

        Library library = new Library();

        boolean expected = false;
        boolean result = library.reportLost(null);

        Assertions.assertEquals(expected, result);
    }

}
