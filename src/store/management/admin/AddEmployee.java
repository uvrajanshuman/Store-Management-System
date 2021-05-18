/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.admin;

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
public class AddEmployee extends JFrame implements ActionListener{
    
    JLabel label1,label2,label3,label4,label5,label6;
    JTextField name,email,mobile;
    JComboBox role;
    JPasswordField pwd;
    JButton addemp,cancel;

    public AddEmployee(){
        this.setLayout(null);
        //Background Image
        ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("store\\management\\icons\\icon11.jpg"));
        Image image11=icon11.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        icon11=new ImageIcon(image11);
        
        //root label
        JLabel background=new JLabel();
        background.setIcon(icon11);
        background.setLayout(null);
        background.setBounds(0,0,600,600);
        this.add(background);
        
        //adding labels,textfeilds
        
        label1=new JLabel("Enter Employee Details");
        label1.setBounds(175,20,250,50);
        label1.setFont(new Font("serif",Font.ITALIC,25));
        background.add(label1);
        
        //Name
        label2=new JLabel("Name");
        label2.setBounds(50,100,100,30);
        label2.setFont(Properties.getFont());
        background.add(label2);
        
        name=new JTextField();
        name.setBounds(200,100,150,30);
        name.setOpaque(false);
        background.add(name);
        
        //Email
        label3=new JLabel("Email");
        label3.setBounds(50,170,100,30);
        label3.setFont(Properties.getFont());
        background.add(label3);
        
        email=new JTextField();
        email.setBounds(200,170,150,30);
        email.setOpaque(false);
        background.add(email);
        
        //Mobile
        label4=new JLabel("Mobile");
        label4.setBounds(50,240,100,30);
        label4.setFont(Properties.getFont());
        background.add(label4);
        
        mobile=new JTextField();
        mobile.setBounds(200,240,150,30);
        mobile.setOpaque(false);
        background.add(mobile);
        
        //role
        label5=new JLabel("Role");
        label5.setBounds(50,310,100,30);
        label5.setFont(Properties.getFont());
        background.add(label5);
        
        String []rolearr={"Admin","Employee"};
        role=new JComboBox(rolearr);
        role.setBackground(Color.WHITE);
        role.setBounds(200,310,100,30);
        background.add(role);
        
        //password
        label6=new JLabel("Password");
        label6.setBounds(50,380,100,30);
        label6.setFont(Properties.getFont());
        background.add(label6);
        
        pwd=new JPasswordField();
        pwd.setBounds(200,380,150,30);
        pwd.setOpaque(false);
        background.add(pwd);
        
        //add
        addemp=new JButton("Add");
        addemp.setBounds(100,500,150,30);
        addemp.setBackground(Color.BLACK);
        addemp.setForeground(Color.white);
        addemp.setFont(Properties.getFont());
        addemp.addActionListener(this);
        background.add(addemp);
        
        //cancel
        cancel=new JButton("Cancel");
        cancel.setBounds(350,500,150,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(Properties.getFont());
        cancel.addActionListener(this);
        background.add(cancel);
        
        
        this.setSize(600,600);
        this.setResizable(false);
        ImageIcon iconimage=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon7.png"));
        this.setIconImage(iconimage.getImage());
        this.setLocationRelativeTo(rootPane);
        this.setTitle("Add Employee");
        this.setVisible(true);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addemp){
            String empname=name.getText();
            String empemail=email.getText();
            String empmob=mobile.getText();
            String emppwd=new String(pwd.getPassword());
            String emprole;
            
            //to check if any feild is not empty//To-Do
            
            if(role.getSelectedIndex()==0)
                emprole="admin";
            else
                emprole="employee";
            
            try(Connection c=DBConnect.getConnection();
                 Statement stmt=c.createStatement();)
            {
                ResultSet set=stmt.executeQuery("Select * from register where email ='"+empemail+"' and password ='"+emppwd+"'");
                if(set.next())
                    JOptionPane.showMessageDialog(rootPane,"User already exists","Error",JOptionPane.ERROR_MESSAGE);
                else{
                    String query="Insert into register values(?,?,?,?,?)";
                    PreparedStatement ps=c.prepareStatement(query);
                    ps.setString(1,empname);
                    ps.setString(2, empemail);
                    ps.setString(3, emppwd);
                    ps.setString(4, emprole);
                    ps.setString(5, empmob);
                    int i=ps.executeUpdate();
                    if(i>0)
                        JOptionPane.showMessageDialog(rootPane,"Employee Added","Success",JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(rootPane,"Invalid Input(s)","Error",JOptionPane.ERROR_MESSAGE);
                    }
                     
            }
            catch(SQLException exception){exception.printStackTrace();}
        }
        else if(e.getSource()==cancel){
            this.setVisible(false);
            this.dispose();
        }
    }
    
    public static void main(String[] args) {
        new AddEmployee();
    }
    
}
