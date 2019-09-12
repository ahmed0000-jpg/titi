package com.example.demo.controller;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;
import com.example.demo.web.exceptions.ProductNotFondException;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping(value = "Produits")
    public List<Product> afficherListeProduits()
    {
        return productDao.findAll();
    }
    @GetMapping(value = "Produits/{id}")
    public Product afficherProduit(@PathVariable  int id ) throws ProductNotFondException {
        Product product=productDao.findById(id);
        if(product==null) throw new ProductNotFondException("le produit n "+id+" n'existe pas");
        return product;
    }
    @PostMapping(value = "Produits/")
    public ResponseEntity<Void> enregistrerProduit(@Valid @RequestBody Product product)
    {
        Product product1=productDao.save(product) ;
        if(product1==null) return ResponseEntity.noContent().build() ;
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(product1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


}
