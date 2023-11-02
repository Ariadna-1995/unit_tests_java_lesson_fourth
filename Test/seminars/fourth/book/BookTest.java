package seminars.fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Java6Assertions.*;

public class BookTest {
    Book book;

    @BeforeEach
    void setUp () {
        book = new Book("1", "Преступление и наказание", "Федор Достоевский");
    }
    @Test
    void checkSetterId() {
        book.setId("2");
        assertThat(book.getId()).isEqualTo("2");
    }
    @Test
    void checkSetterTitle() {
        book.setTitle("Евгений Онегин");
        assertThat(book.getTitle()).isEqualTo("Евгений Онегин");
    }

    @Test
    void checkSetterAuthor() {
        book.setAuthor("Пушкин");
        assertThat(book.getAuthor()).isEqualTo("Пушкин");
    }

    @Test
    void checkBookIdConstructor() {
        Book book1 = new Book("5");
        assertThat(book1.getId()).isEqualTo("5");
        assertThat(book1.getAuthor()).isEqualTo("Пушкин");
        assertThat(book1.getTitle()).isEqualTo("Евгений Онегин");
    }

}