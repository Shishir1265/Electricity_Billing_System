package electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.sql.*;
import net.proteanit.sql.DbUtils;

public class DepositDetails extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1, b2;
    JLabel l1, l2;
    Choice c1, c2;
    String x[] = {"Meter Number","Month","Units","Total Bill","Status"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    DepositDetails(){
        super("Deposit Details");
        setSize(770,610);
        setLocationRelativeTo(null);
        setLayout(null);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/icon.png"));
        setIconImage(icon.getImage());
        getContentPane().setBackground(Color.WHITE);
        
        l1 = new JLabel("Sort by Meter Number");
        l1.setBounds(30, 20, 160, 20);
        add(l1);
        
        c1 = new Choice();
        c1.setFocusable(false);
        
        l2 = new JLabel("Sort By Month");
        l2.setBounds(400, 20, 110, 20);
        add(l2);
        
        c2 = new Choice();
        c2.setFocusable(false);
        
        t1 = new JTable(y,x);
        t1.setRowHeight(35);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        rightRenderer.setBackground(new Color(238, 238, 238));

        for (int c = 0; c < t1.getColumnCount(); c++) {
            t1.getColumnModel().getColumn(c).setCellRenderer(rightRenderer);
        }
        
        try{
            Conn c  = new Conn();
            String s1 = "select * from bill";
            ResultSet rs  = c.s.executeQuery(s1);
            
            t1.setModel(DbUtils.resultSetToTableModel(rs));
            
            String str2 = "select * from customer";
            rs = c.s.executeQuery(str2);
            while(rs.next()){
                c1.add(rs.getString("meter"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        c1.setBounds(190,20, 150, 20);
        add(c1);
        
        c2.setBounds(510, 20, 150, 20);
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");
        add(c2);
        
        b1 = new JButton("Search");
        b1.setBounds(30, 60, 100, 30);
        b1.setFocusable(false);
        b1.setBorder(null);
        b1.addActionListener(this);
        b1.setBackground(Color.lightGray);
        add(b1);
        
        b2 = new JButton("Print");
        b2.setBounds(160, 60, 100, 30);
        b2.setFocusable(false);
        b2.setBorder(null);
        b2.setBackground(Color.lightGray);
        b2.addActionListener(this);
        add(b2);
        
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(30, 110, 700, 440);
        sp.setFocusable(false);
        add(sp);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String str = "select * from bill where meter = '"+c1.getSelectedItem()+"' AND month = '"+c2.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){}
        }else if(ae.getSource() == b2){
            try{
                t1.print();
            }catch(Exception e){}
        }
    }
    
    public static void main(String[] args){
        new DepositDetails();
    }
    
}