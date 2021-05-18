/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.employee;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import store.management.ChangePassword;
import store.management.Login2;
import store.management.LoginProfile;
import store.management.MyProfile;
import store.management.Properties;

/**
 *
 * @author ANSHUMAN
 */
public class Employee extends JFrame implements ActionListener{
LoginProfile profile;
    public Employee(LoginProfile profile) {
        this.profile=profile;
        ImageIcon image5=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon5.jpg"));
        Image i5=image5.getImage().getScaledInstance(1500, 800, Image.SCALE_SMOOTH);
        image5=new ImageIcon(i5);
        JLabel label=new JLabel(image5);
        this.add(label);
       
        JMenuBar menu=new JMenuBar();
        //Menus
        
        //Billing
        JMenu m1=new JMenu("Billing");
        m1.setFont(Properties.getFont4());
        
        //view
        JMenu m2=new JMenu("View");
        m2.setFont(Properties.getFont4());
        
        //utility
        JMenu m3=new JMenu("Utility");
        m3.setFont(Properties.getFont4());
        
        //about
        JMenu m4=new JMenu("About");
        m4.setFont(Properties.getFont4());
        
        //Profile
        JMenu m5=new JMenu("Welcome "+profile.getEmail());
        m5.setFont(Properties.getFont4());
        
        
        //MenuItems
        //startBilling
        JMenuItem startBilling=new JMenuItem("Start Billing");
        ImageIcon imagea=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//pay.png"));
        Image ia=imagea.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        startBilling.setIcon(new ImageIcon(ia));
        startBilling.setFont(Properties.getFont4());
        startBilling.setBackground(Color.WHITE);
        startBilling.setForeground(Color.BLACK);
        m1.add(startBilling);
        startBilling.addActionListener(this);
//        //addEmployee
//        JMenuItem addEmployee=new JMenuItem("Add Employee");
//        ImageIcon image7=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon7.png"));
//        Image i7=image7.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
//        addEmployee.setIcon(new ImageIcon(i7));
//        addEmployee.setFont(Properties.getFont4());
//        addEmployee.setBackground(Color.WHITE);
//        addEmployee.setForeground(Color.BLACK);
//        m1.add(addEmployee);
//        addEmployee.addActionListener(this);
//        
//        //editEmployee
//        JMenuItem editEmployee =new JMenuItem("Edit Employee");
//        ImageIcon image8=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon8.png"));
//        Image i8=image8.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
//        editEmployee.setIcon(new ImageIcon(i8));
//        editEmployee.setFont(Properties.getFont4());
//        editEmployee.setBackground(Color.WHITE);
//        editEmployee.setForeground(Color.BLACK);
//        m1.add(editEmployee);
//        editEmployee.addActionListener(this);
//        
//        //addItem
//        JMenuItem addItem =new JMenuItem("Add Item");
//        ImageIcon image9=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon9.png"));
//        Image i9=image9.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
//        addItem.setIcon(new ImageIcon(i9));
//        addItem.setFont(Properties.getFont4());
//        addItem.setBackground(Color.WHITE);
//        addItem.setForeground(Color.BLACK);
//        m2.add(addItem);
//        addItem.addActionListener(this);
//       
//        //editItem
//        JMenuItem editItem =new JMenuItem("Edit Item");
//        ImageIcon image10=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon10.png"));
//        Image i10=image10.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
//        editItem.setIcon(new ImageIcon(i10));
//        editItem.setFont(Properties.getFont4());
//        editItem.setBackground(Color.WHITE);
//        editItem.setForeground(Color.BLACK);
//        m2.add(editItem);
//        editItem.addActionListener(this);
        
        //notepad
        JMenuItem notepad =new JMenuItem("Notepad");
        ImageIcon image11=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//notepad.png"));
        Image i11=image11.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(i11));
        notepad.setFont(Properties.getFont4());
        notepad.setBackground(Color.WHITE);
        notepad.setForeground(Color.BLACK);
        m3.add(notepad);
        notepad.addActionListener(this);
        
        //calculator
        JMenuItem calculator =new JMenuItem("Calculator");
        ImageIcon image12=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//calculator.png"));
        Image i12=image12.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(i12));
        calculator.setFont(Properties.getFont4());
        calculator.setBackground(Color.WHITE);
        calculator.setForeground(Color.BLACK);
        m3.add(calculator);
        calculator.addActionListener(this);
        
        //Browser
        JMenuItem browser =new JMenuItem("Browser");
        ImageIcon image13=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//browser.png"));
        Image i13=image13.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        browser.setIcon(new ImageIcon(i13));
        browser.setFont(Properties.getFont4());
        browser.setBackground(Color.WHITE);
        browser.setForeground(Color.BLACK);
        m3.add(browser);
        browser.addActionListener(this);
        
        //MyProfile
        JMenuItem myprofile= new JMenuItem("My Profile");
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon14.png"));
        Image ip=image.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        myprofile.setIcon(new ImageIcon(ip));
        myprofile.setFont(Properties.getFont4());
        myprofile.setBackground(Color.WHITE);
        myprofile.setForeground(Color.BLACK);
        myprofile.addActionListener(this);
        m5.add(myprofile);
        
        //Change password
        JMenuItem changepassword = new JMenuItem("Change Password");
        ImageIcon image14 = new ImageIcon(ClassLoader.getSystemResource("store//management//icons//changepassword.jpg"));
        Image i14=image14.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        changepassword.setIcon(new ImageIcon(i14));
        changepassword.setFont(Properties.getFont4());
        changepassword.setBackground(Color.WHITE);
        changepassword.setForeground(Color.BLACK);
        changepassword.addActionListener(this);
        m5.add(changepassword);
        
        //Logout
        JMenuItem logout = new JMenuItem("Logout");
        ImageIcon image15 = new ImageIcon(ClassLoader.getSystemResource("store//management//icons//logout.png"));
        Image i15=image15.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        logout.setIcon(new ImageIcon(i15));
        logout.setFont(Properties.getFont4());
        logout.setBackground(Color.WHITE);
        logout.setForeground(Color.BLACK);
        logout.addActionListener(this);
        m5.add(logout);
        
        //Exit
        JMenuItem exit=new JMenuItem("Exit");
        ImageIcon image16 = new ImageIcon(ClassLoader.getSystemResource("store//management//icons//exit.png"));
        Image i16=image16.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(i16));
        exit.setFont(Properties.getFont4());
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        m5.add(exit);
        
        menu.add(m1);
        menu.add(m2);
        menu.add(m3);
        menu.add(m4);
        menu.add(m5);
      //  menu.add(m6);
        menu.setFont(Properties.getFont3());
        menu.setBackground(Color.WHITE);
        
        this.setJMenuBar(menu);
        
        this.setSize(1536,864);
        this.setLayout(new FlowLayout());
        this.setTitle(profile.getEmail());
        ImageIcon iconImage=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon4.jpg"));
        this.setIconImage(iconImage.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Employee(new LoginProfile());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg=e.getActionCommand();
        
        switch(msg){
            case "Start Billing":
                new StartBilling(null, profile.getName());
                break;
            case "Notepad":
                try{
                Runtime.getRuntime().exec("notepad.exe");
                }catch(IOException exception){exception.printStackTrace();}
                break;
            case "Calculator":
                try{
                Runtime.getRuntime().exec("calc.exe");
                }catch(IOException exception){exception.printStackTrace();}
                break;
            case "Browser":
                 try{
                Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
                }catch(IOException exception){exception.printStackTrace();}
                break;
            case "My Profile":
                new MyProfile(profile);
                break;
            case "Change Password":
                new ChangePassword(profile.getEmail());
                break;
            case "Logout":
                this.setVisible(false);
                new Login2();
                this.dispose();
                break;
            case "Exit":
                System.exit(0);
                break;
        }
        
    }
    
}