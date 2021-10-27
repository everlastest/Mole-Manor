package moleFarm.pattern.state;

import moleFarm.common.MoleFarm;

public interface Weather {
    void watering(MoleFarm moleFarm);

    void disinsection(MoleFarm moleFarm);
}
