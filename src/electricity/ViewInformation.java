package electricity;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewInformation extends JFrame implements ActionListener{
    JButton b1;
    ViewInformation(String meter){
        setSize(775, 400);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/icon.png"));
        setIconImage(icon.getImage());
        setLayout(null);
        
        JLabel title = new JLabel("VIEW CUSTOMER INFORMATION");
        title.setBounds(230, 0, 500, 40);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(50, 80, 100, 20);
        l1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        add(l1);
        
        JLabel l11 = new JLabel();
        l11.setBounds(210, 75, 140, 30);
        add(l11);
        
        JLabel l2 = new JLabel("Meter Number");
        l2.setBounds(50, 140, 110, 20);
        l2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        add(l2);
        
        JLabel l12 = new JLabel();
        l12.setBounds(210, 140, 140, 30);
        add(l12);
        
        JLabel l3 = new JLabel("Address");
        l3.setBounds(50, 200, 100, 20);
        l3.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        add(l3);
        
        JLabel l13 = new JLabel();
        l13.setBounds(210, 200, 140, 30);
        add(l13);
        
        JLabel l4 = new JLabel("City");
        l4.setBounds(50, 260, 100, 20);
        l4.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        add(l4);
        
        JLabel l14 = new JLabel();
        l14.setBounds(210, 260, 140, 30);
        add(l14);
        
        JLabel l5 = new JLabel("State");
        l5.setBounds(430, 80, 100, 20);
        l5.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        add(l5);
        
        JLabel l15 = new JLabel();
        l15.setBounds(565, 75, 140, 30);
        add(l15);
        
        JLabel l6 = new JLabel("Email");
        l6.setBounds(430, 140, 100, 20);
        l6.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        add(l6);
        
        JLabel l16 = new JLabel();
        l16.setBounds(565, 135, 140, 30);
        add(l16);
        
        JLabel l7 = new JLabel("Phone");
        l7.setBounds(430, 200, 100, 20);
        l7.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        add(l7);
        
        JLabel l17 = new JLabel();
        l17.setBounds(565, 200, 140, 30);
        add(l17);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter = '"+meter+"'");
            while(rs.next()){
                l11.setText(rs.getString(1));
                l12.setText(rs.getString(2));
                l13.setText(rs.getString(3));
                l14.setText(rs.getString(4));
                l15.setText(rs.getString(5));
                l16.setText(rs.getString(6));
                l17.setText(rs.getString(7));
                
            }
        }catch(Exception e){}
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(327, 310, 120, 35);
        b1.setFocusable(false);
        b1.setBorder(null);
        b1.addActionListener(this);
        add(b1);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        this.dispose();
    }
    
    public static void main(String[] args){
        new ViewInformation("");
    }
}

