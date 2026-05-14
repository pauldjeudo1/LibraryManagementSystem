package org.paul;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Admin extends User implements Reportable {

    public Admin(String name) {
        super(name);
    }

    public boolean canBorrowItem(Item item) {
        return false;
    }

    /**
     * Generates and displays a report of borrowed,
     * available, and lost library items.
     * @param library the library to generate the report from
     */
    @Override
    public void generateReport(Library library) {

        int borrowedItems = 0;
        int inStoreItems = 0;
        int lostItems = 0;

        for (Item item : library.getItems()) {

            switch (item.getStatus()) {
                case BORROWED ->
                    borrowedItems++;
                case IN_STORE ->
                    inStoreItems++;
                case LOST ->
                    lostItems++;
            }
        }

        System.out.print("===== LIBRARY REPORT =====\n");
        System.out.printf("Borrowed Items: %d\n", borrowedItems);
        System.out.printf("In-Store Items: %d\n", inStoreItems);
        System.out.printf("Lost Items: %d\n", lostItems);
        System.out.println("==========================");
    }
}