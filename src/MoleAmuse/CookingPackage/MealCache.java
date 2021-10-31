package MoleAmuse.CookingPackage;

import MoleAmuse.CookingPackage.Prototype.AbstractMeal;
import MoleAmuse.CookingPackage.Prototype.GongBaoJiDing;
import MoleAmuse.CookingPackage.Prototype.SuanCaiYu;
import MoleAmuse.CookingPackage.Prototype.TangCuLiJi;

import java.util.Hashtable;

public class MealCache {

    private static Hashtable<String, AbstractMeal> mealMap = new Hashtable<String, AbstractMeal>();


    /**
     * 获取克隆对象
     * @param mealId
     * @return
     */
    public static AbstractMeal getMeal(String mealId) {
        AbstractMeal cachedMeal = mealMap.get(mealId);
        if (cachedMeal == null) {return null;}
        return (AbstractMeal) cachedMeal.clone();
    }


    /**
     * 在数据库中加载实体菜
     * mealMap.put(mealKey, meal);
     */

    public static void loadCache() {

        GongBaoJiDing gongBaoJiDing = new GongBaoJiDing();
        gongBaoJiDing.setId("1");
        mealMap.put(gongBaoJiDing.getId(), gongBaoJiDing);

        TangCuLiJi tangCuLiJi = new TangCuLiJi();
        tangCuLiJi.setId("2");
        mealMap.put(tangCuLiJi.getId(), tangCuLiJi);

        SuanCaiYu suanCaiYu = new SuanCaiYu();
        suanCaiYu.setId("3");
        mealMap.put(suanCaiYu.getId(), suanCaiYu);
    }
}
