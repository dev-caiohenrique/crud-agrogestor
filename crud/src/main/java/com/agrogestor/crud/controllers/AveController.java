package com.agrogestor.crud.controllers;

import com.agrogestor.crud.dtos.AveDto;
import com.agrogestor.crud.model.Ave;
import com.agrogestor.crud.repositories.AveRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ave")
public class AveController {

    @Autowired
    AveRepository repository;

    @GetMapping
    public ResponseEntity getAll(){
        List<Ave> listAve = repository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(listAve);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") int id){
        Optional<Ave> product = repository.findById(id);

        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody AveDto dto) {
        var ave = new Ave();
        BeanUtils.copyProperties(dto, ave);

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(ave));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id){
        Optional<Ave> ave = repository.findById(id);

        if(ave.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        repository.delete(ave.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") int id, @RequestBody AveDto dto) {
        Optional<Ave> ave = repository.findById(id);

        if(ave.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        var aveModel = new Ave();
        BeanUtils.copyProperties(dto, aveModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(aveModel));
    }
}