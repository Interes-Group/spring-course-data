package sk.stuba.fei.uim.asos.spring.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private int id;
    private String title;
    private String author;

    public String toString() {
        return id + ":" + title + ":" + author;
    }
}
