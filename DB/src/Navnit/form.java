package Navnit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form extends JFrame {
    JLabel label1, label2, lable13, lable14;
    JTextField t1, t2, t3, t4;
    JButton submit;
    JLabel msg;
    String namev;
    int rollv;
    String coursev;
    String emailv;

    public form() {
        setTitle("Registration Form");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        label1 = new JLabel("name");
        label1.setBounds(20, 50, 100, 20);
        c.add(label1);

        t1 = new JTextField();
        t1.setBounds(150, 50, 100, 20);
        c.add(t1);

        label2 = new JLabel("roll.no");
        label2.setBounds(20, 100, 100, 20);
        c.add(label2);

        t2 = new JTextField();
        t2.setBounds(150, 100, 100, 20);
        c.add(t2);

        lable13 = new JLabel("course");
        lable13.setBounds(20, 150, 100, 20);
        c.add(lable13);

        t3 = new JTextField();
        t3.setBounds(150, 150, 100, 20);
        c.add(t3);

        lable14 = new JLabel("email");
        lable14.setBounds(20, 200, 100, 20);
        c.add(lable14);

        t4 = new JTextField();
        t4.setBounds(150, 200, 100, 20);
        c.add(t4);

        submit = new JButton("submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    namev = t1.getText();
                    rollv = Integer.parseInt(t2.getText());
                    coursev = t3.getText();
                    emailv = t4.getText();

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "");
                    Statement smt = con.createStatement();
                    String query = "INSERT INTO `details`(`name`, `roll.no`, `course`, `email`) VALUES ('" + namev + "', " + rollv + ", '" + coursev + "', '" + emailv + "')";

                    int rowsAffected = smt.executeUpdate(query);
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Submitted Successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Submission Failed");
                    }
                    con.close();
                } catch (Exception ae) {
                    System.out.println(ae);
                }
            }
        });

        submit.setBounds(100, 280, 100, 20);
        c.add(submit);

        setVisible(true);
    }

    public static void main(String[] args) {
        form form = new form();
    }
}
