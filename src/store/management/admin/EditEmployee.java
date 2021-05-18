/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.admin;

import store.management.Properties;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import store.management.DBConnect;
/**
 *
 * @author ANSHUMAN
 */
public class EditEmployee extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField eid,name,email,mob,pass;
    JComboBox role;
    JButton fetch,update,cancel,viewall;
    public EditEmployee() {
        
        //setting background image and label
        ImageIcon icon12=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon12.jpg"));
        Image image12=icon12.getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT);
        JLabel background=new JLabel();
        background.setIcon(new ImageIcon(image12));
        background.setBounds(0,0,600,700);
        background.setLayout(null);
        this.add(background);
        
        //fetch details
        l1=new JLabel("Employee id");
        l1.setBounds(50,100,120,30);
        l1.setFont(Properties.getFont());
        l1.setOpaque(true);
        l1.setBackground(Color.WHITE);
        background.add(l1);
        
        eid=new JTextField();
        eid.setBounds(200,100,200,30);
        eid.setOpaque(false);
        background.add(eid);
        
        fetch=new JButton("Fetch");
        fetch.setBounds(450,100,100,30);
        //fetch.setFont(Properties.getFont());
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.white);
        fetch.addActionListener(this);
        background.add(fetch);
        
        //name
        l2=new JLabel("Name");
        l2.setBounds(50,170,100,30);
        l2.setFont(Properties.getFont());
        background.add(l2);
        
        name=new JTextField();
        name.setBounds(200,170,200,30);
        name.setOpaque(true);
        name.setEditable(false);
        background.add(name);
        
        //email
        l3=new JLabel("Email");
        l3.setBounds(50,240,100,30);
        l3.setFont(Properties.getFont());
        background.add(l3);
        
        email=new JTextField();
        email.setBounds(200,240,200,30);
        email.setOpaque(true);
        email.setEditable(false);
        background.add(email);
        
        //mobile
        l4=new JLabel("Mobile");
        l4.setBounds(50,310,100,30);
        l4.setFont(Properties.getFont());
        background.add(l4);
        
        mob=new JTextField();
        mob.setBounds(200,310,200,30);
        mob.setOpaque(true);
        mob.setEditable(false);
        background.add(mob);
        
        //role
        l5=new JLabel("Role");
        l5.setBounds(50,380,100,30);
        l5.setFont(Properties.getFont());
        background.add(l5);
        
        String rolearr[]={"Admin","Employee"};
        role=new JComboBox(rolearr);
        role.setEnabled(false);
        role.setBounds(200,380,200,30);
        background.add(role);
        
        //password
        l6=new JLabel("Password");
        l6.setBounds(50,450,100,30);
        l6.setFont(Properties.getFont());
        background.add(l6);
        
        pass=new JTextField();
        pass.setBounds(200,450,200,30);
        pass.setOpaque(true);
        pass.setEditable(false);
        background.add(pass);
        
        //update
        update=new JButton("Update");
        update.setBounds(100,540,100,30);
        //update.setFont(Properties.getFont());
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.setEnabled(false);
        update.addActionListener(this);
        background.add(update);
        
        //update
        cancel=new JButton("Cancel");
        cancel.setBounds(400,540,100,30);
        //cancel.setFont(Properties.getFont());
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        //cancel.setEnabled(false);
        cancel.addActionListener(this);
        background.add(cancel);
        
        //viewall employees
        viewall=new JButton("View All");
        viewall.setBounds(200,610,200,30);
        viewall.setBackground(Color.BLACK);
        viewall.setForeground(Color.white);
        viewall.addActionListener(this);
        background.add(viewall);
        
        l7=new JLabel("Update Employee Details");
        l7.setBounds(50,15,500,30);
        l7.setFont(new Font("sansserif",Font.ITALIC,30));
        background.add(l7);
        
        this.setTitle("Edit Employees");
        ImageIcon iconimage=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon8.png"));
        this.setIconImage(iconimage.getImage());
        this.setSize(600,700);
        this.setResizable(false);
        this.setLocationRelativeTo(rootPane);
        this.setVisible(true);
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg=e.getActionCommand();
        
        switch (msg){
            //fetch button
         case "Fetch":
            try(Connection c= DBConnect.getConnection();
                Statement stmt=c.createStatement();) 
            {
                String emailString=eid.getText();
                ResultSet set= stmt.executeQuery("select * from register where email ='"+emailString+"'");
                if(set.next()){
                    name.setText(set.getString("name"));
                    name.setEditable(true);
                    
                    email.setText(set.getString("email"));
                    email.setEditable(true);
                    
                    mob.setText(set.getString("mobileno"));
                    mob.setEditable(true);
                    
                    pass.setText(set.getString("password"));
                    pass.setEditable(true);
                    
                    String r=set.getString("role");
                    if(r.equals("admin"))
                        role.setSelectedIndex(0);
                    else
                        role.setSelectedIndex(1);
                    role.setEnabled(true);
                    
                    eid.setEditable(false);
                    fetch.setEnabled(false);
                    update.setEnabled(true);
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Invalid id", "Error",JOptionPane.ERROR_MESSAGE);
                    eid.setText("");}
            } catch (SQLException exception) {exception.printStackTrace();}
            break;
            
         case "Update" :
             String empname=name.getText();
             String empemail=email.getText();
             String empmob=mob.getText();
             String emppass=pass.getText();
             String emprole;
             if(role.getSelectedIndex()==0)
                 emprole="admin";
             else
                 emprole="employee";
            String query="Update register set name = ?,email = ?,password = ?,role = ?,mobileno = ? where email = ?";
             try (Connection c=DBConnect.getConnection();
                  PreparedStatement ps=c.prepareStatement(query);){
                 ps.setString(1, empname);
                 ps.setString(2, empemail);
                 ps.setString(3, emppass);
                 ps.setString(4, emprole);
                 ps.setString(5, empmob);
                 ps.setString(6, eid.getText());
                 int i=ps.executeUpdate();
                 if(i>0){
                     JOptionPane.showMessageDialog(rootPane, "Details Updated Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                     this.setVisible(false);
                     new EditEmployee();
                     this.dispose();
                 }
                 else{
                     JOptionPane.showMessageDialog(rootPane, "Could not update details","Error",JOptionPane.ERROR_MESSAGE);
                 }
                 
             } catch (SQLException exception) {exception.printStackTrace();}
             break;
             
         case "Cancel":
             this.setVisible(false);
             this.dispose();
             break;
             
         case "View All":
             new EmployeeDetails();
             break;
        
        }
        
    }
    
    public static void main(String[] args) {
        new EditEmployee();
    }
    
}
