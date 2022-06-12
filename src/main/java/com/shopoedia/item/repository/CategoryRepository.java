package com.shopoedia.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopoedia.item.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
    Category findByName(String name);
    void deleteByName(String name);
    //Category update(String name);
}