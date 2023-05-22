/*
package UserUpdate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class MyInfoPage0 extends JFrame implements ActionListener {
    private InfoChangeStrategy nameChangeStrategy;
    private InfoChangeStrategy passwordChangeStrategy;
    private User user;
    private String filePath;
    private User[] users;

    public MyInfoPage0(User user, String filePath, User[] users) {
        this.user = user;
        this.filePath = filePath;
        this.users = users;
        nameChangeStrategy = new NameChangeStrategy();
        passwordChangeStrategy = new PasswordChangeStrategy();

        // ...

        JPanel buttonPanel = new JPanel(new FlowLayout()); // FlowLayout으로 패널 생성

        JButton editNameButton = new JButton("EditName");
        editNameButton.setActionCommand("EditName");
        editNameButton.addActionListener(this);

        JButton editPasswordButton = new JButton("EditPassword");
        editPasswordButton.setActionCommand("EditPassword");
        editPasswordButton.addActionListener(this);

        buttonPanel.add(editNameButton); // 버튼을 패널에 추가
        buttonPanel.add(editPasswordButton); // 버튼을 패널에 추가

        getContentPane().add(buttonPanel, BorderLayout.CENTER); // 패널을 프레임의 중앙에 배치

        // ...

        pack();
        setVisible(true);
    }

    // ...

    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();

        if (event.equals("EditName")) {
            String id = JOptionPane.showInputDialog(this, "사용자 ID를 입력하세요:");
            if (id != null && !id.isEmpty()) {
                String newName = JOptionPane.showInputDialog(this, "새로운 이름을 입력하세요:");
                findUserById(id, nameChangeStrategy, newName);
            } else {
                JOptionPane.showMessageDialog(this, "유효하지 않은 사용자 ID입니다.", "오류", JOptionPane.ERROR_MESSAGE);
            }
        } else if (event.equals("EditPassword")) {
            String id = JOptionPane.showInputDialog(this, "사용자 ID를 입력하세요:");
            if (id != null && !id.isEmpty()) {
                String currentPassword = JOptionPane.showInputDialog(this, "현재 비밀번호를 입력하세요:");
                String newPassword = JOptionPane.showInputDialog(this, "새로운 비밀번호를 입력하세요:");
                findUserById(id, passwordChangeStrategy, currentPassword, newPassword);
            } else {
                JOptionPane.showMessageDialog(this, "유효하지 않은 사용자 ID입니다.", "오류", JOptionPane.ERROR_MESSAGE);
            }
        }

        // 변경된 정보를 저장
        saveUserJSON(filePath);
    }

    private void findUserById(String id, InfoChangeStrategy strategy, String... args) {
        User foundUser = null;
        for (User u : users) {
            if (u.getId().equals(id)) {
                foundUser = u;
                break;
            }
        }

        if (foundUser != null) {
            strategy.changeInfo(foundUser, args);
        } else {
            JOptionPane.showMessageDialog(this, "존재하지 않는 아이디입니다.", "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveUserJSON(String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray jsonArray = new JsonArray();

        for (User existingUser : users) {
            JsonObject userObject = gson.toJsonTree(existingUser).getAsJsonObject();
            if (existingUser.getId().equals(user.getId())) {
                // Update user information with the changed values
                existingUser.setUsername(user.getUsername());
                existingUser.setPassword(user.getPassword());
            }
            jsonArray.add(userObject);
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(jsonArray.toString());
            System.out.println("사용자 정보가 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
