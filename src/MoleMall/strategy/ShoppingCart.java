package MoleMall.strategy;

import MoleMall.abstractFactory.AbstractClothes;
import MoleMall.abstractFactory.ICommodity;
import MoleMall.visitor.ClothesVisitor;

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
        if(cart==null){
            cart=new ShoppingCart();
        }
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
    public boolean loadFood(AbstractClothes clothes, int num){
        return loadObject(clothes,num);
    }

    /**
     * 打印小票
     */
    public void printReceipt(){
        System.out.println("开具发票：\n");
        System.out.print("名称\t\t");
        for (int i =0;i< commoditylist.size(); i++) {
            System.out.print(String.format("%-10s",commoditylist.get(i).getItem()));
        }
        System.out.print("\n价格\t\t");
        for (int i =0;i< commoditylist.size(); i++) {
            System.out.print(String.format("%-11s",commoditylist.get(i).getPrice()));
        }
        System.out.print("\n数量\t\t");
        for (int i =0;i< commoditylist.size(); i++) {
            System.out.print(String.format("%-11s",commoditylist.get(i).getNum()));
        }
    }

}
