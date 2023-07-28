package com.ssafy.ws.step5;

public class UserManagerImpl implements IUserManager {

    private final int MAX_USER_SIZE = 100;
    private User loginUser;
    private User[] users = new User[MAX_USER_SIZE];
    private int userSize = 0;
    private static IUserManager um = new UserManagerImpl();

    private UserManagerImpl(){
    }

    public static IUserManager getinstance(){
        return um;
    }


    public User getLoginUser() {
        return loginUser;
    }

    public void signup(User user) {
        users[userSize++] = user;
    }

    public User login(String id, String password) {
        for (int i = 0; i < userSize; i++) {
            if (users[i].getUserId().equals(id) && users[i].getPassword().equals(password)) {
                loginUser = users[i];
                return users[i];
            }
        }
        return null;
    }

    public void logout() {
        loginUser = null;
    }

    public User getUser(int userSeq) {
        for (int i = 0; i < userSize; i++) {
            if (users[i].getUserSeq() == userSeq)
                return users[i];
        }
        return null;
    }

    public User getUser(String nickname) {
        for (int i = 0; i < userSize; i++) {
            if (users[i].getNickName().equals(nickname))
                return users[i];
        }
        return null;
    }

}
