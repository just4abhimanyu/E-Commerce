package com.av.prod.repo;

import com.av.prod.model.ProductServiceModel;
import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProdServiceRepoTest {

    @Autowired
    private  ProdServiceRepo prodServiceRepo;

    @Test
    void findAll() {
        List<ProductServiceModel> allRecord =  prodServiceRepo.findAll();
        Boolean isEmpty = allRecord.isEmpty();
        assertThat(isEmpty).isFalse();
    }

    @Test
    void findByproductName() {
        ProductServiceModel serviceModel = new ProductServiceModel();
        serviceModel.setProductName("Cake");
        serviceModel.setProductType("Food");
        serviceModel.setProductPrice(1000);
        prodServiceRepo.save(serviceModel);

        List<ProductServiceModel> expectedRes= prodServiceRepo.findByproductName(serviceModel.getProductName());
        assertThat(expectedRes.getFirst().getProductPrice()).isEqualTo(serviceModel.getProductPrice());
    }

    @AfterEach
    void tearDown(){
        System.out.println("Tearing down...");
    }
    @BeforeEach
    void setUp(){
        System.out.println("Setting up");
    }
}