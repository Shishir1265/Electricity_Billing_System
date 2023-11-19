package electricity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomerDetails extends JFrame implements ActionListener {

    JTable table;

    CustomerDetails() {
        Object y[][] = new String[40][7];
        Object x[] = {"Customer Name", "Meter Number", "Address", "City", "State", "Email", "Phone"};
        int i = 0, j = 0;

        try {
            Conn c1 = new Conn();
            String s1 = "select * from customer";
            ResultSet rs = c1.s.executeQuery(s1);
            while (rs.next()) {
                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("meter");
                y[i][j++] = rs.getString("address");
                y[i][j++] = rs.getString("city");
                y[i][j++] = rs.getString("state");
                y[i][j++] = rs.getString("email");
                y[i][j++] = rs.getString("phone");
                i++;
                j = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Customer Details");
        setSize(1200, 650);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.lightGray);
        setResizable(false);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/icon.png"));
        setIconImage(icon.getImage());

        table = new JTable(y, x);
        table.setRowHeight(37);
        table.setFocusable(false);
        table.setFont(new Font("TimesRoman", Font.PLAIN, 17));

        JScrollPane sp = new JScrollPane();
        sp.setViewportView(table);
        sp.setBounds(40, 75, 1100, 450);

        table.getTableHeader().setPreferredSize(new Dimension(sp.getWidth(), 30));
        table.getTableHeader().setFont(new Font("Sans_Serif", Font.BOLD, 17));

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int c = 0; c < table.getColumnCount(); c++) {
            table.getColumnModel().getColumn(c).setCellRenderer(rightRenderer);
        }

        DefaultTableCellRenderer colourbender = new DefaultTableCellRenderer();
        colourbender.setBackground(new Color(238, 238, 238));
        colourbender.setHorizontalAlignment(SwingConstants.CENTER);

        for (int c = 0; c < table.getColumnCount(); c = c + 2) {
            table.getColumnModel().getColumn(c).setCellRenderer(colourbender);
            ;
        }

        ImageIcon print = new ImageIcon(ClassLoader.getSystemResource("icon/print.png"));
        Image print1 = print.getImage().getScaledInstance(115, 55, Image.SCALE_DEFAULT);
        JButton b1 = new JButton(new ImageIcon(print1));
        b1.setBounds(515, 545, 150, 45);
        b1.setFocusable(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.addActionListener(this);

        add(b1);
        getContentPane().add(sp);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CustomerDetails();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            table.print();
        } catch (Exception e) {
        }
    }
}
