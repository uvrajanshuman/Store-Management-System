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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import store.management.DBConnect;
import store.management.Properties;

/**
 *
 * @author ANSHUMAN
 */
public class EditItem extends JFrame implements ActionListener{
    
     JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5;
    JComboBox comboBox;
    JTextArea desc;
    JButton b1,b2,b3,b4;
    JTable table;
    
    //for image
    File file=null;
    
    Item item;
    
           //ItemCategory
      String category[]={"Beverages","Bread/Bakery","Cleaners","Dairy",
           "Frozen Foods","Personal Care","Stationory","Vegetables","Others"};
      
      Object []columndata={ "Sl No.", "Item_id", "Item_name", "Item_price","Item_category","Item_quantity"};
    Object [][]rowdata;
       
    
    public EditItem(){
        ImageIcon icon14=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon15.jpg"));
        Image image14=icon14.getImage().getScaledInstance(900, 800,Image.SCALE_DEFAULT);
        l7=new JLabel(icon14);
        //l7.setBounds(500,0,900,800);
       JLabel background=new JLabel();
       background.setBounds(0,0,1400,800);
       background.setBackground(Color.WHITE);
       this.add(background);
       
       //Table
       DefaultTableModel dTableModel=new DefaultTableModel(rowdata,columndata);
       int i=0;
            try(Connection con=DBConnect.getConnection();
                Statement stmt=con.createStatement();
                ResultSet set =stmt.executeQuery("select * from items");) {
                 Object[]temprow;
                while(set.next()){
                   temprow=new Object[]{++i,set.getString("item_id"),set.getString("item_name"),
                       set.getString("item_price"),set.getString("item_category"),set.getString("item_quantity")};
                          
                   dTableModel.addRow(temprow);
                }
            
        } catch (SQLException e) {e.printStackTrace();}
            
            //to make table uneditable
            table=new JTable(dTableModel){
        private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column) {                
                return false;               
        }
        };
            table.setRowHeight(table.getRowHeight()+10);
            table.setFont(new Font("serif",Font.PLAIN,15));
           
            
            //setting up sizes of columna
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            TableColumn col1 = table.getColumnModel().getColumn(0);
            col1.setPreferredWidth(50);
            TableColumn col2 = table.getColumnModel().getColumn(1);
            col2.setPreferredWidth(100);
            TableColumn col3 = table.getColumnModel().getColumn(2);
            col3.setPreferredWidth(150);
            TableColumn col4 = table.getColumnModel().getColumn(3);
            col4.setPreferredWidth(100);
            TableColumn col5 = table.getColumnModel().getColumn(4);
            col5.setPreferredWidth(148);
           TableColumn col6 = table.getColumnModel().getColumn(5);
            col6.setPreferredWidth(100);

        
       JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20,50,650,500);
        this.add(sp);
        
        //adding mouseListener
        table.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e) {
               int rowselect=table.getSelectedRow();
               String itemid=(String)table.getValueAt(rowselect, 1);
               try(Connection c=DBConnect.getConnection();
            Statement stmt=c.createStatement();
            ResultSet set=stmt.executeQuery("Select * from items where item_id= '"+itemid+"'");) {
            
            if(set.next()){
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
            
        } catch (SQLException exception) {exception.printStackTrace();}
        }});

        
        
        
       
       //ItemId
       l1=new JLabel("Item Id :");
       l1.setBounds(700,100,200,30);
       l1.setFont(Properties.getFont());
       background.add(l1);
       
       t1=new JTextField();
       t1.setBounds(850,100,200,30);
      // t1.setOpaque(false);
            //adding key listener
     //  t1.addKeyListener(this);
       background.add(t1);
       
       //ItemName
       l2=new JLabel("Item Name :");
       l2.setBounds(700,170,200,30);
       l2.setFont(Properties.getFont());
       background.add(l2);
       
       t2= new JTextField();
       t2.setBounds(850,170,200,30);
       //t2.setOpaque(false);
       background.add(t2);
       
       //ItemPrice
       l3=new JLabel("Item Price :");
       l3.setBounds(700,240,200,30);
       l3.setFont(Properties.getFont());
       background.add(l3);
       
       t3= new JTextField();
       t3.setBounds(850,240,200,30);
       //t3.setOpaque(false);
       background.add(t3);
       

       //Item category
       l4=new JLabel("Item Category :");
       l4.setBounds(700,310,200,30);
       l4.setFont(Properties.getFont());
       background.add(l4);
       
       comboBox= new JComboBox(category);
       comboBox.setBounds(850,310,200,30);
       background.add(comboBox);
       
       //Item Description
       l5=new JLabel("Item Description :");
       l5.setBounds(700,380,200,30);
       l5.setFont(Properties.getFont());
       background.add(l5);
       
       desc=new JTextArea();
       desc.setBounds(870,390,250,100);
       //desc.setOpaque(false);
       //Border border= BorderFactory.createLineBorder(Color.BLACK,1);
       //desc.setBorder(border);
       background.add(desc);
       
       //net Quantity
       l6=new JLabel("Net Quantity :");
       l6.setBounds(700,520,200,30);
       l6.setFont(Properties.getFont());
       background.add(l6);
       
       t4=new JTextField();
       t4.setBounds(850,520,200,30);
      // t4.setOpaque(false);
       background.add(t4);
       
       //select image
       //l7=new JLabel("Select Image :");
//       l7.setBounds(500,100,200,30);
//       l7.setFont(Properties.getFont());
//       background.add(l7);
       
       b1=new JButton("click to choose image");
       b1.setBounds(1150,100,200,30);
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
       b1.addActionListener(this);
       background.add(b1);
       
       ImageIcon icon15=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon15.png"));
       Image image15= icon15.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
       l8=new JLabel(new ImageIcon(image15));
       l8.setBounds(1150,200,150,150);
       background.add(l8);
       
       //add
       b2=new JButton("Add item");
       b2.setBounds(650,650,200,30);
       b2.setBackground(Color.BLACK);
       b2.setForeground(Color.white);
       b2.addActionListener(this);
       background.add(b2);
       
       //clear
       b3=new JButton("Update Item");
       b3.setBounds(900,650,200,30);
       b3.setBackground(Color.BLACK);
       b3.setForeground(Color.WHITE);
       b3.addActionListener(this);
       background.add(b3);
       
       //cancel
       b4=new JButton("Cancel");
       b4.setBounds(1150,650,200,30);
       b4.setBackground(Color.BLACK);
       b4.setForeground(Color.WHITE);
       b4.addActionListener(this);
       background.add(b4);
        
        this.setBackground(Color.CYAN);
        this.setLayout(null);
        this.setTitle("Edit Item");
        ImageIcon iconImage=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon10.png"));
        this.setIconImage(iconImage.getImage());
        this.setSize(1400,800);
        this.setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg=e.getActionCommand();
        switch (msg){
            case "Add item":
                new AddItem();
                this.setVisible(false);
                this.dispose();
                break;
            case "Update Item":
                System.out.println(file);
                FileInputStream fis=null;
                try {
                if(file!=null)
                    fis=new FileInputStream(file);} catch (Exception exception) {}
                String query;
                if(file==null)
                query="update items set item_id=?,item_name=?,item_price=?,item_category=?,item_desc=?,item_quantity=? where item_id ='"+t1.getText()+"'";
                else
                query="update items set item_id=?,item_name=?,item_price=?,item_category=?,item_desc=?,item_quantity=?,item_image=? where item_id ='"+t1.getText()+"'";
                try (Connection c=DBConnect.getConnection();){
                    PreparedStatement ps=c.prepareStatement(query);
                    //setting up values
                    ps.setString(1, t1.getText());
                    ps.setString(2, t2.getText());
                    ps.setString(3, t3.getText());
                    ps.setString(4, (String)comboBox.getSelectedItem());
                    ps.setString(5, desc.getText());
                    ps.setString(6, t4.getText());
                    if(file!=null)
                    ps.setBinaryStream(7, fis,fis.available());

                    int i=ps.executeUpdate();
                    if(i>0){
                    JOptionPane.showMessageDialog(rootPane, "Item Updated Successfully");
                    new EditItem();
                    this.setVisible(false);
                    this.dispose();}
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Item not added due to some error","Error",JOptionPane.ERROR_MESSAGE);
                    }

                }
                catch(Exception exception){}
                break;
            case "click to choose image":
                JFileChooser fileChooser=new JFileChooser();
                fileChooser.showOpenDialog(rootPane);
                file=fileChooser.getSelectedFile();
                 Image ic=new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(l8.getWidth(), l8.getHeight(),Image.SCALE_DEFAULT);
                ImageIcon imageIcon=new ImageIcon(ic);
                l8.setIcon(imageIcon);
                break;
            case "Cancel":
                this.setVisible(false);
                this.dispose();
        }
    }
    
    public static void main(String[] args) {
        new EditItem();
    }
  
}
