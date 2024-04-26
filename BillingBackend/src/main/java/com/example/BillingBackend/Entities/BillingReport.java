package com.example.BillingBackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BillingReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Assuming you want to keep the invoices list, but it's not clear how it's mapped.
    // If it's a one-to-many relationship, you should annotate it similarly to expenses.

    @OneToMany(mappedBy = "billingReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceReports> invoicesReports;

}
