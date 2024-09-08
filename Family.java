import java.util.Scanner;

public class Family extends User{

  private String family;

  public Family(String userName, String password, String name, String family){
    super.userName = userName;
    super.password = password;
    super.name = name;
    this.family = family;
  }

  public Family(){}

  public String getFamily(){
    return family;
  }
  
  public void createExpense(String currentUser, String familyName){
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
    scanner.next();
    String description = scanner.nextLine();
    fileHandler.addExpFamily(currentUser, familyName, name, amount, day, month, year, category, description);
  }

  public void deleteExpense(String currentUser, String familyName){
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    System.out.println("Please enter name of expense to delete: ");
    String name = scanner.nextLine();
    System.out.println("Please enter date of expense to delete: ");
    String month = months();
    String day = days(month);
    String year = years();
    fileHandler.removeExpFamily(currentUser, familyName, name, day, month, year);
  }

  public void viewExpense(String currentUser, String familyName){
    FileHandler fileHandler = new FileHandler();
    fileHandler.viewPersonalExp(currentUser, familyName);
  }

  public void createIncome(String currentUser, String familyName){
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
    System.out.println("Please enter description of income: ");
    scanner.nextLine();
    String description = scanner.nextLine();
    fileHandler.addIncFamily(currentUser, familyName, name, amount, day, month, year, description);
  }

  public void deleteIncome(String currentUser, String familyName){
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    System.out.println("Please enter name of income to delete: ");
    String name = scanner.nextLine();
    System.out.println("Please enter date of income to delete: ");
    String month = months();
    String day = days(month);
    String year = years();
    fileHandler.removeIncFamily(currentUser, familyName, name, day, month, year);
  }

  public void viewIncome(String currentUser, String familyName){
    FileHandler fileHandler = new FileHandler();
    fileHandler.viewPersonalInc(currentUser, familyName);
  }

  public void personalMonthlyReport(String currentUser, String familyName){
    FileHandler fileHandler = new FileHandler();
    System.out.println("Please enter month to view report for: ");
    String month = months();
    System.out.println("Please enter year to view report for: \n");
    String year = years();
    fileHandler.personalMonthlyReport(currentUser, familyName, month, year);
  }

  public void personalYearlyReport(String currentUser, String familyName){
    FileHandler fileHandler = new FileHandler();
    System.out.println("Please enter year to view report for: \n");
    String year = years();
    fileHandler.personalYearlyReport(currentUser, familyName, year);
  }

  public void viewByCategory(String currentUser, String familyName){
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
        fileHandler.personalMonthlyReportByCat(currentUser, familyName, month, year, category);
        keepGoing = false;
      } else if(choice == 2){
        System.out.println("Please select a year: ");
        String year = years();
        fileHandler.personalYearlyReportByCat(currentUser, familyName, year, category);
        keepGoing = false;
      } else if(choice == 3){
        fileHandler.viewPersonalExpByCat(currentUser, familyName, category);
        keepGoing = false;
      } else {
        System.out.println("\n Invald input. Please try again. \n");
      }
    }
  }

  public void memberSpending(String currentUser, String familyName){
    FileHandler fileHandler = new FileHandler();
    Scanner scanner = new Scanner(System.in);
    boolean keepGoing = true;
    System.out.println("\nPlease choose the duration you want to see Member specific spending: ");
    while(keepGoing){
      System.out.println("1. Monthly   2. Yearly   3.All time    4.Exit\n");
      System.out.println("Please selcet an option: ");
      int choice = scanner.nextInt();
      if(choice == 1){
        System.out.println("Please select a month: ");
        String month = months();
        System.out.println("Please select a year: ");
        String year = years();
        fileHandler.memberSpendingByMonth(currentUser, familyName, month, year);
        keepGoing = false;
      } else if(choice == 2){
        System.out.println("Please select a year: ");
        String year = years();
        fileHandler.memberSpendingByYear(currentUser, familyName, year);
        keepGoing = false;
      } else if(choice == 3){
        fileHandler.memberSpending(currentUser, familyName);
        keepGoing = false;
      } else if(choice == 4){
      } else {
        System.out.println("\n Invald input. Please try again. \n");
      }
    }
  }

  public void monthlySpending(String currentUser, String familyName){
    FileHandler fileHandler = new FileHandler();
    System.out.println("Please enter month to view report for: ");
    String month = months();
    System.out.println("Please enter year to view report for: \n");
    String year = years();
    fileHandler.familyMonthlyReport(currentUser, familyName, month, year);
  }

  public void yearlySpending(String currentUser, String familyName){
    FileHandler fileHandler = new FileHandler();
    System.out.println("Please enter year to view report for: \n");
    String year = years();
    fileHandler.familyYearlyReport(currentUser, familyName, year);
  }

  public void addNewMember(String currentUser, String familyName){
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    boolean keepGoing = true;
    String userName = "";
    System.out.println("Please enter name of new member: ");
    String name = scanner.nextLine();
    while(keepGoing){
    System.out.println("Please enter username of new member: ");
    userName = scanner.nextLine();
    if(fileHandler.isUserUnq(userName)){
      keepGoing = false;
    } else {
      System.out.println("Username already exists. Please try again.");
    }
    }
    System.out.println("Please enter password of new member: ");
    String password = scanner.nextLine();
    System.out.println(userName);
    fileHandler.addNewMember(currentUser, familyName, name, userName, password);
  }

  public void viewExpByCategory(String currentUser, String familyName){
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
        fileHandler.monthlyFamilyExpByCat(currentUser, familyName, month, year, category);
        keepGoing = false;
      } else if(choice == 2){
        System.out.println("Please select a year: ");
        String year = years();
        fileHandler.yearlyFamilyExpByCat(currentUser, familyName, year, category);
        keepGoing = false;
      } else if(choice == 3){
        fileHandler.viewFamilyExpByCat(currentUser, familyName, category);
        keepGoing = false;
      } else if(choice == 4){
      } else {
        System.out.println("\n Invald input. Please try again. \n");
      }
    }
  }
}
