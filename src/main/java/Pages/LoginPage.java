package Pages;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {
    public LoginPage() {
        setTitle("Login Screen");
        setSize(1280, 720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelMainWhite = new JPanel();
        panelMainWhite.setBackground(Color.white);
        getContentPane().add(panelMainWhite);

        setResizable(false);
        setVisible(true);
    }
}
