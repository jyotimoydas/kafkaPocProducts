package pocProductsKafka.products.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pocProductsKafka.products.Model.Product;
import pocProductsKafka.products.Pojo.ProductPojo;

@Component
public class ProductKafkaListener {

    private final ProductService productService;

    public ProductKafkaListener(ProductService productService) {
        this.productService = productService;
    }

//    @KafkaListener(topics = "product_topic", groupId = "product_group")
//    public void listenProductData(Product productData) {
//        // Process incoming product data (in this case, we assume it's a String)
//        productService.processProductData(productData);
//    }
}
