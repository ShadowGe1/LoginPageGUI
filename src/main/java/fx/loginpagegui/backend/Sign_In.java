package fx.loginpagegui.backend;

public class Sign_In {
    private final Storage passwords;
    public Sign_In(Storage storage){
        passwords = storage;
    }

    public boolean correctPassword(String username, String password_user){
        GetPassword userPasswords = new GetPassword(password_user, passwords.userSalt(username));
        return !passwords.userPassword(username).equals(userPasswords.generatedPass);
    }
}
