package src;

public class UserProfile {

    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String address;
    private final String profilePicture;
    private final String dateOfBirth;
    private final boolean newsletterSubscription;

     UserProfile(UserProfileBuilder builder) {
        this.name = builder.getName();
        this.email = builder.getEmail();
        this.phoneNumber = builder.getPhoneNumber();
        this.address = builder.getAddress();
        this.profilePicture = builder.getProfilePicture();
        this.dateOfBirth = builder.getDateOfBirth();
        this.newsletterSubscription = builder.isNewsletterSubscription();
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

    @Override
    public String toString() {

        StringBuilder userString = new StringBuilder("User Profile");

        userString.append("\nName: ").append(name);
        userString.append("\nEmail: ").append(email);
        if(checkStringValueNotNull(phoneNumber)){
            userString.append("\nPhone Number: ").append(phoneNumber);
        }
        if(checkStringValueNotNull(address)){
            userString.append("\nAddress: ").append(address);
        }
        if(checkStringValueNotNull(profilePicture)){
            userString.append("\nProfile Picture: ").append(profilePicture);
        }
        if(checkStringValueNotNull(dateOfBirth)){
            userString.append("\nDate of Birth: ").append(dateOfBirth);
        }
        userString.append("\nNewsletter Subscription: ").append(newsletterSubscription);

        return userString.toString();
    }

    private boolean checkStringValueNotNull(String value){
        return value != null && !value.isBlank();
    }


}
