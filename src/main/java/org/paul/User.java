package org.paul;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public abstract class User {
    protected String id;
    protected String name;
    protected List<Item> borrowedItems;

    private static int nextId = 1;

    public User(String name) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public abstract boolean canBorrowItem(Item item);

    public void addBorrowedItem(Item item) {
        if (item != null && !this.borrowedItems.contains(item)) {
            this.borrowedItems.add(item);
        }
    }

    public void removeBorrowedItem(Item item) {
        if (item != null && this.borrowedItems.contains(item)) {
            this.borrowedItems.remove(item);
        }
    }

}
