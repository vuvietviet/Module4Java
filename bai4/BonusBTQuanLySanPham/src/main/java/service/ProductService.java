package service;

import model.Catergory;
import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "bmw", 100, "https://static.carmudi.vn/wp-content/uploads/2020-09/slT2quQaEq.jpg",CatergoryService.catergoryList.get(0),true));
        products.put(2, new Product(2, "toyota", 300, "https://i.xeoto.com.vn/auto/toyota/vios/2022/ngoai-that-toyota-vios-41319.jpg",CatergoryService.catergoryList.get(1),false));
        products.put(3, new Product(3, "hyundai", 400, "https://i.xeoto.com.vn/auto/hyundai/tucson/hyundai-tucson-2021-43153.png",CatergoryService.catergoryList.get(1),false));
        products.put(4, new Product(4, "mercedes", 200, "https://xehay.vn/uploads/images/2017/3/2/xehay-mercedes-amg-gt-070317-3.jpg",CatergoryService.catergoryList.get(0),true));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> list = new ArrayList<>(products.values());
        List<Product> searchList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().contains(name)) {
                searchList.add(list.get(i));
            }
        }
        return searchList;
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
