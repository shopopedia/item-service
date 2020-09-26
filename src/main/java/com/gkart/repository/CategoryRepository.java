package com.gkart.repository;

import com.gkart.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
    Category findByName(String name);
    void deleteByName(String name);
    //Category update(String name);
}