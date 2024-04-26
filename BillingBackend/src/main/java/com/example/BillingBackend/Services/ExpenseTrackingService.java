package com.example.BillingBackend.Services;

import com.example.BillingBackend.Entities.ExpenseTracking;
import com.example.BillingBackend.Repositories.ExpenseTrackingRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseTrackingService {

    private final ExpenseTrackingRepository expenseTrackingRepository;

    public ExpenseTrackingService(ExpenseTrackingRepository expenseTrackingRepository) {
        this.expenseTrackingRepository = expenseTrackingRepository;
    }

    public ExpenseTracking createExpense(ExpenseTracking expenseTracking) {
        return (ExpenseTracking) expenseTrackingRepository.save(expenseTracking);
    }

    public ExpenseTracking getExpenseById(Long id) {
        return (ExpenseTracking) expenseTrackingRepository.findById(id).orElse(null);
    }

    public ExpenseTracking updateExpense(ExpenseTracking expenseTracking) {
        return (ExpenseTracking) expenseTrackingRepository.save(expenseTracking);
    }

    public void deleteExpense(Long id) {
        expenseTrackingRepository.deleteById(id);
    }
}