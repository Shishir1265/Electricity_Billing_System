package electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class NewCustomer extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l11;
    JTextField t1, t3, t4, t5, t6, t7;
    JButton b1, b2;

    NewCustomer() {
        setResizable(false);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/icon.png"));
        setIconImage(icon.getImage());
        setSize(950, 460);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.WHITE);
        p.setBackground(new Color(223, 105, 118));
        p.setBounds(400, 0, 550, 460);

        JLabel title = new JLabel("New Customer");
        title.setBounds(160, 15, 250, 26);
        title.setFont(new Font("Verdana", Font.BOLD, 26));
        p.add(title);

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
        Image i3 = ic1.getImage().getScaledInstance(310, 330, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);
        l8.setHorizontalAlignment(JLabel.CENTER);
        l8.setVerticalAlignment(JLabel.CENTER);
        l8.setBackground(new Color(0.980f, 0.580f, 0.121f, 0.9f));
        l8.setOpaque(true);
        l8.setBounds(0, -20, 400, 460);
        add(l8);

        l1 = new JLabel("Customer Name");
        l1.setBounds(90, 80, 120, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 15));

        t1 = new JTextField();
        t1.setBounds(240, 80, 200, 22);
        t1.setBorder(null);
        p.add(l1);
        p.add(t1);
        l2 = new JLabel("Meter Number");
        l2.setBounds(90, 120, 110, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        l11 = new JLabel();
        l11.setBounds(240, 120, 200, 30);
        p.add(l2);
        p.add(l11);
        l3 = new JLabel("Address");
        l3.setBounds(90, 160, 100, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 15));
        t3 = new JTextField();
        t3.setBounds(240, 160, 200, 22);
        t3.setBorder(null);

        p.add(l3);
        p.add(t3);
        l5 = new JLabel("City");
        l5.setBounds(90, 200, 100, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 15));
        t5 = new JTextField();
        t5.setBounds(240, 200, 200, 22);
        t5.setBorder(null);
        p.add(l5);
        p.add(t5);
        l4 = new JLabel("State");
        l4.setBounds(90, 240, 100, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 15));
        t4 = new JTextField();
        t4.setBounds(240, 240, 200, 22);
        t4.setBorder(null);
        p.add(l4);
        p.add(t4);

        l6 = new JLabel("Email");
        l6.setBounds(90, 280, 100, 30);
        l6.setFont(new Font("Arial", Font.BOLD, 15));
        t6 = new JTextField();
        t6.setBounds(240, 280, 200, 22);
        t6.setBorder(null);
        p.add(l6);
        p.add(t6);
        l7 = new JLabel("Phone Number");
        l7.setBounds(90, 320, 110, 30);
        l7.setFont(new Font("Arial", Font.BOLD, 15));
        t7 = new JTextField();
        t7.setBounds(240, 320, 200, 22);
        t7.setBorder(null);
        p.add(l7);
        p.add(t7);

        b1 = new JButton("Next");
        b1.setBounds(140, 365, 120, 30);
        b1.setBorder(null);
        b2 = new JButton("Cancel");
        b1.setFont(new Font("Arial",Font.BOLD,15));
        b2.setBounds(290, 365, 120, 30);
        b2.setFont(new Font("Arial",Font.BOLD,15));
        b2.setBorder(null);

        b1.setBackground(new Color(0.980f, 0.580f, 0.121f, 1f));
        b1.setForeground(Color.WHITE);

        b2.setBackground(new Color(0.980f, 0.580f, 0.121f, 1f));
        b2.setForeground(Color.WHITE);

        p.add(b1);
        p.add(b2);
        setLayout(null);
        add(p);

        b1.addActionListener(this);
        b2.addActionListener(this);

        Random ran = new Random();
        long first = (ran.nextLong() % 1000000);
        l11.setText("" + Math.abs(first));
        getContentPane().setBackground(Color.BLACK);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String name = t1.getText();
            String meter = l11.getText();
            String address = t3.getText();
            String state = t4.getText();
            String city = t5.getText();
            String email = t6.getText();
            String phone = t7.getText();

            String q1 = "insert into customer values('" + name + "','" + meter + "','" + address + "','" + city + "','"
                    + state + "','" + email + "','" + phone + "')";
            String q2 = "insert into login values('" + meter + "', '', '', '', '')";
            try{
            Conn c1 = new Conn();
            c1.s.executeUpdate(q1);
            c1.s.executeUpdate(q2);
            JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
            this.setVisible(false);
            new MeterInfo(meter);

            }catch(Exception ex){
            ex.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}

