package com.esctb.restapiserver.domain.product.repository;

import com.esctb.restapiserver.domain.model.ProductStatus;
import com.esctb.restapiserver.domain.product.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void save(){
        //given
        final Product product = Product.builder()
                .title("apple")
                .price(100)
                .status(ProductStatus.SALE)
                .viewCount(0)
                .build();

        //when
        final Product save = productRepository.save(product);

        //then
        assertEquals(product.getTitle(),save.getTitle());
        assertEquals(product.getPrice(),save.getPrice());
        assertEquals(product.getViewCount(),save.getViewCount());

    }

}