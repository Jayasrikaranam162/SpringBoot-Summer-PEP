package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Asset;

public interface AssetService {

    Asset createAsset(Asset asset, Long categoryId, Long vendorId);

    List<Asset> getAllAssets();

    Asset getAssetById(Long id);

    Asset updateAsset(Long id, Asset asset, Long categoryId, Long vendorId);

    void deleteAsset(Long id);
}