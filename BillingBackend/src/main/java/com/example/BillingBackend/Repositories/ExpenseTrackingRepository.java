package com.example.BillingBackend.Repositories;

import com.example.BillingBackend.Entities.ExpenseTracking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseTrackingRepository extends CrudRepository<ExpenseTracking, Long> {
//    ScopedValue<ExpenseTracking> findById(Long id);

    ExpenseTracking save(ExpenseTracking expenseTracking);

    void deleteById(Long id);

    Optional<ExpenseTracking> findById(Long id);
}
