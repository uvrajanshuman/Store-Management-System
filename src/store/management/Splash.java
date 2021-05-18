/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author ANSHUMAN
 */
public class Splash {
    public static void main(String[] args) {
        
      Frame f=new Frame();
      f.setVisible(true);
      
      //setting frame size and location dynamically
        int i;
        int x=1;
        for(i=2;i<=600;i+=4,x+=1){
            f.setLocation((600-((i+x)/2) ),400-(i/2));
            f.setSize(i+3*x,i+x/2);
            
            try{
                Thread.sleep(10);
            }catch(Exception e) { }
        }
    }
}

class Frame extends JFrame implements Runnable{
    
    Thread t1;

    public Frame(){
        
        //splash page image
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("store//management//icons//splash.jpeg"));
        Image i1=image1.getImage().getScaledInstance(1200, 800, Image.SCALE_DEFAULT);
        image1=new ImageIcon(i1);
        
       //adding image to JLabel
        JLabel label=new JLabel(image1);
        this.add(label);
        
        //To disable windows minimise maximise exit button
        this.setUndecorated(true);
        
        //Threading
        t1=new Thread(this);
        t1.start();
    }

    @Override
    public void run() {
        try {
            //thread sleeptime 7 seconds.
            Thread.sleep(7000);
            
            //current frame made invisible and disposed
            this.setVisible(false);
            this.dispose();
            
            //opening login page
            new Login2();
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
}