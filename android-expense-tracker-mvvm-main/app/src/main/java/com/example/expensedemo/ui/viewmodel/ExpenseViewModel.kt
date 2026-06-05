package com.example.expensedemo.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.expensedemo.data.database.ExpenseDatabase
import com.example.expensedemo.data.model.ExpenseModel
import com.example.expensedemo.repository.ExpenseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExpenseViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ExpenseRepository

    val allExpenses: LiveData<List<ExpenseModel>>
    val totalAmount: LiveData<Double>

    init {
        val dao = ExpenseDatabase.getDatabase(application).expenseDao()
        repository = ExpenseRepository(dao)
        allExpenses = repository.allExpenses
        totalAmount = repository.totalAmount
    }

    fun insert(expense: ExpenseModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(expense)
    }

    fun delete(expense: ExpenseModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(expense)
    }
}
