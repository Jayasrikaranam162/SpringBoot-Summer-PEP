package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AssetCategory;

public interface AssetCategoryService {

    AssetCategory createCategory(AssetCategory category);

    List<AssetCategory> getAllCategories();

    AssetCategory getCategoryById(Long id);

    AssetCategory updateCategory(Long id, AssetCategory category);

    void deleteCategory(Long id);
}