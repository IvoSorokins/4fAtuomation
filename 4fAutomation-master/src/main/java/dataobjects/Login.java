package dataobjects;

/**
 * Represents a login object that contains an email and password.
 * This class encapsulates the email and password fields required for user login.
 */
public class Login {

    private final String email;
    private final String password;

    /**
     * Constructs a new Login object with the specified email and password.
     *
     * @param email the email associated with the login
     * @param password the password associated with the login
     */
    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Retrieves the email associated with the login.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retrieves the password associated with the login.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns a string representation of the Login object.
     *
     * @return a string representation of the Login object
     */
    @Override
    public String toString() {
        return "Login{" +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
