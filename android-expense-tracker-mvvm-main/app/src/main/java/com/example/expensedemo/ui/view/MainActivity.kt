package com.example.expensedemo.ui.view

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expensedemo.R
import com.example.expensedemo.data.model.ExpenseModel
import com.example.expensedemo.databinding.ActivityMainBinding
import com.example.expensedemo.databinding.DialogAddExpenseBinding
import com.example.expensedemo.ui.adapter.ExpenseAdapter
import com.example.expensedemo.ui.viewmodel.ExpenseViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ExpenseViewModel
    private lateinit var adapter: ExpenseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
//        val tvTotal = findViewById<TextView>(R.id.tvTotal)
//        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAdd)

        adapter = ExpenseAdapter { expense ->
            viewModel.delete(expense)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this)[ExpenseViewModel::class.java]

        viewModel.allExpenses.observe(this) {
            adapter.setExpenses(it)
        }

        viewModel.totalAmount.observe(this) { total ->
            binding.tvTotal.text = "Total: $${String.format("%.2f", total ?: 0.0)}"
        }

        binding.fabAdd.setOnClickListener {
            showAddDialog()
        }
    }

    private fun showAddDialog() {
        val dialogBinding = DialogAddExpenseBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Add Expense")
            .setView(dialogBinding.root)
            .setPositiveButton("Add") { _, _ ->
                val title = dialogBinding.etTitle.text.toString()
                val amount = dialogBinding.etAmount.text.toString().toDoubleOrNull() ?: 0.0
                val category = dialogBinding.etCategory.text.toString()
                val date = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Date())

                val expense = ExpenseModel(title = title, amount = amount, category = category, date = date)
                viewModel.insert(expense)
            }
            .setNegativeButton("Cancel", null)
            .create()

        dialog.show()
    }
}
