///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package store.management;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import store.management.admin.AdminLogin;
//import store.management.employee.EmployeeLogin;
//
///**
// *
// * @author ANSHUMAN
// */
//public class Login extends JFrame implements ActionListener{
//    JLabel l1,admin,employee;
//    JButton b1,b2;
//    public Login() {
//        
//        this.setSize(900, 500);
//        this.setLayout(null);
//
//        
//        l1=new JLabel("Login");
//        l1.setFont(Properties.getFont());
//        l1.setBounds(414, 10, 100, 35);
//        this.add(l1);
//        
//        b1=new JButton("Admin");
//        b1.setFont(Properties.getFont());
//        b1.setBounds(125,400,200,34);
//        b1.setFocusable(true);
//        b1.addActionListener(this);
//        
//        
//        b2=new JButton("Employee");
//        b2.setFont(Properties.getFont());
//        b2.setBounds(550, 400, 200, 34);
//        b2.setFocusable(true);
//        b2.addActionListener(this);
//        
//        this.add(b2);
//        this.add(b1);
//        
//        //Employee
//        ImageIcon image2=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon2.jpg"));
//        Image i2=image2.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
//        //Admin
//        ImageIcon image3=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon3.jpg"));
//        Image i3=image3.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
//        
//        admin=new JLabel(image2);
//        admin.setBounds(0,0,450,450);
//        this.add(admin);
//
//        employee=new JLabel(image3);
//        employee.setBounds(450,0,450,450);
//        this.add(employee);
//        
//        this.setTitle("STORE MANAGEMENT");
//        this.setBackground(Color.WHITE);
//        
//        this.setResizable(false);
//        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
//    }
//    public static void main(String[] args) {
//        new Login();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==b1){
//            this.setVisible(false);
//            this.dispose();
//            new AdminLogin();
//        }
//        else if(e.getSource()==b2){
//            this.setVisible(false);
//            this.dispose();
//            new EmployeeLogin();
//        }
//    }
// 
//}
