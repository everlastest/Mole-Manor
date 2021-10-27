package MoleFarm.pattern.builder;

import MoleFarm.common.MoleFarmBlock;
import MoleFarm.common.product.seed.CabbageSeed;
import MoleFarm.pattern.builder.conc.ConcreteBuilder1;

public class Test {
    public static void main(String[] args) {
        MoleFarmBlock block = new MoleFarmBlock();
        Builder builder1 = new ConcreteBuilder1();
        builder1.setFarmBlock(block);
        Director director = new Director(builder1, block);
        //因为是测试，随便传一个种子和一个肥料回去
        MoleFarmBlock moleFarmBlock = director.getMoleFarmBlock(new CabbageSeed());
        //接着输出土地块的状态即可
        //moleFarmBlock.getStatusList().forEach(System.out::println);
    }
}
