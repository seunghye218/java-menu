package menu.view;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;

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

    public void inedibleMenus(final String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public void result(final List<Category> categoriesOfWeek, final List<Coach> coaches) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(getCategories(categoriesOfWeek));
        for (Coach coach : coaches) {
            System.out.println(getRecommendMenu(coach.getName(), coach.getMenus()));
        }
        System.out.println("\n추천을 완료했습니다.");
    }

    public void println() {
        System.out.println();
    }

    private String getCategories(final List<Category> categoriesOfWeek) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ 카테고리 ");
        for (Category category : categoriesOfWeek) {
            stringBuilder.append("| " + category.getName() + " ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private String getRecommendMenu(final String name, final List<String> menus) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ " + name + " ");
        for (String menu : menus) {
            stringBuilder.append("| " + menu + " ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
