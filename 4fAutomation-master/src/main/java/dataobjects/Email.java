package dataobjects;

/**
 * Represents an email address.
 * This class encapsulates the email address string.
 */
public class Email {
    private final String email;

    /**
     * Constructs a new Email object with the specified email address.
     *
     * @param email the email address
     */
    public Email(String email) {
        this.email = email;
    }

    /**
     * Retrieves the email address.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns a string representation of the Email object.
     *
     * @return a string representation of the Email object
     */
    @Override
    public String toString() {
        return "Email{" +
                ", email='" + email + '\'' +
                '}';
    }
}
