package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import lab5.Book;
import lab5.PaperBook;
import lab5.PaperBookFactory;
import lab5.EBook;
import lab5.EBookFactory;
import lab5.AudioBook;
import lab5.AudioBookFactory;

/*
 * Part 8 (Felix): Tests the creation of books
 * using the Factory Method pattern.
 */

class TestBookFactories {

    @Test
    void testPaperBookFactory() {
        PaperBookFactory factory = new PaperBookFactory();

        Book book = factory.createBook("test1");
        assertInstanceOf(PaperBook.class, book);
    }

    @Test
    void testEBookFactory() {
        EBookFactory factory = new EBookFactory();

        Book book = factory.createBook("test2");
        assertInstanceOf(EBook.class, book);
    }

    @Test
    void testAudioBookFactory() {
        AudioBookFactory factory = new AudioBookFactory();

        Book book = factory.createBook("test3");
        assertInstanceOf(AudioBook.class, book);
    }
}