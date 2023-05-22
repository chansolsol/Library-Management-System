package UserUpdate;

interface InfoChangeStrategy {
    void changeInfo(User user, String... args);
}
//InfoChangeStrategy 인터페이스를 생성하여 변경 전략을 정의하고, 이 인터페이스를 구현하는 NameChangeStrategy와 PasswordChangeStrategy 클래스를 작성했습니다. 각각 changeInfo 메서드를 구현하여 사용자 정보를 변경하는 방식을 다르게 정의했습니다.
//
//MyInfoPage 클래스에서는 사용자 정보 변경을 위해 InfoChangeStrategy를 활용합니다. findUserById 메서드에서 사용자를 ID로 찾은 후, 해당 전략을 적용하여 정보를 변경합니다. 사용자 정보 변경은 이름 변경과 비밀번호 변경을 나누어 처리합니다.
//
//사용자가 이름 변경 또는 비밀번호 변경을 요청하면, 해당 전략을 사용하여 사용자 정보를 변경합니다. 변경된 정보는 saveUserJSON 메서드를 호출하여 JSON 파일에 저장됩니다.
//
//전략 패턴을 사용함으로써 사용자 정보 변경 방식을 유연하게 확장할 수 있고, MyInfoPage 클래스는 변경에 영향을 받지 않고 사용자 정보를 처리할 수 있게 되었습니다.