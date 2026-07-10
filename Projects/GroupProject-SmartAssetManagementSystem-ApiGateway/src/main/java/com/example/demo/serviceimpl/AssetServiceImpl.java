package com.example.demo.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Asset;
import com.example.demo.entity.AssetCategory;
import com.example.demo.entity.Vendor;
import com.example.demo.repository.AssetCategoryRepository;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.AssetService;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final AssetCategoryRepository assetCategoryRepository;
    private final VendorRepository vendorRepository;

    public AssetServiceImpl(AssetRepository assetRepository,
                            AssetCategoryRepository assetCategoryRepository,
                            VendorRepository vendorRepository) {
        this.assetRepository = assetRepository;
        this.assetCategoryRepository = assetCategoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public Asset createAsset(Asset asset, Long categoryId, Long vendorId) {

        AssetCategory category = assetCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Asset Category not found with id: " + categoryId));

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found with id: " + vendorId));

        asset.setCategory(category);
        asset.setVendor(vendor);
        asset.setAssetStatus("AVAILABLE");
        asset.setConditionStatus("GOOD");
        asset.setCreatedAt(LocalDateTime.now());
        asset.setUpdatedAt(LocalDateTime.now());

        return assetRepository.save(asset);
    }

    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @Override
    public Asset getAssetById(Long id) {
        return assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found with id: " + id));
    }

    @Override
    public Asset updateAsset(Long id, Asset asset, Long categoryId, Long vendorId) {

        Asset existingAsset = getAssetById(id);

        AssetCategory category = assetCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Asset Category not found with id: " + categoryId));

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found with id: " + vendorId));

        existingAsset.setAssetCode(asset.getAssetCode());
        existingAsset.setAssetName(asset.getAssetName());
        existingAsset.setSerialNumber(asset.getSerialNumber());
        existingAsset.setBrand(asset.getBrand());
        existingAsset.setModel(asset.getModel());
        existingAsset.setPurchaseDate(asset.getPurchaseDate());
        existingAsset.setPurchaseCost(asset.getPurchaseCost());
        existingAsset.setWarrantyExpiryDate(asset.getWarrantyExpiryDate());
        existingAsset.setAssetStatus(asset.getAssetStatus());
        existingAsset.setConditionStatus(asset.getConditionStatus());
        existingAsset.setCategory(category);
        existingAsset.setVendor(vendor);
        existingAsset.setUpdatedAt(LocalDateTime.now());

        return assetRepository.save(existingAsset);
    }

    @Override
    public void deleteAsset(Long id) {
        Asset asset = getAssetById(id);
        assetRepository.delete(asset);
    }
}