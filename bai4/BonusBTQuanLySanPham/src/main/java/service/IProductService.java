package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    List<Product> findByName(String name);

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}
