package src;

public class UserRegistrationApplication {

    public static void main(String[] args) {

        UserProfile user = new UserProfileBuilder()
                .setName("John Doe")
                .setEmail("john@example.com")
                .setPhoneNumber("9876543210")
                .setAddress("Mumbai")
                .setProfilePicture("profile.jpg")
                .setDateOfBirth("15-08-1995")
                .setNewsletterSubscription(true)
                .build();

        System.out.println(user);

    }
}
