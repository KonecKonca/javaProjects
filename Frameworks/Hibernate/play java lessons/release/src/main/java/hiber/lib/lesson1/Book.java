package hiber.lib.lesson1;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue
    private long id;
    private String title;
}
