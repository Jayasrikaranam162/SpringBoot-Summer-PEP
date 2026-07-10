package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AssetAssignment;

public interface AssetAssignmentRepository extends JpaRepository<AssetAssignment, Long> {

}