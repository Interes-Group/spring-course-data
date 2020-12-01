package sk.stuba.fei.uim.asos.spring.data;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt(1);
        String title = rs.getString(2);
        String author = rs.getString(3);
        return new Book(id, title, author);
    }
}
