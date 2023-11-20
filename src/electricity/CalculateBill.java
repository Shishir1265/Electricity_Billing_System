package electricity;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CalculateBill extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5;
    JTextField t1;
    Choice c1, c2;
    JButton b1, b2;
    JPanel p;

    CalculateBill() {
        setSize(900, 430);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/icon.png"));
        setIconImage(icon.getImage());

        p = new JPanel();
        p.setLayout(null);
        p.setBounds(400, 0, 500, 430);
        p.setBackground(new Color(230, 230, 230));

        l1 = new JLabel("Calculate Electricity Bill");
        l1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        l1.setBounds(45, 13, 400, 30);

        l2 = new JLabel("Meter Number");
        l2.setBounds(80, 70, 110, 30);
        l2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

        JLabel l6 = new JLabel("Name");
        l6.setBounds(80, 120, 100, 30);
        l6.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

        JLabel l7 = new JLabel("Address");
        l7.setBounds(80, 170, 100, 30);
        l7.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

        l3 = new JLabel("Units Cosumed");
        l3.setBounds(80, 220, 110, 30);
        l3.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

        l5 = new JLabel("Month");
        l5.setBounds(80, 270, 100, 30);
        l5.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

        c1 = new Choice();
        c1.setBounds(220, 70, 180, 20);
        c1.setFocusable(false);
        try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from customer");
        while(rs.next()){
        c1.add(rs.getString("meter"));
        }
        }catch(Exception e){}

        JLabel l11 = new JLabel();
        l11.setBounds(220, 120, 180, 20);
        p.add(l11);

        JLabel l12 = new JLabel();
        l12.setBounds(220, 170, 180, 20);
        p.add(l12);

        try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from customer where meter = '"+c1.getSelectedItem()+"'");
        while(rs.next()){
        l11.setText(rs.getString("name"));
        l12.setText(rs.getString("address"));
        }
        }catch(Exception e){}

        c1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from customer where meter = '"+c1.getSelectedItem()+"'");
                while(rs.next()){
                l11.setText(rs.getString("name"));
                l12.setText(rs.getString("address"));
                }
                }catch(Exception e){}
            }
        });

        t1 = new JTextField();
        t1.setBounds(220, 220, 180, 20);
        t1.setFocusable(false);

        c2 = new Choice();
        c2.setBounds(220, 270, 180, 20);
        c2.setFocusable(false);
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

        b1 = new JButton("Submit");
        b1.setBounds(115, 332, 105, 35);
        b2 = new JButton("Cancel");
        b2.setBounds(255, 332, 105, 35);
        b1.setBorder(null);
        b2.setBorder(null);
        b1.setFocusable(false);
        b2.setFocusable(false);

        b1.setBackground(new Color(239, 98, 78));
        b1.setForeground(Color.WHITE);
        b2.setBackground(new Color(239, 98, 78));
        b2.setForeground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/caclbill.png"));
        Image i2 = i1.getImage().getScaledInstance(340, 320, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l4 = new JLabel(i3);
        l4.setBounds(0, -20, 400, 430);
        l4.setOpaque(true);
        l4.setBackground(new Color(245, 240, 245));
        l1.setHorizontalAlignment(JLabel.CENTER);

        p.add(l1);
        p.add(l2);
        p.add(l6);
        p.add(l7);
        p.add(c1);
        p.add(l5);
        p.add(c2);
        p.add(l3);
        p.add(t1);
        p.add(b1);
        p.add(b2);

        setLayout(null);

        add(p);
        add(l4);

        b1.addActionListener(this);
        b2.addActionListener(this);

        getContentPane().setBackground(new Color(255, 255, 255));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String meter_no = c1.getSelectedItem();
            String units = t1.getText();
            String month = c2.getSelectedItem();

            int units_consumed = Integer.parseInt(units);

            int total_bill = 0;
            try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from tax");
            while(rs.next()){
            total_bill = units_consumed *
            Integer.parseInt(rs.getString("cost_per_unit")); // 120 * 9
            total_bill += Integer.parseInt(rs.getString("meter_rent"));
            total_bill += Integer.parseInt(rs.getString("service_charge"));
            total_bill += Integer.parseInt(rs.getString("service_tax"));
            total_bill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
            total_bill += Integer.parseInt(rs.getString("fixed_tax"));
            }
            }catch(Exception e){}

            String q = "insert into bill values('"+meter_no+"','"+month+"','"+units+"','"+total_bill+"', 'Not Paid')";

            try{
            Conn c1 = new Conn();
            c1.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"Customer Bill Updated Successfully");
            this.setVisible(false);
            }catch(Exception aee){
            aee.printStackTrace();
            }

        } else if (ae.getSource() == b2) {
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new CalculateBill();
    }
}

