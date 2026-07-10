package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AssetCategory;

public interface AssetCategoryRepository extends JpaRepository<AssetCategory, Long> {

    Optional<AssetCategory> findByCategoryName(String categoryName);
}