package Res;

import Pages.MainPage;
import com.google.gson.Gson;
import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GsonMethod {
    private static final String USER_FILE = "users.json"; // 로그인 정보를 저장하는 파일 경로
    private static final Gson gson = new Gson(); // JSON 파싱을 위한 Gson 객체 생성
    private static final ArrayList<User> users = new ArrayList<>(); // users 리스트 객체 생성


    /** 회원 정보를 저장하는 클래스 */
    private static class User {
        String id;
        String password;
        String username;
        public User(String id, String password, String username){
            this.id = id;
            this.password = password;
            this.username = username;
        }
        public String getUsername() {return username;}
    }
    public static String getUsername(String id) {
        User user = users.stream()
                .filter(u -> u.id.equals(id))
                .findFirst()
                .orElse(null);

        if (user != null) {
            return user.getUsername();
        }

        return null;
    }

    /** 프로그램을 시작할때 json 파일 내용을 불러옴 */
    public void signInit() {
        if(!users.isEmpty())
            users.clear(); // users 리스트가 비어있지 않으면 리스트의 모든 요소 삭제, init()가 두번 불리는 경우 방지

        try (FileReader reader = new FileReader(USER_FILE)) {
            User[] userArr = gson.fromJson(reader, User[].class); // userArr 배열 생성
            if(userArr != null)
                users.addAll(Arrays.stream(userArr).toList()); // userArr 배열이 비어있지 않으면 Arrays.stream(userArr)을 호출하여 Stream<User> 객체를 생성하고,
        } catch (IOException e) {                              // toList()를 호출하여 List<User>로 변환 후 users.addAll()을 사용하여 List<User>를 users 리스트에 추가
            e.printStackTrace();
        }
    }

    /** 회원 정보를 저장하는 JSON 파일에서 특정 아이디의 회원 정보를 가져옴 */
    private static User getUserById(String userId) {
        for(User user : users) {
            if (Objects.equals(user.id, userId))
                return user;
            if (Objects.equals(user.username, userId))
                return user;
        }
        return null;
    }

    /** 회원 정보를 users 리스트에 추가함 */
    private static void addUser(User user) {
        users.add(user);
    }

    /** users 리스트에 저장된 객체들을 JSON 으로 변환해서 저장함 */
    private static void signSave() {
        try (FileWriter writer = new FileWriter(USER_FILE, false)) { // true = 이어쓰기, false = 덮어쓰기
            String json = gson.toJson(users.toArray()); // users 리스트에 저장된 객체들을 JSON 문자열로 변환
            writer.write(json); // 변환된 JSON 문자열을 USER_FILE 에 쓰기
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** 회원 정보를 저장하는 JSON 파일에서 특정 아이디의 회원 정보를 삭제함 */
    /*
    private static void deleteUserById(String id) {
        List<User> users = getUsers();
        users.removeIf(user -> user.id.equals(id));
        try (FileWriter writer = new FileWriter(USER_FILE)) {
            for (User user : users) {
                gson.toJson(user, writer);
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     */

    /** 로그인 기능 */
    public static boolean login(String id, String password) {
        User user = getUserById(id);
        return user != null && user.password.equals(password);
    }

    /** 회원가입 기능 */
    public static boolean signup(String id, String password, String username) {
        JOptionPane alert = new JOptionPane();  //알림 패널 생성

        if (getUserById(id) != null) {
            alert.showMessageDialog(null, "이미 존재하는 아이디입니다.", "알림", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (getUserById(username) != null) {
            alert.showMessageDialog(null, "이미 존재하는 이름입니다.", "알림", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        addUser(new User(id, password, username));
        signSave();
        alert.showMessageDialog(null, "회원가입 성공!", "알림", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

}