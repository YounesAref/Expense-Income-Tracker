import java.util.Scanner;

public abstract class User {
  protected String name;
  protected String password;
  protected String userName;

  public String getName() {
    return name;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String printCategories() {
    Scanner scanner = new Scanner(System.in);
    boolean keepGoing = true;
    int choice;
    while (keepGoing) {
      System.out.println("\nPlease select a category: \n");
      System.out.println("1- Food   2- Transportation   3- Entertainment   4- Housing    5- Medical   6- Other \n");
      System.out.println("Please select an option: ");
      choice = scanner.nextInt();
      if (choice == 1) {
        keepGoing = false;
        return "Food";
      } else if (choice == 2) {
        keepGoing = false;
        return "Transportation";
      } else if (choice == 3) {
        keepGoing = false;
        return "Entertainment";
      } else if (choice == 4) {
        keepGoing = false;
        return "Housing";
      } else if (choice == 5) {
        keepGoing = false;
        return "Medical";
      } else if (choice == 6) {
        keepGoing = false;
        return "Other";
      } else {
        System.out.println("Invalid choice. Please try again.");
      }
    }
    return null;
  }

  public String months() {
    Scanner scanner = new Scanner(System.in);
    boolean keepGoing = true;
    while (keepGoing) {
      System.out.println("1. January   2. February   3. March   4. April   5. May   6. June   7. July   8. August   9. September   10. October   11. November   12. December");
      System.out.println("Please select a month: ");
      int month = scanner.nextInt();
      if (month == 1) {
        keepGoing = false;
        return "January";
      } else if (month == 2) {
        keepGoing = false;
        return "February";
      } else if (month == 3) {
        keepGoing = false;
        return "March";
      } else if (month == 4) {
        keepGoing = false;
        return "April";
      } else if (month == 5) {
        keepGoing = false;
        return "May";
      } else if (month == 6) {
        keepGoing = false;
        return "June";
      } else if (month == 7) {
        keepGoing = false;
        return "July";
      } else if (month == 8) {
        keepGoing = false;
        return "August";
      } else if (month == 9) {
        keepGoing = false;
        return "September";
      } else if (month == 10) {
        keepGoing = false;
        return "October";
      } else if (month == 11) {
        keepGoing = false;
        return "November";
      } else if (month == 12) {
        keepGoing = false;
        return "December";
      } else {
        System.out.println("Please enter a valid month");
      }
    }
    return null;
  }

  public String days(String month) {
    Scanner scanner = new Scanner(System.in);
    boolean keepGoing = true;
    while (keepGoing) {
      System.out.println("1st  2nd  3rd  4th  5th  6th  7th  8th  9th  10th  11th  12th  13th  14th  15th  16th 17th  18th  19th  20th  21st  22nd  23th  24th  25th  26th  27th  28th  29th  30th  31st");
      System.out.println("Please select a day: ");
      int choice = scanner.nextInt();
      if (choice == 1) {
        return "1st";
      } else if (choice == 2) {
        return "2nd";
      } else if (choice == 3) {
        return "3rd";
      } else if (choice == 4) {
        return "4th";
      } else if (choice == 5) {
        return "5th";
      } else if (choice == 6) {
        return "6th";
      } else if (choice == 7) {
        return "7th";
      } else if (choice == 8) {
        return "8th";
      } else if (choice == 9) {
        return "9th";
      } else if (choice == 10) {
        return "10th";
      } else if (choice == 11) {
        return "11th";
      } else if (choice == 12) {
        return "12th";
      } else if (choice == 13) {
        return "13th";
      } else if (choice == 14) {
        return "14th";
      } else if (choice == 15) {
        return "15th";
      } else if (choice == 16) {
        return "16th";
      } else if (choice == 17) {
        return "17th";
      } else if (choice == 18) {
        return "18th";
      } else if (choice == 19) {
        return "19th";
      } else if (choice == 20) {
        return "20th";
      } else if (choice == 21) {
        return "21st";
      } else if (choice == 22) {
        return "22nd";
      } else if (choice == 23) {
        return "23rd";
      } else if (choice == 24) {
        return "24th";
      } else if (choice == 25) {
        return "25th";
      } else if (choice == 26) {
        return "26th";
      } else if (choice == 27) {
        return "27th";
      } else if (choice == 28) {
        return "28th";
      } else if (choice == 29) {
        return "29th";
      } else if (choice == 30 && !"Febuary".equals(month)) {
        return "30th";
      } else if (choice == 31 && month.equals("January") || month.equals("March") || month.equals("May")
          || month.equals("July") || month.equals("August") || month.equals("October") || month.equals("December")) {
        return "31st";
      } else {
        System.out.println("Please enter a valid day");
      }
    }
    return null;
  }

  public String years() {
    Scanner scanner = new Scanner(System.in);
    boolean keepGoing = true;
    while (keepGoing) {
      System.out.println("Please selecet a year: \n");
      System.out.println("1. 2024     2. 2025     3. 2026     4. 2027     5. 2028");
      int choice = scanner.nextInt();
      if (choice == 1) {
        return "2024";
      } else if (choice == 2) {
        return "2025";
      } else if (choice == 3) {
        return "2026";
      } else if (choice == 4) {
        return "2027";
      } else if (choice == 5) {
        return "2028";
      } else {
        System.out.println("Invalid choice. Please try again.");
      }
    }
    return null;
  }
}
