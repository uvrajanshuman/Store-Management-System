/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.admin;
import store.management.Item;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import javax.swing.border.Border;
import store.management.DBConnect;
import store.management.Properties;

/**
 *
 * @author ANSHUMAN
 */
public class AddItem extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,find;
    JTextField t1,t2,t3,t4,t5;
    JComboBox comboBox;
    JTextArea desc;
    JButton b1,b2,b3,b4;
    
    //flag to check if item already exists
    boolean found=false;
    
    //for image
    File file;
    
    Item item;
    
           //ItemCategory
      String category[]={"Beverages","Bread/Bakery","Cleaners","Dairy",
           "Frozen Foods","Personal Care","Stationory","Vegetables","Others"};
       
    
    public AddItem(){
        ImageIcon icon14=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon14.jpg"));
        Image image14=icon14.getImage().getScaledInstance(900, 800,Image.SCALE_DEFAULT);
       JLabel background=new JLabel(new ImageIcon(image14));
       background.setBounds(0,0,900,800);
       this.add(background);
       
       //ItemId
       l1=new JLabel("Item Id :");
       l1.setBounds(50,100,200,30);
       l1.setFont(Properties.getFont());
       background.add(l1);
       
       t1=new JTextField();
       t1.setBounds(200,100,200,30);
       //adding key listener to check if item already exists
       t1.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
                String query="select * from items where item_id='"+t1.getText()+"'";
                try(Connection c=DBConnect.getConnection();
                        Statement stmt=c.createStatement();) {
                    ResultSet set=stmt.executeQuery(query);
                    if(set.next()){
                        found=true;
                    //getting up data
                    item=new Item();
                    item.setItem_id(set.getString("item_id"));
                    item.setItem_name(set.getString("item_name"));
                    item.setItem_price(set.getString("item_price"));
                    item.setItem_category(set.getString("item_category"));
                    item.setItem_desc(set.getString("item_desc"));
                    item.setItem_quantity(set.getString("item_quantity"));
                    item.setItem_image(set.getBytes("item_image"));
                    //setting up data to feilds
                    t1.setText(item.getItem_id());
                    t2.setText(item.getItem_name());
                    t3.setText(item.getItem_price());
                    t4.setText(item.getItem_quantity());
                    comboBox.setSelectedItem(item.getItem_category());
                    desc.setText(item.getItem_desc());
                    //setting image on label
                    Image img = Toolkit.getDefaultToolkit().createImage(item.getItem_image());
                    img=img.getScaledInstance(l8.getWidth(), l8.getHeight(),Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(img);
                    l8.setIcon(icon);
                    }
               else{found=false;}
                     b1.setEnabled(!found);
                } catch (SQLException exception) {exception.printStackTrace();}   
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
       });
       background.add(t1);
       
       
       //ItemName
       l2=new JLabel("Item Name :");
       l2.setBounds(50,170,200,30);
       l2.setFont(Properties.getFont());
       background.add(l2);
       
       t2= new JTextField();
       t2.setBounds(200,170,200,30);
       //t2.setOpaque(false);
       background.add(t2);
       
       //ItemPrice
       l3=new JLabel("Item Price :");
       l3.setBounds(50,240,200,30);
       l3.setFont(Properties.getFont());
       background.add(l3);
       
       t3= new JTextField();
       t3.setBounds(200,240,200,30);
       //t3.setOpaque(false);
       background.add(t3);
       

       //Item category
       l4=new JLabel("Item Category :");
       l4.setBounds(50,310,200,30);
       l4.setFont(Properties.getFont());
       background.add(l4);
       
       comboBox= new JComboBox(category);
       comboBox.setBounds(200,310,200,30);
       background.add(comboBox);
       
       //Item Description
       l5=new JLabel("Item Description :");
       l5.setBounds(50,380,200,30);
       l5.setFont(Properties.getFont());
       background.add(l5);
       
       desc=new JTextArea();
       desc.setBounds(220,390,250,100);
       //desc.setOpaque(false);
       Border border= BorderFactory.createLineBorder(Color.BLACK,1);
       desc.setBorder(border);
       background.add(desc);
       
       //net Quantity
       l6=new JLabel("Net Quantity :");
       l6.setBounds(50,520,200,30);
       l6.setFont(Properties.getFont());
       background.add(l6);
       
       t4=new JTextField();
       t4.setBounds(200,520,200,30);
      // t4.setOpaque(false);
       background.add(t4);
       
       //select image
       l7=new JLabel("Select Image :");
       l7.setBounds(500,100,200,30);
       l7.setFont(Properties.getFont());
       background.add(l7);
       
       b1=new JButton("click to choose image");
       b1.setBounds(650,100,200,30);
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
       b1.addActionListener(this);
       background.add(b1);
       
       ImageIcon icon15=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon15.png"));
       Image image15= icon15.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
       l8=new JLabel(new ImageIcon(image15));
       l8.setBounds(600,210,150,150);
       background.add(l8);
       
       //add
       b2=new JButton("Add item");
       b2.setBounds(50,650,200,30);
       b2.setBackground(Color.BLACK);
       b2.setForeground(Color.white);
       b2.addActionListener(this);
       background.add(b2);
       
       //clear
       b3=new JButton("Clear All");
       b3.setBounds(300,650,200,30);
       b3.setBackground(Color.BLACK);
       b3.setForeground(Color.WHITE);
       b3.addActionListener(this);
       background.add(b3);
       
       //cancel
       b4=new JButton("Cancel");
       b4.setBounds(550,650,200,30);
       b4.setBackground(Color.BLACK);
       b4.setForeground(Color.WHITE);
       b4.addActionListener(this);
       background.add(b4);
        
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("AddItem");
        this.setTitle("Add Item");
        this.setIconImage(new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon9.png")).getImage());
        this.setSize(900,800);
        this.setVisible(true);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg=e.getActionCommand();
        //choose image
        switch(msg){
            
        case "click to choose image":
            //File Chooser to select file
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.showOpenDialog(rootPane);
            //to get selected file
            file=fileChooser.getSelectedFile();
            //prints the path of chooseen file
            //System.out.println(file);
            
            //setting icon onto label
            Image ic=new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(l8.getWidth(),l8.getHeight(), Image.SCALE_DEFAULT);
            ImageIcon imageIcon=new ImageIcon(ic);
            l8.setIcon(imageIcon);
            break ;
            
        case "Add item":
            //if item found in database
            String query;
            FileInputStream fis=null;
            if (found==true) 
                query="update items set item_id=?,item_name=?,item_price=?,item_category=?,item_desc=?,item_quantity=? where item_id ='"+t1.getText()+"'";
            else{
                query="insert into items values(?,?,?,?,?,?,?)";
                //if no image is choosen
                if(file==null){JOptionPane.showMessageDialog(rootPane, "Select Image","Error",JOptionPane.ERROR_MESSAGE);}
                else{
                    //image is choosen
                    try {
                        fis=new FileInputStream(file);
                    } catch (Exception exception) {exception.printStackTrace();}
                }
            }
            try (Connection c= DBConnect.getConnection();
                 PreparedStatement ps=c.prepareStatement(query);){
                     //setting up values
                    ps.setString(1, t1.getText());
                    ps.setString(2, t2.getText());
                    ps.setString(3, t3.getText());
                    ps.setString(4, (String)comboBox.getSelectedItem());
                    ps.setString(5, desc.getText());
                    if(found==true){
                        //setting up quantity if item is found
                        int quantity=Integer.parseInt(t4.getText());
                        quantity+=Integer.parseInt(item.getItem_quantity());
                        ps.setString(6, Integer.toString(quantity));
                    }else{
                        //item not found
                        ps.setString(6, t4.getText());
                        ps.setBinaryStream(7, fis,fis.available());
                    }
                     int i=ps.executeUpdate();
                    if(i>0){
                    JOptionPane.showMessageDialog(rootPane, "Item Added Successfully");
                        new AddItem();
                        this.setVisible(false);
                        this.dispose(); 
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Item not added due to some error","Error",JOptionPane.ERROR_MESSAGE);
                    }
                
            } catch (Exception exception) {exception.printStackTrace();}
            break;
            
        case "Clear All":
            this.setVisible(false);
            new AddItem();
            this.dispose();
            break;
            
        case "Cancel":
            this.setVisible(false);
            this.dispose();
            break;
        
        }
        //last commented
//        if(e.getSource()==b1){
//            //File chooser to select file
//            JFileChooser fileChooser =new JFileChooser();
//            fileChooser.showOpenDialog(rootPane);
//            
//            //to get path of selected file
//            file=fileChooser.getSelectedFile();
//            //print path of choosen file
//            //System.out.println(file);
//            
//            Image ic=new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(l8.getWidth(), l8.getHeight(),Image.SCALE_DEFAULT);
//            ImageIcon imageIcon=new ImageIcon(ic);
//            l8.setIcon(imageIcon);
//        }
//        else if(e.getSource()==b2){
//            //Image insertion
//            if(file==null){JOptionPane.showMessageDialog(rootPane, "Select Image","Error",JOptionPane.ERROR_MESSAGE);}
//            else{
//                FileInputStream fis=null;
//                try {
//    //                if(file==null){
//    //                    file=new File("store//management//icons//icon15.png");
//    //                    fis=new FileInputStream(file);
//    //                    
//    //                }
//    //                else
//                        fis=new FileInputStream(file);
//                } catch (Exception exception) { exception.printStackTrace();}
//
//                //adding items
//                String query;
//
//                try (Connection c=DBConnect.getConnection();){
//                    //if(item==null)
//                        query="insert into items values(?,?,?,?,?,?,?)";
//    //                 else
//    //                    query="update items set item_id=?,item_name=?,item_price=?,item_category=? "
//    //                        + "item_desc=?,item_quantity=?,item_image=? where item_id ='"+item.getItem_id()+"'";
//                    PreparedStatement ps=c.prepareStatement(query);
//                    //setting up values
//                    ps.setString(1, t1.getText());
//                    ps.setString(2, t2.getText());
//                    ps.setString(3, t3.getText());
//                    ps.setString(4, (String)comboBox.getSelectedItem());
//                    ps.setString(5, desc.getText());
//                    //setting quantity
//    //                int quantity=Integer.parseInt(t4.getText());
//    //                    quantity+=(item==null)?0:Integer.parseInt(item.getItem_quantity());
//    //                ps.setString(6, Integer.toString(quantity));
//                    ps.setString(6, t4.getText());
//                    //setting image
//                    ps.setBinaryStream(7, fis,fis.available());
//
//                    int i=ps.executeUpdate();
//                    if(i>0){
//                    JOptionPane.showMessageDialog(rootPane, "Item Added Successfully");}
//                    else{
//                        JOptionPane.showMessageDialog(rootPane, "Item not added due to some error","Error",JOptionPane.ERROR_MESSAGE);
//                    }
//
//                } catch (Exception exception) {}  }
//        }
//        else if(e.getSource()==b3){
//            this.setVisible(false);
//            new AddItem();
//            this.dispose();
//        }
//        else if(e.getSource()==b4){
//            this.setVisible(false);
//            this.dispose();
//        }
        
    }
    
    public static void main(String[] args) {
        new AddItem();
    }

   
//   
//    @Override
//    public void keyReleased(KeyEvent e) {
//        String text=t1.getText();
//        try(Connection c=DBConnect.getConnection();
//            Statement stmt=c.createStatement();
//            ResultSet set=stmt.executeQuery("Select * from items where item_id= '"+text+"'");) {
//            
//            if(set.next()){
//                //getting up data
//                item=new Item();
//                item.setItem_id(set.getString("item_id"));
//                item.setItem_name(set.getString("item_name"));
//                item.setItem_price(set.getString("item_price"));
//                item.setItem_category(set.getString("item_category"));
//                item.setItem_desc(set.getString("item_desc"));
//                item.setItem_quantity(set.getString("item_quantity"));
//                item.setItem_image(set.getBytes("item_image"));
//                //setting up data to feilds
//                t2.setText(item.getItem_name());
//                t3.setText(item.getItem_price());
//                comboBox.setSelectedItem(item.getItem_category());
//                desc.setText(item.getItem_desc());
//                //setting image on label
//                Image img = Toolkit.getDefaultToolkit().createImage(item.getItem_image());
//                img=img.getScaledInstance(l8.getWidth(), l8.getHeight(),Image.SCALE_DEFAULT);
//                ImageIcon icon = new ImageIcon(img);
//                l8.setIcon(icon);
//            }
//            
//        } catch (SQLException exception) {exception.printStackTrace();}
//       
//    }
}
