package com.gkart.controller;

import com.gkart.domain.Category;
import com.gkart.exception.APIException;
import com.gkart.model.CategoryRequest;
import com.gkart.model.CategoryResponse;
import com.gkart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService catagoryService;

    @PostMapping(value = "/create")
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest categoryRequest) throws APIException {
        System.out.println(" request : " + categoryRequest);

        Category category = catagoryService.create(categoryRequest);
            CategoryResponse categoryResponse = new CategoryResponse(category.getId(),category.getName());

        return ResponseEntity.ok(categoryResponse);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<CategoryResponse> get(@PathVariable String name) throws APIException {
        System.out.println(" request : " + name);
        System.out.println(" ::::: get ::::: " + CategoryController.class);

        CategoryResponse categoryResponse = catagoryService.get(name);

        return ResponseEntity.ok(categoryResponse);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Category> update(@RequestBody CategoryRequest categoryRequest) throws APIException {

        System.out.println(" request : " + categoryRequest.toString());
        System.out.println(" ::::: get ::::: " + CategoryController.class);

        Category category  = catagoryService.update(categoryRequest);

        return ResponseEntity.ok(category);
    }

    @DeleteMapping(value = "/{name}")
    public ResponseEntity delete(@PathVariable String name) throws APIException {

        System.out.println(" ::::: delete ::::: " + name);

        catagoryService.delete(name);

        return ResponseEntity.ok().build();
    }

}