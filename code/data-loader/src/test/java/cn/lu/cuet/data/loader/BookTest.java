package cn.lu.cuet.data.loader;

import cn.lu.cuet.data.loader.entities.Author;
import cn.lu.cuet.data.loader.entities.Book;
import cn.lu.cuet.data.loader.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by mofang on 18/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DataLoaderApplication.class)
public class BookTest {
    private Logger logger = LoggerFactory.getLogger(BookTest.class);

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testAll() throws Exception{
        testIndexing();
    }

    private void testIndexing() {
        Book book;
        Author author;

        book = new Book();
        book.setId(1L);
        book.setTitle("All Quiet on the Western Front");
        book.setoTitle("Im Westen nichts Neues");
        author = new Author();
        author.setFirstName("Erich");
        author.setLastName("Maria Remarque");
        book.setAuthor(author);
        book.setYear(1929L);
        book.addCharacter("Paul Baumer");
        book.addCharacter("Albert Kropp");
        book.addCharacter("Haie Westhus");
        book.addCharacter("Fredrich Muller");
        book.addCharacter("Stanislaus Katczinsky");
        book.addCharacter("Tjaden");
        book.addTag("novel");
        book.setCopies(1L);
        book.setAvailable(true);
        book.setSection(3L);
        book = bookRepository.save(book);
        logger.info("book=" + book.toString());

        book = new Book();
        book.setId(2L);
        book.setTitle("Catch-22");
        author = new Author();
        author.setFirstName("Joseph");
        author.setLastName("Helloer");
        book.setAuthor(author);
        book.setYear(1961L);
        book.addCharacter("John Yossarian");
        book.addCharacter("Captain Aardvark");
        book.addCharacter("Chaplain Tappman");
        book.addCharacter("Colonel Cathcart");
        book.addCharacter("Doctor Daneeka");
        book.addTag("novel");
        book.setCopies(6L);
        book.setAvailable(false);
        book.setSection(1L);
        book = bookRepository.save(book);
        logger.info("book=" + book.toString());

        book = new Book();
        book.setId(3L);
        book.setTitle("The Complete Sherlock Holmes");
        author = new Author();
        author.setFirstName("Arthur");
        author.setLastName("Conan Doyle");
        book.setAuthor(author);
        book.setYear(1936L);
        book.addCharacter("Sherlock Holmes");
        book.addCharacter("Dr. Watson");
        book.addCharacter("G. Lestrade");
        book.setCopies(0L);
        book.setAvailable(false);
        book.setSection(12L);
        book = bookRepository.save(book);
        logger.info("book=" + book.toString());

        book = new Book();
        book.setId(4L);
        book.setTitle("Crime and Punishment");
        book.setoTitle("");
        author = new Author();
        author.setFirstName("Fyodor");
        author.setLastName("Dostoevsky");
        book.setAuthor(author);
        book.setYear(1886L);
        book.addCharacter("Raskolnikow");
        book.addCharacter("Sofia Semyonovna Marmeladova");
        book.setCopies(0L);
        book.setAvailable(true);
        book = bookRepository.save(book);
        logger.info("book=" + book.toString());
    }
}
