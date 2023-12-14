package menu.view;

public class OutputView {

    public void start() {
        final String START = "점심 메뉴 추천을 시작합니다.\n";
        System.out.println(START);
    }

    public void getNames() {
        final String GET_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
        System.out.println(GET_NAMES);
    }

    public void error(String message) {
        final String ERROR = "[ERROR] ";
        System.err.println(ERROR + message);
    }
}
