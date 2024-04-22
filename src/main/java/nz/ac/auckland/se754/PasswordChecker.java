package nz.ac.auckland.se754;

public class PasswordChecker {
    private User user;
public  PasswordChecker(User user){
    this.user = user;
}
    public boolean isValid(String pwd){

    for(int i= 0; i<3;i++){
        if(user.getList().size() < i + 1){
            break;
        }
        if(pwd.equals(user.getList().get(user.getList().size() - 1 - i ))){
            return false;
        }
    }
    if(user.getName()!=null && pwd.contains(user.getName())){
        return false;
    }
        return (pwd.length() >= 8);
    }

}
