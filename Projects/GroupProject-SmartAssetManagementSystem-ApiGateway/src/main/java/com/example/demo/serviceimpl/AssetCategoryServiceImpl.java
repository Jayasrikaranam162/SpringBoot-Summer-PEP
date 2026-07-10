package com.example.demo.serviceimpl;

import java.time.LocalDateTime;
import com.example.demo.exception.BusinessException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AssetCategory;
import com.example.demo.repository.AssetCategoryRepository;
import com.example.demo.service.AssetCategoryService;

@Service
public class AssetCategoryServiceImpl implements AssetCategoryService {

    private final AssetCategoryRepository assetCategoryRepository;

    public AssetCategoryServiceImpl(AssetCategoryRepository assetCategoryRepository) {
        this.assetCategoryRepository = assetCategoryRepository;
    }

    @Override
    public AssetCategory createCategory(AssetCategory category) {

        assetCategoryRepository.findByCategoryName(category.getCategoryName())
                .ifPresent(existing -> {
                    throw new BusinessException("Category already exists with name: " + category.getCategoryName());
                });

        category.setStatus("ACTIVE");
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());

        return assetCategoryRepository.save(category);
    }

    @Override
    public List<AssetCategory> getAllCategories() {
        return assetCategoryRepository.findAll();
    }

    @Override
    public AssetCategory getCategoryById(Long id) {
        return assetCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset Category not found with id: " + id));
    }

    @Override
    public AssetCategory updateCategory(Long id, AssetCategory category) {
        AssetCategory existingCategory = getCategoryById(id);

        existingCategory.setCategoryName(category.getCategoryName());
        existingCategory.setDescription(category.getDescription());
        existingCategory.setStatus(category.getStatus());
        existingCategory.setUpdatedAt(LocalDateTime.now());

        return assetCategoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        AssetCategory category = getCategoryById(id);
        assetCategoryRepository.delete(category);
    }
}