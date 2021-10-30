package MoleMall.visitor;

public class ClothesLeaseVisitor implements ClothesVisitor {
    @Override
    public <T> void visit(T t) {
        System.out.println("租赁");
    }

}
