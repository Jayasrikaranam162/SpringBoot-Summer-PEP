package com.example.demo.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AssetCategory;
import com.example.demo.service.AssetCategoryService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ui/categories")
public class WebCategoryController {

	private final AssetCategoryService assetCategoryService;

	public WebCategoryController(AssetCategoryService assetCategoryService) {
		this.assetCategoryService = assetCategoryService;
	}

	@GetMapping
	public String listCategories(Model model) {
		model.addAttribute("categories", assetCategoryService.getAllCategories());
		return "category/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("category", new AssetCategory());
		return "category/add";
	}

	@PostMapping("/add")
	public String addCategory(@Valid @ModelAttribute("category") AssetCategory category, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "category/add";
		}

		try {
			assetCategoryService.createCategory(category);
		} catch (Exception e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "category/add";
		}

		return "redirect:/ui/categories";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		model.addAttribute("category", assetCategoryService.getCategoryById(id));
		return "category/edit";
	}

	@PostMapping("/edit/{id}")
	public String updateCategory(@PathVariable Long id, @Valid @ModelAttribute("category") AssetCategory category,
			BindingResult result) {

		if (result.hasErrors()) {
			return "category/edit";
		}

		assetCategoryService.updateCategory(id, category);
		return "redirect:/ui/categories";
	}

	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable Long id, Model model) {

		try {
			assetCategoryService.deleteCategory(id);
		} catch (Exception e) {
			model.addAttribute("categories", assetCategoryService.getAllCategories());
			model.addAttribute("errorMessage", "Cannot delete this category because assets are linked to it.");
			return "category/list";
		}

		return "redirect:/ui/categories";
	}
}