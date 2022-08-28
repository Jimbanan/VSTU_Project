package com.example.vstu_project.dto;

import com.example.vstu_project.entity.Category;
import com.example.vstu_project.enums.Categories;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesCheckboxDTO {

    List<String> categoriesArrayList;

}
