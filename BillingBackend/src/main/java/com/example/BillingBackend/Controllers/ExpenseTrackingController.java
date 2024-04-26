package com.example.BillingBackend.Controllers;

import com.example.BillingBackend.Entities.ExpenseTracking;
import com.example.BillingBackend.Services.ExpenseTrackingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseTrackingController {

    private final ExpenseTrackingService expenseTrackingService;

    public ExpenseTrackingController(ExpenseTrackingService expenseTrackingService) {
        this.expenseTrackingService = expenseTrackingService;
    }

    @PostMapping("/expenses")
    public ResponseEntity<String> createExpense(@RequestBody ExpenseTracking expenseTracking) {
        ExpenseTracking createdExpense = expenseTrackingService.createExpense(expenseTracking);
        return ResponseEntity.status(HttpStatus.CREATED).body("Expense created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getExpenseById(@PathVariable Long id) {
        ExpenseTracking expenseTracking = expenseTrackingService.getExpenseById(id);
        if (expenseTracking == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense not found");
        }
        return ResponseEntity.ok("Expense retrieved successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateExpense(@PathVariable Long id, @RequestBody ExpenseTracking expenseTracking) {
        expenseTracking.setId(id); // Ensure ID is set for update
        ExpenseTracking updatedExpense = expenseTrackingService.updateExpense(expenseTracking);
        if (updatedExpense == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense not found");
        }
        return ResponseEntity.ok("Expense updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        expenseTrackingService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully");
    }
}
