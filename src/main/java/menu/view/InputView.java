package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<String> getNames() {
        List<String> input = List.of(Console.readLine().split(","));
        validation(input);
        return input;
    }

    private void validation(List<String> input) {
        if (input.size() < 2 || input.size() > 5) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명 입력 하여야 합니다");
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
}
