package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping("/category/{categoryId}/vendor/{vendorId}")
    public Asset createAsset(@RequestBody Asset asset,
                             @PathVariable Long categoryId,
                             @PathVariable Long vendorId) {
        return assetService.createAsset(asset, categoryId, vendorId);
    }

    @GetMapping
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    @GetMapping("/{id}")
    public Asset getAssetById(@PathVariable Long id) {
        return assetService.getAssetById(id);
    }

    @PutMapping("/{id}/category/{categoryId}/vendor/{vendorId}")
    public Asset updateAsset(@PathVariable Long id,
                             @PathVariable Long categoryId,
                             @PathVariable Long vendorId,
                             @RequestBody Asset asset) {
        return assetService.updateAsset(id, asset, categoryId, vendorId);
    }

    @DeleteMapping("/{id}")
    public String deleteAsset(@PathVariable Long id) {
        assetService.deleteAsset(id);
        return "Asset deleted successfully with id: " + id;
    }
}