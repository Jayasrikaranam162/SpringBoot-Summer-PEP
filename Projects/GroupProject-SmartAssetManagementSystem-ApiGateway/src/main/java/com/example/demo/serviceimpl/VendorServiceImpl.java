package com.example.demo.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Vendor;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public Vendor createVendor(Vendor vendor) {
        vendor.setStatus("ACTIVE");
        vendor.setCreatedAt(LocalDateTime.now());
        vendor.setUpdatedAt(LocalDateTime.now());
        return vendorRepository.save(vendor);
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    @Override
    public Vendor getVendorById(Long id) {
        return vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found with id: " + id));
    }

    @Override
    public Vendor updateVendor(Long id, Vendor vendor) {
        Vendor existingVendor = getVendorById(id);

        existingVendor.setVendorName(vendor.getVendorName());
        existingVendor.setContactPerson(vendor.getContactPerson());
        existingVendor.setEmail(vendor.getEmail());
        existingVendor.setPhone(vendor.getPhone());
        existingVendor.setAddress(vendor.getAddress());
        existingVendor.setStatus(vendor.getStatus());
        existingVendor.setUpdatedAt(LocalDateTime.now());

        return vendorRepository.save(existingVendor);
    }

    @Override
    public void deleteVendor(Long id) {
        Vendor vendor = getVendorById(id);
        vendorRepository.delete(vendor);
    }
}