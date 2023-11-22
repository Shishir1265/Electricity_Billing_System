package electricity;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class menubar implements ActionListener {

    JFrame frame;
    String meter;
    String not[] = { "Notepad.exe" };
    String cal[] = { "calc.exe" };
    String browser[] = { "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe" };

    menubar(JMenuBar mb, String person, JFrame frame, String meter) {
        this.frame = frame;
        this.meter = meter;
        Font f = new Font("Verdana", Font.PLAIN, 15);
        Color c = new Color(105, 127, 226);

        /* First Column */
        JMenu master = new JMenu("Master");
        master.setFont(new Font("Verdana", Font.PLAIN, 20));
        master.setForeground(Color.WHITE);
        JMenuItem m1 = new JMenuItem("New Customer");
        JMenuItem m2 = new JMenuItem("Customer Details");
        JMenuItem m3 = new JMenuItem("Deposit Details");
        JMenuItem m4 = new JMenuItem("Calculate Bill");

        /* ---- Customer Details ---- */
        m1.setFont(new Font("monospaced", Font.PLAIN, 12));
        m1.setMnemonic(KeyEvent.VK_D);
        m1.setBackground(Color.WHITE);
        m1.setSize(20, 10);
        m1.setFont(f);
        m1.setForeground(c);
        
        /* ---- Meter Details ---- */
        m2.setFont(new Font("monospaced", Font.PLAIN, 12));
        m2.setMnemonic(KeyEvent.VK_M);
        m2.setBackground(Color.WHITE);
        m2.setSize(20, 10);
        m2.setFont(f);
        m2.setForeground(c);


        /* ---- Deposit Details ----- */
        m3.setFont(new Font("monospaced", Font.PLAIN, 12));
        m3.setMnemonic(KeyEvent.VK_D);
        m3.setBackground(Color.WHITE);
        m3.setSize(20, 10);
        m3.setFont(f);
        m3.setForeground(c);


        m4.setFont(new Font("monospaced", Font.PLAIN, 12));
        m4.setMnemonic(KeyEvent.VK_C);
        m4.setBackground(Color.WHITE);
        m4.setSize(20, 10);
        m4.setFont(f);
        m4.setForeground(c);


        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);

        /* First Column */
        JMenu info = new JMenu("Info");
        info.setFont(new Font("Verdana", Font.PLAIN, 20));
        info.setForeground(Color.WHITE);
        JMenuItem info1 = new JMenuItem("Update");
        JMenuItem info2 = new JMenuItem("View");
        
        /* ---- Pay Bill ---- */
        info1.setFont(new Font("monospaced", Font.PLAIN, 12));
        info1.setMnemonic(KeyEvent.VK_U);
        info1.setBackground(Color.WHITE);
        info1.setSize(20, 10);
        info1.setFont(f);
        info1.setForeground(c);

        /* ---- Last Bill ---- */
        info2.setFont(new Font("monospaced", Font.PLAIN, 12));
        info2.setMnemonic(KeyEvent.VK_V);
        info2.setBackground(Color.WHITE);
        info2.setSize(20, 10);
        info2.setFont(f);
        info2.setForeground(c);

        info1.addActionListener(this);
        info2.addActionListener(this);

        /* Second Column */
        JMenu user = new JMenu("User");
        user.setFont(new Font("Verdana", Font.PLAIN, 20));
        user.setForeground(Color.WHITE);
        JMenuItem u1 = new JMenuItem("Pay");
        JMenuItem u3 = new JMenuItem("Bill");

        u1.setFont(new Font("monospaced", Font.PLAIN, 12));
        u1.setMnemonic(KeyEvent.VK_P);
        u1.setBackground(Color.WHITE);
        u1.setSize(20, 10);
        u1.setFont(f);
        u1.setForeground(c);

        /* ---- Last Bill ---- */
        u3.setFont(new Font("monospaced", Font.PLAIN, 12));
        u3.setMnemonic(KeyEvent.VK_B);
        u3.setBackground(Color.WHITE);
        u3.setSize(20, 10);
        u3.setFont(f);
        u3.setForeground(c);

        u1.addActionListener(this);
        u3.addActionListener(this);

        /* Third Column */
        JMenu report = new JMenu("Report");
        report.setFont(new Font("Verdana", Font.PLAIN, 20));
        report.setForeground(Color.WHITE);
        JMenuItem r1 = new JMenuItem("Make Bill");

        /* ---- Report ---- */
        r1.setFont(new Font("monospaced", Font.PLAIN, 12));
        r1.setMnemonic(KeyEvent.VK_M);
        r1.setBackground(Color.WHITE);
        r1.setSize(20, 10);
        r1.setFont(f);
        r1.setForeground(c);

        r1.addActionListener(this);

        /* Fourth Column */
        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("Verdana", Font.PLAIN, 20));
        utility.setForeground(Color.WHITE);
        JMenuItem ut1 = new JMenuItem("Notepad");
        JMenuItem ut2 = new JMenuItem("Calculator");
        JMenuItem ut3 = new JMenuItem("Web Browser");

        /* ---- Notepad ---- */
        ut1.setFont(new Font("monospaced", Font.PLAIN, 12));
        ut1.setMnemonic(KeyEvent.VK_N);
        ut1.setBackground(Color.WHITE);
        ut1.setSize(20, 10);
        ut1.setFont(f);
        ut1.setForeground(c);

        /* ---- Calculator ---- */
        ut2.setFont(new Font("monospaced", Font.PLAIN, 12));
        ut2.setMnemonic(KeyEvent.VK_C);
        ut2.setBackground(Color.WHITE);
        ut2.setSize(20, 10);
        ut2.setFont(f);
        ut2.setForeground(c);

        /* ---- Web Browser ---- */
        ut3.setFont(new Font("monospaced", Font.PLAIN, 12));
        ut3.setMnemonic(KeyEvent.VK_W);
        ut3.setBackground(Color.WHITE);
        ut3.setSize(20, 10);
        ut3.setFont(f);
        ut3.setForeground(c);

        ut1.addActionListener(this);
        ut2.addActionListener(this);
        ut3.addActionListener(this);

        /* Fifth Column */
        JMenu exit = new JMenu("Logout");
        exit.setFont(new Font("Verdana", Font.PLAIN, 20));
        exit.setForeground(Color.WHITE);
        JMenuItem ex = new JMenuItem("Logout");

        /* ---- Exit ---- */
        ex.setFont(new Font("monospaced", Font.PLAIN, 12));
        ex.setMnemonic(KeyEvent.VK_L);
        ex.setBackground(Color.WHITE);
        ex.setSize(20, 10);
        ex.setFont(f);
        ex.setForeground(c);
        ex.addActionListener(this);

        master.add(m1);
        master.addSeparator();
        master.add(m2);
        master.addSeparator();
        master.add(m3);
        master.addSeparator();
        master.add(m4);

        info.add(info1);
        info.addSeparator();
        info.add(info2);

        user.add(u1);
        user.addSeparator();
        user.add(u3);

        report.add(r1);

        utility.add(ut1);
        utility.addSeparator();
        utility.add(ut2);
        utility.addSeparator();
        utility.add(ut3);

        exit.add(ex);

        if (person.equals("Admin")) {
            mb.add(master);
        } else {
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        mb.add(utility);
        mb.add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Customer Details")) {
            new CustomerDetails();

        } else if (msg.equals("New Customer")) {
             new NewCustomer();

        } else if (msg.equals("Calculate Bill")) {
             new CalculateBill();

        } else if (msg.equals("Pay")) {
             new PayBill(meter);

        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec(not);
            } catch (IOException e) {
            }
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec(cal);
            } catch (IOException e) {
            }
        } else if (msg.equals("Web Browser")) {
            try {
                Runtime.getRuntime().exec(browser);
            } catch (IOException e) {
            }
        } else if (msg.equals("Logout")) {
            frame.dispose();
            new Login();
        } else if (msg.equals("Make Bill")) {
             new GenerateBill(meter);
        } else if (msg.equals("Deposit Details")) {
             new DepositDetails();
        } else if (msg.equals("View")) {
             new ViewInformation(meter);
        } else if (msg.equals("Update")) {
             new UpdateInformation(meter);
        } else if (msg.equals("Bill")) {
             new BillDetails(meter);
        }
    }

}

