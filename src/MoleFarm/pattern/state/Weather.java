package MoleFarm.pattern.state;

import MoleFarm.common.MoleFarm;

public interface Weather {
    void watering(MoleFarm moleFarm);

    void disinsection(MoleFarm moleFarm);
}
