// Boolean Statements
data class TodoTask(val id: Int, var description: String, var isCompleted: Boolean = false)

class TodoListApp {
    private val tasks = mutableListOf<TodoTask>()
    private var taskId = 1

    fun start() {
        println("Welcome to the Todo List Application!")

        while (true) {
            printMenu()
            val choice = readLine()?.toIntOrNull()

            when (choice) {
                1 -> addTask()
                2 -> viewTasks()
                3 -> markTaskAsCompleted()
                4 -> removeTask()
                5 -> {
                    println("Exiting the Todo List App. Goodbye!") // Bye Bye :(
                    return
                }
                else -> println("Invalid choice. Please try again.") // Incorrect choice
            }
        }
    }

    // Information which is displayed to the user.

    private fun printMenu() {
        println("\nApplication Menu:")
        println(">> 1. Add Task")
        println(">> 2. View Tasks")
        println(">> 3. Mark Task as Completed")
        println(">> 4. Remove Task")
        println(">> 5. Exit")
        print("Enter your choice: ")
    }

    // Adding a task to the tasks section.

    private fun addTask() {
        print("Enter the task description: ")
        val description = readLine()?.trim() ?: ""

        if (description.isNotEmpty()) {
            tasks.add(TodoTask(taskId++, description))
            println("Task added successfully!")
        } else {
            println("Task description cannot be empty. Task not added.")
        }
    }

    // Fetching tasks and allowing the user to view them.

    private fun viewTasks() {
        if (tasks.isEmpty()) {
            println("Todo list is empty.")
        } else {
            println("\nTodo List:")
            for (task in tasks) {
                val status = if (task.isCompleted) "[✔]" else "[ ]" // Check indicates that the task is completed.
                println("$status Task #${task.id}: ${task.description}")
            }
        }
    }

    private fun markTaskAsCompleted() {
        print("Enter the task number to mark as completed: ")
        val taskId = readLine()?.toIntOrNull()

        if (taskId != null) {
            val task = tasks.find { it.id == taskId }
            if (task != null) {
                task.isCompleted = true
                println("Task #${task.id} marked as completed.")
            } else {
                println("Task not found.")
            }
        } else {
            println("Invalid input. Please enter a valid task number.")
        }
    }

    private fun removeTask() {
        print("Enter the task number to remove: ")
        val taskId = readLine()?.toIntOrNull()

        if (taskId != null) {
            val task = tasks.find { it.id == taskId }
            if (task != null) {
                tasks.remove(task)
                println("Task #${task.id} removed.")
            } else {
                println("Task not found.")
            }
        } else {
            println("Invalid input. Please enter a valid task number.")
        }
    }
}

fun main() {
    val todoListApp = TodoListApp()
    todoListApp.start()
}