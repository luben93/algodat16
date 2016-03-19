package lists;

/**
 * Created by luben on 2016-03-18.
 */
public class hash<K, V> {

    private LinkList<Entry<K, V>>[] table;
    private int fill = 0;

    private static class Entry<K, V> {
        public K key;
        public V val;

        public Entry(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public hash(int size) {
        table = new LinkList[size];
    }

    public V put(K key, V val) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (fill <= table.length * 0.75) {
//            resize();
            System.out.println("should resize");
        }
        if (table[index] == null) {
            table[index] = new LinkList<>();
            table[index].add(new Entry<K, V>(key, val));
            return val;
        } else {
//            return table[index].stream().filter(kvEntry -> kvEntry.key.equals(key)).findFirst().orElse(null).val;
            V vold;
            for (Entry<K, V> e : table[index]) {
                if (e.key.equals(key)) {
                    vold = e.val;
                    e.val = val;
                    return vold;
                }
            }
            table[index].add(new Entry<K, V>(key, val));
            return null;
        }
//        fill++;
    }

    public V get(K key, V val) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        return table[index].stream().filter(kvEntry -> kvEntry.key.equals(val)).findFirst().orElse(null).val;
    }
}
