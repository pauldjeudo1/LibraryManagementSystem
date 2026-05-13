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

    public void backupUsers() {
        // to be updated
    }

    public void backupItems() {
        // to be updated

    }

    public void generateReport() {
        // to be updated
    }

}