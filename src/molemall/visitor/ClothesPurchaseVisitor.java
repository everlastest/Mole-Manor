package molemall.visitor;

public class ClothesPurchaseVisitor implements ClothesVisitor {
    @Override
    public <T> void visit(T t) {
        System.out.println("购买");//购买接口放置
    }

}

