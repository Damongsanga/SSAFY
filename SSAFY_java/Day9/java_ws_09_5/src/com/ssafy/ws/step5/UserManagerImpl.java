package com.ssafy.ws.step5;

import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements IUserManager {

    private final int MAX_USER_SIZE = 100;
    private User loginUser;
    private List<User> users = new ArrayList<>();
    private static IUserManager um = new UserManagerImpl();

    private UserManagerImpl(){
    }

    public static IUserManager getinstance(){
        return um;
    }


    public User getLoginUser() {
        return loginUser;
    }

    
    // equals()를 override해서?
    // 그러면 다른 부분에서 문제가 생길 수 있으니 그냥 여기서만 따로 구현하자
    // userID만 비교하는 방식으로 ㄱㄱ
    public void signup(User user) throws UserIdDuplicateException{
        if (users.size() < MAX_USER_SIZE) {
        	for (User usertmp : users) {
				if (usertmp.getUserId().equals(user.getUserId())) {
					throw new UserIdDuplicateException(user.getUserId());
				}
			}
        	users.add(user);   	
        }


    }

    public User login(String id, String password) throws LoginException{
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equals(id) && users.get(i).getPassword().equals(password)) {
                loginUser = users.get(i);
                return users.get(i);
            }
        }
        throw new LoginException();
    }

    public void logout() {
        loginUser = null;
    }

    public User getUser(int userSeq) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserSeq() == userSeq)
                return users.get(i);
        }
        return null;
    }

    public User getUser(String nickname) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getNickName().equals(nickname))
                return users.get(i);
        }
        return null;
    }

}
