package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DamageReport;

public interface DamageReportRepository extends JpaRepository<DamageReport, Long> {

}