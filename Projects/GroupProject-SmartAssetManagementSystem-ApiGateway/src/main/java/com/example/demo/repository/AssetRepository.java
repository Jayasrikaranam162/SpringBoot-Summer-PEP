package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {

    long countByAssetStatus(String assetStatus);

    long countByConditionStatus(String conditionStatus);
}