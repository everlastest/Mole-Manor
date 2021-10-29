package moleFarm.pattern.state;

import moleFarm.common.MoleFarm;

public interface Weather {
    default void watering(MoleFarm moleFarm){}

    default void disinsection(MoleFarm moleFarm){}
}
