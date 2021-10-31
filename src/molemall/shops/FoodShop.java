package molemall.shops;

import molemall.abstractfactory.AbstractFood;
import molemall.abstractfactory.factory.FoodFactory;
import molemall.commodities.food.Hamburger;
import molemall.commodities.food.Soda;
import molemall.commodities.food.Watermelon;
import molemall.shops.cart.ShoppingCart;
import molemall.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 食品店
 *
 */
public class FoodShop {
    private static final FoodFactory foodFactory = FoodFactory.newInstance();
    private static final ShoppingCart foodCart = ShoppingCart.newInstance();
    private static final Map<String, String> map = JsonUtils.searchMapper();

    private List<AbstractFood> foodList= new ArrayList<>();


    private static volatile FoodShop foodShop = new FoodShop();

    public static synchronized FoodShop newInstance() {
        return foodShop;
    }

    private FoodShop() {
        foodList.add(new Hamburger());
        foodList.add(new Soda());
        foodList.add(new Watermelon());
    }
    public static void createFood(String name){
        AbstractFood food;
        food=foodFactory.create( map.get(name));
        System.out.println("请输入你需要的数量");
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        foodCart.loadFood(food,num);
    }
    public void checkout(){
        foodCart.printReceipt();
    }

    public void showFoodShop() {
        System.out.println("食品店售卖情况如下：\n");
        System.out.print("食品名称\t\t");
        for (int i =0;i< foodList.size(); i++) {
            System.out.print(String.format("%-10s",foodList.get(i).getItem()));
        }
        System.out.print("\n食品价格\t\t");
        for (int i =0;i< foodList.size(); i++) {
            System.out.print(String.format("%-11s",foodList.get(i).getPrice()));
        }

    }


}
