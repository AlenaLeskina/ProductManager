package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private final ProductRepository repository = new ProductRepository();
    private final Book javaBook = new Book(1, "jabaBook", 1000, "Shildt");
    private final Book javaCode = new Book(2, "jabaCde", 1000, "Code");
    private final Smartphone iphoneX = new Smartphone(1, "iphoneX", 75000, "Apple");
    private final Smartphone iphone12 = new Smartphone(2, "iphoneX", 99000, "Apple");


    @Test
    public void shouldSaveItems() {
        repository.save(iphoneX);
        repository.save(javaBook);
        Product[] expected = new Product[]{iphoneX, javaBook};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindAll() {
        repository.save(iphoneX);
        repository.save(javaBook);
        Product[] expected = new Product[]{iphoneX, javaBook};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 2;
        repository.save(iphoneX);
        repository.save(iphone12);
        repository.save(javaBook);
        repository.removeById(idToRemove);
        Product[] expected = new Product[]{iphoneX, javaBook};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}