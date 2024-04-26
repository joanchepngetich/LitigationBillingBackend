package com.example.BillingBackend.Controllers;

import com.example.BillingBackend.Entities.ExpenseTracking;
import com.example.BillingBackend.Entities.InvoiceReports;
import com.example.BillingBackend.Services.BillingReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BillingReportController {

    private final BillingReportService billingService;

    @Autowired
    public BillingReportController(BillingReportService billingService) {
        this.billingService = billingService;
    }

    @GetMapping(value = "/billing/reports", produces = "application/json")
    public ResponseEntity<Map<String, List<?>>> generateBillingReport() {
        List<InvoiceReports> invoicesReports = billingService.getAllInvoicesReports();
        List<ExpenseTracking> expenses = billingService.getAllExpenses();

        Map<String, List<?>> report = new HashMap<>();
        report.put("invoicesReports", invoicesReports);
        report.put("expenses", expenses);

        return ResponseEntity.ok(report);
    }
}
