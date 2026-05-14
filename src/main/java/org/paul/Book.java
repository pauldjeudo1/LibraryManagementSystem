package org.paul;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class Book extends Item {
    private String author;
    private String isbn;
    private String genre;

    public Book(String title, Status status, String author, String isbn, String genre) {
        super(title, status);
        this.isbn = isbn.replace("-", "").trim();

        if (!Validation.isValidISBN(this.isbn)) {
            throw new IllegalArgumentException("ISBN is invalid");
        }

        this.author = author;
        this.genre = genre;
    }

}
