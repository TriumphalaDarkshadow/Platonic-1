package user;
import java.io.Serializable;
import java.util.*;


public class UserData implements java.io.Serializable{

        private String username;
        private String email;
        private String password;
        private String birthday;
        private String location;
        private String interests;
        private long int1;
        private long id;
        
        public UserData(){
             }
        
        public UserData(long id, String username, String email, String password, String birthday, String location, String interests){
            super();
            this.id = id;
            this.username = username;
            this.email = email;
            this.password = password;
            this.birthday = birthday;
            this.location = location;
            this.interests = interests;
        }
    
        public void setUsername(String username){
            this.username = username;
        }
        
        public void setEmail(String email){
            this.email = email;
        }
        
        public void setPassword(String password){
            this.password = password;
        }
        
        public void setBirthday(String birthday){
            this.birthday= birthday;
        }
        
        public void setLocation(String location){
            this.location = location;
        }
        
        public void setInterests(String interests){
            this.interests = interests;
        }
        
        public void setId(Long id) {
            this.id = id;            
        }
        
        
        public String getUsername(){
            return username;
        }
        
        public String getEmail(){
            return email;
        }
        
        public String getPassword(){
            return password;
        }
        
        public String getBirthday(){
            return birthday;
        }
        
        public String getLocation(){
            return location;
        }
        
        public String getInterests(){
            return interests;
        }

        public Long getId() {
            return id;            
        }


}
