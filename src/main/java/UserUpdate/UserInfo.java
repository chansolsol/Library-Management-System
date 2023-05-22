package UserUpdate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserInfo {

    public static void main(String[] args) {
        User[] users = readUserJSON("users.json");

        if (users != null && users.length > 0) {
            MyInfoPage infoPage = new MyInfoPage(users[0], "users.json", users);
            infoPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            infoPage.pack();
            infoPage.setVisible(true);

            saveUserJSON("users.json", users);
        } else {
            System.out.println("사용자 정보를 읽을 수 없습니다.");
        }
    }

    public static User[] readUserJSON(String filePath) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(filePath)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            User[] users = new User[jsonArray.size()];
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject userObject = jsonArray.get(i).getAsJsonObject();
                User user = gson.fromJson(userObject, User.class);
                users[i] = user;
            }

            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new User[0];
    }

    public static void saveUserJSON(String filePath, User[] users) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray jsonArray = new JsonArray();

        for (User user : users) {
            jsonArray.add(gson.toJsonTree(user));
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(jsonArray.toString());
            System.out.println("사용자 정보가 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
