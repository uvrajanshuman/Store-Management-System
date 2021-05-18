///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package store.management.employee;
//import java.sql.*;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import store.management.DBConnect;
//import store.management.Login;
//import store.management.Properties;
//
///**
// *
// * @author ANSHUMAN
// */
//public class EmployeeLogin extends JFrame implements ActionListener{
//    JLabel l1,l2,l3;
//    JTextField t1;
//    JPasswordField p1;
//    JButton login,cancel;
//    public EmployeeLogin(){
//        super("Employee Login");
//        this.setBackground(Color.WHITE);
//        
//        l1=new JLabel("User Name");
//        l1.setBounds(40,20,100,30);
//        this.add(l1);
//        
//        l2= new JLabel("Password");
//        l2.setBounds(40, 70, 100, 30);
//        this.add(l2);
//        
//        t1=new JTextField();
//        t1.setBounds(150,20,150,30);
//        this.add(t1);
//        
//        p1=new JPasswordField();
//        p1.setBounds(150,70,150,30);
//        this.add(p1);
//        
//        ImageIcon image4=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon4.jpg"));
//        Image i4=image4.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
//        image4=new ImageIcon(i4);
//        l3=new JLabel(image4);
//        l3.setBounds(350,20,150,150);
//        this.add(l3);
//        
//        login=new JButton("Login");
//        login.setFont(Properties.getFont2());
//        login.setBackground(Color.BLACK);
//        login.setForeground(Color.WHITE);
//        login.addActionListener(this);
//        login.setBounds(40,140,120,30);
//        this.add(login);
//        
//        cancel=new JButton("Cancel");
//        cancel.setFont(Properties.getFont2());
//        cancel.setBackground(Color.BLACK);
//        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
//        cancel.setBounds(180,140,120,30);
//        this.add(cancel);
//        
//        //To open Login page on closing.
//        addWindowListener(new java.awt.event.WindowAdapter() {
//            public void windowClosing(java.awt.event.WindowEvent e) {
//                new Login();
//            }
//        });
//        
//        this.setLayout(null);
//        this.setSize(600,300);
//        this.setLocation(500,300);
//        this.setBackground(Color.WHITE);
//        this.setVisible(true);
//        
//    }
//
//    @Override
//public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==login){
//            String username=t1.getText();
//            char arr[]=p1.getPassword();
//            String password=new String(arr);
//            try (Connection c=DBConnect.getConnection();
//                 Statement stmt=c.createStatement();
//                 ResultSet set=stmt.executeQuery("select * from register where email='"+username+"'and password='"+password+"'");
//                    )
//            {
//                
//                if(set.next()&& set.getString("role").equals("employee")){
//                    this.setVisible(false);
//                    new Employee();
//                    this.dispose();
//                    //System.out.println("Employee Page");
//                }
//                else{
//                    JOptionPane.showMessageDialog(rootPane, "Error", "Invalid credientals", JOptionPane.ERROR_MESSAGE);
//                      t1.setText("");
//                      p1.setText("");
//                }
//                    
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        else if(e.getSource()==cancel){
//            this.setVisible(false);
//            new Login();
//        }
//    }
//    
//    public static void main(String[] args) {
//        new EmployeeLogin();
//    }
//}
