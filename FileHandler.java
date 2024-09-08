import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

  static void emptyFile(String fileName) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getFamilyName(String currentUser){
    ArrayList<Family> list = readFamily();
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUserName().equals(currentUser)){
        return list.get(i).getFamily();
      }
    }
    return null;
  }

  public boolean authBasicUser(String userName, String password) {
    ArrayList<BasicUser> users = readBasicUsers();
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUserName().equals(userName) && users.get(i).getPassword().equals(password)) {
        return true;
      }
    }
    return false;
  }

  public boolean authFamily(String userName, String password) {
    ArrayList<Family> users = readFamily();
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUserName().equals(userName) && users.get(i).getPassword().equals(password)) {
        return true;
      }
    }
    return false;
  }

  public ArrayList<BasicUser> readBasicUsers() {
    ArrayList<BasicUser> list = new ArrayList<BasicUser>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("users.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String userNameF = data[0];
        String passwordF = data[1];
        String nameF = data[2];
        BasicUser basicUser = new BasicUser(userNameF, passwordF, nameF);
        list.add(basicUser);
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public ArrayList<Family> readFamily() {
    ArrayList<Family> list = new ArrayList<Family>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("family.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String userNameF = data[0];
        String passwordF = data[1];
        String nameF = data[2];
        String familyNameF = data[3];
        Family family = new Family(userNameF, passwordF, nameF, familyNameF);
        list.add(family);
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public boolean isUserNameUnqBU(String userName) {
    ArrayList<BasicUser> basicUserList = readBasicUsers();
    for (int i = 0; i < basicUserList.size(); i++) {
      if (basicUserList.get(i).getUserName().equals(userName)) {
        return false;
      }
    }
    return true;
  }

  public boolean isUserNameUnqFam(String userName) {
    ArrayList<Family> familyList = readFamily();
    for (int i = 0; i < familyList.size(); i++) {
      if (familyList.get(i).getUserName().equals(userName)) {
        return false;
      }
    }
    return true;
  }

public boolean isFamilyNameUnq(String familyName){
  ArrayList<Family> familyList = readFamily();
  for(int i = 0; i < familyList.size(); i++){
    if(familyList.get(i).getFamily().equals(familyName)){
      return false;
    }
  }
  return true;
}

  public boolean isUserUnq(String userName) {
    if (isUserNameUnqFam(userName) && isUserNameUnqBU(userName)) {
      return true;
    }
    return false;
  }

  public void createBasicUser(String userName, String password, String name) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("users.csv", true));
      writer.write(userName + "," + password + "," + name + "\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void createFamily(String userName, String password, String name, String familyName) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("family.csv", true));
      writer.write(userName + "," + password + "," + name + "," + familyName + "\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Expense> readExp() {
    ArrayList<Expense> list = new ArrayList<Expense>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("expenses.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String user = data[0];
        String name = data[1];
        Double amount = Double.valueOf(data[2]);
        String day = data[3];
        String month = data[4];
        String year = data[5];
        String category = data[6];
        String description = data[7];
        Expense expense = new Expense(user, name, amount, day, month, year, category, description);
        list.add(expense);
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public ArrayList<Income> readInc() {
    ArrayList<Income> list = new ArrayList<Income>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("income.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String user = data[0];
        String name = data[1];
        Double amount = Double.valueOf(data[2]);
        String day = data[3];
        String month = data[4];
        String year = data[5];
        String description = data[6];
        Income income = new Income(user, name, amount, day, month, year, description);
        list.add(income);
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public ArrayList<Income> readIncByMonth(String currentUser, String month, String year){
    ArrayList<Income> list = new ArrayList<Income>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("income.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String user = data[0];
        String name = data[1];
        Double amount = Double.valueOf(data[2]);
        String day = data[3];
        String monthTemp = data[4];
        String yearTemp = data[5];
        String description = data[6];
        Income income = new Income(user, name, amount, day, monthTemp, yearTemp, description);
        if(income.getMonth().equals(month) && income.getYear().equals(year) && income.getUser().equals(currentUser)){
        list.add(income);
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public ArrayList<Income> readIncByYear(String currentUser, String year){
    ArrayList<Income> list = new ArrayList<Income>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("income.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String user = data[0];
        String name = data[1];
        Double amount = Double.valueOf(data[2]);
        String day = data[3];
        String monthTemp = data[4];
        String yearTemp = data[5];
        String description = data[6];
        Income income = new Income(user, name, amount, day, monthTemp, yearTemp, description);
        if(income.getYear().equals(year) && income.getUser().equals(currentUser)){
        list.add(income);
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public ArrayList<Expense> readExpByMonth(String currentUser, String month, String year){
    ArrayList<Expense> list = new ArrayList<Expense>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("expenses.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String user = data[0];
        String name = data[1];
        Double amount = Double.valueOf(data[2]);
        String day = data[3];
        String  monthTemp = data[4];
        String yearTemp = data[5];
        String category = data[6];
        String description = data[7];
        Expense expense = new Expense(user, name, amount, day, monthTemp, yearTemp, category, description);
        if(expense.getMonth().equals(month) && expense.getYear().equals(year) && expense.getUser().equals(currentUser)){
        list.add(expense);
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public ArrayList<Expense> readExpByYear(String currentUser, String year){
    ArrayList<Expense> list = new ArrayList<Expense>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("expenses.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String user = data[0];
        String name = data[1];
        Double amount = Double.valueOf(data[2]);
        String day = data[3];
        String  monthTemp = data[4];
        String yearTemp = data[5];
        String category = data[6];
        String description = data[7];
        Expense expense = new Expense(user, name, amount, day, monthTemp, yearTemp, category, description);
        if(expense.getYear().equals(year) && expense.getUser().equals(currentUser)){
        list.add(expense);
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public ArrayList<Expense> readExpByCategory(String currentUser, String category){
    ArrayList<Expense> list = new ArrayList<Expense>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("expenses.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String user = data[0];
        String name = data[1];
        Double amount = Double.valueOf(data[2]);
        String day = data[3];
        String  monthTemp = data[4];
        String yearTemp = data[5];
        String categoryTemp = data[6];
        String description = data[7];
        Expense expense = new Expense(user, name, amount, day, monthTemp, yearTemp, categoryTemp, description);
        if(expense.getUser().equals(currentUser) && expense.getCategory().equals(category)){
        list.add(expense);
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public void createExp(String currentUser, String name, Double amount, String day, String month, String year, String category, String description) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("expenses.csv", true));
      writer.write(currentUser + "," + name + "," + amount + "," + day + "," + month + "," + year + "," + category + "," + description + "\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void deleteExp(String currentUser, String name, String day, String month, String year) {
    ArrayList<Expense> expenses = readExp();
    for (int i = 0; i < expenses.size(); i++) {
      if (expenses.get(i).getName().equals(name) && (expenses.get(i).getDay().equals(day))
          && expenses.get(i).getMonth().equals(month) && expenses.get(i).getYear().equals(year)) {
        expenses.remove(i);
      }
    }
    try {
      emptyFile("expenses.csv");
      BufferedWriter writer = new BufferedWriter(new FileWriter("expenses.csv", true));
      for (int i = 0; i < expenses.size(); i++) {
        writer.write(expenses.get(i).getUser() + "," + expenses.get(i).getName() + "," + expenses.get(i).getAmount() + "," + expenses.get(i).getDay() + "," + expenses.get(i).getMonth() + "," + expenses.get(i).getYear() + "," + expenses.get(i).getCategory() + "," + expenses.get(i).getDescription() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void viewExp(String currentUser) {
    ArrayList<Expense> expenses = readExp();
    int counter = 1;
    System.out.println("\tExpense Name, Amount, Day, Month, Year, Category, Description" + "\n");
    for (int i = 0; i < expenses.size(); i++) {
      if (expenses.get(i).getUser().equals(currentUser)) {
        System.out.println(counter + ") " +expenses.get(i).getName() + "  " + expenses.get(i).getAmount() + " " + expenses.get(i).getDay() + "  " + expenses.get(i).getMonth() + "  " + expenses.get(i).getYear() + "  " + expenses.get(i).getCategory() + "  " + expenses.get(i).getDescription() + "\n");
        counter++;
      }
    }
    Double total = expenseSum(currentUser);
    System.out.println("\nTotal Expenses: $" + total);
  }

  public void createInc(String currentUser, String name, Double amount, String day, String month, String year, String description) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("income.csv", true));
      writer.write(currentUser + "," + name + "," + amount + "," + day + "," + month + "," + year + "," + description + "\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void deleteInc(String currentUser, String name, String day, String month, String year) {
    ArrayList<Income> incomes = readInc();
    for (int i = 0; i < incomes.size(); i++) {
      if (incomes.get(i).getUser().equals(currentUser) && incomes.get(i).getName().equals(name) && incomes.get(i).getDay().equals(day) && incomes.get(i).getMonth().equals(month) && incomes.get(i).getYear().equals(year)) {
        incomes.remove(i);
      }
    }
    try {
      emptyFile("income.csv");
       BufferedWriter writer = new BufferedWriter(new FileWriter("income.csv", true));
      for (int i = 0; i < incomes.size(); i++) {
        writer.write(incomes.get(i).getUser() + "," + incomes.get(i).getName() + "," + incomes.get(i).getAmount() + "," + incomes.get(i).getDay() + "," + incomes.get(i).getMonth() + "," + incomes.get(i).getYear() + "," + incomes.get(i).getDescription() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void viewInc(String currentUser) {
    ArrayList<Income> income = readInc();
    int counter = 1;
    System.out.println("\tExpense Name, Amount, Day, Month, Year, Description" + "\n");
    for (int i = 0; i < income.size(); i++) {
      if (income.get(i).getUser().equals(currentUser)) {
        System.out.println(counter + ") " + income.get(i).getName() + "  " + income.get(i).getAmount() + "  " + income.get(i).getDay() + "  " + income.get(i).getMonth() + "  " + income.get(i).getYear() + "  " + income.get(i).getDescription() + "\n");
        counter++;
      }
    }
    Double total = incomeSum(currentUser);
    System.out.println("Total Income: $" + total);
  }

  public Double incomeSum(String currentUser){
    ArrayList<Income> income = readInc();
    Double sum = 0.0;
    for(int i = 0; i < income.size(); i++){
      if(income.get(i).getUser().equals(currentUser)){
        sum += income.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double expenseSum(String currentUser){
    ArrayList<Expense> expense = readExp();
    Double sum = 0.0;
    for(int i = 0; i < expense.size(); i++){
      if(expense.get(i).getUser().equals(currentUser)){
        sum += expense.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double monthlyIncomeSum(String currentUser, String month, String year){
    ArrayList<Income> income = readInc();
    Double sum = 0.0;
    for(int i = 0; i < income.size(); i++){
      if(income.get(i).getUser().equals(currentUser) && income.get(i).getMonth().equals(month) && income.get(i).getYear().equals(year)){
        sum += income.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double monthlyExpenseSum(String currentUser, String month, String year){
    ArrayList<Expense> expense = readExp();
    Double sum = 0.0;
    for(int i = 0; i < expense.size(); i++){
      if(expense.get(i).getUser().equals(currentUser) && expense.get(i).getMonth().equals(month) && expense.get(i).getYear().equals(year)){
        sum += expense.get(i).getAmount();
      }
    }
    return sum;
  }

  public void viewIncByMonth(String currentUser, String month, String year){
    ArrayList<Income> income = readIncByMonth(currentUser, month, year);
    int counter = 1;
    System.out.println("\tExpense Name, Amount, Day, Month, Year, Description" + "\n");
    for (int i = 0; i < income.size(); i++){
      System.out.println(counter + ") " + income.get(i).getName() + "  " + income.get(i).getAmount() + "  " + income.get(i).getDay() + "  " + income.get(i).getMonth() + "  " + income.get(i).getYear() + "  " + income.get(i).getDescription() + "\n");
      counter++;
    }
  }

  public void viewIncByYear(String currentUser, String year){
    ArrayList<Expense> expense = readExpByYear(currentUser, year);
    int counter = 1;
    System.out.println("\tExpense Name, Amount, Day, Month, Year, Category, Description" + "\n");
    for (int i = 0; i < expense.size(); i++){
      System.out.println( counter + ") " + expense.get(i).getName() + "  " + expense.get(i).getAmount() + "  " + expense.get(i).getDay() + "  " + expense.get(i).getMonth() + "  " + expense.get(i).getYear() + "  " + expense.get(i).getCategory() + "  " + expense.get(i).getDescription() + "\n");
      counter++;
    }
  }

  public void viewExpByMonth(String currentUser, String month, String year){
    ArrayList<Expense> expense = readExpByMonth(currentUser, month, year);
    int counter = 1;
    System.out.println("\tExpense Name, Amount, Day, Month, Year, Category, Description" + "\n");
    for (int i = 0; i < expense.size(); i++){
      System.out.println(counter + ") " + expense.get(i).getName() + "  " + expense.get(i).getAmount() + "  " + expense.get(i).getDay() + "  " + expense.get(i).getMonth() + "  " + expense.get(i).getYear() + "  " + expense.get(i).getCategory() + "  " + expense.get(i).getDescription() + "\n");
      counter++;
    }
  }

  public void viewExpByYear(String currentUser, String year){
    ArrayList<Expense> expense = readExpByYear(currentUser, year);
    int counter = 1;
    System.out.println("\tExpense Name, Amount, Day, Month, Year, Category, Description" + "\n");
    for (int i = 0; i < expense.size(); i++){
      System.out.println(counter + ") " + expense.get(i).getName() + "  " + expense.get(i).getAmount() + "  " + expense.get(i).getDay() + "  " + expense.get(i).getMonth() + "  " + expense.get(i).getYear() + "  " + expense.get(i).getCategory() + "  " + expense.get(i).getDescription() + "\n");
      counter++;
    }
  }

  public Double monthlyExpByCategory(String currentUser, String month, String year, String category){
    Double sum = 0.0;
    ArrayList<Expense> expense = readExpByMonth(currentUser, month, year);
    for(int i = 0; i < expense.size(); i++){
      if(expense.get(i).getUser().equals(currentUser) && expense.get(i).getCategory().equals(category)){
        sum += expense.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double expSumByCategory(String currentUser, String category){
    ArrayList<Expense> expense = readExpByCategory(currentUser, category);
    Double sum = 0.0;
    for(int i = 0; i < expense.size(); i++){
      if(expense.get(i).getUser().equals(currentUser) && expense.get(i).getCategory().equals(category)){
        sum += expense.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double yearlyExpSum(String currentUser, String year){
    ArrayList<Expense> expense = readExp();
    Double sum = 0.0;
    for(int i = 0; i < expense.size(); i++){
      if(expense.get(i).getUser().equals(currentUser) && expense.get(i).getYear().equals(year)){
        sum += expense.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double yearlyIncSum(String currentUser, String year){
    ArrayList<Income> income = readInc();
    Double sum = 0.0;
    for(int i = 0; i < income.size(); i++){
      if(income.get(i).getUser().equals(currentUser) && income.get(i).getYear().equals(year)){
        sum += income.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double yearlyExpSumByCategory(String currentUser, String year, String category){
    Double sum = 0.0;
    ArrayList<Expense> expense = readExp();
    for(int i = 0; i < expense.size(); i++){
      if(expense.get(i).getUser().equals(currentUser) && expense.get(i).getCategory().equals(category) && expense.get(i).getYear().equals(year)){
        sum += expense.get(i).getAmount();
      }
    }
    return sum;
  }

  public void viewExpByCategory(String currentUser, String category){
    ArrayList<Expense> expense = readExpByCategory(currentUser, category);
    int counter = 1;
    System.out.println("\tExpense Name, Amount, Day, Month, Year, Category, Description" + "\n");
    for (int i = 0; i < expense.size(); i++){
      System.out.println(counter + ") " + expense.get(i).getName() + "  " + expense.get(i).getAmount() + "  " + expense.get(i).getDay() + "  " + expense.get(i).getMonth() + "  " + expense.get(i).getYear() + "  " + expense.get(i).getCategory() + "  " + expense.get(i).getDescription() + "\n");
      counter++;
    }
    Double sum = expSumByCategory(currentUser, category);
    System.out.println("Total Expenses: $" + sum);
  }

  public void viewExpByCatMonthly(String currentUser, String month, String year, String category){
    ArrayList<Expense> expense = readExpByCategory(currentUser, category);
    int counter = 1;
    System.out.println("\tExpense Name, Amount, Day, Month, Year, Category, Description" + "\n");
    for(int i = 0; i < expense.size(); i++){
      if(expense.get(i).getUser().equals(currentUser) && expense.get(i).getCategory().equals(category) && expense.get(i).getMonth().equals(month) && expense.get(i).getYear().equals(year)){
        System.out.println(counter + ") " + expense.get(i).getName() + "  " + expense.get(i).getAmount() + "  " + expense.get(i).getDay() + "  " + expense.get(i).getMonth() + "  " + expense.get(i).getYear() + "  " + expense.get(i).getCategory() + "  " + expense.get(i).getDescription() + "\n");
        counter++;
      }
    }
    Double sum = monthlyExpByCategory(currentUser, month, year, category);
    System.out.println("\n Total = $" + sum);
  }

  public void viewExpByCatYearly(String currentUser, String year, String category){
    ArrayList<Expense> expense = readExpByCategory(currentUser, category);
    int counter = 1;
    System.out.println("\tExpense Name, Amount, Day, Month, Year, Category, Description" + "\n");
    for(int i = 0; i < expense.size(); i++){
      if(expense.get(i).getUser().equals(currentUser) && expense.get(i).getCategory().equals(category) && expense.get(i).getYear().equals(year)){
        System.out.println(counter + ") " + expense.get(i).getName() + "  " + expense.get(i).getAmount() + "  " + expense.get(i).getDay() + "  " + expense.get(i).getMonth() + "  " + expense.get(i).getYear() + "  " + expense.get(i).getCategory() + "  " + expense.get(i).getDescription() + "\n");
        counter++;
      }
    }
    Double sum = yearlyExpSumByCategory(currentUser, year, category);
    System.out.println("\n Total = $" + sum);
  }
  
  public void monthlyReport(String currentUser, String month, String year){
    Double incSum = monthlyIncomeSum(currentUser, month, year);
    Double expSum = monthlyExpenseSum(currentUser, month, year);
    Double sum = incSum - expSum;
    Double foodSum = monthlyExpByCategory(currentUser, month, year, "Food");
    Double entertainmentSum = monthlyExpByCategory(currentUser, month, year, "Entertainment");
    Double transportationSum = monthlyExpByCategory(currentUser, month, year, "Transportation");
    Double housingSum = monthlyExpByCategory(currentUser, month, year, "Housing");
    Double medicalSum = monthlyExpByCategory(currentUser, month, year, "Medical");
    Double otherSum = monthlyExpByCategory(currentUser, month, year, "Other");
    viewIncByMonth(currentUser, month, year);
    System.out.println("\nIncome total = " + incSum + "\n" + "\n");
    viewExpByMonth(currentUser, month, year);
    System.out.println("\nExpense total = " + expSum + "\n" + "\n");
    System.out.println("Spending by category for" + month + " " + year + ": \n");
    System.out.println("Food = $" + foodSum + "\n" + "Entertainment = $" + entertainmentSum + "\n" + "Transportation = $" + transportationSum + "\n" + "Housing = $" + housingSum + "\n" + "Medical = $" + medicalSum + "\n" + "Other = $" + otherSum + "\n" + "\n");
    System.out.println("Total for " + month + year + " = $" + sum);
  }

  public void yearlyReport(String currentUser, String year){
    Double incSum = yearlyIncSum(currentUser, year);
    Double expSum = yearlyExpSum(currentUser, year);
    Double sum = incSum - expSum;
    Double foodSum = yearlyExpSumByCategory(currentUser, year, "Food");
    Double entertainmentSum = yearlyExpSumByCategory(currentUser, year, "Entertainment");
    Double transportationSum = yearlyExpSumByCategory(currentUser, year, "Transportation");
    Double medicalSum = yearlyExpSumByCategory(currentUser, year, "Medical");
    Double otherSum = yearlyExpSumByCategory(currentUser, year, "Other");
    viewIncByYear(currentUser, year);
    System.out.println("\nIncome total = $" + incSum + "\n" + "\n");
    viewExpByYear(currentUser, year);
    System.out.println("\nExpense total = $" + expSum + "\n" + "\n");
    System.out.println("Spending by category for " + year + ": \n");
    System.out.println("Food = $" + foodSum + "\n" + "Entertainment = $" + entertainmentSum + "\n" + "Transportation = $" + transportationSum + "\n" + "Medical = $" + medicalSum + "\n" + "Other = $" + otherSum + "\n" + "\n");
    System.out.println("Total for " + year + " = $" + sum);
  }

  public ArrayList<Expense> readFamExp(String currentUser, String familyName) {
    ArrayList<Expense> list = new ArrayList<Expense>();
    try{
      BufferedReader reader = new BufferedReader(new FileReader("familyExpense.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String user = data[0];
        String name = data[1];
        Double amount = Double.valueOf(data[2]);
        String day = data[3];
        String month = data[4];
        String year = data[5];
        String category = data[6];
        String description = data[7];
        String familyNameTemp = data[8];
        Expense expense = new Expense(user, name, amount, day, month, year, category, description, familyNameTemp);
        if(familyNameTemp.equals(familyName)){
        list.add(expense);
        }
      }
      reader.close();
    } catch(IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public ArrayList<Income> readFamInc(String currentUser, String familyName){
    ArrayList<Income> list = new ArrayList<Income>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("familyIncome.csv"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String user = data[0];
        String name = data[1];
        Double amount = Double.valueOf(data[2]);
        String day = data[3];
        String month = data[4];
        String year = data[5];
        String description = data[6];
        String familyNameTemp = data[7];
        Income income = new Income(user, name, amount, day, month, year, description, familyNameTemp);
        if(income.getFamilyName().equals(familyName)){
        list.add(income);
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public void addExpFamily(String currentUser, String familyName, String name, Double amount, String day, String month, String year, String category, String description){
    try {
      FileWriter writer = new FileWriter("familyExpense.csv", true);
      writer.write(currentUser + "," + name + "," + amount + "," + day + "," + month + "," + year + "," + category + "," + description + "," + familyName + "\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void addIncFamily(String currentUser, String familyName, String name, Double amount, String day, String month, String year, String description){
    try {
      FileWriter writer = new FileWriter("familyIncome.csv", true);
      writer.write(currentUser + "," + name + "," + amount + "," + day + "," + month + "," + year + "," + description + "," + familyName + "\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void removeExpFamily(String currentUser, String familyName, String name, String day, String month, String year){
     ArrayList<Expense> expenses = readFamExp(currentUser, familyName);
      for (int i = 0; i < expenses.size(); i++) {
        if (expenses.get(i).getName().equals(name) && (expenses.get(i).getDay().equals(day)) && expenses.get(i).getMonth().equals(month) && expenses.get(i).getYear().equals(year)) {
          expenses.remove(i);
        }
      }
      try {
        emptyFile("familyExpense.csv");
        BufferedWriter writer = new BufferedWriter(new FileWriter("familyExpense.csv", true));
        for (int i = 0; i < expenses.size(); i++) {
          writer.write(expenses.get(i).getUser() + "," + expenses.get(i).getName() + "," + expenses.get(i).getAmount() + "," + expenses.get(i).getDay() + "," + expenses.get(i).getMonth() + "," + expenses.get(i).getYear() + "," + expenses.get(i).getCategory() + "," + expenses.get(i).getDescription() + "," + expenses.get(i).getFamilyName() + "\n");
        }
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
  }

  public void removeIncFamily(String currentUser, String familyName, String name, String day, String month, String year){
    ArrayList<Income> incomes = readFamInc(currentUser, familyName);
    for (int i = 0; i < incomes.size(); i++) {
      if (incomes.get(i).getUser().equals(currentUser) && incomes.get(i).getName().equals(name) && incomes.get(i).getDay().equals(day) && incomes.get(i).getMonth().equals(month) && incomes.get(i).getYear().equals(year)) {
        incomes.remove(i);
      }
    }
    try {
      emptyFile("familyIncome.csv");
       BufferedWriter writer = new BufferedWriter(new FileWriter("familyIncome.csv", true));
      for (int i = 0; i < incomes.size(); i++) {
        writer.write(incomes.get(i).getUser() + "," + incomes.get(i).getName() + "," + incomes.get(i).getAmount() + "," + incomes.get(i).getDay() + "," + incomes.get(i).getMonth() + "," + incomes.get(i).getYear() + "," + incomes.get(i).getDescription() + "," + incomes.get(i).getFamilyName() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void viewFamExp(String currentUser, String familyName){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    int counter = 1;
    System.out.println("\tExpense Name, Amount, Day, Month, Year, Category, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      System.out.println(counter + ") " + list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getCategory() + "  " + list.get(i).getDescription() + "\n");
      counter++;
    }
    Double sum = familyExpenseSum(currentUser, familyName);
    System.out.println("\n Total = $" + sum);
  }

  public void viewFamInc(String currentUser, String familyName){
    ArrayList<Income> list = readFamInc(currentUser, familyName);
    int counter = 1;
    System.out.println("Member, Income Name, Amount, Day, Month, Year, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      System.out.println(counter + ") " + list.get(i).getUser() + "  " + list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getDescription() + "\n");
      counter++;
    }
    Double sum = familyIncomeSum(currentUser, familyName);
    System.out.println("\n Total = $" + sum);
  }

  public Double familyExpenseSum(String currentUser, String familyName){
    Double sum = 0.0;
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    for(int i = 0; i < list.size(); i++){
      sum += list.get(i).getAmount();
    }
    return sum;
  }

  public Double familyIncomeSum(String currentUser, String familyName){
    Double sum = 0.0;
    ArrayList<Income> list = readFamInc(currentUser, familyName);
    for(int i = 0; i < list.size(); i++){
      sum += list.get(i).getAmount();
    }
    return sum;
  }

  public Double personalExpenseSum(String currentUser, String familyName){
    Double sum = 0.0;
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double personalIncomeSum(String currentUser, String familyName){
    Double sum = 0.0;
    ArrayList<Income> list = readFamInc(currentUser, familyName);
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public void viewPersonalExp(String currentUser, String familyName){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    int counter = 1;
    System.out.println("\tExpense Name, Amount, Day, Month, Year, Category, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser)){
      System.out.println(counter + ") " + list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getCategory() + "  " + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
    Double sum = personalExpenseSum(currentUser, familyName);
    System.out.println("\n Total = $" + sum);
  }

 public void viewPersonalInc(String currentUser, String familyName){
    ArrayList<Income> list = readFamInc(currentUser, familyName);
   int counter = 1;
    System.out.println("\tIncome Name, Amount, Day, Month, Year, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser)){
      System.out.println(counter + ") " + list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
    Double sum = personalIncomeSum(currentUser, familyName);
    System.out.println("\n Total = $" + sum);
  }

  public void viewFamExpbyCat(String currentUser, String familyName, String category){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    int counter = 1;
    System.out.println("\tExpense Name, Amount, Day, Month, Year, Category, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getCategory().equals(category)){
      System.out.println(counter + ") " + list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getCategory() + "  " + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
    Double sum = familyExpenseSumbyCat(currentUser, familyName, category);
    System.out.println("\n Total = $" + sum);
  }

  public void viewPersonalExpByCat(String currentUser, String familyName, String category){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    int counter = 1;
    System.out.println("\tExpense Name, Amount, Day, Month, Year, Category, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser) && list.get(i).getCategory().equals(category)){
      System.out.println(counter + ") " + list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getCategory() + "  " + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
    Double sum = personalExpenseSum(currentUser, familyName);
    System.out.println("\n Total = $" + sum);
  }

  public void viewMonthlyPersonalExpByCat(String currentUser, String familyName, String month, String year, String category){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
     int counter = 1;
    System.out.println("\tExpense Name, Amount, Day, Month, Year, Category, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser) && list.get(i).getCategory().equals(category) && list.get(i).getMonth().equals(month) && list.get(i).getYear().equals(year)){
      System.out.println(counter + ") " + list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getCategory() + "  " + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
  }

  public void viewYearlyPersonalExpByCat(String currentUser, String familyName, String year, String category){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    int counter = 1;
    System.out.println("\tExpense Name, Amount, Day, Month, Year, Category, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser) && list.get(i).getCategory().equals(category) && list.get(i).getYear().equals(year)){
      System.out.println(counter + ") " + list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getCategory() + "  " + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
  }

  public Double familyExpenseSumbyCat(String currentUser, String familyName, String category){
    Double sum = 0.0;
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getCategory().equals(category)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double personalExpenseSumbyCat(String currentUser, String familyName, String category){
    Double sum = 0.0;
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser) && list.get(i).getCategory().equals(category)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public void viewMonthlyPersonalExp(String currentUser, String familyName, String month, String year){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    int counter = 1;
    System.out.println("Expense Name, Amount, Day, Month, Year, Category, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser) && list.get(i).getMonth().equals(month) && list.get(i).getYear().equals(year)){
      System.out.println(counter + ") " + list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
  }

  public void viewMonthlyPersonalInc(String currentUser, String familyName, String month, String year){
    ArrayList<Income> list = readFamInc(currentUser, familyName);
    int counter = 1;
    System.out.println("Income Name, Amount, Day, Month, Year, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser) && list.get(i).getMonth().equals(month) && list.get(i).getYear().equals(year)){
      System.out.println(counter + ") " + list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getCategory() + "  " + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
  }

  public void viewYearlyPersonalExp(String currentUser, String familyName, String year){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    int counter = 1;
    System.out.println("Expense Name, Amount, Day, Month, Year, Category, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser) && list.get(i).getYear().equals(year)){
      System.out.println(counter + ") " + list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getCategory() + "  " + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
  }
  
  public void viewYearlyPersonalInc(String currentUser, String familyName, String year){
    ArrayList<Income> list = readFamInc(currentUser, familyName);
    int counter = 1;
    System.out.println("Income Name, Amount, Day, Month, Year, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser) && list.get(i).getYear().equals(year)){
      System.out.println(counter + ") " + list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
  }

  public Double monthlyPersonalExpSum(String currentUser, String familyName, String month, String year){
    Double sum = 0.0;
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser) && list.get(i).getMonth().equals(month) && list.get(i).getYear().equals(year)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double monthlyPersonalIncSum(String currentUser, String familyName, String month, String year){
    Double sum = 0.0;
    ArrayList<Income> list = readFamInc(currentUser, familyName);
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser) && list.get(i).getMonth().equals(month) && list.get(i).getYear().equals(year)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double monthlyPersonalExpSumbyCat(String currentUser, String familyName, String month, String year, String category){
    Double sum = 0.0;
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser) && list.get(i).getMonth().equals(month) && list.get(i).getYear().equals(year) && list.get(i).getCategory().equals(category)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double yearlyPersonalExpSum(String currentUser, String familyName, String year){
    Double sum = 0.0;
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser) && list.get(i).getYear().equals(year)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double yearlyPersonalIncSum(String currentUser, String familyName, String year){
    Double sum = 0.0;
    ArrayList<Income> list = readFamInc(currentUser, familyName);
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser) && list.get(i).getYear().equals(year)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double yearlyPersonalExpSumbyCat(String currentUser, String familyName, String year, String category){
    Double sum = 0.0;
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getUser().equals(currentUser) && list.get(i).getYear().equals(year) && list.get(i).getCategory().equals(category)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public void personalMonthlyReport(String currentUser, String familyName, String month, String year){
    Double incSum = monthlyPersonalIncSum(currentUser, familyName, month, year);
    Double expSum = monthlyPersonalExpSum(currentUser, familyName, month, year);
    Double total = incSum - expSum;
    Double foodSum = monthlyPersonalExpSumbyCat(currentUser, familyName, month, year, "Food");
    Double transportationSum = monthlyPersonalExpSumbyCat(currentUser, familyName, month, year, "Transportation");
    Double entertainmentSum = monthlyPersonalExpSumbyCat(currentUser, familyName, month, year, "Entertainment");
    Double medicalSum = monthlyPersonalExpSumbyCat(currentUser, familyName, month, year, "Medical");
    Double housingSum = monthlyPersonalExpSumbyCat(currentUser, familyName, month, year, "Housing");
    Double otherSum = monthlyPersonalExpSumbyCat(currentUser, familyName, month, year, "Other");
    viewMonthlyPersonalExp(currentUser, familyName, month, year);
    System.out.println("\n \nTotal = $" + expSum + "\n \n");
    viewMonthlyPersonalInc(currentUser, familyName, month, year);
    System.out.println("\n \nTotal = $" + incSum + "\n \n");
    System.out.println("Food = $" + foodSum + "\n");
    System.out.println("Transportation = $" + transportationSum + "\n");
    System.out.println("Entertainment = $" + entertainmentSum + "\n");
    System.out.println("Medical = $" + medicalSum + "\n");
    System.out.println("Housing = $" + housingSum + "\n");
    System.out.println("Other = $" + otherSum + "\n");
    System.out.println("Total for " + month + " " + year + " = $" + total + "\n");
  }

  public void personalYearlyReport(String currentUser, String familyName, String year){
    Double incSum = yearlyPersonalIncSum(currentUser, familyName, year);
    Double expSum = yearlyPersonalExpSum(currentUser, familyName, year);
    Double total = incSum - expSum;
    Double foodSum = yearlyPersonalExpSumbyCat(currentUser, familyName, year, "Food");
    Double transportationSum = yearlyPersonalExpSumbyCat(currentUser, familyName, year, "Transportation");
    Double entertainmentSum = yearlyPersonalExpSumbyCat(currentUser, familyName, year, "Entertainment");
    Double medicalSum = yearlyPersonalExpSumbyCat(currentUser, familyName, year, "Medical");
    Double housingSum = yearlyPersonalExpSumbyCat(currentUser, familyName, year, "Housing");
    Double otherSum = yearlyPersonalExpSumbyCat(currentUser, familyName, year, "Other");
    viewYearlyPersonalExp(currentUser, familyName, year);
    System.out.println("\n \nTotal = $" + expSum + "\n \n");
    viewYearlyPersonalInc(currentUser, familyName, year);
    System.out.println("\n \nTotal = $" + incSum + "\n \n");
    System.out.println("Food = $" + foodSum + "\n");
    System.out.println("Transportation = $" + transportationSum + "\n");
    System.out.println("Entertainment = $" + entertainmentSum + "\n");
    System.out.println("Medical = $" + medicalSum + "\n");
    System.out.println("Housing = $" + housingSum + "\n");
    System.out.println("Other = $" + otherSum + "\n");
    System.out.println("Total for " + year + " = $" + total + "\n");
  }

  public void personalMonthlyReportByCat(String currentUser, String familyName, String month, String year, String category){
    Double sum = monthlyPersonalExpSumbyCat(currentUser, familyName, month, year, category);
    viewMonthlyPersonalExpByCat(currentUser, familyName, month, year, category);
    System.out.println("\n \nTotal = $" + sum + "\n \n");
  }

  public void personalYearlyReportByCat(String currentUser, String familyName, String year, String category){
    Double sum = yearlyPersonalExpSumbyCat(currentUser, familyName, year, category);
    viewYearlyPersonalExpByCat(currentUser, familyName, year, category);
    System.out.println("\n \nTotal = $" + sum + "\n \n");
  }

  public ArrayList<Family> getFamilyMembers(String familyName){
    ArrayList<Family> list = readFamily();
    ArrayList<Family> familyList = new ArrayList<Family>();
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamily().equals(familyName)){
        familyList.add(list.get(i));
      }
    }
    return familyList;
  }

  public Double getMemberSpending(String familyName, String memberName){
    ArrayList<Expense> expList = readFamExp(memberName, familyName);
    Double sum = 0.0;
    for(int j = 0; j < expList.size(); j++){
      if(expList.get(j).getUser().equals(memberName)){
        sum += expList.get(j).getAmount();
          }
    }
    return sum;
  }

  public void memberSpending(String currentUser, String familyName){
    ArrayList<Family> list = readFamily();
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamily().equals(familyName)){
        System.out.println(list.get(i).getName() + " = $" + getMemberSpending(familyName, list.get(i).getUserName()));
      }
    }
    System.out.println("Total = $" + familyExpenseSum(currentUser, familyName));
      }

  public Double getMemberSpendingByMonth(String familyName, String memberName, String month, String year){
    ArrayList<Expense> expList = readFamExp(memberName, familyName);
    Double sum = 0.0;
    for(int j = 0; j < expList.size(); j++){
      if(expList.get(j).getUser().equals(memberName) && expList.get(j).getMonth().equals(month) && expList.get(j).getYear().equals(year)){
        sum += expList.get(j).getAmount();
          }
    }
    return sum;
  }

  public void memberSpendingByMonth(String currentUser, String familyName, String month, String year){
    ArrayList<Family> list = readFamily();
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamily().equals(familyName)){
        System.out.println(list.get(i).getName() + " = $" + getMemberSpendingByMonth(familyName, list.get(i).getUserName(), month , year));
      }
    }
    System.out.println("Total = $" + monthlyFamilyExpenseSum(currentUser, familyName, month, year));
  }

  public Double getMemberSpendingByYear(String familyName, String memberName, String year){
    ArrayList<Expense> expList = readFamExp(memberName, familyName);
    Double sum = 0.0;
    for(int j = 0; j < expList.size(); j++){
      if(expList.get(j).getUser().equals(memberName) && expList.get(j).getYear().equals(year)){
        sum += expList.get(j).getAmount();
          }
    }
    return sum;
  }

  public void memberSpendingByYear(String currentUser, String familyName, String year){
    ArrayList<Family> list = readFamily();
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamily().equals(familyName)){
        System.out.println(list.get(i).getName() + " = $" + getMemberSpendingByYear(familyName, list.get(i).getUserName() , year));
      }
    }
    System.out.println("Total = $" + familyYearlyExpSum(currentUser, familyName, year));
  }

  public void monthlyFamilyExp(String currentUser, String familyName, String month, String year){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    int counter = 1;
    System.out.println("Expense Name, Amount, Day, Month, Year, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamilyName().equals(familyName) && list.get(i).getMonth().equals(month) && list.get(i).getYear().equals(year)){
      System.out.println(counter + ") " + list.get(i).getUser() + "  "+ list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
  }

  public void monthlyFamilyInc(String currentUser, String familyName, String month, String year){
    ArrayList<Income> list = readFamInc(currentUser, familyName);
    int counter = 1;
    System.out.println("\tIncome Name, Amount, Day, Month, Year, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamilyName().equals(familyName) && list.get(i).getMonth().equals(month) && list.get(i).getYear().equals(year)){
      System.out.println(counter + ") " + list.get(i).getUser() + "  "+ list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
  }

  public Double monthlyFamilyExpenseSum(String currentUser, String familyName, String month, String year){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    Double sum = 0.0;
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamilyName().equals(familyName) && list.get(i).getMonth().equals(month) && list.get(i).getYear().equals(year)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double monthlyFamilyIncomeSum(String currentUser, String familyName, String month, String year){
    ArrayList<Income> list = readFamInc(currentUser, familyName);
    Double sum = 0.0;
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamilyName().equals(familyName) && list.get(i).getMonth().equals(month) && list.get(i).getYear().equals(year)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double monthlyFamilyExpenseSumbyCat(String currentUser, String familyName, String month, String year, String category){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    Double sum = 0.0;
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamilyName().equals(familyName) && list.get(i).getMonth().equals(month) && list.get(i).getYear().equals(year) && list.get(i).getCategory().equals(category)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public void familyMonthlyReport(String currentUser, String familyName, String month, String year){
    Double incSum = monthlyFamilyIncomeSum(currentUser, familyName, month, year);
    Double expSum = monthlyFamilyExpenseSum(currentUser, familyName, month, year);
    Double total = incSum - expSum;
    Double foodSum = monthlyFamilyExpenseSumbyCat(currentUser, familyName, month, year, "Food");
    Double transportationSum = monthlyFamilyExpenseSumbyCat(currentUser, familyName, month, year, "Transportation");
    Double entertainmentSum = monthlyFamilyExpenseSumbyCat(currentUser, familyName, month, year, "Entertainment");
    Double medicalSum = monthlyFamilyExpenseSumbyCat(currentUser, familyName, month, year, "Medical");
    Double housingSum = monthlyFamilyExpenseSumbyCat(currentUser, familyName, month, year, "Housing");
    Double otherSum = monthlyFamilyExpenseSumbyCat(currentUser, familyName, month, year, "Other");
    monthlyFamilyExp(currentUser, familyName, month, year);
    System.out.println("\n \nTotal = $" + expSum + "\n \n");
    monthlyFamilyInc(currentUser, familyName, month, year);
    System.out.println("\n \nTotal = $" + incSum + "\n \n");
    System.out.println("Food = $" + foodSum + "\n");
    System.out.println("Transportation = $" + transportationSum + "\n");
    System.out.println("Entertainment = $" + entertainmentSum + "\n");
    System.out.println("Medical = $" + medicalSum + "\n");
    System.out.println("Housing = $" + housingSum + "\n");
    System.out.println("Other = $" + otherSum + "\n");
    System.out.println("Total for " + month + " " + year + " = $" + total + "\n");
  }

  public void familyYearlyExp(String currentUser, String familyName, String year){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    int counter = 1;
    System.out.println("Expense Name, Amount, Day, Month, Year, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamilyName().equals(familyName) && list.get(i).getYear().equals(year)){
      System.out.println(counter + ") " + list.get(i).getUser() + "  "+ list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
  }

  public void familyYearlyInc(String currentUser, String familyName, String year){
    ArrayList<Income> list = readFamInc(currentUser, familyName);
    int counter = 1;
    System.out.println("Income Name, Amount, Day, Month, Year, Description" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamilyName().equals(familyName) && list.get(i).getYear().equals(year)){
      System.out.println(counter + ") " + list.get(i).getUser() + "  "+ list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
  }
  
  public Double familyYearlyExpSum(String currentUser, String familyName, String year){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    Double sum = 0.0;
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamilyName().equals(familyName) && list.get(i).getYear().equals(year)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double familyYearlyIncSum(String currentUser, String familyName, String year){
    ArrayList<Income> list = readFamInc(currentUser, familyName);
    Double sum = 0.0;
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamilyName().equals(familyName) && list.get(i).getYear().equals(year)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public Double familyYearlyExpSumByCat(String currentUser, String familyName, String year, String category){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    Double sum = 0.0;
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamilyName().equals(familyName) && list.get(i).getYear().equals(year) && list.get(i).getCategory().equals(category)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public void familyYearlyReport(String currentUser, String familyName, String year){
    Double incSum = familyYearlyIncSum(currentUser, familyName, year);
    Double expSum = familyYearlyExpSum(currentUser, familyName, year);
    Double total = incSum - expSum;
    Double foodSum = familyYearlyExpSumByCat(currentUser, familyName, year, "Food");
    Double transportationSum = familyYearlyExpSumByCat(currentUser, familyName, year, "Transportation");
    Double entertainmentSum = familyYearlyExpSumByCat(currentUser, familyName, year, "Entertainment");
    Double medicalSum = familyYearlyExpSumByCat(currentUser, familyName, year, "Medical");
    Double housingSum = familyYearlyExpSumByCat(currentUser, familyName, year, "Housing");
    Double otherSum = familyYearlyExpSumByCat(currentUser, familyName, year, "Other");
    familyYearlyExp(currentUser, familyName, year);
    System.out.println("\n \nTotal = $" + expSum + "\n \n");
    familyYearlyInc(currentUser, familyName, year);
    System.out.println("\n \nTotal = $" + incSum + "\n \n");
    System.out.println("Food = $" + foodSum + "\n");
    System.out.println("Transportation = $" + transportationSum + "\n");
    System.out.println("Entertainment = $" + entertainmentSum + "\n");
    System.out.println("Medical = $" + medicalSum + "\n");
    System.out.println("Housing = $" + housingSum + "\n");
    System.out.println("Other = $" + otherSum + "\n");
    System.out.println("Total for " + year + " = $" + total + "\n");
  }

  public void addNewMember(String currentUser, String familyName, String name, String userName, String password){
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("family.csv", true));
      writer.write(userName + "," + password + "," + name + "," + familyName + "\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Double familyMonthlyExpSumByCat(String currentUser, String familyName, String month, String year, String category){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    Double sum = 0.0;
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamilyName().equals(familyName) && list.get(i).getMonth().equals(month) && list.get(i).getYear().equals(year) && list.get(i).getCategory().equals(category)){
        sum += list.get(i).getAmount();
      }
    }
    return sum;
  }

  public void viewMonthlyFamilyExpByCat(String currentUser, String familyName, String month, String year, String category){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    int counter = 1;
    System.out.println("Member,\tExpense Name, \tAmount, \tDay, \tMonth, \tYear, \tDescription" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamilyName().equals(familyName) && list.get(i).getMonth().equals(month) && list.get(i).getYear().equals(year) && list.get(i).getCategory().equals(category)){
      System.out.println(counter + ") " + list.get(i).getUser() + "\t"+ list.get(i).getName() + "\t" + list.get(i).getAmount() + "\t" + list.get(i).getDay() + "\t" + list.get(i).getMonth() + "\t" + list.get(i).getYear() + "\t" + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
  }

  public void viewYearlyFamilyExpByCat(String currentUser, String familyName, String year, String category){
    ArrayList<Expense> list = readFamExp(currentUser, familyName);
    int counter = 1;
    System.out.println("Member \tExpense Name, \tAmount, \tDay, \tMonth, \tYear, \tDescription" + "\n");
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).getFamilyName().equals(familyName) && list.get(i).getYear().equals(year) && list.get(i).getCategory().equals(category)){
      System.out.println(counter + ") " + list.get(i).getUser() + "  "+ list.get(i).getName() + "  " + list.get(i).getAmount() + "  " + list.get(i).getDay() + "  " + list.get(i).getMonth() + "  " + list.get(i).getYear() + "  " + list.get(i).getDescription() + "\n");
        counter++;
    }
    }
  }

  public void viewFamilyExpByCat(String currentUser, String familyName, String category){
   viewFamExpbyCat(currentUser, familyName, category);  
  }

  public void monthlyFamilyExpByCat(String currentUser, String familyName, String month, String year, String category){
    Double sum = monthlyFamilyExpenseSumbyCat(currentUser, familyName, month, year, category);
    viewMonthlyFamilyExpByCat(currentUser, familyName, month, year, category);
    System.out.println("\nTotal = $" + sum);
  }

  public void yearlyFamilyExpByCat(String currentUser, String familyName, String year, String category){
    Double sum = familyYearlyExpSumByCat(currentUser, familyName, year, category);
    viewYearlyFamilyExpByCat(currentUser, familyName, year, category);
    System.out.println("\nTotal = $" + sum);
  }
}
