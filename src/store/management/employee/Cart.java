/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import store.management.Item;
import store.management.Properties;
import store.management.admin.AddItem;

/**
 *
 * @author ANSHUMAN
 */
public class Cart extends JFrame implements ActionListener,MouseListener{
    JTable table;
    JLabel l1,l2,l3,l4,l5,csr;
    JTextArea desc;
    JComboBox comboBox;
    JButton b1,b2,b3,b4,b5;
    
    HashMap<String, Item> billcart;
    String cashier;
    
    Object []columndata={"Sl. No.","Item Id","Item Name","Item Price","Item Quantity","Item Total Price"};
    Object [][]rowdata;
    
    int row;
    
    double totalPrice=0;
    
    public Cart(HashMap <String,Item>billcart,String cashier){
 
        this.billcart=billcart;
        this.cashier=cashier;
        
        JLabel title=new JLabel("Cart :");
        title.setBounds(50,20,200,40);
        title.setFont(new Font("serif",Font.ITALIC,30));
        this.add(title);
        
        //cashier name
        csr=new JLabel("Cashier: "+cashier);
        csr.setBounds(750,20,500,30);
        csr.setFont(Properties.getFont());
        this.add(csr);
        
        //Table
        DefaultTableModel dTempModel=new DefaultTableModel(rowdata,columndata);
        
       
       
        
          table=new JTable(dTempModel){
        private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column) {                
                return false;               
        }
        };
          
        //update Table
        updateTable();
        
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
            col4.setPreferredWidth(150);
            TableColumn col5 = table.getColumnModel().getColumn(4);
            col5.setPreferredWidth(100);
           TableColumn col6 = table.getColumnModel().getColumn(5);
            col6.setPreferredWidth(150);

        
       JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20,80,700,500);
        this.add(sp);
        
        //adding click listener to jtable
        table.addMouseListener(this);
        
        //TotalBill
        l1=new JLabel("Total Bill :");
        l1.setFont(Properties.getFont());
        l1.setBounds(550,610,200,30);
        this.add(l1);
        
        l2=new JLabel("___________");
        l2.setBounds(650,610,200,30);
        l2.setFont(Properties.getFont());
        l2.setText(String.valueOf(totalPrice));
        this.add(l2);
        
        //Item description;
        l3=new JLabel("Item Description :");
        l3.setBounds(750,70,200,30);
        l3.setFont(Properties.getFont());
        this.add(l3);
        
        desc=new JTextArea("");
        desc.setBounds(850,110,250,90);
        desc.setFont(Properties.getFont());
        //desc.setBackground(Color.red);
        this.add(desc);
        
        ImageIcon icon15=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon15.png"));
        Image defaultItemImage= icon15.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        l5=new JLabel(new ImageIcon(defaultItemImage));
        l5.setBounds(850,200,150,150);
        this.add(l5);
        
        //Quantity;
        l4=new JLabel("Item Quantity :");
        l4.setBounds(750,390,300,30);
        l4.setFont(Properties.getFont());
        this.add(l4);
        
        Integer []arr=new Integer[50];
        for(int j=0;j<50;arr[j++]=j);
        comboBox=new JComboBox(arr);
        comboBox.setBounds(950,390,100,30);
        comboBox.setEnabled(false);
        this.add(comboBox);
        
        //update
        b1=new JButton("Update");
        b1.setBounds(800,430,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setEnabled(false);
        b1.addActionListener(this);
        this.add(b1);
        
        //delete
        b2=new JButton("Delete");
        b2.setBounds(950,430,100,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setEnabled(false);
        b2.addActionListener(this);
        this.add(b2);
        
        //Next
        b3=new JButton("Next");
        b3.setBounds(150,700,100,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        this.add(b3);
        
        //cancel
        b4=new JButton("Cancel");
        b4.setBounds(450,700,100,30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        this.add(b4);
        
        //Add item
        b5=new JButton("Add Item");
        b5.setBounds(300,700,100,30);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.white);
        b5.addActionListener(this);
        this.add(b5);
        
        ImageIcon backim=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon18.jpg"));
        Image icon=backim.getImage().getScaledInstance(626, 417, Image.SCALE_DEFAULT);
        JLabel background=new JLabel(new ImageIcon(icon));
        background.setBounds(560,400,626,417);
        this.add(background);
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1200,820);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
   
    @Override
    public void mouseClicked(MouseEvent e) {
        row=table.getSelectedRow();
        String item_id=(String)table.getValueAt(row, 1);
        Item item=billcart.get(item_id);
        Image img=Toolkit.getDefaultToolkit().createImage(item.getItem_image());
        img=img.getScaledInstance(l5.getWidth(), l5.getHeight(), Image.SCALE_DEFAULT);
        l5.setIcon(new ImageIcon(img));
        desc.setText(item.getItem_desc());
        comboBox.setSelectedItem(item.getItem_quantity());
        comboBox.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
     public static void main(String[] args) {
        new Cart(null,"Anshuman Yuvraj");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg=e.getActionCommand();
        switch(msg){
            case "Update":
                String qnty=String.valueOf(comboBox.getSelectedItem());
                String item_id=(String)table.getValueAt(row, 1);
                Item item=billcart.get(item_id);
                 //to check if quantity exceeds the storage
                if(Integer.parseInt(item.getItem_quantity())<Integer.parseInt(qnty)){
                    JOptionPane.showMessageDialog(rootPane, "Quantity exceeds storage","Error",JOptionPane.ERROR_MESSAGE);
                    comboBox.setSelectedIndex(0);
                    break;
                }
                double price=Integer.parseInt(qnty)*Double.parseDouble(item.getItem_price());
                item.setItem_Desired_quantity(qnty);
                billcart.put(item_id, item);
                table.setValueAt(qnty, row,4 );
                table.setValueAt(String.valueOf(price), row, 5);
                //update Total
                updateTotal(); 
                b1.setEnabled(false);
                b2.setEnabled(false);
                comboBox.setEnabled(false);
                break;
            case "Delete":
                String itemid=(String)table.getValueAt(row, 1);
                billcart.remove(itemid);
                //
//                DefaultTableModel dTempModel=(DefaultTableModel)table.getModel();
//                dTempModel.removeRow(row);
                updateTable();
//                new Cart(billcart, cashier);
//                this.setVisible(false);
//                this.dispose();
                break;
            case "Add Item":
                new StartBilling(billcart,cashier);
                this.setVisible(false);
                this.dispose();
                break;
            case "Cancel":
                    int ans=JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to cancel","Cart not Empty",JOptionPane.YES_NO_OPTION);
                    if(ans==0){
                        this.setVisible(false);
                        this.dispose();
                    }
                    break;
             case "Next":
                     new Payment(billcart, cashier);
                     this.setVisible(false);
                     this.dispose();
                     break;
                    
        }
    }

    private void updateTable() {
         int i=0;
         DefaultTableModel dTempModel =(DefaultTableModel)table.getModel();
         //to clear table
         dTempModel.setRowCount(0);
        Object[]temprow;
        for (Map.Entry<String, Item> entry : billcart.entrySet()) {
            Item val = entry.getValue();
            Double total=Integer.parseInt(val.getItem_Desired_quantity())*Double.parseDouble(val.getItem_price());
            totalPrice+=total;
            temprow=new Object[]{++i,val.getItem_id(),val.getItem_name(),val.getItem_price(),val.getItem_Desired_quantity(),total};
            dTempModel.addRow(temprow);
        }
    }

    private void updateTotal() {
        totalPrice=0;
       for (Map.Entry<String, Item> entry : billcart.entrySet()) {
                    Item val = entry.getValue();
                    Double total=Integer.parseInt(val.getItem_Desired_quantity())*Double.parseDouble(val.getItem_price());
                    totalPrice+=total;
                }
       l2.setText(String.valueOf(totalPrice));
    }
}
