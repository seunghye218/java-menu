package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<Coach> coaches = getCoaches(getNames(inputView, outputView));
        setInedibleMenus(inputView, outputView, coaches);

        List<Category> categoriesOfWeek = getCategoriesOfWeek();
        recommendMenu(coaches, categoriesOfWeek);

        outputView.result(categoriesOfWeek, coaches);
    }

    private static void recommendMenu(List<Coach> coaches, List<Category> categoriesOfWeek) {
        for (Category category : categoriesOfWeek) {
            List<String> menus = category.getMenus();
            for (Coach coach : coaches) {
                addMenu(coach, menus);
            }
        }
    }

    private static void addMenu(Coach coach, List<String> menus) {
        while (true) {
            if (coach.addMenu(Randoms.shuffle(menus).get(0))) {
                break;
            }
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

    private static List<Category> getCategoriesOfWeek() {
        List<Category> categoriesOfWeek = new ArrayList<>();
        while (categoriesOfWeek.size() < 5) {
            Category category = Category.get(Randoms.pickNumberInRange(1, 5));
            if (isValidCategory(categoriesOfWeek, category)) {
                categoriesOfWeek.add(category);
            }
        }
        return categoriesOfWeek;
    }

    private static boolean isValidCategory(List<Category> categoriesOfWeek, Category category) {
        if (categoriesOfWeek.size() < 3) {
            return true;
        }
        int lastIndex = categoriesOfWeek.size() - 1;
        return category != categoriesOfWeek.get(lastIndex - 1) || category != categoriesOfWeek.get(lastIndex - 2);
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


