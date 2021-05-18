/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.employee;

import java.util.*;
import java.sql.*;
import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import store.management.DBConnect;


import store.management.Properties;
import store.management.Item;

/**
 *
 * @author ANSHUMAN
 */
public class StartBilling extends JFrame implements ActionListener, KeyListener, ItemListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,title;
    JTextField id;
    JTextArea desc;
    JComboBox comboBox;
    JButton b1,b2,b3,b4;
    
    Item item;
    String cashier;
    
    //boolean found = false;
    
    //default item image
    ImageIcon icon15=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon15.png"));
    Image defaultItemImage= icon15.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
    
    //
    HashMap <String,Item> billcart;

    public StartBilling(HashMap<String,Item>billcart,String name) {
        
        cashier=name;
        this.billcart=billcart;
        
        title=new JLabel("Billing :");
        title.setBounds(50,20,200,40);
        title.setFont(new Font("serif",Font.ITALIC,30));
        this.add(title);
        
        //cashier name
        l1=new JLabel("Cashier: "+cashier);
        l1.setBounds(800,20,500,30);
        l1.setFont(Properties.getFont());
        this.add(l1);
        
        //Item id
        l2=new JLabel("Item Id :");
        l2.setBounds(50,100,200,30);
        l2.setFont(Properties.getFont());
        this.add(l2);
        
        id=new JTextField();
        id.setBounds(250,100,200,30);
        this.add(id);
        id.addKeyListener(this);
        
        //Item Name
        l3=new JLabel("Item Name :");
        l3.setBounds(50,170,200,30);
        l3.setFont(Properties.getFont());
        this.add(l3);
        
        l4=new JLabel("____________________");
        l4.setBounds(250,170,300,30);
        l4.setFont(Properties.getFont());
        this.add(l4);
        
        //Item Price
        l5=new JLabel("Item Price :");
        l5.setBounds(50,240,200,30);
        l5.setFont(Properties.getFont());
        this.add(l5);
        
        l6=new JLabel("____________________");
        l6.setBounds(250,240,300,30);
        l6.setFont(Properties.getFont());
        this.add(l6);
        
        //Item category
        l7=new JLabel("Item Category :");
        l7.setBounds(50,310,200,30);
        l7.setFont(Properties.getFont());
        this.add(l7);
        
        l8=new JLabel("____________________");
        l8.setBounds(250,310,300,30);
        l8.setFont(Properties.getFont());
        this.add(l8);
        
        //Item Description
        l9=new JLabel("Item Description :");
        l9.setBounds(50,380,200,30);
        l9.setFont(Properties.getFont());
        this.add(l9);
        
        desc=new JTextArea("____________________");
        desc.setBounds(250,380,250,100);
        desc.setFont(Properties.getFont());
        desc.setBackground(new Color(0xccf3ff));
        desc.setEditable(false);
        this.add(desc);
        
        //Item Quantity
        l10=new JLabel("Item Quantity :");
        l10.setBounds(50,510,200,30);
        l10.setFont(Properties.getFont());
        this.add(l10);
        
        Integer arr[]=new Integer[51];
        for(int i=0;i<=50;arr[i++]=Integer.valueOf(i));
        comboBox=new JComboBox(arr);
        comboBox.setBounds(250,510,200,30);
        comboBox.setEnabled(false);
        comboBox.addItemListener(this);
        this.add(comboBox);
        
        //Item Price
        l11=new JLabel("Item Price :");
        l11.setBounds(50,580,200,30);
        l11.setFont(Properties.getFont());
        this.add(l11);
        
        l12=new JLabel("____________________");
        l12.setBounds(250,580,300,30);
        l12.setFont(Properties.getFont());
        this.add(l12);
        
        //Total Price
        l14=new JLabel("Total Price :");
        l14.setBounds(50,650,200,30);
        l14.setFont(Properties.getFont());
        this.add(l14);
        
        l15=new JLabel("____________________");
        l15.setBounds(250,650,300,30);
        l15.setFont(Properties.getFont());
        this.add(l15);
        
        //Item Image
        
        l13=new JLabel(new ImageIcon(defaultItemImage));
        l13.setBounds(900,100,150,150);
        this.add(l13);
        
        //add to cart
        b1=new JButton("Add To Cart");
        b1.setBounds(200,700,200,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setEnabled(false);
        b1.addActionListener(this);
        this.add(b1);
        
        //next
        b2=new JButton("Next");
        b2.setBounds(450,700,200,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        if(billcart==null)
        b2.setEnabled(false);
        b2.addActionListener(this);
        this.add(b2);
        
        //cancel
        b3=new JButton("Cancel");
        b3.setBounds(700,700,200,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        this.add(b3);
        
        //cart
//        b4=new JButton("View Cart");
//        b4.setBounds(350,700,200,30);
//        b4.setBackground(Color.BLACK);
//        b4.setForeground(Color.WHITE);
//        b4.addActionListener(this);
//        if(billcart==null)
//        b4.setEnabled(false);
//        this.add(b4);
        
        //background
        ImageIcon backgroundIcon=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon17.jpg"));
        Image backgrooundImage=backgroundIcon.getImage().getScaledInstance(1000, 800,Image.SCALE_DEFAULT);
        JLabel back=new JLabel(backgroundIcon);
        back.setBounds(80,38,1200,800);
        this.add(back);
        
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1200,820);
        this.getContentPane().setBackground(new Color(0xccf3ff));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    
       public static void main(String[] args) {
        new StartBilling(null,"Anshuman Yuvraj");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg=e.getActionCommand();
        //add to cart
        switch(msg){
            case "Add To Cart":
                Integer quantity=(Integer)comboBox.getSelectedItem();
                item.setItem_Desired_quantity(String.valueOf(comboBox.getSelectedItem()));
                if(Integer.parseInt(item.getItem_quantity())<Integer.parseInt(item.getItem_Desired_quantity())){
                    JOptionPane.showMessageDialog(rootPane, "Quantity exceeds storage","Error",JOptionPane.ERROR_MESSAGE);
                    comboBox.setSelectedIndex(0);
                    break;
                }
               // billcart not initialised
                if(billcart==null)
                    billcart=new HashMap<>();
                
                if(billcart.containsKey(id.getText())){
                Item temp=billcart.get(id.getText());
                int newquantiy=Integer.parseInt(item.getItem_Desired_quantity())+Integer.parseInt(temp.getItem_Desired_quantity());
                if(Integer.parseInt(item.getItem_quantity())< newquantiy){
                    //System.out.println(item.getItem_Desired_quantity()+"  "+item.getItem_quantity());
                    JOptionPane.showMessageDialog(rootPane, "Quantity exceeds storage","Error",JOptionPane.ERROR_MESSAGE);
                    comboBox.setSelectedIndex(0);
                    break;
                }
                temp.setItem_Desired_quantity(String.valueOf(newquantiy));
                billcart.replace(id.getText(), temp);
                }
                else{
                billcart.put(id.getText(), item);
                }
                id.setText("");
                l4.setText("____________________");
                l6.setText("____________________");
                l8.setText("____________________");
                desc.setText("____________________");
                l12.setText("____________________");
                comboBox.setSelectedIndex(0);
                comboBox.setEnabled(false);
                l13.setIcon(new ImageIcon(defaultItemImage));
                l15.setText("____________________");
                //System.out.println(billcart.values());
                JOptionPane.showMessageDialog(rootPane, "Item Added to the cart");
                //b4.setEnabled(true);
                b2.setEnabled(true);
                break;
            case "View Cart":
                if(billcart!=null)
                    new Cart(billcart, cashier);
                break;
            case "Next":
                new Cart(billcart,cashier);
                this.setVisible(false);
                this.dispose();
                break;
            case "Cancel":
                if(billcart!=null){
                    int ans=JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to cancel","Cart not Empty",JOptionPane.YES_NO_OPTION);
                    if(ans==0){
                        this.setVisible(false);
                        this.dispose();
                    }     
                }
                else{
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
        try (Connection c=DBConnect.getConnection();
             Statement stmt=c.createStatement();
             ResultSet set=stmt.executeQuery("select * from items where item_id='"+id.getText()+"'")){
            
            if(set.next()){
                item=new Item();
                item.setItem_id(set.getString("item_id"));
                item.setItem_name(set.getString("item_name"));
                item.setItem_price(set.getString("item_price"));
                item.setItem_category(set.getString("item_category"));
                item.setItem_desc(set.getString("item_desc"));
                item.setItem_quantity(set.getString("item_quantity"));
                //System.out.println(item.getItem_quantity());
                item.setItem_image(set.getBytes("item_image"));
                
                //setting up quantity availaible in db.
                item.setItem_quantity(set.getString("item_quantity"));
                
                l4.setText(item.getItem_name());
                l6.setText(item.getItem_price());
                l8.setText(item.getItem_category());
                desc.setText(item.getItem_desc());
                l12.setText(item.getItem_price());
                //setting up image on label
                Image img=Toolkit.getDefaultToolkit().createImage(item.getItem_image());
                img=img.getScaledInstance(l13.getWidth(), l13.getHeight(), Image.SCALE_DEFAULT);
                l13.setIcon(new ImageIcon(img));
                comboBox.setEnabled(true);
                
                //setting up price
                Integer quantity=(Integer)comboBox.getSelectedItem();
                String Price=l12.getText();
                double total=quantity*Double.parseDouble(Price);
                l15.setText(String.valueOf(total));
                b1.setEnabled(true);
                b3.setEnabled(true);
            }
            else{
                l4.setText("____________________");
                l6.setText("____________________");
                l8.setText("____________________");
                desc.setText("____________________");
                l12.setText("____________________");
                comboBox.setSelectedIndex(0);
                comboBox.setEnabled(false);
                l13.setIcon(new ImageIcon(defaultItemImage));
                l15.setText("____________________");
                b1.setEnabled(false);
                if(billcart==null)
                b2.setEnabled(false);
               // b4.setEnabled(false);
            }
            
        } catch (SQLException exception) {exception.printStackTrace();}
    }

    //combobox state changed
    @Override
    public void itemStateChanged(ItemEvent e) {
        Integer quantity=(Integer)comboBox.getSelectedItem();
        String Price=l12.getText();
        //Integer quantity=(Integer)comboBox.getSelectedItem();
                if(Integer.parseInt(item.getItem_quantity())<quantity){
                    JOptionPane.showMessageDialog(rootPane, "Quantity exceeds storage","Error",JOptionPane.ERROR_MESSAGE);
                    comboBox.setSelectedIndex(0);
                }
                else if(!Price.equals("____________________")){
            double total=quantity*Double.parseDouble(Price);
            l15.setText(String.valueOf(total));
        
        }
        
    }
    
}
