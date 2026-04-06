package com.agrogestor.crud.controllers;

import com.agrogestor.crud.dtos.SuinoDto;
import com.agrogestor.crud.model.Suino;
import com.agrogestor.crud.repositories.SuinoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suino")
public class SuinoController {

    @Autowired
    SuinoRepository repository;

    @GetMapping
    public ResponseEntity getAll(){
        List<Suino> listSuino = repository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(listSuino);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") int id){
        Optional<Suino> product = repository.findById(id);

        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody SuinoDto dto) {
        var suino = new Suino();
        BeanUtils.copyProperties(dto, suino);

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(suino));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id){
        Optional<Suino> suino = repository.findById(id);

        if(suino.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        repository.delete(suino.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") int id, @RequestBody SuinoDto dto) {
        Optional<Suino> suino = repository.findById(id);

        if(suino.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        var suinoModel = new Suino();
        BeanUtils.copyProperties(dto, suinoModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(suinoModel));
    }
}