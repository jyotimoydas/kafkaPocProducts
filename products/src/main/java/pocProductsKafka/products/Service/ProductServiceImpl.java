package pocProductsKafka.products.Service;
//package com.example.product.service;


//import com.example.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pocProductsKafka.products.Model.Product;
import pocProductsKafka.products.Pojo.ProductPojo;
import pocProductsKafka.products.Repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
        private ProductRepository repository;

        @Autowired
        private KafkaTemplate<String, String> kafkaTemplate;

        private static final String TOPIC = "product_topic";

        private static final String ACK_TOPIC="ack_topic";

        @Override
        public List<ProductPojo> getAllProducts() {
            List<ProductPojo> products = repository.findAll();
            //kafkaTemplate.send(TOPIC, "Product created successfully: " + savedProduct.getId());
            return products;
        }

    @Override
    public void processProductData(Product productData) {
       try{
           ProductPojo product = new ProductPojo();
           product.setId(productData.getId());
           product.setDescription(productData.getDescription());
           product.setName(productData.getName());
           // Send acknowledgment back to the Customer microservice

           // Save product to the database
           repository.save(product);
           String acknowledgment = "Product " + product.getId() + " added successfully!";
           kafkaTemplate.send(ACK_TOPIC, acknowledgment);
       }catch(Exception e){
           System.out.println(e.getMessage());
           // Send acknowledgment back to the Customer microservice
           String acknowledgment = "Product "  + " addition failed.";
           kafkaTemplate.send(ACK_TOPIC, acknowledgment);
       }



    }

}
