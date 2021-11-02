package molemall.pattern.visitor;

public class ClothesPurchaseVisitor implements ClothesVisitor {
    @Override
    public <T> void visit(T t) {
        System.out.println("您选择了购买");//购买接口放置
    }

}

