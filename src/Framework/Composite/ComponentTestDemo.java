package Framework.Composite;

public class ComponentTestDemo {
    public static void main(String[] args) {

        Menu menu = new Menu("menu");

        Menu mmenu1 = new Menu("mmenu1");
        MenuOption mmenu2 = new MenuOption("mmenu2");
        MenuOption mmenu3 = new MenuOption("mmenu3");

        menu.add(mmenu1, mmenu2, mmenu3);

        MenuOption mmmenu1 = new MenuOption("mmmenu1");
        MenuOption mmmenu2 = new MenuOption("mmmenu2");
        MenuOption mmmenu3 = new MenuOption("mmmenu3");

        mmenu1.add(mmmenu1, mmmenu2, mmmenu3);

        menu.printMenu();
        System.out.println();

        Component m = menu.moveTo(0);
        m.printMenu();
        System.out.println();

        m = m.getLast();
        m.printMenu();

    }
}
