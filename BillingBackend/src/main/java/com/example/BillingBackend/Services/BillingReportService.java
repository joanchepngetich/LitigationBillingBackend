package com.example.BillingBackend.Services;

import com.example.BillingBackend.Entities.BillingReport;
import com.example.BillingBackend.Entities.ExpenseTracking;
import com.example.BillingBackend.Entities.InvoiceReports;
import com.example.BillingBackend.Repositories.ExpenseTrackingRepository;
import com.example.BillingBackend.Repositories.InvoiceReportsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingReportService {
    private final InvoiceReportsRepository invoiceReportsRepository;
    private final ExpenseTrackingRepository expenseTrackingRepository;

    public BillingReportService(InvoiceReportsRepository invoiceReportsRepository, ExpenseTrackingRepository expenseTrackingRepository) {
        this.invoiceReportsRepository = invoiceReportsRepository;
        this.expenseTrackingRepository = expenseTrackingRepository;
    }

    public List<InvoiceReports> getAllInvoicesReports() {
        return invoiceReportsRepository.findAll();
    }

    public List<ExpenseTracking> getAllExpenses() {
        return (List<ExpenseTracking>) expenseTrackingRepository.findAll();
    }

    public BillingReport generateBillingReport() {
        List<InvoiceReports> invoicesReports = getAllInvoicesReports();
        List<ExpenseTracking> expenses = getAllExpenses();


        BillingReport report = new BillingReport();
        for (InvoiceReports invoiceReports : invoicesReports) {
            invoiceReports.setBillingReport(report);
        }

        for (ExpenseTracking expense : expenses) {
            expense.setBillingReport(report);
        }
        return report;
    }

}
