package DesignPatterns.Builder;

public class BuilderMain {
    public static void main(String[] args) {
        User user = new User.UserBuilder()
                .setEmail("a")
                .setFirstName("akash")
                .setLastName("adhikari")
                .build();
    }
}
