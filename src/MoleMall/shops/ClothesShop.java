package MoleMall.shops;

import MoleMall.abstractFactory.AbstractClothes;
import MoleMall.commodities.clothes.Jackets;
import MoleMall.commodities.clothes.Jeans;
import MoleMall.commodities.clothes.Shorts;
import MoleMall.commodities.clothes.Tshirt;
import MoleMall.abstractFactory.factory.ClothesFactory;
import MoleMall.strategy.ShoppingCart;
import MoleMall.utils.JsonUtils;
import MoleMall.visitor.ClothesLeaseVisitor;
import MoleMall.visitor.ClothesPurchaseVisitor;
import MoleMall.visitor.ClothesVisitor;

import java.util.*;

/**
 * 服装店
 *
 */
public class ClothesShop {
    private static final ClothesFactory clothesFactory = ClothesFactory.newInstance();
    private static final ShoppingCart clothesCart = ShoppingCart.newInstance();
    private static final Map<String, String> map = JsonUtils.searchMapper();
    /**
     * 服装存储
     */
    private Map<AbstractClothes,Double> clothesMap=new HashMap<>();
    /**
     * 服装分区：上衣区，下衣区，鞋子区，帽子区共4种
     */
    private Integer clothesBlockCount = 2;//再改
    /**
     * 服装分区列表
     */
    private List<clothesBlock> clothesBlockList= new ArrayList<>();

    private List<AbstractClothes> clothesList= new ArrayList<>();


    private static volatile ClothesShop clothesShop = new ClothesShop();

    public static synchronized ClothesShop newInstance() {
        return clothesShop;
    }

    private ClothesShop() {
        clothesList.add(new Jackets());
        clothesList.add(new Tshirt());
        clothesList.add(new Jeans());
        clothesList.add(new Shorts());
    }
    public static void createClothes(String name){
        AbstractClothes clothes;
        clothes=clothesFactory.create( map.get(name));

        /**
         * 可能会改写到别的地方，租赁or购买询问
         */
        while(true){
            System.out.println("请问你是要购买还是租赁这件服装：1——购买，2——租赁");
            Scanner input=new Scanner(System.in);
            int select = input.nextInt();
            if(select==1){//购买
                ClothesVisitor visitor=new ClothesPurchaseVisitor();
               clothesCart.accept(visitor);
               break;
            }
            else if(select==2){//租赁
                ClothesVisitor visitor=new ClothesLeaseVisitor();
                clothesCart.accept(visitor);
                break;
            }
            else {
                continue;
            }
        }

        clothesCart.loadClothes(clothes,1);
        clothesCart.loadClothes(clothes,2);
        clothesCart.printReceipt();

    }

    public void showClothesShop() {
        System.out.println("服装店售卖情况如下：\n");
        System.out.print("服装名称\t\t");
        for (int i =0;i< clothesList.size(); i++) {
            System.out.print(String.format("%-10s",clothesList.get(i).getItem()));
        }
        System.out.print("\n服装价格\t\t");
        for (int i =0;i< clothesList.size(); i++) {
            System.out.print(String.format("%-11s",clothesList.get(i).getPrice()));
        }

    }


}
