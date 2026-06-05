# 💰 Expense Tracker App (MVVM + Room Database + ViewBinding)

A simple and clean **Expense Tracker Android app** built using **MVVM Architecture**, **Room Database**, **ViewModel**, **LiveData**, and **ViewBinding** with **XML layouts**.  
This project is perfect for learning **Android MVVM architecture** and how to structure a scalable and maintainable Android app.

---

## 🎯 Features

- ➕ Add new expenses with title, amount, category, and date  
- 🗑️ Delete expenses with a long press  
- 💵 View total expenses updated in real-time  
- 💾 Local data storage using **Room Database**  
- ⚙️ Clean architecture using **Repository + ViewModel + LiveData**  
- 🎨 Modern UI built with **XML layouts** and **ViewBinding**

---

## 🧱 Tech Stack

| Component | Description |
|------------|-------------|
| **Language** | Kotlin |
| **Architecture** | MVVM (Model–View–ViewModel) |
| **Database** | Room |
| **UI** | XML Layouts + ViewBinding |
| **Async Tasks** | Coroutines (with `viewModelScope`) |
| **Libraries** | AndroidX Lifecycle, Room, Material Components |

---

## 🗂️ Project Structure

app/
├── data/
│ ├── model/ → Expense.kt
│ ├── dao/ → ExpenseDao.kt
│ └── database/ → ExpenseDatabase.kt
│
├── repository/ → ExpenseRepository.kt
│
├── ui/
│ ├── adapter/ → ExpenseAdapter.kt
│ ├── viewmodel/ → ExpenseViewModel.kt
│ └── view/ → MainActivity.kt
│
└── utils/ (optional)

yaml
Copy code

---

## ⚙️ Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone git@github.com:khaliqdadmohmand/android-expense-tracker-mvvm.git
   cd ExpenseTracker-MVVM
Open in Android Studio

Sync Gradle to install dependencies.

Run the App on an emulator or real device.

🎥 YouTube Tutorial
👉 [YouTube Link](https://youtu.be/QrNhz5QgrU4)

In this video, you’ll learn to build this app step-by-step using MVVM architecture, Room Database, and ViewModel. Perfect for beginners learning modern Android development.

💡 Concepts Covered
MVVM Architecture in Android

Room Database Integration

Repository Pattern

LiveData and ViewModel

ViewBinding in XML layouts

RecyclerView Adapter with Live Updates

🧑‍💻 Author
Khaliq KD
📺 YouTube Channel: https://www.youtube.com/@kdtechs
💻 GitHub
