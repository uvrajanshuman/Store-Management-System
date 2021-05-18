/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management;

/**
 *
 * @author ANSHUMAN
 */
public class LoginProfile {
   private String name="Anshuman Yuvraj",email="admin@admin.com",password="admin",mobileno="9546610003",role="admin";

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileno() {
        return mobileno;
    }

    public String getRole() {
        return role;
    }
    
}
