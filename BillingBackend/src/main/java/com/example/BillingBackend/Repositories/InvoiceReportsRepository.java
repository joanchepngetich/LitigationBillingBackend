package com.example.BillingBackend.Repositories;

import com.example.BillingBackend.Entities.InvoiceReports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceReportsRepository extends JpaRepository<InvoiceReports,Long> {

}