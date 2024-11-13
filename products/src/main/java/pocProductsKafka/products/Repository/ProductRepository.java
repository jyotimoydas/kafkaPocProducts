package pocProductsKafka.products.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pocProductsKafka.products.Model.Product;
import pocProductsKafka.products.Pojo.ProductPojo;

public interface ProductRepository extends JpaRepository<ProductPojo, Long> {
}
