
public class Main {
    public static void main(String[] args) {
        ExpenseStorage storage = new ExpenseStorage("expenses.dat");
        ExpenseManager manager = new ExpenseManager(storage);
        System.out.println("Welcome to the Expense Tracker Application!");
        manager.loadExpenses();
        manager.run();
        manager.saveExpenses();
    }
}
