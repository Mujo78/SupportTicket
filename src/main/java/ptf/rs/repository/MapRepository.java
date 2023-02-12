package ptf.rs.repository;

import ptf.rs.Config;
import ptf.rs.models.BaseClass;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapRepository<T extends BaseClass> implements CRUDRepository<T> {
    private long counter = 0;

    private final Map<Long, T> valuesMap = new HashMap<>();
    @Override
    public void save(T value) {
        if(value.getId() != null){
            update(value);
            return;
        }
        value.setId(counter);
        valuesMap.put(counter++, value);
        if(Config.DEBUG_MODE) System.out.println(value + "\" saved to map!!");
        }

    @Override
    public void update(T value) {
        if(value.getId() ==null) throw new IllegalStateException("Cannot update value with the id of null");
        valuesMap.put(value.getId(), value);
        if(Config.DEBUG_MODE) System.out.println(value + "\" updated!!");
    }

    @Override
    public List<T> readAll() {
        List<T> values = valuesMap.values().stream().toList();
        if(Config.DEBUG_MODE) System.out.println("Values read:\n"  + values);
        return values;
    }



    @Override
    public void delete(Long id) {
        if(Config.DEBUG_MODE) System.out.println("Value with id: " + id + " removed");
        valuesMap.remove(id);
    }
}
