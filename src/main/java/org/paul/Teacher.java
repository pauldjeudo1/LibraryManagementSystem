package org.paul;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Teacher extends User {

    private static final int MAX_ITEMS = 10;

    public Teacher(String name) {
        super(name);
    }

    /**
     * Determines whether the teacher is allowed to borrow
     * the specified item. Teachers may borrow any type of
     * library item as long as they do not exceed the
     * maximum borrowing limit.
     *
     * @param item the item to borrow
     * @return true if the teacher can borrow the item, false otherwise
     */
    @Override
    public boolean canBorrowItem(Item item) {

        if (item == null) {
            return false;
        }

        return getBorrowedItems().size() < MAX_ITEMS;
    }

}
