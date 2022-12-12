import java.util.ArrayList;
import java.util.Random;

public class Instance {

    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public Instance() {

        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();

    }

    public void showUserInfo() {
        for (User u : this.users) {
            System.out.println("");

            System.out.println("First Name: " + u.getFirstName());
            System.out.println("Last Name: " + u.getUserLastname());
            System.out.println("User Id: " + u.getUserId());
            System.out.println("");

        }

    }

    /**
     * @return
     */
    public int generateUserId() {
        int uId = 0;
        Random r = new Random();
        boolean foundSameId = true;

        while (foundSameId) {
            foundSameId = false;
            uId = r.nextInt(1000000);
            for (User x : this.users) {
                if (uId == x.getUserId()) {

                    foundSameId = true;
                    break;

                }

            }
        }

        return uId;
    }

    public int generateAccountId() {
        int aId = 0;
        Random r = new Random();
        boolean foundSameId = true;

        while (foundSameId) {
            foundSameId = false;
            aId = r.nextInt(1000000);
            for (Account x : this.accounts) {
                if (aId == x.getAccountId()) {

                    foundSameId = true;
                    break;

                }

            }
        }

        return aId;
    }

    public void addNewAccount(Account naAccount) {

        this.accounts.add(naAccount);

    }

    public User addNewUser(String fName, String lName, int pin) {
        User u = new User(fName, lName, pin, this);
        this.users.add(u);
        System.out.println("");

        System.out.println("New User: ");
        System.out.println(" First Name: " + fName);
        System.out.println(" Last Name: " + lName);
        System.out.println(" LoginPin: " + pin);
        System.out.println(" UserId: " + u.getUserId());
        System.out.println(" ");
        return u;

    }

    public User verifyLogin(int userId, int pin) {
        for (User x : this.users) {
            if (userId == x.getUserId() && pin == x.getUserPin()) {

                return x;

            }

        }
        return null;

    }

}
