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

    public void setInedibleMenus(List<String> inedibleMenus) {
        this.inedibleMenus = inedibleMenus;
    }

    public boolean addMenu(String menu) {
        if (inedibleMenus.contains(menu) ||
                (!menus.isEmpty() && menu.equals(menus.get(menus.size() - 1)))) {
            return false;
        }
        menus.add((menu));
        return true;
    }

    public String getName() {
        return name;
    }

    public List<String> getMenus() {
        return menus;
    }
}
