package org.paul;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Student extends User {

    private static final int MAX_BOOKS = 5;

    public Student(String name) {
        super(name);
    }

    /**
     * Determines whether the student is allowed to borrow
     * the specified item. Students may only borrow books
     * and may not exceed the maximum borrowing limit.
     * @param item the item to borrow
     * @return true if the student can borrow the item, false otherwise
     */
    @Override
    public boolean canBorrowItem(Item item) {

        if (item == null) {
            return false;
        }

        if (!(item instanceof Book)) {
            return false;
        }

        return getBorrowedItems().size() < MAX_BOOKS;
    }

}
