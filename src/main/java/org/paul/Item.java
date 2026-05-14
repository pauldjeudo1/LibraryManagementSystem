package org.paul;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Comparator;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public abstract class Item implements Comparable<Item> {
    private String id;
    private String title;
    private Status status;

    private static int nextId = 1;

    public Item(String title, Status status) {

        if (!Validation.isValidString(title)) {
            throw new IllegalArgumentException("Invalid title");
        }

        this.id = String.format("%04d", nextId++);
        this.title = title;
        this.status = status;
    }

    /**
     * Checks whether the item is currently available for borrowing.
     * @return true if the item is in store, false otherwise
     */
    public boolean isAvailable() {
        return this.status == Status.IN_STORE;
    }

    /**
     * Marks the item as borrowed.
     */
    public void borrow() {
        status = Status.BORROWED;
    }

    /**
     * Marks the item as returned and available in the library.
     */
    public void returnItem() {
        status = Status.IN_STORE;
    }

    /**
     * Marks the item as lost.
     * @return true if successful, false otherwise
     */
    public boolean markAsLost() {

        if (status != Status.BORROWED) {
            return false;
        }

        status = Status.LOST;

        return true;
    }

    /**
     * Compares items by their unique ID. Represents the natural ordering of Item objects.
     */
    @Override
    public int compareTo(Item o) {
        return this.id.compareTo(o.id);
    }

    /**
     * Comparator for sorting items by title alphabetically.
     */
    public static class TitleComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public enum Status {
        IN_STORE, BORROWED, LOST
    }

}
