package com.example.vstu_project.services;

import com.example.vstu_project.entity.Category;
import com.example.vstu_project.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServicesImpl implements CategoryServices {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category getCategoryIdByCategory(String category){
        return categoryRepository.findByCategory(category);
    }

}
