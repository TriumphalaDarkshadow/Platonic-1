package user;
import java.io.Serializable;
import javafx.scene.image.Image;
import java.util.*;


public class UserData implements java.io.Serializable{

        private String username;
        private String email;
        private String password;
        private String birthday;
        private String location;
        private String interests;
        private long id;
        private byte[] photo;
        private String filename;
        
      
    
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
        
        public void setPhoto (byte[] photo) {
            this.photo = photo;
        }
        
        public void setFilename(String filename) {
            this.filename = filename;
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
        
        public byte[] getPhoto () {
            return photo;
        }

        public String getFilename() {
            return filename;
        }
     
        

}
