package UserUpdate;

class NameChangeStrategy implements InfoChangeStrategy {
    public void changeInfo(User user, String... args) {
        String newName = args[0];
        user.setUsername(newName);
        System.out.println("이름 변경: " + user.getUsername());
    }
}
