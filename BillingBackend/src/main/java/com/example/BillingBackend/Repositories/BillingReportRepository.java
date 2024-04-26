package com.example.BillingBackend.Repositories;

import com.example.BillingBackend.Entities.BillingReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingReportRepository extends JpaRepository<BillingReport, Long> {
}