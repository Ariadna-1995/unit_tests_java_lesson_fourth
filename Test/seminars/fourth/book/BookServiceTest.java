package seminars.fourth.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {
    static Book book1;
    static Book book2;
    static List<Book> bookstore;

    @BeforeAll
    public static void setUp() {
        book1 = new Book("1", "Горе от ума", "Грибоедов");
        book2 = new Book("2", "Джейн Эйр", "Шарлотта Бронте");
        book3 = new Book("3", "Борис Годунов", "Пушкин");
        bookstore = new ArrayList<>();
        bookstore.add(book1);
        bookstore.add(book2);
        bookstore.add(book3);
    }
    @Test
    void testFindByIdBookService() {
        BookRepository library = mock(BookRepository.class);
        BookService bookService = new BookService(library);
        when(library.findById("2")).thenReturn(book2);
        Book book = bookService.findBookById("2");
        verify(library).findById("2");
        assertThat(book).isEqualTo(book2);
        assertThat(book.getId()).isEqualTo("2");
        assertThat(book.getTitle()).isEqualTo("Джейн Эйр");
        assertThat(book.getAuthor()).isEqualTo("Шарлотта Бронте");
    }
    @Test
    void testFindAllBookService() {
        BookRepository library = mock(BookRepository.class);
        BookService bookService = new BookService(library);
        when(library.findAll()).thenReturn(bookstore);

        List<Book> myBooks = bookService.findAllBooks();

        verify(memory).findAll();
        assertThat(myBooks).isEqualTo(bookstore);
        assertThat(myBooks.get(1).getId()).isEqualTo("3");
        assertThat(myBooks.get(1).getTitle()).isEqualTo("Борис Годунов");
        assertThat(myBooks.get(1).getAuthor()).isEqualTo("Пушкин");
    }

}
