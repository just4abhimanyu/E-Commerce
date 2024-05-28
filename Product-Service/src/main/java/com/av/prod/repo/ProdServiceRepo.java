package com.av.prod.repo;

import com.av.prod.model.ProductServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdServiceRepo extends JpaRepository<ProductServiceModel, Long> {

        List<ProductServiceModel> findAll();
        List<ProductServiceModel> findByproductName(String name);
}
