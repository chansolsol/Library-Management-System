package Pages;

import javax.swing.*;
import java.awt.*;

public class mainFrame extends JFrame {
    public mainFrame(){
        setTitle("Library Management System");
        setSize(1280, 720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
        setResizable(false);

        LoginPage LP = new LoginPage();
        add(LP);
    }
}
