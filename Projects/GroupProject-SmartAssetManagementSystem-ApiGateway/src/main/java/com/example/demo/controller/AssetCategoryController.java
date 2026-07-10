package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AssetCategory;
import com.example.demo.service.AssetCategoryService;

@RestController
@RequestMapping("/api/categories")
public class AssetCategoryController {

    private final AssetCategoryService assetCategoryService;

    public AssetCategoryController(AssetCategoryService assetCategoryService) {
        this.assetCategoryService = assetCategoryService;
    }

    @PostMapping
    public AssetCategory createCategory(@RequestBody AssetCategory category) {
        return assetCategoryService.createCategory(category);
    }

    @GetMapping
    public List<AssetCategory> getAllCategories() {
        return assetCategoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public AssetCategory getCategoryById(@PathVariable Long id) {
        return assetCategoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public AssetCategory updateCategory(@PathVariable Long id,
                                        @RequestBody AssetCategory category) {
        return assetCategoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        assetCategoryService.deleteCategory(id);
        return "Asset Category deleted successfully with id: " + id;
    }
}