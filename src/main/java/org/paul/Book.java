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

        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
    }

}
