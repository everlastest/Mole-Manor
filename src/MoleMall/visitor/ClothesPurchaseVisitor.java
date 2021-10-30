package MoleMall.visitor;

public class ClothesPurchaseVisitor implements ClothesVisitor {
    @Override
    public <T> void visit(T t) {
        System.out.println("购买");
    }

}

