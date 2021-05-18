/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.employee;

import java.util.*;
import java.util.Date;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import store.management.DBConnect;
import store.management.Item;
import store.management.Properties;

/**
 *
 * @author ANSHUMAN
 */
public class Payment extends JFrame implements ActionListener,KeyListener{
    
    JLabel l1,l2,l3,l4,l5,l7;
    JTextField phone,name;
    JTextArea bill;
    JComboBox comboBox;
    JButton pay,cancel,back;
    JPanel p1;
    HashMap <String,Item>billcart;
    String cashier;
    
    double totalprice;
    
    boolean payment_done=false;
    boolean customer_found=false;
    
    public Payment(HashMap <String,Item>billcart,String cashier){
        
        this.billcart=billcart;
        this.cashier=cashier;
        
        l7=new JLabel("Cashier :"+cashier);
        l7.setBounds(900,20,300,30);
        l7.setFont(Properties.getFont());
        this.add(l7);
        
        l1=new JLabel("Phone No. :");
        l1.setBounds(50,100,200,40);
        l1.setFont(Properties.getFont());
        this.add(l1);
        
        phone=new JTextField();
        phone.setBounds(250,100,200,30);
        phone.setFont(Properties.getFont());
        phone.addKeyListener(this);
        this.add(phone);
        
        l2=new JLabel("Name :");
        l2.setBounds(50,170,200,40);
        l2.setFont(Properties.getFont());
        this.add(l2);
        
        name=new JTextField();
        name.setBounds(250,170,200,30);
        name.setFont(Properties.getFont());
        this.add(name);
        
        
        l3=new JLabel("Total Bill:");
        l3.setBounds(50,240,200,30);
        l3.setFont(Properties.getFont());
        this.add(l3);
        
        l4=new JLabel("__________");
        l4.setBounds(250,240,200,30);
        l4.setFont(Properties.getFont());
        this.add(l4);
        
        l5=new JLabel("Payment:");
        l5.setBounds(50,310,200,30);
        l5.setFont(Properties.getFont());
        this.add(l5);
        
        String paymethod[]={"Cash","Card","UPI"};
        comboBox=new JComboBox(paymethod);
        comboBox.setBounds(250,310,200,30);
        this.add(comboBox);
        
       // p1 = new JPanel();
        bill=new JTextArea(40,15);
        bill.setBorder(BorderFactory.createTitledBorder("Bill"));
        //bill.setEditable(false);
        bill.setFont(new Font("Senserif",Font.ITALIC,18));
         JScrollPane jsp=new JScrollPane(bill);
         jsp.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
         jsp.setBounds(600,60,500,600);
         this.add(jsp);
         billprint();
         

        //p1.add(jsp,"Center");
        
        back=new JButton("Back");
        back.setBounds(600,700,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        this.add(back);
        
        pay=new JButton("Pay");
        pay.setBounds(800,700,100,30);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        this.add(pay);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(1000,700,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        this.add(cancel);
        
        ImageIcon background=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//payment1.jpg"));
        Image backgroundImage=background.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        JLabel back=new JLabel(new ImageIcon(backgroundImage));
        back.setBounds(100,350,400,400);
        this.add(back);
        
        this.setLayout(null);
        this.setSize(1200,820);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Payment(null,"Anshuman Yuvraj");
    }

    private void billprint() {
        
        bill.setText("\t\t Bill:\n");
        //To add date and time
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        Date date = new Date();  
        bill.append("\n\tDate: "+formatter.format(date)); 
        bill.append("\n\tCashier: "+cashier); 
        bill.append("\n\tCustomer Name :"+name.getText());
        bill.append("\n\t Mobile No. :"+phone.getText());
        bill.append("\n----------------------------------------------------------------------------------");
        //bill.append("\n___________________________________");
        bill.append("\nSl.No.   Item Name   Item Price   Item Quantity   Total Price");
        bill.append("\n----------------------------------------------------------------------------------");
        int i=1;
        for (Map.Entry<String, Item> entry : billcart.entrySet()) {
            Item val = entry.getValue();
            bill.append("\n "+i+++".       "+val.getItem_name()+"\t");
            bill.append(val.getItem_price()+"\t");
            bill.append(val.getItem_Desired_quantity()+"\t");
            double price=Integer.parseInt(val.getItem_Desired_quantity())*Double.parseDouble(val.getItem_price());
            totalprice+=price;
            bill.append(price+"");
            
        }
        l4.setText(String.valueOf(totalprice));
        bill.append("\n----------------------------------------------------------------------------------");
       // bill.append("___________________________________");
        bill.append("\n\t\t Total:"+totalprice);
        bill.append("\n\t\tThank You");
        bill.append("\n\t\tPlease visit again");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String msg=e.getActionCommand();
       switch(msg){
           case "Back":
               new Cart(billcart, cashier);
               this.setVisible(false);
               this.dispose();
               break;
           case "Pay":
               payment_done=true;
               if(payment_done){
                   //adding customer if it is not pre-existing;
                   if(!customer_found){
                       String query="insert into customers values(?,?)";
                       try(Connection c=DBConnect.getConnection();
                           PreparedStatement psstmt=c.prepareStatement(query)) {
                           psstmt.setString(1,name.getText());
                           psstmt.setString(2, phone.getText());
                           int i=psstmt.executeUpdate();
                       } catch (Exception exception) {exception.printStackTrace();}
                   }
                   
                   //updating item quantity;
                   for (Map.Entry<String, Item> entry : billcart.entrySet()) {
                       Item val = entry.getValue();
                       int quantity_left=Integer.valueOf(val.getItem_quantity())-Integer.valueOf(val.getItem_Desired_quantity());
                       String query="update items set item_quantity='"+quantity_left+"' where item_id='"+val.getItem_id()+"'";
                        try(Connection c=DBConnect.getConnection();
                           Statement stmt=c.createStatement();){
                            int i=stmt.executeUpdate(query);  
                        } catch (Exception exception) {exception.printStackTrace();}
                   }
                   
                   //inseting into shopping details table;
                   //creating arraylist of shopping details
                   
                   HashMap<String,ArrayList>hm=new HashMap<>();
                   ArrayList<String>al;
                   for (Map.Entry<String, Item> entry : billcart.entrySet()) {
                       al=new ArrayList<>();
                       Item val = entry.getValue();
                       al.add(val.getItem_name());
                       String price=val.getItem_price();
                       al.add(price);
                       String quantity=val.getItem_Desired_quantity();
                       al.add(quantity);
                       double totalprice=Integer.valueOf(quantity)*Double.valueOf(price);
                       al.add(String.valueOf(totalprice));
                       hm.put(val.getItem_id(),al);
                   }
                   //formatting date and time
                   Date d=new Date();
                   SimpleDateFormat sdf1=new SimpleDateFormat("dd/mm/yyyy");
                   String date1=sdf1.format(d);
                   
                   SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
                   String time1=sdf2.format(d);
                   try(Connection c=DBConnect.getConnection();
                           PreparedStatement ps=c.prepareStatement("insert into shopping_history values(?,?,?,?,?,?,?,?)")){
                       ps.setString(1, name.getText());
                       ps.setString(2, phone.getText());
                       ps.setString(3, hm.toString());
                       ps.setString(4, String.valueOf(totalprice));
                       ps.setString(5, (String) comboBox.getSelectedItem());
                       ps.setString(6, date1);
                       ps.setString(7, time1);
                       ps.setString(8, cashier);
                        int i= ps.executeUpdate();
                   } catch (SQLException exception) {exception.printStackTrace();}
                   
                        JOptionPane.showMessageDialog(rootPane,"Payment Successfull");
                       
                        this.setVisible(false);
                        this.dispose();
               }
               break;
           case "Cancel":
               int i=JOptionPane.showConfirmDialog(rootPane,"Are you sure you want to cancel the transaction","Cancel Transaction",JOptionPane.YES_NO_OPTION);
               if(i==0){
               this.setVisible(false);
               this.dispose();
               }
               break;
       }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String mobno=phone.getText();
        if(mobno.length()==10){
        try(Connection c=DBConnect.getConnection();
                Statement stmt=c.createStatement();
                ){
            
            ResultSet set=stmt.executeQuery("Select * from customers where mobno ='"+mobno+"'");
            if(set.next()){
                name.setText(set.getString("name"));
                customer_found=true;
            }
            else{
                name.setText("");
                customer_found=false;
            }
        }catch(SQLException exception){exception.printStackTrace();}}
    }

   
}
