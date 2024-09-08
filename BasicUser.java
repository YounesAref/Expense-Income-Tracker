import java.util.Scanner;

public class BasicUser extends User {

  public BasicUser(String userName, String password, String name) {
    super.userName = userName;
    super.password = password;
    super.name = name;
  }

  public BasicUser() {}

  public void createExpense(String currentUser) {
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    System.out.println("Please enter name of expense: ");
    String name = scanner.nextLine();
    System.out.println("Please enter amount of expense: ");
    Double amount = scanner.nextDouble();
    System.out.println("Please enter date of expense: ");
    String month = months();
    String day = days(month);
    String year = years();
    String category = printCategories();
    System.out.println("Please enter description of expense: ");
    String description = scanner.nextLine();
    fileHandler.createExp(currentUser, name, amount, day, month, year, category, description);
  }

  public void deleteExpense(String currentUser) {
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    System.out.println("Please enter name of expense to delete: ");
    String name = scanner.nextLine();
    System.out.println("Please enter date of expense to delete: ");
    String month = months();
    String day = days(month);
    String year = years();
    fileHandler.deleteExp(currentUser, name, day, month, year);
  }

  public void viewExpense(String currentUser) {
    FileHandler fileHandler = new FileHandler();
    fileHandler.viewExp(currentUser);
  }

  public void addIncome(String currentUser) {
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    System.out.println("Please enter name of income: ");
    String name = scanner.nextLine();
    System.out.println("Please enter amount of income: ");
    Double amount = scanner.nextDouble();
    System.out.println("Please enter date of income: ");
    String month = months();
    String day = days(month);
    String year = years();
    System.out.println("Enter decription of income: ");
    String description = scanner.nextLine();
    fileHandler.createInc(currentUser, name, amount, day, month, year, description);
  }

  public void deleteIncome(String currentUser) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter income name: ");
    String name = scanner.nextLine();
    System.out.println("Please enter date of income to delete: ");
    String month = months();
    String day = days(month);
    String year = years();
    FileHandler fileHandler = new FileHandler();
    fileHandler.deleteInc(currentUser, name, day, month, year);
  }

  public void viewIncome(String currentUser) {
    FileHandler fileHandler = new FileHandler();
    fileHandler.viewInc(currentUser);
  }

  public void monthlyReport(String currentUser) {
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    System.out.println("Please enter month to view report for: ");
    String month = months();
    System.out.println("Please enter year to view report for: \n");
    String year = years();
    fileHandler.monthlyReport(currentUser, month, year);
  }

  public void yearlyReport(String currentUser){
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    System.out.println("Please enter year to view report for: \n");
    String year = years();
    fileHandler.yearlyReport(currentUser, year);
  }

  public void viewByCategory(String currentUser){
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    boolean keepGoing = true;
    System.out.println("Please enter category to view: \n");
    String category = printCategories();
    System.out.println("\nPlease choose the duration you want to see category specific spending: ");
    while(keepGoing){
      System.out.println("1. Monthly   2. Yearly   3.All time    4.Exit\n");
      System.out.println("Please selcet an option: ");
      int choice = scanner.nextInt();
      if(choice == 1){
        System.out.println("Please select a month: ");
        String month = months();
        System.out.println("Please select a year: ");
        String year = years();
        fileHandler.viewExpByCatMonthly(currentUser, month, year, category);
        keepGoing = false;
      } else if(choice == 2){
        System.out.println("Please select a year: ");
        String year = years();
        fileHandler.viewExpByCatYearly(currentUser, year, category);
        keepGoing = false;
      } else if(choice == 3){
        fileHandler.viewExpByCategory(currentUser, category);
        keepGoing = false;
      } else {
        System.out.println("\n Invald input. Please try again. \n");
      }
    }
  }
}
