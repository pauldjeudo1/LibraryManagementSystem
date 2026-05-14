package org.paul;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public abstract class User implements Comparable<User> {
    protected String id;
    protected String name;
    protected List<Item> borrowedItems;

    private static int nextId = 1;

    public User(String name) {

        if (!Validation.isValidString(name)) {
            throw new IllegalArgumentException("Invalid name");
        }

        this.id = String.format("%04d", nextId++);
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    /**
     * Determines whether the user is allowed to borrow
     * the specified item according to their borrowing rules.
     * @param item the item to borrow
     * @return true if the user can borrow the item, false otherwise
     */
    public abstract boolean canBorrowItem(Item item);

    /**
     * Adds an item to the user's list of borrowed items
     * if the item is not null and is not already borrowed
     * by the user.
     * @param item the item to add
     */
    public void addBorrowedItem(Item item) {
        if (item != null && !this.borrowedItems.contains(item)) {
            this.borrowedItems.add(item);
        }
    }

    /**
     * Removes an item from the user's list of borrowed items
     * if the item is not null and is currently borrowed
     * by the user.
     * @param item the item to remove
     */
    public void removeBorrowedItem(Item item) {
        if (item != null) {
            this.borrowedItems.remove(item);
        }
    }

    /**
     * Compares items by their unique ID. Represents the natural ordering of Item objects.
     */
    @Override
    public int compareTo(User o) {
        return this.id.compareTo(o.id);
    }

    /**
     * Comparator for sorting items by title alphabetically.
     */
    public static class NameComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

}
