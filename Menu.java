import java.util.Scanner;

public class Menu {

  private String currentUser;
  private String userType;
  private String familyName;

  public void setCurrentUser(String currentUser) {
    this.currentUser = currentUser;
  }

  public String getCurrentUser() {
    return currentUser;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getUserType() {
    return userType;
  }

  public void setFamilyName(String familyName){
    this.familyName = familyName;
  }

  public String getFamilyName(){
    return familyName;
  }

  public boolean createAcc() {
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    boolean keepGoing = true;
    boolean keepGoing3 = true;
    System.out.println("Enter your name: ");
    String name = scanner.nextLine();
    System.out.println("\nEnter a username: ");
    String userName = scanner.nextLine();
    while (keepGoing) {
      if (!fileHandler.isUserUnq(userName)) {
        System.out.println("\nUsername already exists. Please try again.");
      } else {
        keepGoing = false;
      }
    }
    System.out.println("\nEnter a password: ");
    String password = scanner.nextLine();
    boolean keepGoing2 = true;
    while(keepGoing2){
    System.out.println("Please select type of account or select 4 to learn more about each type: \n");
    System.out.println("1. Basic User");
    System.out.println("2. Family");
    System.out.println("3. Learn more");
    System.out.println("4. Cancel and exit\n");
    System.out.println("Please enter choice: ");
    String choice = scanner.nextLine();
    if (choice.equals("1")) {
      fileHandler.createBasicUser(userName, password, name);
      setUserType("BasicUser");
      setCurrentUser(userName);
      keepGoing2 = false;
      return true;
    } else if (choice.equals("2")) {
      while(keepGoing3){
      System.out.println("\nPlease enter family name: ");
      String familyName = scanner.nextLine();
      if(fileHandler.isFamilyNameUnq(familyName)){
      setFamilyName(familyName);
      keepGoing3 = false;
      }
      }
      fileHandler.createFamily(userName, password, name, familyName);
      setUserType("Family");
      setCurrentUser(userName);
      keepGoing2 = false;
      return true;
    } else if (choice.equals("3")) {
      System.out.println("\nBasic User: This type of account is for your typical adults that just want a simple way to moniter their budget, their spending habits and their income. \n");
      System.out.println("Family: This type of account is geared more towards family that want a simple way to moniter the spending habits of the whole family in one place");
      System.out.println("*Note: Adding more users to a family account can only be done by a user that is logged in");
    } else if (choice.equals("4")) {
      System.exit(0);
    } else {
      System.out.println("Invalid choice\n");
    }
    }
    return false;
  }

  public boolean auth() {
    Scanner scanner = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();
    boolean keepGoing = true;
    while(keepGoing){
    System.out.println("\nEnter your username: ");
    String username = scanner.nextLine();
    System.out.println("\nEnter your password: ");
    String password = scanner.nextLine();
     if (fileHandler.authFamily(username, password)) {
      setCurrentUser(username);
      setUserType("Family");
      setFamilyName(fileHandler.getFamilyName(username));
      keepGoing = false;
      return true;
    } else if (fileHandler.authBasicUser(username, password)) {
      setCurrentUser(username);
      setUserType("BasicUser");
       keepGoing = false;
      return true;
    } else {
      System.out.println("\nInvalid username or password \n");
      System.out.println("Do you want to try again? (y/n)");
       if(scanner.nextLine().equals("n")){
         System.exit(0);
       }
    }
    }
    return false;
  }

  public void menuBasicUser() {
    Scanner scanner = new Scanner(System.in);
    BasicUser basicUser = new BasicUser();
    boolean keepGoing = true;
    int choice;
    System.out.println("\nWelcome " + getCurrentUser() + "!");
    while (keepGoing) {
      System.out.println("\n                                         Main Menu \n");
      System.out.println("---------------------------------------------------------------------------------------------------------------------------");
      System.out.println("\nWhat would you like to do? \n");
      System.out.println("1- Add an expense");
      System.out.println("2- Remove an expense");
      System.out.println("3- View expenses");
      System.out.println("4- Add income");
      System.out.println("5- Remove income");
      System.out.println("6- View income");
      System.out.println("7- View Monthly Report");
      System.out.println("8- Yearly Report");
      System.out.println("9- View category spcific spending report");
      System.out.println("10- Logout \n");
      System.out.println("Please enter choice: ");
      choice = scanner.nextInt();
      System.out.println("\n");
      if (choice == 1) {
        basicUser.createExpense(currentUser);
      } else if (choice == 2) {
        basicUser.deleteExpense(currentUser);
      } else if (choice == 3) {
        basicUser.viewExpense(currentUser);
      } else if (choice == 4) {
        basicUser.addIncome(currentUser);
      } else if (choice == 5) {
        basicUser.deleteIncome(currentUser);
      } else if (choice == 6) {
        basicUser.viewIncome(currentUser);
      } else if (choice == 7) {
        basicUser.monthlyReport(currentUser);
      } else if (choice == 8) {
        basicUser.yearlyReport(currentUser);
      } else if(choice == 9) {
        basicUser.viewByCategory(currentUser);
      } else if (choice == 10) {
        keepGoing = false;
        System.exit(0);
      } else {
        System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  public void menuFamily() {
    Scanner scanner = new Scanner(System.in);
    Family family = new Family();
    boolean keepGoing = true;
    int choice;
    System.out.println("\nWelcome " + getCurrentUser() + "!");
    while (keepGoing) {
      System.out.println("\n                                         Main Menu \n");
      System.out.println("---------------------------------------------------------------------------------------------------------------------------");
      System.out.println("\nWhat would you like to do? \n");
      System.out.println("1- Add an expense");
      System.out.println("2- Remove an expense");
      System.out.println("3- View personal expenses");
      System.out.println("4- Add income");
      System.out.println("5- Remove income");
      System.out.println("6- View personal income");
      System.out.println("7- View personal Monthly Report");
      System.out.println("8- View personal Yearly Report");
      System.out.println("9- View personal category spcific spending report");
      System.out.println("10- Track family spending by person");
      System.out.println("11- Track family spending by category");
      System.out.println("12- View family Monthly Report");
      System.out.println("13- View family Yearly Report");
      System.out.println("14- Add new member to family account");
      System.out.println("15- Logout\n");
      System.out.println("Please enter choice: ");
      choice = scanner.nextInt();
      System.out.println("\n");
      if (choice == 1) {
        family.createExpense(currentUser, familyName);
      } else if (choice == 2) {
        family.deleteExpense(currentUser, familyName);
      } else if (choice == 3) {
        family.viewExpense(currentUser, familyName);
      } else if (choice == 4) {
        family.createIncome(currentUser, familyName);
      } else if (choice == 5) {
        family.deleteIncome(currentUser, familyName);
      } else if (choice == 6) {
        family.viewIncome(currentUser, familyName);
      } else if (choice == 7) {
        family.personalMonthlyReport(currentUser, familyName);
      } else if (choice == 8) {
        family.personalYearlyReport(currentUser, familyName);
      } else if (choice == 9) {
        family.viewByCategory(currentUser, familyName);
      } else if (choice == 10) {
        family.memberSpending(currentUser, familyName);
      } else if (choice == 11) {
        family.viewExpByCategory(currentUser, familyName);
      } else if (choice == 12) {
        family.monthlySpending(currentUser, familyName);
      } else if(choice == 13){
        family.yearlySpending(currentUser, familyName);
      } else if(choice == 14){
        family.addNewMember(currentUser, familyName);
      } else if (choice == 15) {
        keepGoing = false;
        System.exit(0);
      } else {
        System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  public void mainProgram() {
    Scanner scanner = new Scanner(System.in);
    boolean keepGoing = true;
    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
    System.out.println("                               Welcome to the budget tracker! \n");
    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
    while(keepGoing){
    System.out.println("                  1- Sign in                                    2- Create account\n");
    System.out.println("Please enter choice: ");
    int choice = scanner.nextInt();
    if (choice == 1) {
      if (auth()) {
        if (userType == "BasicUser") {
          menuBasicUser();
        } else if (userType == "Family") {
          menuFamily();
        }
      }
      keepGoing = false;
    } else if (choice == 2) {
      if (createAcc()) {
        if (userType == "BasicUser") {
          menuBasicUser();
        } else if (userType == "Family") {
          menuFamily();
        }
      }
      keepGoing = false;
    } else {
      System.out.println("Invalid choice. Please try again.");
    }
  }
  }
}
