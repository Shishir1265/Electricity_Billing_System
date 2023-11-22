
package electricity;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

public class PayBill extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6;
    JLabel l11, l12, l13, l14, l15;
    JLabel label;
    JTextField t1;
    Choice c1, c2;
    JButton b1, b2;
    String meter;

    PayBill(String meter) {
        this.meter = meter;
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/icon.png"));
        setIconImage(icon.getImage());
        setLayout(null);
        setSize(500, 540);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/newback.png"));
        Image img1 = img.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        label = new JLabel(new ImageIcon(img1));
        label.setBounds(0, 0, 500, 500);

        JLabel title = new JLabel("Electricity Bill");
        title.setFont(new Font("Calibri", Font.BOLD, 22));
        title.setBounds(160, 15, 165, 32);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setOpaque(true);
        title.setBackground(Color.white);
        title.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(105, 107, 210)),
                BorderFactory.createEmptyBorder(1, 1, 1, 1)));

        JLabel BACKGROUND = new JLabel();
        BACKGROUND.setOpaque(true);
        BACKGROUND.setBackground(new java.awt.Color(180, 180, 180, 165));
        BACKGROUND.setBorder(null);
        BACKGROUND.setBounds(23, 60, 440, 380);

        l1 = new JLabel("Meter No");
        l1.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
        l1.setOpaque(true);
        l1.setBackground(new Color(206,206,206));
        l1.setBounds(80, 80, 100, 20);

        l11 = new JLabel();
        l11.setBounds(280, 75, 150, 30);

        l2 = new JLabel("Name");
        l2.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
        l2.setOpaque(true);
        l2.setBackground(new Color(206,206,206));
        l2.setBounds(80, 140, 100, 20);

        l12 = new JLabel();
        l12.setBounds(280, 135, 150, 30);

        l3 = new JLabel("Month");
        l3.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
        l3.setOpaque(true);
        l3.setBackground(new Color(206,206,206));
        l3.setBounds(80, 200, 100, 20);

        c1 = new Choice();
        c1.setBounds(280, 200, 150, 30);
        c1.setFocusable(false);
        c1.add("January");
        c1.add("February");
        c1.add("March");
        c1.add("April");
        c1.add("May");
        c1.add("June");
        c1.add("July");
        c1.add("August");
        c1.add("September");
        c1.add("October");
        c1.add("November");
        c1.add("December");

        l4 = new JLabel("Units");
        l4.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
        l4.setOpaque(true);
        l4.setBackground(new Color(206,206,206));
        l4.setBounds(80, 260, 100, 20);

        l13 = new JLabel();
        l13.setBounds(280, 255, 150, 30);

        l5 = new JLabel("Total Bill");
        l5.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
        l5.setOpaque(true);
        l5.setBackground(new Color(206,206,206));
        l5.setBounds(80, 320, 100, 20);

        l14 = new JLabel();
        l14.setBounds(280, 315, 150, 30);

        l6 = new JLabel("Status");
        l6.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
        l6.setBounds(80, 380, 100, 20);

        l15 = new JLabel();
        l15.setBounds(280, 375, 150, 30);
        l15.setForeground(Color.RED);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter = '"+meter+"'");
            while(rs.next()){
                l11.setText(rs.getString("meter"));
                l12.setText(rs.getString("name"));
            }
            rs = c.s.executeQuery("select * from bill where meter = '"+meter+"' AND month = 'January' ");
            while(rs.next()){
                l13.setText(rs.getString("units"));
                l14.setText(rs.getString("total_bill"));
                l15.setText(rs.getString("status"));
            }
        }catch(Exception e){}
        
        c1.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ae){
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bill where meter = '"+meter+"' AND month = '"+c1.getSelectedItem()+"'");
                    while(rs.next()){
                        l13.setText(rs.getString("units"));
                        l14.setText(rs.getString("total_bill"));
                        l15.setText(rs.getString("status"));
                    }
                }catch(Exception e){}
            }
        });

        b1 = new JButton("Pay");
        b1.setFont(new Font ("Comic Sans MS", Font.PLAIN, 15));
        b1.setBounds(117, 453, 110, 35);
        add(b1);
        b2 = new JButton("Back");
        b2.setFont(new Font ("Comic Sans MS", Font.PLAIN, 15));
        b2.setBounds(260, 453, 110, 35);
        add(b2);
        
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setFocusable(false);
        b1.setBorder(BorderFactory.createEtchedBorder(new Color(161,149,223), new Color(161,149,223)));

        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setFocusable(false);
        b2.setBorder(BorderFactory.createEtchedBorder(new Color(161,149,223), new Color(161,149,223)));

        b1.addActionListener(this);
        b2.addActionListener(this);

        JLayeredPane layer = new JLayeredPane();
        layer.setBounds(0, 0, 500, 500);
        layer.add(label, Integer.valueOf(0));
        layer.add(title, Integer.valueOf(1));
        layer.add(BACKGROUND, Integer.valueOf(1));
        layer.add(l1, Integer.valueOf(2));
        layer.add(l2, Integer.valueOf(2));
        layer.add(l3, Integer.valueOf(2));
        layer.add(l4, Integer.valueOf(2));
        layer.add(l5, Integer.valueOf(2));
        layer.add(l6, Integer.valueOf(2));
        layer.add(l11, Integer.valueOf(2));
        layer.add(l12, Integer.valueOf(2));
        layer.add(l13, Integer.valueOf(2));
        layer.add(l14, Integer.valueOf(2));
        layer.add(l15, Integer.valueOf(2));
        layer.add(c1, Integer.valueOf(2));

        add(layer);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
        try{
        Conn c = new Conn();
        c.s.executeQuery("update bill status = 'Paid' where meter = '"+meter+"' AND month = '"+c1.getSelectedItem()+"'");

        }catch(Exception e){}
        this.setVisible(false);
        createLink("https://paytm.com/electricity-bill-payment");
        
        }else if(ae.getSource()== b2){
        this.dispose();
        }
    }
    
    public void createLink(String url){
       try {         
         java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
       }
       catch (java.io.IOException e) {
           System.out.println(e.getMessage());
       }
    }

    public static void main(String[] args) {
        new PayBill("");
    }
}
