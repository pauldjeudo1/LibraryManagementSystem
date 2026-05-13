package org.paul;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.paul.Item.Status;

@ToString
@Getter
@Setter
public class Library {
    List<Item> items = new ArrayList();
    List<User> users = new ArrayList();

    /**
     * Adds a user to the library system.
     *
     * @param user the user to add
     * @return true if the user was successfully added, false otherwise
     */
    public boolean addUser(User user) {

        if (user == null) {
            return false;
        }

        return users.add(user);
    }

    /**
     * Removes a user from the library system.
     *
     * @param user the user to remove
     * @return true if the user was successfully removed, false otherwise
     */
    public boolean removeUser(User user) {

        if (user == null) {
            return false;
        }

        return users.remove(user);
    }

    /**
     * Adds an item to the library inventory.
     *
     * @param item the item to add
     * @return true if the item was successfully added, false otherwise
     */
    public boolean addItem(Item item) {

        if (item == null) {
            return false;
        }

        return items.add(item);
    }

    /**
     * Removes an item from the library inventory.
     *
     * @param item the item to remove
     * @return true if the item was successfully removed, false otherwise
     */
    public boolean removeItem(Item item) {

        if (item == null) {
            return false;
        }

        return items.remove(item);
    }

    /**
     * Allows a user to borrow an item if the item is available
     * and the user satisfies the borrowing conditions.
     *
     * @param user the user borrowing the item
     * @param item the item to borrow
     * @return true if the item was successfully borrowed, false otherwise
     */
    public boolean borrowItem(User user, Item item) {

        if (user == null || item == null) {
            return false;
        }

        if (!item.isAvailable() || !user.canBorrowItem(item)) {
            return false;
        }

        user.addBorrowedItem(item);
        item.borrow();

        return true;
    }

    /**
     * Allows a user to return a borrowed item.
     *
     * @param user the user returning the item
     * @param item the item to return
     * @return true if the item was successfully returned, false otherwise
     */
    public boolean returnItem(User user, Item item) {

        if (user == null || item == null) {
            return false;
        }

        if (item.getStatus() != Item.Status.BORROWED
                || !user.getBorrowedItems().contains(item)) {

            return false;
        }

        user.removeBorrowedItem(item);
        item.returnItem();

        return true;
    }

    /**
     * Searches the library inventory recursively for items
     * whose titles match the given title.
     *
     * @param title the title to search for
     * @return a list of matching items
     */
    public List<Item> searchItemsByTitleRecursive(String title) {

        return null; // placeholder
    }

    /**
     * Searches the library inventory using streams for items
     * whose titles match the given title.
     *
     * @param title the title to search for
     * @return a list of matching items
     */
    public List<Item> searchItemsByTitleStream(String title) {

        return null; // placeholder
    }

    /**
     * Searches the library inventory recursively for books
     * whose authors match the given author name.
     *
     * @param author the author to search for
     * @return a list of matching items
     */
    public List<Item> searchItemsByAuthorRecursive(String author) {

        return null; // placeholder
    }

    /**
     * Searches the library inventory using streams for books
     * whose authors match the given author name.
     *
     * @param author the author to search for
     * @return a list of matching items
     */
    public List<Item> searchItemsByAuthorStream(String author) {

        return null; // placeholder
    }

}
