package moleFarm.pattern.state.conc;

import moleFarm.common.MoleFarmBlock;
import moleFarm.common.MoleFarmWarehouse;
import moleFarm.pattern.adapter.Weather;
import moleFarm.pattern.adapter.conc.MoleAdapter;

public class SunnyWeather extends Weather {

    private MoleAdapter mole=MoleAdapter.getInstance();

    private MoleFarmWarehouse farmWarehouse=mole.getFarmWarehouse();

    @Override
    public void watering(){
        farmWarehouse.getWateringCan().ToolBehavior();
    }
}
