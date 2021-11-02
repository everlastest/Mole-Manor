package molemall.pattern.visitor;

public class ClothesLeaseVisitor implements ClothesVisitor {
    @Override
    public <T> void visit(T t) {
        System.out.println("您选择了租赁");//租赁接口放置？？？
    }

}
