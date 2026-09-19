package src;

public class UserProfileBuilder {
    private String name;
    private String email;
    private String phoneNumber = null;
    private String address = null;
    private String profilePicture = null;
    private String dateOfBirth = null;
    private boolean newsletterSubscription = false;

    public UserProfileBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserProfileBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserProfileBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserProfileBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public UserProfileBuilder setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }

    public UserProfileBuilder setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public UserProfileBuilder setNewsletterSubscription(boolean newsletterSubscription) {
        this.newsletterSubscription = newsletterSubscription;
        return this;
    }

    public UserProfile build() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required.");
        }

        return new UserProfile(this);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isNewsletterSubscription() {
        return newsletterSubscription;
    }
}
