package org.example.studentadminstator.data;

public class User {
        private String password;
        private String username;
        private String type;
        
       
        public User(String password, String username, String type) {
            this.password = password;
            this.username = username;
            this.type = type;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;   
        }
}