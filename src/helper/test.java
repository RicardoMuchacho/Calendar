package helper;

import helper.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DB db = DB.getInstances();
		User user = new User("rickity", "h", "h@gmail.com");
		user.setUserid(2);;
		
		//User user2 = db.loginData(user.getName(), user.getPassword());
		//System.out.println(user2.getName());
		//user2.getEmail();
		//user2.getPassword();
		
		db.updateUser(user);
	}

}
