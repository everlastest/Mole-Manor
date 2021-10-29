package Framework.Composite;

import java.util.ArrayList;

public class MenuList {
    /**
     * 单例模式：菜单表
     */
    private static MenuList instance = new MenuList();
    public static MenuList getInstance(){
        return instance;
    }

    private final Menu menulist = new Menu("菜单列表");

    /**
     * 设置菜单
     */
    private MenuList(){

        /**
         *主菜单
         */
        Menu meanMenu = new Menu("摩尔大厅");
        menulist.add(meanMenu);
        /**
         * 大厅菜单
         */
        Menu amuseMenu = new Menu("摩尔游乐园");
        Menu farmMenu = new Menu("摩尔农场");
        Menu shopMenu = new Menu("摩尔商场");
        Menu chatMenu = new Menu("摩尔聊天室");
        meanMenu.add(amuseMenu, farmMenu, shopMenu, chatMenu);

        /**
         * 聊天室菜单
         */
        chatMenu.add(new MenuOption("发送信息"), new MenuOption("显示聊天内容"));

        /**
         * 游乐园菜单
         */
        amuseMenu.add(new MenuOption("做菜"),new MenuOption("摩摩赛车"),new MenuOption("井字棋"));

        /**
         * 农场菜单
         */

        /**
         * 商场菜单
         */
    }

    /**
     * 获取菜单
     * @param menuname
     * @return
     */
    public Component getMenulist(String menuname){
        return getSublist(menulist.getMenu(), menuname);
    }

    public Component getSublist(ArrayList<Component> sublist, String menuname){
        Component temp;
        for (Component i : sublist){
            if(i.getName() == menuname){
                return i;
            }
            temp = getSublist(i.getMenu(), menuname);
            if(temp != null){
                return temp;
            }
        }
        return null;
    }
}
