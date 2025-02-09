package org.example.studentadminstator.data;

import java.util.ArrayList;

public class UsersDB<T> {

        private final ArrayList<User> userDB = new ArrayList<>();
        
        public UsersDB (){
        }

        //username, password , type
//    userDB:   [
//                {
//                username:"Esraa",
//                password:"12345",
//                type:"Student",
//                 },
//                 {
//                username:"Ibrahim",
//                password:"123456",
//                type:"Student",
//                 }
//        ]
        public void createUser(User user){
//                userDB.add(user);
        userDB.add(user);
        }

        public void deleteUser(User user){
                userDB.remove(user);
        }

        public void updateUser(User user,User newUser){
                for(int i=0;i<userDB.size();i++){
                        if(userDB.get(i).getUsername().equals(user.getUsername())){
                                userDB.set(i,newUser);
                        }
                }
        }

        public ArrayList<User> fetchAllUsers(){
                return userDB;
        }

        public User fetchOneUser (String username){
                for(User user:userDB){
                        if(user.getUsername().equals(username)){
                                return user;
                        }
                }
                return null;
        }

        public Boolean searchUser(String username, String password) {
            for (User user : userDB) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return true; 
                }
            }
            return false;
        }

        public String getUserType(String username){
                String type = ""; 
                for(User user:userDB){
                        if(user.getUsername().equals(username)){
                                type = user.getType();
                                return type; 
                        }
                }
                return type; 
        }

        
}
