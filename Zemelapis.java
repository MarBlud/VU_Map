import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Map;
import java.util.*;
import java.io.*;


public class Zemelapis<K, V> implements Map{
    private List<K> keys;
    private List<V> values;

    @Override
    public int size() {
        return keys.size();
    }
    @Override
    public boolean isEmpty(){
        return values.isEmpty();
    }
    @Override
    public boolean containsKey(Object key){
        return values.contains(key);
    }
    @Override
    public boolean containsValue(Object value){
        return values.contains(value);
    }
    @Override
    public V get(Object key){
        if(keys.contains(key)){
            return values.get(keys.indexOf(key));
        }
        return null;
    }
    @Override
    public V put(Object key, Object value){
        V oldValue;
        if(keys.contains(key)){
            oldValue = values.get(keys.indexOf(key));
            values.add(keys.indexOf(key), (V) value);
            return oldValue;
        }else{
            keys.add((K) key);
            values.add((V) value);
            return null;
        }
    }
    public V remove(Object key) {
        for (K objectKey : keys)
        {
            if (objectKey.equals(key))
            {
                values.remove(values.indexOf(objectKey));
                keys.remove(objectKey);
            }
        }
        return null;
    }

    @Override
    public void putAll(Map m) {
        throw new NotImplementedException();
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public Set keySet() {
        Set<K> keysToReturn = new LinkedHashSet<>();
        keysToReturn.addAll(keys);
        return keysToReturn;
    }

    @Override
    public Collection values() {
        return values;
    }

    @Override
    public Set entrySet() {
        throw new NotImplementedException();
    }
}
