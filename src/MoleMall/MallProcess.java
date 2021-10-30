package MoleMall;
//import MoleMall.abstractFactory.CommodityFood;



import MoleMall.shops.ClothesShop;
import MoleMall.utils.JsonUtils;

import java.util.Map;
import java.util.Scanner;


public class MallProcess {
    //商店
    private ClothesShop clothesShop=ClothesShop.newInstance();

    private static final Map<String, String> map = JsonUtils.searchMapper();

    private MallProcess() {
    }

    private static volatile MallProcess mallProcess = new MallProcess();

    public static synchronized MallProcess newInstance() {
        return mallProcess;
    }

    /**
     * 商场总进程
     */
    public void process() {
        ClothesShop clothesShop = ClothesShop.newInstance();

        System.out.print("欢迎来到商场！\n");
        System.out.print("请选择你要进入的商店：1——服装店，2——食品店，3——农资店，0——游戏首页\n");

        while(true){
            Scanner input=new Scanner(System.in);
            int shopSelect = input.nextInt();
            if(shopSelect==1){
                System.out.println("欢迎进入服装店！");
                clothesShop.showClothesShop();
                System.out.println("\n请输入你想要选择的服装名称");
                String clothesName =input.next();
                clothesShop.createClothes(clothesName);


            }
            else if(shopSelect==2){

            }
            else if(shopSelect==3){

            }
            else if(shopSelect==0){

            }
            else {
                continue;
            }
        }

    }

    public static void main(String[] args){//测试用
        MallProcess mallProcess = MallProcess.newInstance();
        mallProcess.process();
        return;
    }
}
