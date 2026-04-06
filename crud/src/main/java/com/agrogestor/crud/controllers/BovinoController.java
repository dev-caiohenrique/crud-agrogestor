package com.agrogestor.crud.controllers;

import com.agrogestor.crud.dtos.BovinoDto;
import com.agrogestor.crud.model.Bovino;
import com.agrogestor.crud.repositories.BovinoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bovino")
public class BovinoController {
    @Autowired
BovinoRepository repository;

    @GetMapping
    public ResponseEntity getAll(){
        List<Bovino> listBovino = repository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(listBovino);

    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id")int id){
        Optional <Bovino> product = repository.findById(id);

        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produc not found");

        }
        return ResponseEntity.status(HttpStatus.OK).body(product.get());

    }

    @PostMapping
    public ResponseEntity save(@RequestBody BovinoDto dto) {
        var bovino = new Bovino();
        BeanUtils.copyProperties(dto, bovino);

        return  ResponseEntity.status(HttpStatus.CREATED).body(repository.save(bovino));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id")int id){
        Optional<Bovino> bovino = repository.findById(id);

        if(bovino.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produc not found");
        }
        repository.delete(bovino.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") int id, @RequestBody BovinoDto dto) {
        Optional<Bovino> bovino = repository.findById(id);

        if(bovino.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produc not found");
        }

        var bovinoModel = new Bovino();
        BeanUtils.copyProperties(dto, bovinoModel);
        return  ResponseEntity.status(HttpStatus.OK).body(repository.save(bovinoModel));
    }


}
