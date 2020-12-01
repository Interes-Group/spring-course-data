package sk.stuba.fei.uim.asos.spring.data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class Main {

    public static final String SQL = "select * from Book;";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config.xml"});
        DataSource dataSource = context.getBean(SimpleDriverDataSource.class);

//        System.out.println("Row Set");
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(SQL);
//        while (sqlRowSet.next()) {
//            int id = sqlRowSet.getInt(1);
//            String title = sqlRowSet.getString(2);
//            String author = sqlRowSet.getString(3);
//            Book book = new Book(id, title, author);
//
//            System.out.println(book);
//        }
//
//        System.out.println("Row Mapper");
//        List<Book> books = jdbcTemplate.query(SQL, new BookMapper());
//        for (Book book : books) {
//            System.out.println(book);
//        }
//
//        System.out.println("Spring Repository");
        BookRepository bean = context.getBean(BookRepository.class);
//        books = bean.findAll();
//        for (Book book : books) {
//            System.out.println(book);
//        }
//
//        List<Book> tolkien = bean.findAllByAuthor("John Ronald Reuel Tolkien");
//        for (Book book : tolkien) {
//            System.out.println(book);
//        }

        Page<Book> page = bean.findAllByAuthor(PageRequest.of(0, 2), "John Ronald Reuel Tolkien");
        for (Book book : page.getContent()) {
            System.out.println(book);
        }
        page = bean.findAllByAuthor(PageRequest.of(1, 2), "John Ronald Reuel Tolkien");
        for (Book book : page.getContent()) {
            System.out.println(book);
        }
    }
}
