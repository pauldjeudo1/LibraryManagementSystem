package org.paul;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Library library = new Library();
        

        Book book1 = new Book("The Alchemist", Item.Status.IN_STORE, "Paulo Coelho",
                "1234567890123", "Adventure");
        Book book2 = new Book("The Stranger", Item.Status.IN_STORE, "Albert Camus",
                "5678901234567", "Non-Fiction");
        Book book3 = new Book("The Power of Your Subconscious Mind", Item.Status.IN_STORE,
                "Dr. Joseph Murphy", "1212343456789", "Self-Help");

        library.addItem(book3);
        library.addItem(book2);
        library.addItem(book1);

        System.out.println(library.searchItemsByAuthorStream("paulo coelho"));
    }
}
