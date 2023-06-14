package dataobjects;

/**
 * Represents a password object.
 * This class encapsulates a password string and provides methods to access and manipulate it.
 */
public class Password {

    private final String password;

    /**
     * Constructs a new Password object with the specified password string.
     *
     * @param password the password string to set
     */
    public Password(String password) {
            this.password = password;
        }

    /**
     * Retrieves the password string.
     *
     * @return the password string
     */
        public String getPassword() {
            return password;
        }

    /**
     * Returns a string representation of the Password object.
     *
     * @return a string representation of the Password object
     */
        @Override
        public String toString() {
            return "Password{" +
                    ", password='" + password + '\'' +
                    '}';
        }
    }


