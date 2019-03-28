package lunch_package;

public class Restaurant {
    private int num;
    private String name;
    private String kind;
    private String recoMenu;
    private String menuLink;

    public Restaurant() {
        super();
    }

    public Restaurant(int num, String name, String kind, String recoMenu, String menuLink) {
        this.num = num;
        this.name = name;
        this.kind = kind;
        this.recoMenu = recoMenu;
        this.menuLink = menuLink;
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getRecoMenu() {
        return recoMenu;
    }
    public void setRecoMenu(String recoMenu) {
        this.recoMenu = recoMenu;
    }

    public String getMenuLink() {
        return menuLink;
    }
    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                ", recoMenu='" + recoMenu + '\'' +
                ", menuLink='" + menuLink + '\'' +
                '}';
    }
}
