
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseManager {
    private ArrayList<Expense> expenses;
    private ExpenseStorage storage;

    public ExpenseManager(ExpenseStorage storage) {
        this.storage = storage;
        this.expenses = new ArrayList<>();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addExpense(scanner);
                case 2 -> viewExpenses();
                case 3 -> deleteExpense(scanner);
                case 4 -> running = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private void addExpense(Scanner scanner) {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        expenses.add(new Expense(category, description, amount));
        System.out.println("Expense added successfully!");
    }

    private void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        System.out.println("Expenses:");
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println((i + 1) + ". " + expenses.get(i));
        }
    }

    private void deleteExpense(Scanner scanner) {
        viewExpenses();

        if (expenses.isEmpty()) return;

        System.out.print("Enter the expense number to delete: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
            System.out.println("Expense deleted successfully!");
        } else {
            System.out.println("Invalid expense number.");
        }
    }

    public void saveExpenses() {
        storage.saveExpenses(expenses);
    }

    public void loadExpenses() {
        ArrayList<Expense> loadedExpenses = storage.loadExpenses();
        if (loadedExpenses != null) {
            expenses = loadedExpenses;
            System.out.println("Expenses loaded.");
        }
    }
}
