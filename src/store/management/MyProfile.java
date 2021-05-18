/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ANSHUMAN
 */
public class MyProfile extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField eid,name,email,mob,pass;
    JComboBox role;
    JButton update,cancel;
    
    LoginProfile profile;
    public MyProfile(LoginProfile profile) {
        
        this.profile=profile;
        
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
        eid.setBounds(300,100,200,30);
        eid.setOpaque(false);
        eid.setText(profile.getEmail());
        eid.setEditable(false);
        background.add(eid);
        
//        fetch=new JButton("Edit");
//        fetch.setBounds(450,100,100,30);
//        //fetch.setFont(Properties.getFont());
//        fetch.setBackground(Color.BLACK);
//        fetch.setForeground(Color.white);
//        fetch.addActionListener(this);
//        background.add(fetch);
        
        //name
        l2=new JLabel("Name");
        l2.setBounds(50,170,100,30);
        l2.setFont(Properties.getFont());
        background.add(l2);
        
        name=new JTextField();
        name.setBounds(300,170,200,30);
        name.setOpaque(true);
        name.setText(profile.getName());
        name.setEditable(false);
        background.add(name);
        
        //email
        l3=new JLabel("Email");
        l3.setBounds(50,240,100,30);
        l3.setFont(Properties.getFont());
        background.add(l3);
        
        email=new JTextField();
        email.setBounds(300,240,200,30);
        email.setOpaque(true);
        email.setText(profile.getEmail());
        email.setEditable(false);
        background.add(email);
        
        //mobile
        l4=new JLabel("Mobile");
        l4.setBounds(50,310,100,30);
        l4.setFont(Properties.getFont());
        background.add(l4);
        
        mob=new JTextField();
        mob.setBounds(300,310,200,30);
        mob.setOpaque(true);
        mob.setText(profile.getMobileno());
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
        role.setBounds(300,380,200,30);
        if(profile.getRole().equals("admin"))
            role.setSelectedIndex(0);
        else
            role.setSelectedIndex(1);
        background.add(role);
        
        //password
        l6=new JLabel("Password");
        l6.setBounds(50,450,100,30);
        l6.setFont(Properties.getFont());
        background.add(l6);
        
        pass=new JTextField();
        pass.setBounds(300,450,200,30);
        pass.setOpaque(true);
        pass.setEditable(false);
        pass.setText(profile.getPassword());
        background.add(pass);
        
        //update
        update=new JButton("Change Password");
        update.setBounds(50,540,200,30);
        //update.setFont(Properties.getFont());
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        //update.setEnabled(false);
        update.addActionListener(this);
        background.add(update);
        
        //cancel
        cancel=new JButton("Cancel");
        cancel.setBounds(350,540,200,30);
        //cancel.setFont(Properties.getFont());
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        //cancel.setEnabled(false);
        cancel.addActionListener(this);
        background.add(cancel);
        
//        //change password
//        changepwd=new JButton("Change Password");
//        changepwd.setBounds(200,610,200,30);
//        changepwd.setBackground(Color.BLACK);
//        changepwd.setForeground(Color.white);
//        changepwd.addActionListener(this);
//        background.add(changepwd);
        
        l7=new JLabel("My Profile :");
        l7.setBounds(50,15,500,35);
        l7.setFont(new Font("serif",Font.ITALIC,30));
        background.add(l7);
        
        this.setTitle("My Profile");
        ImageIcon iconimage=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//icon8.png"));
        this.setIconImage(iconimage.getImage());
        this.setSize(600,700);
        this.setResizable(false);
        this.setLocationRelativeTo(rootPane);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==update){
            new ChangePassword(profile.getEmail());
            this.setVisible(false);
            this.dispose();
        }
        else if(e.getSource()==cancel){
        this.setVisible(false);
            this.dispose();
        }
            
    }
    
    public static void main(String[] args) {
        new MyProfile(new LoginProfile());
    }
    
}
