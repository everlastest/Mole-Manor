package molemall.shops.cart;

import molemall.abstractfactory.AbstractClothes;
import molemall.abstractfactory.AbstractFood;
import molemall.abstractfactory.ICommodity;
import molemall.strategy.SaleSelect;
import molemall.visitor.ClothesVisitor;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart{//之后增加继承，目前用于测试；输出：打印一张小票
    //使用list装载购买的物品
    List<CommodityForCart> commoditylist=new ArrayList<CommodityForCart>();
    /**
     * @param newInstance
     */
    private static volatile ShoppingCart cart;
    private ShoppingCart(){

    }
    public synchronized static ShoppingCart newInstance(){
        cart=new ShoppingCart();
        return cart;
    }

    /**
     * visitor模式：接受租赁和购买两种操作
     * @param clothesVisitor
     */
    public void accept(ClothesVisitor clothesVisitor){clothesVisitor.visit(this);}


    public <T extends ICommodity> boolean loadObject(T object, int num) {
        CommodityForCart commodity=new CommodityForCart(object.getItem(),object.getPrice(),num);
        Integer it=commoditylist.indexOf(commodity);
        if (it != -1){ //若购物车中已经有此商品，则将其与新增商品数量累加
            commoditylist.get(it).num+=num;
        }
        else{ //若购物车中没有此商品，则将其加入其中
            commoditylist.add(commodity);
        }
        return true;
    }

    public boolean loadClothes(AbstractClothes clothes, int num){
        return loadObject(clothes,num);
    }
    public boolean loadFood(AbstractFood food, int num){
        return loadObject(food,num);
    }

    /**
     * 打印小票
     */
    public void printReceipt(){
        if(commoditylist.size()>0){
            Double sumPrice=0.0;
        System.out.println("\n--------发票--------");
        System.out.println("名称\t\t价格\t\t数量");
        for (int i =0;i< commoditylist.size(); i++) {
            Double price=commoditylist.get(i).getPrice();
            int num=commoditylist.get(i).getNum();
            System.out.print(String.format("%-7s",commoditylist.get(i).getItem()));
            System.out.print(String.format("%-8s",price));
            System.out.print(String.format("%-8s",num));
            System.out.print("\n");
            sumPrice+=price*num;
        }
            System.out.println("\n\n总价格 \t\t"+sumPrice);
            System.out.println("-------------------");
            /**
             * 清空购物车
             */
            commoditylist.clear();
        }
        else{
            return;
        }
    }
    /**
     * 打印小票
     */
    public void printPurchaseReceipt(){
        if(commoditylist.size()>0){
            Double sumPrice=0.0;
            System.out.println("\n--------发票--------");
            System.out.println("名称\t\t价格\t\t数量");
            for (int i =0;i< commoditylist.size(); i++) {
                Double price=commoditylist.get(i).getPrice();
                int num=commoditylist.get(i).getNum();
                System.out.print(String.format("%-7s",commoditylist.get(i).getItem()));
                System.out.print(String.format("%-8s",price));
                System.out.print(String.format("%-8s",num));
                System.out.print("\n");
                sumPrice+=price*num;
            }
            System.out.println("\n\n总价格 \t\t"+sumPrice);
            Double realPrice=SaleSelect.sale(sumPrice);
            System.out.println("实付价格\t\t"+realPrice);
            System.out.println("-------------------");
            /**
             * 清空购物车
             */
            commoditylist.clear();
        }
        else{
            return;
        }
    }


    /**
     * 打印小票
     */
    public void printLeaseReceipt(){
        if(commoditylist.size()>0){
            Double sumPrice=0.0;
            System.out.println("\n------租赁票据------");
            System.out.println("名称\t\t价格\t\t数量");
            for (int i =0;i< commoditylist.size(); i++) {
                Double price=commoditylist.get(i).getPrice();
                int num=commoditylist.get(i).getNum();
                System.out.print(String.format("%-7s",commoditylist.get(i).getItem()));
                System.out.print(String.format("%-8s",price));
                System.out.print(String.format("%-8s",num));
                System.out.print("\n");
                sumPrice+=price*num;
            }
            System.out.println("\n\n租赁时长 \t\t一个月");
            System.out.println("租赁价格 \t\t"+sumPrice*0.1);
            System.out.println("-------------------");
            /**
             * 清空购物车
             */
            commoditylist.clear();
        }
        else{
            return;
        }
    }

}
