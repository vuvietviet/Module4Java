package com.codegym.service;

import com.codegym.dao.ProductDao;
import com.codegym.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

public class ProductService implements CRUD<Product> {
    @Autowired
    ProductDao productDao;

    @Override
    public void create(Product product) {
        productDao.save(product);
    }

    @Override
    public void edit(Product product) {
        productDao.edit(product);
    }

    @Override
    public void delete(int id) {
//        Product product=  products.get(index);
//        File anh=new File("F:\\demo_UploadFile_C0322g1\\src\\main\\webapp\\WEB-INF\\" +product.getImg());
//        anh.delete();
//        products.remove(index);
        productDao.delete(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getList();
    }

    public Product findById(int id){
        return productDao.findById(id);
    }
}
