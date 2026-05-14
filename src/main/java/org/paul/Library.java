package org.paul;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Library {
    List<Item> items = new ArrayList<>();
    List<User> users = new ArrayList<>();

    /**
     * Adds a user to the library system.
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
     * @param user the user borrowing the item
     * @param item the item to borrow
     * @return true if the item was successfully borrowed, false otherwise
     */
    public boolean borrowItem(User user, Item item) {

        if (user == null || item == null) {
            throw new IllegalArgumentException("User or item cannot be null.");
        }

        if (!item.isAvailable()) {
            return false;
        }

        if (!user.canBorrowItem(item)) {
            return false;
        }

        user.addBorrowedItem(item);
        item.borrow();

        return true;
    }

    /**
     * Allows a user to return a borrowed item.
     * @param user the user returning the item
     * @param item the item to return
     * @return true if the item was successfully returned, false otherwise
     */
    public boolean returnItem(User user, Item item) {

        if (user == null || item == null) {
            throw new IllegalArgumentException("User or item cannot be null.");
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
     * Reports an item as lost.
     * @param item the item to report as lost
     * @return true if the item was successfully marked as lost, false otherwise
     */
    public boolean reportLost(Item item) {

        if (item == null || !items.contains(item)) {
            return false;
        }

        return item.markAsLost();
    }

    /**
     * Recursive helper method for title searching.
     * @param title the title to search for
     * @param index the current index in the items list
     * @param matchingItems the list storing matching items
     */
    private void searchTitleHelper(String title, int index, List<Item> matchingItems) {

        if (index >= items.size()) {
            return;
        }

        Item currentItem = items.get(index);

        if (currentItem.getTitle().equalsIgnoreCase(title)) {
            matchingItems.add(currentItem);
        }

        searchTitleHelper(title, index + 1, matchingItems);
    }

    /**
     * Recursive helper method for author searching.
     * @param author the author to search for
     * @param index the current index in the items list
     * @param matchingItems the list storing matching items
     */
    private void searchAuthorHelper(String author, int index, List<Item> matchingItems) {

        if (index >= items.size()) {
            return;
        }

        Item currentItem = items.get(index);

        if (currentItem instanceof Book book) {

            if (book.getAuthor().equalsIgnoreCase(author)) {
                matchingItems.add(book);
            }
        }

        searchAuthorHelper(author, index + 1, matchingItems);
    }

    /**
     * Searches the library inventory recursively for items
     * whose titles match the given title.
     * @param title the title to search for
     * @return a list of matching items
     */
    public List<Item> searchItemsByTitleRecursive(String title) {

        List<Item> matchingItems = new ArrayList<>();

        if (title == null) {
            return matchingItems;
        }

        searchTitleHelper(title, 0, matchingItems);

        return matchingItems;
    }

    /**
     * Searches the library inventory using streams for items
     * whose titles match the given title.
     * @param title the title to search for
     * @return a list of matching items
     */
    public List<Item> searchItemsByTitleStream(String title) {

        if (title == null) {
            return new ArrayList<>();
        }

        return items.stream()
                .filter(item -> item.getTitle().equalsIgnoreCase(title))
                .toList();
    }

    /**
     * Searches the library inventory recursively for books
     * whose authors match the given author name.
     * @param author the author to search for
     * @return a list of matching items
     */
    public List<Item> searchItemsByAuthorRecursive(String author) {
        List<Item> matchingItems = new ArrayList<>();

        if (author == null) {
            return matchingItems;
        }

        searchAuthorHelper(author, 0, matchingItems);

        return matchingItems;
    }

    /**
     * Searches the library inventory using streams for books whose authors match the given author name.
     * @param author the author to search for
     * @return a list of matching items
     */
    public List<Item> searchItemsByAuthorStream(String author) {

        if (author == null) {
            return new ArrayList<>();
        }

        return items.stream()
                .filter(item -> item instanceof Book)
                .map(item -> (Book) item)
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .map(book -> (Item) book)
                .toList();
    }

    /**
     * Loads users from the users CSV file and initializes the library's user collection.
     */
    public void loadUsersFromCSV() {

        File file = new File(Constants.USERS_CSV_PATH);

        try (Scanner scanner = new Scanner(file)) {
            FileReader fileReader = new FileReader(file);
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                String[] parts = line.split(",");

                String type = parts[0];
                String name = parts[1];

                switch (type) {
                    case "Student" ->
                            users.add(new Student(name));
                    case "Teacher" ->
                            users.add(new Teacher(name));
                    case "Admin" ->
                            users.add(new Admin(name));
                }
            }

            scanner.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error opening users from CSV file");
        }
    }

    /**
     * Loads items from the items CSV file and initializes the library's item inventory.
     */
    public void loadItemsFromCSV() {

        File file = new File(Constants.ITEMS_CSV_PATH);

        try (FileReader fileReader = new FileReader(file);
             Scanner scanner = new Scanner(fileReader)) {

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                String[] parts = line.split(",");

                String type = parts[0];
                String title = parts[1];
                Item.Status status = Item.Status.valueOf(parts[2]);

                switch (type) {

                    case "Book" -> {

                        String author = parts[3];
                        String isbn = parts[4];
                        String genre = parts[5];

                        items.add(new Book(title, status, author, isbn, genre));
                    }

                    case "DVD" -> {

                        String director = parts[3];
                        int duration = Integer.parseInt(parts[4]);

                        items.add(new DVD(title, status, director, duration));
                    }

                    case "Magazine" -> {

                        String publisher = parts[3];
                        int issueNumber = Integer.parseInt(parts[4]);

                        items.add(new Magazine(title, status, publisher, issueNumber));
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading items from CSV file.");
        }
    }

    /**
     * Saves the current users in the library system into a CSV backup file.
     */
    public void backupUsers() {

        File file = new File(Constants.USERS_CSV_PATH);

        try (FileWriter fileWriter = new FileWriter(file)) {

            for (User user : users) {

                if (user instanceof Student) {
                    fileWriter.write("Student," + user.getName() + "\n");
                }

                else if (user instanceof Teacher) {
                    fileWriter.write("Teacher," + user.getName() + "\n");
                }

                else if (user instanceof Admin) {
                    fileWriter.write("Admin," + user.getName() + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("Error backing up users.");
        }
    }

    /**
     * Saves the current library inventory into a CSV backup file.
     */
    public void backupItems() {

        File file = new File(Constants.ITEMS_CSV_PATH);

        try (FileWriter fileWriter = new FileWriter(file)) {

            for (Item item : items) {

                if (item instanceof Book book) {

                    fileWriter.write(
                            "Book," +
                                    book.getTitle() + "," +
                                    book.getStatus() + "," +
                                    book.getAuthor() + "," +
                                    book.getIsbn() + "," +
                                    book.getGenre() + "\n"
                    );
                }

                else if (item instanceof DVD dvd) {

                    fileWriter.write(
                            "DVD," +
                                    dvd.getTitle() + "," +
                                    dvd.getStatus() + "," +
                                    dvd.getDirector() + "," +
                                    dvd.getDuration() + "\n"
                    );
                }

                else if (item instanceof Magazine magazine) {

                    fileWriter.write(
                            "Magazine," +
                                    magazine.getTitle() + "," +
                                    magazine.getStatus() + "," +
                                    magazine.getPublisher() + "," +
                                    magazine.getIssueNumber() + "\n"
                    );
                }
            }

        } catch (IOException e) {
            System.out.println("Error backing up items.");
        }
    }

}
