package com.example.demo.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetCategoryService;
import com.example.demo.service.AssetService;
import com.example.demo.service.VendorService;

@Controller
@RequestMapping("/ui/assets")
public class WebAssetController {

    private final AssetService assetService;
    private final AssetCategoryService assetCategoryService;
    private final VendorService vendorService;

    public WebAssetController(AssetService assetService,
                              AssetCategoryService assetCategoryService,
                              VendorService vendorService) {
        this.assetService = assetService;
        this.assetCategoryService = assetCategoryService;
        this.vendorService = vendorService;
    }

    @GetMapping
    public String listAssets(Model model) {
        model.addAttribute("assets", assetService.getAllAssets());
        return "asset/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("asset", new Asset());
        model.addAttribute("categories", assetCategoryService.getAllCategories());
        model.addAttribute("vendors", vendorService.getAllVendors());
        return "asset/add";
    }

    @PostMapping("/add")
    public String addAsset(@ModelAttribute Asset asset,
                           @RequestParam Long categoryId,
                           @RequestParam Long vendorId) {

        assetService.createAsset(asset, categoryId, vendorId);
        return "redirect:/ui/assets";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("asset", assetService.getAssetById(id));
        model.addAttribute("categories", assetCategoryService.getAllCategories());
        model.addAttribute("vendors", vendorService.getAllVendors());
        return "asset/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateAsset(@PathVariable Long id,
                              @ModelAttribute Asset asset,
                              @RequestParam Long categoryId,
                              @RequestParam Long vendorId) {

        assetService.updateAsset(id, asset, categoryId, vendorId);
        return "redirect:/ui/assets";
    }

    @GetMapping("/delete/{id}")
    public String deleteAsset(@PathVariable Long id, Model model) {

        try {
            assetService.deleteAsset(id);
        } catch (Exception e) {
            model.addAttribute("assets", assetService.getAllAssets());
            model.addAttribute("errorMessage", "Cannot delete this asset because it is linked with assignment, maintenance, or damage records.");
            return "asset/list";
        }

        return "redirect:/ui/assets";
    }
}