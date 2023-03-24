package POJO;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Users")
public class User implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Username")
    private String Username ;
    @Column(name = "Email")
    private String Email;
    @Column(name = "Password")
    private String Password;



    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public User(int id, String username, String email, String password) {
        this.id = id;
        this.Username = username;
        this.Email = email;
        this.Password = password;
    }
    public User(String username,String password){
        this.Username = username;
        this.Password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", FullName='" + Username + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
