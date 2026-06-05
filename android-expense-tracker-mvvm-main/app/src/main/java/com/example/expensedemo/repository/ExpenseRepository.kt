package com.example.expensedemo.repository

import androidx.lifecycle.LiveData
import com.example.expensedemo.data.dao.ExpenseDao
import com.example.expensedemo.data.model.ExpenseModel

class ExpenseRepository(private val dao: ExpenseDao) {

    val allExpenses: LiveData<List<ExpenseModel>> = dao.getAllExpenses()
    val totalAmount: LiveData<Double> = dao.getTotalAmount()

    suspend fun insert(expense: ExpenseModel) {
        dao.insert(expense)
    }

    suspend fun delete(expense: ExpenseModel) {
        dao.delete(expense)
    }
}
