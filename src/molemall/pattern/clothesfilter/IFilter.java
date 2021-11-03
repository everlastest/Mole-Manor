package molemall.pattern.clothesfilter;

import molemall.pattern.abstractfactory.AbstractClothes;
import java.util.List;

public interface IFilter
{
    List<AbstractClothes> filter(List<AbstractClothes> clothesList,double start_price,double end_price);
}
