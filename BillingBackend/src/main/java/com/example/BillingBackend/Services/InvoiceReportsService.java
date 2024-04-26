package com.example.BillingBackend.Services;

import com.example.BillingBackend.Entities.InvoiceReports;
import com.example.BillingBackend.Repositories.InvoiceReportsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InvoiceReportsService {

    private final InvoiceReportsRepository invoiceReportsRepository;

    @Autowired
    public InvoiceReportsService(InvoiceReportsRepository invoiceReportsRepository) {
        this.invoiceReportsRepository = invoiceReportsRepository;
    }

    public InvoiceReports generateInvoiceReports(InvoiceReports invoiceReports) {
        return invoiceReportsRepository.save(invoiceReports);
    }

    public List<InvoiceReports> getAllInvoicesReports() {
        return invoiceReportsRepository.findAll();
    }

    public InvoiceReports updateInvoiceReports(InvoiceReports invoiceReports) {
        return invoiceReports;
    }

    public void deleteInvoiceReports(Long id) {
    }
}