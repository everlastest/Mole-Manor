package moleFarm.test.state;

import moleFarm.common.MoleFarmBlock;
import moleFarm.common.status.FarmBlockStatus;
import moleFarm.pattern.state.Context;
import moleFarm.pattern.state.conc.SunnyWeather;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        MoleFarmBlock block=new MoleFarmBlock();
        Set<FarmBlockStatus>set=new HashSet<>();

        block.setBlockStatusSet(set);
        Context context = new Context(new SunnyWeather());
        context.watering();
    }
}
