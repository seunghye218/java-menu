package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> menus;
    private List<String> inedibleMenus;

    public Coach(String name) {
        this.name = name;
        this.menus = new ArrayList<>();
        this.inedibleMenus = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setInedibleMenus(List<String> inedibleMenus) {
        this.inedibleMenus = inedibleMenus;
    }
}
