package MoleFarm.pattern.state;

import MoleFarm.MoleFarm;

public interface Weather {
    void watering(MoleFarm moleFarm);

    void disinsection(MoleFarm moleFarm);
}
