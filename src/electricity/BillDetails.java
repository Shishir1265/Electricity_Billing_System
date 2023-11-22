
package electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame {

    JTable t1;
    String x[] = { "Meter Number", "Month", "Units", "Total Bill", "Status" };
    String y[][] = new String[40][8];
    int i = 0, j = 0;

    BillDetails(String meter) {
        super("Bill Details");
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/icon.png"));
        setIconImage(icon.getImage());
        setSize(700, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        t1 = new JTable(y, x);
        t1.setRowHeight(25);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        rightRenderer.setBackground(new Color(248, 248, 248));

        for (int c = 0; c < t1.getColumnCount(); c++) {
            t1.getColumnModel().getColumn(c).setCellRenderer(rightRenderer);
        }

        try{
        Conn c = new Conn();
        String s1 = "select * from bill where meter = " + meter;
        ResultSet rs = c.s.executeQuery(s1);

        t1.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
        e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(0, 0, 700, 600);
        add(sp);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BillDetails("");
    }
}

