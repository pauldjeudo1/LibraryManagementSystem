package org.paul;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class Magazine extends Item {
    private String publisher;
    private int issueNumber;

    public Magazine(String title, Item.Status status, String publisher, int issueNumber) {
        super(title, status);
        this.publisher = publisher;
        this.issueNumber = issueNumber;
    }

}
