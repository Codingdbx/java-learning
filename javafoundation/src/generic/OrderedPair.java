package generic;

/**
 * 泛型-通用类型
 * created by dbx on 2019/3/14
 */
public class OrderedPair<K, V> extends Pair<K,V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        super(key, value);
    }

    public K getKey()	{
        return key;
    }
    public V getValue() {
        return value;
    }


}