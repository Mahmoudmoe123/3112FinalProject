import java.util.Scanner; // import the Scanner class 

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Instance instance = new Instance();

        displayHomeMenu(instance, s);

    }

    public static void displayHomeMenu(Instance i, Scanner s) {

        int select = 0;
        boolean y = true;
        while (y) {

            System.out.println("Welcome, Please select choice by inputing appropriate number:");
            System.out.println("1: Create New User ");
            System.out.println("2: Show Users List");
            System.out.println("3: LogIn");
            System.out.println("4: End Program");
            select = s.nextInt();
            s.nextLine();
            if (select == 1 || select == 2 || select == 3 || select == 4) {
                y = false;

            }

        }

        switch (select) {
            case 1:
                Main.addNewUser(i, s);
                break;

            case 2:
                Main.showUsersList(i, s);
                break;

            case 3:
                Main.loginFlow(i, s);
                break;

            case 4:
                System.exit(0);
                break;

        }

    }

    /**
     * @param i
     * @param s
     */
    private static void showUsersList(Instance i, Scanner s) {

        System.out.println(" [[Available Users:]] ");

        i.showUserInfo();
        displayHomeMenu(i, s);

    }

    public static void loginFlow(Instance i, Scanner s) {
        User x;
        x = displayMainMenu(i, s);
        displayUserMenu(i, x, s);

    }

    public static void addNewUser(Instance i, Scanner s) {
        String fName;
        String lName;
        int pin;

        System.out.println("Please Enter Your First Name:");
        fName = s.nextLine();
        System.out.println("Please Enter Your Last Name:");
        lName = s.nextLine();
        System.out.println("Please Enter Your Desired Login Pin Number:");
        pin = s.nextInt();
        s.nextLine();

        i.addNewUser(fName, lName, pin);

        displayHomeMenu(i, s);

    }

    public static User displayMainMenu(Instance i, Scanner s) {

        int userId;
        int pin;
        User w;
        // boolean x = true;

        while (true) {

            System.out.println("");

            System.out.println("Welcome");
            System.out.println("Please enter your userId: ");
            userId = s.nextInt();
            System.out.println("Please Enter your pin number");
            pin = s.nextInt();
            s.nextLine();

            w = i.verifyLogin(userId, pin);
            if (w == null) {
                System.out.println("");

                System.out.println("[[Sorry please verify login information and try again]]");
                System.out.println("");

                displayHomeMenu(i, s);

            } else {

                break;

            }

        }
        return w;

    }

    public static void displayUserMenu(Instance i, User u, Scanner s) {
        int selection = 0;
        boolean y = true;
        u.printAccountInfo();

        while (y) {
            System.out.println("");

            System.out.println("Welcome User , Please select choice by inputing appropriate number:");
            System.out.println("1: Create an Account ");
            System.out.println("2: Make a Transaction(Withdrawl)");
            System.out.println("3: Make a Transaction(Deposit Income)");
            System.out.println("4: Start Month");
            System.out.println("5: End Month");
            System.out.println("6: Exit");
            selection = s.nextInt();
            if (selection == 1 || selection == 2 || selection == 3 || selection == 4 || selection == 5
                    || selection == 6) {
                y = false;

            }
        }
        switch (selection) {
            case 1:
                Main.addNewAccount(i, u, s);

            case 2:
                Main.withdrawMoney(i, u, s);
                break;

            case 3:
                Main.depositIncome(i, u, s);
                break;

            case 4:
                Main.startMonth(i, u, s);
                break;

            case 5:
                Main.endMonth(i, u, s);
                break;

            case 6:

                Main.Exit(i, u, s);
                break;

        }

    }

    private static void depositIncome(Instance i, User u, Scanner s) {
        if (u.checkifMonthStarted() == true && u.checkifAccountExists() == true) {
            double amount = 0;
            System.out.println("Please Enter Income Transaction Amount: $");
            amount = s.nextDouble();
            u.makeADepositTransaction("Income", amount);
            displayUserMenu(i, u, s);

        } else if (u.checkifMonthStarted() == false && u.checkifAccountExists() == true) {

            System.out.println("[[No simulated month has been started, please start one first]]");
            System.out.println("");
            displayUserMenu(i, u, s);

        }
        System.out.println("[[Sorry Please Create an account first]]");
        System.out.println("");

        displayUserMenu(i, u, s);

    }

    private static void withdrawMoney(Instance i, User u, Scanner s) {
        if (u.checkifMonthStarted() == true && u.checkifAccountExists() == true) {

            int select = 0;
            double amount = 0;
            boolean y = true;
            while (y) {
                System.out.println("Please Input Transaction Category:");

                System.out.println("1: Home and Utilities ");
                System.out.println("2: Transportation");
                System.out.println("3: Food");
                System.out.println("4: Insurance");
                System.out.println("5: Entertainment");
                System.out.println("6: Other");
                select = s.nextInt();

                if (select == 1 || select == 2 || select == 3 || select == 4 || select == 5 || select == 6) {
                    y = false;

                }

            }

            System.out.println("Please Enter Trasaction Amount : ");
            amount = s.nextDouble();

            switch (select) {
                case 1:
                    Main.makeWithdrawlTransaction(i, u, s, "Home and Utilities", amount);
                    break;

                case 2:
                    Main.makeWithdrawlTransaction(i, u, s, "Transportation", amount);
                    break;

                case 3:
                    Main.makeWithdrawlTransaction(i, u, s, "Food", amount);
                    break;

                case 4:
                    Main.makeWithdrawlTransaction(i, u, s, "Insurance", amount);
                    break;

                case 5:
                    Main.makeWithdrawlTransaction(i, u, s, "Entertainment", amount);
                    break;

                case 6:
                    Main.makeWithdrawlTransaction(i, u, s, "Other", amount);
                    break;

            }
        } else if (u.checkifMonthStarted() == false && u.checkifAccountExists() == true) {

            System.out.println("[[No simulated month has been started, pls start one first]]");
            System.out.println("");
            displayUserMenu(i, u, s);

        }

        System.out.println("[[Sorry Please Create an account first]]");
        System.out.println("");

        displayUserMenu(i, u, s);

    }

    public static void makeWithdrawlTransaction(Instance i, User u, Scanner s, String category, double amount) {
        u.makeAWithdrawlTransaction(category, amount);
        displayUserMenu(i, u, s);

    }

    private static void Exit(Instance i, User u, Scanner s) {

        displayHomeMenu(i, s);
    }

    private static void startMonth(Instance i, User u, Scanner s) {
        if (u.checkifAccountExists() == true && u.checkifMonthStarted() == false) {
            u.setMonthStart(true);
            double startingBalance;
            double monthlyBudget;

            System.out.println("[[Please Enter your starting balance for this month]]");
            startingBalance = s.nextInt();
            System.out.println("[[Please Enter monthly Budget]]");
            monthlyBudget = s.nextInt();

            u.setMonthlyBudget(monthlyBudget);

            u.setAccountBalance(startingBalance);

            displayUserMenu(i, u, s);

        } else if (u.checkifMonthStarted() == true && u.checkifAccountExists() == true) {
            System.out
                    .println("[[A simulated month is already in motion,you may make a transaction or end the month]]");
            displayUserMenu(i, u, s);

        }

        System.out.println("[[Sorry, Please Create an Account Before starting a simulated month]]");
        displayUserMenu(i, u, s);

    }

    private static void endMonth(Instance i, User u, Scanner s) {

        if (u.checkifMonthStarted() == true && u.checkifAccountExists() == true) {
            u.setMonthStart(false);

            Account x = u.getFirstAccount();
            budgetInfo(i, u, s);
            x.displayTransactionsForMonth();

            u.getFirstAccount().clearAccountTransactionList();
            displayUserMenu(i, u, s);
        }

        else if (u.checkifMonthStarted() == false && u.checkifAccountExists() == true) {

            System.out.println("[[No simulated month has been started, please start one first]]");
            displayUserMenu(i, u, s);

        }

        System.out.println("[[Sorry Please Create an account first]]");
        displayUserMenu(i, u, s);

    }

    public static void budgetInfo(Instance i, User u, Scanner s) {

        double budget;
        double totalMoneySpent;
        budget = u.getMonthlyBudget();
        totalMoneySpent = u.getFirstAccount().totalMoneySpent();

        System.out.println("Your inital budget for this month was:  $" + budget);
        if (totalMoneySpent <= budget)

        {
            System.out.println("Congrats you  did not exceed your set budget for the month ");

        } else {

            System.out.println("");
            System.out.println("You have exceeded your set Budget by $: " + (Math.abs(budget - totalMoneySpent)));
            System.out.println(
                    "Unfortunately you have exceeded your set buget for the month , Consider reviewing your financial transactions below for more information");
            System.out.println("");
        }

    }

    public static void addNewAccount(Instance i, User u, Scanner s) {

        if (u.checkifAccountExists() == true) {

            System.out.println("[[Sorry an Account Already Exists. One Account Per User.]]");

        } else {
            String t;
            s.nextLine();
            System.out.println("[[Please Enter your account type/name (Checking or Savings)]]");
            t = s.nextLine();

            Account n = new Account(t, u, i);
            i.addNewAccount(n);

        }

        displayUserMenu(i, u, s);

    }

}
