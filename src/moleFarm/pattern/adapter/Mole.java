package moleFarm.pattern.adapter;

/**
 * 摩尔角色类
 */
public class Mole {
    /*
    摩尔豆（金币）
     */
    private Double money;

    private static Mole mole = new Mole();
    

    public static Mole getInstance() {
        return mole;
    }

    /**
     * 获取摩尔豆
     *
     * @return
     */
    public Double getMoney() {
        return mole.money;
    }

    /**
     * 设置摩尔豆
     *
     * @param money
     */
    public void setMoney(Double money) {
        mole.money = money;
    }
}
