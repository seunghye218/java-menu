package menu;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<Coach> coaches = getCoaches(getNames(inputView, outputView));
        setInedibleMenus(inputView, outputView, coaches);
    }

    private static List<Coach> getCoaches(List<String> names) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : names) {
            coaches.add(new Coach(name));
        }
        return coaches;
    }

    private static void setInedibleMenus(InputView inputView, OutputView outputView, List<Coach> coaches) {
        for (Coach coach : coaches) {
            List<String> inedibleMenus = getInedibleMenus(inputView, outputView, coach.getName());
            coach.setInedibleMenus(inedibleMenus);
        }
    }

    private static List<String> getNames(InputView inputView, OutputView outputView) {
        outputView.start();
        outputView.getNames();
        while (true) {
            try {
                return inputView.getNames();
            } catch (IllegalArgumentException exception) {
                outputView.error(exception.getMessage());
            }
        }
    }

    private static List<String> getInedibleMenus(InputView inputView, OutputView outputView, String name) {
        outputView.inedibleMenus(name);
        while (true) {
            try {
                List<String> inedibleMenus = inputView.inedibleMenus();
                outputView.println();
                return inedibleMenus;
            } catch (IllegalArgumentException exception) {
                outputView.error(exception.getMessage());
            }
        }
    }
}


