package org.paul;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public abstract class Item {
    private int id;
    private String title;
    private Status status;

    private static int nextId = 1;

    public Item(String title, Status status) {
        this.id = nextId++;
        this.title = title;
        this.status = status;
    }

    /**
     * Checks whether the item is currently available for borrowing.
     *
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

    public enum Status {
        IN_STORE,
        BORROWED,
        LOST
    }

}
