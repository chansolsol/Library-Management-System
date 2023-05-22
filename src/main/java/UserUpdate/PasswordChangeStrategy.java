package UserUpdate;

class PasswordChangeStrategy implements InfoChangeStrategy {
    public void changeInfo(User user, String... args) {
        String currentPassword = args[0];
        String newPassword = args[1];
        if (user.getPassword().equals(currentPassword)) {
            user.setPassword(newPassword);
            System.out.println("비밀번호 변경: " + user.getPassword());
        } else {
            System.out.println("비밀번호 변경 실패: 현재 비밀번호가 일치하지 않습니다.");
        }
    }
}