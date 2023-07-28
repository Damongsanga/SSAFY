package com.ssafy.ws.step5;

public class User {


    private String userId;
    private String password;
    private String userName;
    private String nickName;
    private String email;
    private int userSeq;

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(String userId, String password, String userName, String nickName, String email, int userSeq) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.nickName = nickName;
        this.email = email;
        this.userSeq = userSeq;
    }




    public String getUserId() {
        return userId;
    }



    public void setUserId(String userId) {
        this.userId = userId;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public String getUserName() {
        return userName;
    }



    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getNickName() {
        return nickName;
    }



    public void setNickName(String nickName) {
        this.nickName = nickName;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public int getUserSeq() {
        return userSeq;
    }



    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    @Override
    public String toString() {
        return "User [userSeq=" + userSeq + ", userId=" + userId + ", password=" + password + ", userName=" + userName
                + ", nickName=" + nickName + ", email=" + email + "]";
    }


    // override하여 signup을 구현할 수도 있으나 다른 부분에서 문제가 생길 수 있음으로 하지 않겠다.
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		
//		User other = (User) obj;
//		
//		if (email.equals(other.email)|| nickName.equals(other.nickName) || userId.equals(other.userId) || userName.equals(other.userName) || userSeq == other.userSeq )
//			return true;
//		else 
//			return false;
//	}

    

}

