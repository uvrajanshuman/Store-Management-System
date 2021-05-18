/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//view Employees;
package store.management.admin;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import store.management.Properties;
import store.management.DBConnect;

/**
 *
 * @author ANSHUMAN
 */
public class EmployeeDetails extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4;
    JTextField t1;
    JTable table;
    JButton add,update,delete;
    
    String []attributes={"Name","Email","Mobile No.","Role","Password"};
    String [][]rowdata=new String[10][5];
    int i=0,j=0;
    public EmployeeDetails() {
         l4=new JLabel("Employees:");
         l4.setBounds(20,10,200,30);
         l4.setFont(new Font("sansserif",Font.ITALIC,25));
         this.add(l4);
       
        try(Connection c=DBConnect.getConnection();
             Statement stmt=c.createStatement();) {
            ResultSet set=stmt.executeQuery("Select * from register");
            while(set.next()){
            rowdata[i][j++]=set.getString("name");
            rowdata[i][j++]=set.getString("email");
            rowdata[i][j++]=set.getString("mobileno");
            rowdata[i][j++]=set.getString("role");
            rowdata[i][j++]=set.getString("password");
            i++;
            j=0;}
        } catch (Exception e) {
        }
        
        table=new JTable(rowdata,attributes);
        table.setEnabled(false);
        table.setRowHeight(table.getRowHeight()+10);
        table.setFont(new Font("serif",Font.PLAIN,15));
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20,50,950,200);
        this.add(sp);
        
        //delete
        l1=new JLabel("Enter Employee id to Delete");
        l1.setBounds(50, 300, 300, 30);
        l1.setFont(Properties.getFont());
        this.add(l1);
        
        t1=new JTextField();
        t1.setBounds(300,300,150,30);
        this.add(t1);
        
        delete=new JButton("Delete");
        delete.setBounds(500,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        this.add(delete);
        
        //add Employee
        l2=new JLabel("Add New Employee");
        l2.setBounds(50,370,300,30);
        l2.setFont(Properties.getFont());
        this.add(l2);
        
        add=new JButton("Add");
        add.setBounds(300,370,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        this.add(add);
        
        //update
        l3=new JLabel("Update Employee Details");
        l3.setBounds(50,440,300,30);
        l3.setFont(Properties.getFont());
        this.add(l3);
        
        update=new JButton("Update");
        update.setBounds(300,440,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        this.add(update);
        
        
        ImageIcon icon13=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon13.jpg"));
        Image image13=icon13.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        
        JLabel background=new JLabel(icon13);
        background.setBounds(400,150,600,600);
        this.add(background);
        
        getContentPane().setBackground(Color.WHITE);
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon14.png"));
        this.setIconImage(icon.getImage());
        this.setTitle("Employee Details");
        this.setLayout(null);
        this.setSize(1000,600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==delete){
            String email=t1.getText();
            try (Connection c=DBConnect.getConnection();
                    Statement stmt=c.createStatement();){
                
                    int i=stmt.executeUpdate("delete from register where email ='"+email+"'");
                    if(i>0){
                        JOptionPane.showMessageDialog(rootPane, "Employee Deleted", "Success",JOptionPane.INFORMATION_MESSAGE);
                        new EmployeeDetails();
                        this.setVisible(false);
                        this.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Invalid Email id","Error",JOptionPane.ERROR_MESSAGE);
                        t1.setText("");
                    }
            } catch (SQLException exception) {exception.printStackTrace();}
        }
        else if(e.getSource()==add){
            new AddEmployee();
        }
        else if(e.getSource()==update){
            new EditEmployee();
        }
    }
    
    public static void main(String[] args) {
        new EmployeeDetails();
    }
    
}
