package pocProductsKafka.products.Service;

import pocProductsKafka.products.Model.Product;
import pocProductsKafka.products.Pojo.ProductPojo;

import java.util.List;

public interface ProductService {
    public List<ProductPojo> getAllProducts();
    public void processProductData(Product productData);
}
