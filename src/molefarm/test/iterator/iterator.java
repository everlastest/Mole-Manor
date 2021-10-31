package molefarm.test.iterator;

import molefarm.common.MoleFarm;
import molefarm.pattern.iterator.conc.FarmIterator;

public class iterator {
    public static void main(String[] args) {
        MoleFarm farm = MoleFarm.getInstance();
        FarmIterator iterator = farm.getIterator();
        System.out.println(iterator.first());
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
