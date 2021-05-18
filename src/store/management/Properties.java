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
public class Properties {
    static Font font=new Font("serif",Font.BOLD,20);
    static Font font2=new Font("serif",Font.BOLD,15);
    static Font font3=new Font("sansserif",Font.BOLD,25);
    static Font font4=new Font("monospaced",Font.BOLD,16);

    public Properties() {
    }
    public static Font getFont(){
        return font;
    }
    public static Font getFont2(){
        return font2;
    }
    
    public static Font getFont3(){
        return font3;
    }
    public static Font getFont4(){
        return font4;
    }
}
