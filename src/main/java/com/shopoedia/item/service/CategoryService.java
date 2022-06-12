package com.shopoedia.item.service;

import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.shopoedia.item.domain.Category;
import com.shopoedia.item.exception.APIException;
import com.shopoedia.item.model.CategoryRequest;
import com.shopoedia.item.model.CategoryResponse;
import com.shopoedia.item.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    Category category = new Category();

    //create
    public Category create(CategoryRequest categoryRequest) throws APIException {
        category.setName(categoryRequest.getName());

        try {
            categoryRepository.save(category);
        }catch (DataIntegrityViolationException e){
            System.out.println("catch called!");
            if(e.getCause()!=null && e.getCause() instanceof ConstraintViolationException){
                throw new APIException("Duplicate entry for " + e.getCause().getCause().getLocalizedMessage(), HttpStatus.BAD_REQUEST);
            }
        }
        return category;
    }
    //get
    public CategoryResponse get(String name) throws APIException {
        System.out.println(" ::::: get ::::: " + CategoryService.class);

        Optional<Category> category = Optional.of(new Category());
        CategoryResponse categoryResponse = null;

        try {
//            category = categoryRepository.findById(id);
                category = Optional.ofNullable(categoryRepository.findByName(name));
            categoryResponse = new CategoryResponse(category.get().getId(), category.get().getName());

        } catch (Exception e) {
            System.out.println("catch called! " +e);
//            if (e.getCause() != null && e.getCause() instanceof ConstraintViolationException) {
//                throw new APIException(" Exception : " + e.getCause().getCause().getLocalizedMessage(), HttpStatus.BAD_REQUEST);
//            }
        }
        return categoryResponse;
    }
    //update
    public Category update(CategoryRequest categoryRequest) throws APIException {

        category.setName(categoryRequest.getName());

        try {
            categoryRepository.save(category);
        } catch (DataIntegrityViolationException e) {
            System.out.println("catch called!");
//            if(e.getCause()!=null && e.getCause() instanceof ConstraintViolationException){
//                throw new APIException("Duplicate entry for " + e.getCause().getCause().getLocalizedMessage(), HttpStatus.BAD_REQUEST);//           }
//        }
        }
            return category;
        }

    public void delete(String name) throws APIException {

        try {
            categoryRepository.deleteByName(name);
        }catch (DataIntegrityViolationException e){
            System.out.println("catch called!");
//            if(e.getCause()!=null && e.getCause() instanceof ConstraintViolationException){
//                throw new APIException("Duplicate entry for " + e.getCause().getCause().getLocalizedMessage(), HttpStatus.BAD_REQUEST);
//            }
        }
    }
}