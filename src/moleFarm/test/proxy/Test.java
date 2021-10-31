package moleFarm.test.proxy;

import moleFarm.pattern.proxy.Proxy;

public class Test {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.fertilizerPurchase("高级肥料",10);
        proxy.seedPurchase("草莓种子",-1);
    }
}
