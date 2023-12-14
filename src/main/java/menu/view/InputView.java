package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;

public class InputView {

    public List<String> getNames() {
        List<String> input = List.of(Console.readLine().split(","));
        validationName(input);
        return input;
    }
    public List<String> inedibleMenus() {
        List<String> input = List.of(Console.readLine().split(","));
        validationInedibleMenus(input);
        return input;
    }

    private void validationName(List<String> input) {
        if (input.size() < 2 || input.size() > 5) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명 입력 해야 합니다.");
        }
        List<String> checkDuplicate = new ArrayList<>();
        for (String name : input) {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자 입니다.");
            }
            if (checkDuplicate.contains(name)) {
                throw new IllegalArgumentException("코치 이름은 달라야 합니다.");
            }
            checkDuplicate.add(name);
        }
    }

    private void validationInedibleMenus(List<String> input) {
        if (input.size() > 2) {
            throw new IllegalArgumentException("최대 2개의 못 먹는 메뉴를 입력 해야 합니다.");
        }
        for (String menu : input) {
            if (Category.findByMenu(menu) == Category.EMPTY) {
                throw new IllegalArgumentException("없는 메뉴 입니다.");
            }
        }
    }
}
