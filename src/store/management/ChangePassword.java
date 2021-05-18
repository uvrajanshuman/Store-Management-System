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
import store.management.DBConnect;
import store.management.Properties;

/**
 *
 * @author ANSHUMAN
 */
public class ChangePassword extends JFrame implements ActionListener {
    String name;
    JLabel l1,l2,l3,l4;
    JTextField t1,t2;
    JPasswordField p1;
    JButton changepwd,cancel;
    public ChangePassword(String name){
        super("Change Password");
        this.name=name;
        
        this.setBackground(Color.WHITE);
        
        l1=new JLabel("Old Password");
        l1.setBounds(30,20,100,30);
        this.add(l1);
        
        l2= new JLabel("New Password");
        l2.setBounds(30, 70, 100, 30);
        this.add(l2);
        
        l4= new JLabel("Re-Enter Password");
        l4.setBounds(20, 130, 100, 30);
        this.add(l4);
        
        t1=new JTextField();
        t1.setBounds(170,20,150,30);
        this.add(t1);
        
        t2=new JTextField();
        t2.setBounds(170,70,150,30);
        this.add(t2);
        
        p1=new JPasswordField();
        p1.setBounds(170,130,150,30);
        this.add(p1);
        
        ImageIcon image4=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//password.jpg"));
        Image i4=image4.getImage().getScaledInstance(260, 260, Image.SCALE_DEFAULT);
        image4=new ImageIcon(i4);
        l3=new JLabel(image4);
        l3.setBounds(350,0,260,260);
        this.add(l3);
        
        changepwd=new JButton("Change Password");
        changepwd.setFont(Properties.getFont2());
        changepwd.setBackground(Color.BLACK);
        changepwd.setForeground(Color.WHITE);
        changepwd.addActionListener(this);
        changepwd.setBounds(20,180,160,30);
        this.add(changepwd);
        
        cancel=new JButton("Cancel");
        cancel.setFont(Properties.getFont2());
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setBounds(180,180,160,30);
        this.add(cancel);
        
        //To open Login page on closing.
//        addWindowListener(new java.awt.event.WindowAdapter() {
//            public void windowClosing(java.awt.event.WindowEvent e) {
//              
//                        
//            }
//        });
        
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//changepassword.jpg"));
        this.setIconImage(icon.getImage());
        this.setLayout(null);
        this.setSize(600,300);
        this.setLocationRelativeTo(rootPane);
        this.setBackground(Color.cyan);
        this.setResizable(false);
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==changepwd){
            String oldpass = t1.getText();
            String newpass = t2.getText();
            char []arr=p1.getPassword();
            String newpass2=new String(arr);
            //if newpassword and re-enter does not matches
             if(newpass.equals(newpass2)==false){
                 JOptionPane.showMessageDialog(rootPane,"Enter same password in both feilds", "Error",JOptionPane.ERROR_MESSAGE);
                 t1.setText("");
                 t2.setText("");
                 p1.setText("");
             }else{
                 String query="select * from register where email='"+name+"'and password ='"+oldpass+"'";
                 try(Connection c= DBConnect.getConnection();
                      Statement stmt=c.createStatement();
                      ResultSet set=stmt.executeQuery(query)){
                     if(set.next()){
                         //old password matches
                         if(oldpass.equals(set.getString("password"))){
                         stmt.execute("update register set password='"+newpass+"' where email='"+name+"'");
                         JOptionPane.showMessageDialog(rootPane, "Success","Password changed Successfully",JOptionPane.INFORMATION_MESSAGE);
                         }else{
                             JOptionPane.showMessageDialog(rootPane, "Error", "Invalid Old Password",JOptionPane.ERROR_MESSAGE);
                         }      
                     }else{
                        JOptionPane.showMessageDialog(rootPane, "Error", "Invalid Credientals",JOptionPane.ERROR_MESSAGE);
                     }   
                    }catch(SQLException exception){exception.printStackTrace();}
             }
        }else if(e.getSource()==cancel){
            this.setVisible(false);
            this.dispose();
        }
    }
    
    public static void main(String[] args) {
        new ChangePassword("Anshuman");
    }
}
