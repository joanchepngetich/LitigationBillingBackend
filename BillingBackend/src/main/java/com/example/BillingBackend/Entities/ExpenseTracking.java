package com.example.BillingBackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "billing_report_id")
    @JsonIgnore
    private BillingReport billingReport;

    private String expenseType;
    private String expenseDescription;
    private Double expenseAmount;
    private LocalDate expenseDate;
    private String expenseApprover;
    private LocalDate expenseApprovalDate;
    private String expenseApprovalStatus;

}
