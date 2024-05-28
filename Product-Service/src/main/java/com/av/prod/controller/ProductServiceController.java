package com.av.prod.controller;

import com.av.prod.exception.ProductNotFoundException;
import com.av.prod.model.ProductServiceModel;
import com.av.prod.repo.ProdServiceRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping("prodService")
@EnableSwagger2
@Api(value = "Product Management",protocols = "http")
public class ProductServiceController {

    @Autowired
    private ProdServiceRepo prodServiceRepo;

    @ApiOperation(value = "Get example data", response = String.class)
    @GetMapping("controllerTest")
    public ResponseEntity<String> controllerTest(){
        return ResponseEntity.ok("Product service API is on....");
    }

    @GetMapping("getServiceName/{prodName}")
    public ResponseEntity<List<ProductServiceModel>> getProdServicesName(@PathVariable String prodName){
        List<ProductServiceModel> prodList = null;
        if (prodName != null) {
            prodList = prodServiceRepo.findByproductName(prodName);
        }
        assert prodList != null;
        if (prodList.isEmpty()) {
            throw new ProductNotFoundException("Product not found for "+prodName+" in DB");
        }
        return ResponseEntity.ok(prodServiceRepo.findAll());
    }

    @PostMapping(path = "addServices", consumes = "application/json",produces = "application/json")
    public ResponseEntity<String> addServices(@RequestBody ProductServiceModel productServiceModel , BindingResult bindingResult){

        if (productServiceModel != null)
                prodServiceRepo.save(productServiceModel);


        return ResponseEntity.ok(bindingResult.getAllErrors().toString());
    }
}
