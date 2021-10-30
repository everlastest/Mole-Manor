package MoleMall.strategy;

import java.util.Random;

public class Client {

    public static void checkout() {
        CashContext cashContext = null;

        Random r=new Random();
        int in = r.nextInt(3);
        String type = "";

        switch (in) {
            case 0:
                cashContext = new CashContext(new CashNormal());
                type += "正常收费";
                break;

            case 1:
                cashContext = new CashContext(new CashReturn(300, 100));
                type += "满300返100";
                break;

            case 2:
                cashContext = new CashContext(new CashRebate(0.8));
                type += "打8折";
                break;

            default:
                System.out.println("随机条件有误");
                break;
        }

        double totalPrices = 0;

        double price=10;
        int num=1;
        totalPrices = cashContext.getResult(price * num);

        System.out.println("单价：" + price + "，数量：" + num + "，类型：" + type + "，合计：" + totalPrices);

    }

}
