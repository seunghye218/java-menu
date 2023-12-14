package menu;

import java.util.List;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.start();
        List<String> list = getNames(inputView, outputView);

    }

    private static List<String> getNames(InputView inputView, OutputView outputView) {
        outputView.getNames();
        List<String> names;
        while (true) {
            try {
                return inputView.getNames();
            } catch (IllegalArgumentException exception) {
                outputView.error(exception.getMessage());
            }
        }
    }
}

