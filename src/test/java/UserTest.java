
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.paul.DVD;
import org.paul.Item;
import org.paul.Teacher;
import org.paul.User;
import org.paul.Item.Status;

public class UserTest {
    @Test
    @DisplayName("Valid item -> item added in list")
    public void addBorrowedItemTest1() {
        User user = new Teacher("Yi Wang");
        Item item = new DVD("Movie", Status.IN_STORE, "Director", 120);
        user.addBorrowedItem(item);
        Assertions.assertTrue(user.getBorrowedItems().contains(item));
    }

    @Test
    @DisplayName("Duplicate item -> item not added in list")
    public void addBorrowedItemTest2() {
        User user = new Teacher("Yi Wang");
        Item item = new DVD("Movie", Status.IN_STORE, "Director", 120);
        user.addBorrowedItem(item);
        user.addBorrowedItem(item);
        int expected = 1;
        int actual = user.getBorrowedItems().size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null item -> item not added in list")
    public void addBorrowedItemTest3() {
        User user = new Teacher("Yi Wang");
        user.addBorrowedItem((Item)null);
        int expected = 0;
        int actual = user.getBorrowedItems().size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Existing item -> successfully removed from list")
    public void removeBorrowedItemTest1() {
        User user = new Teacher("Yi Wang");
        Item item = new DVD("Movie", Status.IN_STORE, "Director", 120);
        user.addBorrowedItem(item);
        user.removeBorrowedItem(item);
        Assertions.assertFalse(user.getBorrowedItems().contains(item));
    }

    @Test
    @DisplayName("Non-existing item -> no change in list")
    public void removeBorrowedItemTest2() {
        User user = new Teacher("Yi Wang");
        Item item = new DVD("Movie", Status.IN_STORE, "Director", 120);
        user.removeBorrowedItem(item);
        int expected = 0;
        int actual = user.getBorrowedItems().size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null item -> no change in list")
    public void removeBorrowedItemTest3() {
        User user = new Teacher("Yi Wang");
        user.removeBorrowedItem((Item)null);
        int expected = 0;
        int actual = user.getBorrowedItems().size();
        Assertions.assertEquals(expected, actual);
    }
}
