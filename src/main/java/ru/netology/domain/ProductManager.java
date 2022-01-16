package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class ProductManager {
    ProductRepository repository = new ProductRepository();

    public ProductRepository getRepository() {
        return repository;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().contains(search))
                return true;
            if (book.getAuthor().contains(search))
                return true;
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().contains(search))
                return true;
            return smartphone.getManufacturer().contains(search);
        }
        return false;
    }
}
