package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    private final ProductManager productManager = new ProductManager(repository);
    private final Book javaBook = new Book(1, "SteveBook", 1000, "Jobs");
    private final Book javaCode = new Book(2, "javaCode", 1000, "CodeSteve");
    private final Smartphone iphoneX = new Smartphone(1, "SteveIphoneX", 75000, "Jobs");
    private final Smartphone iphone12 = new Smartphone(2, "iphoneX", 99000, "AppleSteve");

    @Test
    public void shouldAddItems() {
        productManager.add(iphoneX);
        Product[] expected = new Product[]{iphoneX};
        Product[] actual = productManager.getRepository().findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookNameAndSmartphoneName() {
        productManager.add(iphoneX);
        productManager.add(javaBook);
        Product[] expected = new Product[]{iphoneX, javaBook};
        Product[] actual = productManager.searchBy("Steve");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldItemsNotFound() {
        productManager.add(javaBook);
        productManager.add(iphoneX);
        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy("rt");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByCodeAuthorAndSmartphoneManufacturer() {
        productManager.add(javaCode);
        productManager.add(iphone12);
        Product[] expected = new Product[]{javaCode, iphone12};
        Product[] actual = productManager.searchBy("Steve");
        assertArrayEquals(expected, actual);
    }
}