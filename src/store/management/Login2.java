/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import store.management.admin.Admin;
import store.management.employee.Employee;



/**
 *
 * @author ANSHUMAN
 */
public class Login2 extends JFrame implements ActionListener{
    JLabel l1,l2,l3,imageJLabel;
    JTextField t1;
    JPasswordField p1;
    JButton login,cancel;
    LoginProfile profile;
    public Login2(){
        super("Admin Login");
        
        
        l1=new JLabel("User Name");
        l1.setBounds(30,80,100,30);
        this.add(l1);
        
        l2= new JLabel("Password");
        l2.setBounds(30, 130, 100, 30);
        this.add(l2);
        
        t1=new JTextField();
        t1.setBounds(110,80,150,30);
        this.add(t1);
        
        p1=new JPasswordField();
        p1.setBounds(110,130,150,30);
        this.add(p1);
        
        ImageIcon image4=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon3.jpg"));
        Image i4=image4.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        image4=new ImageIcon(i4);
        l3=new JLabel(image4);
        l3.setBounds(300,00,300,300);
        this.add(l3);
        
        login=new JButton("Login");
        login.setFont(Properties.getFont2());
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setBounds(30,200,120,30);
        this.add(login);
        
        cancel=new JButton("Cancel");
        cancel.setFont(Properties.getFont2());
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setBounds(170,200,120,30);
        this.add(cancel);
        
//        //To open Login page on closing.
//        addWindowListener(new java.awt.event.WindowAdapter() {
//            public void windowClosing(java.awt.event.WindowEvent e) {
//                new Login();
//            }
//        });

        this.setUndecorated(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(600,300);
        this.setLocation(500,300);
        this.setBackground(Color.WHITE);
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            String username=t1.getText();
            char arr[]=p1.getPassword();
            String password=new String(arr);
            try (Connection c=DBConnect.getConnection();
                 Statement stmt=c.createStatement();
                 ResultSet set=stmt.executeQuery("select * from register where email='"+username+"'and password='"+password+"'");
                    )
            {
                if(set.next()){
                    profile=new LoginProfile();
                    profile.setName(set.getString("name"));
                    profile.setEmail(set.getString("email"));
                    profile.setPassword(set.getString("password"));
                    profile.setMobileno(set.getString("mobileno"));
                    profile.setRole(set.getString("role"));
                    if(profile.getRole().equals("admin"))
                        new Admin(profile);
                    else if(profile.getRole().equals("employee"))
                        new Employee(profile);
                    this.setVisible(true);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Error", "Invalid credientals", JOptionPane.ERROR_MESSAGE);
                      t1.setText("");
                      p1.setText("");
                }
                    
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getSource()==cancel){
            this.setVisible(false);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login2();
    }
}


