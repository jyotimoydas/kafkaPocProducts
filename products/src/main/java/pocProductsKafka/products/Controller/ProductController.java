package pocProductsKafka.products.Controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pocProductsKafka.products.Model.Product;
import pocProductsKafka.products.Pojo.ProductPojo;
import pocProductsKafka.products.Service.ProductService;

import java.util.List;


@RestController
    public class ProductController {

        @Autowired
        private ProductService productService;

        @GetMapping("/products")
        public List<ProductPojo> getAllProducts() {
            return productService.getAllProducts();
        }

        //@PostMapping("/createProduct")

//    @KafkaListener(topics = "product_topic", groupId = "product_group")
//    public void listenProductData(String message) {
//        // Process incoming product data (in this case, we assume it's a String)
//       System.out.println(message);
//    }

        @KafkaListener(topics = "product_topic", groupId = "product_group")
        public void listenProductData(String productData) {
            // Process incoming product data (in this case, we assume it's a String)
            Gson gson = new Gson();

            // Convert JSON string to Product object
            Product product = gson.fromJson(productData, Product.class);
            productService.processProductData(product);
        }
    }

