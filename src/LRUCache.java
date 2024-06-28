import java.util.*;

public class LRUCache {

    public static class Page{
        int key;
        int val;
        public Page(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Page> mp;
    private Deque<Page> cache;
    private int capacity;

    public LRUCache(int capacity){
        mp = new HashMap<>();
        cache = new ArrayDeque<>(capacity);
        this.capacity = capacity;
    }

    public void put(int key, int val){
        if(mp.containsKey(key)){
            Page p = mp.get(key);
            mp.remove(key);
            cache.remove(p);

        }
        if(cache.size() == this.capacity){
            Page pg = cache.removeLast();
            mp.remove(pg.key);
        }
        Page newPage = new Page(key, val);
        mp.put(key, newPage); // 1-> [1,1], 2->[2,2]
        cache.addFirst(newPage); //[1,1], [2,2]
    }

    public int get(int key){
        if(mp.containsKey(key)){
            Page p = mp.get(key);
            cache.remove(p);
            cache.addFirst(p);
            return p.val;
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cap = Integer.parseInt(sc.nextLine());
        String[] keyVal = sc.nextLine().split(",");
        LRUCache lruCache = new LRUCache(cap);
        lruCache.put(Integer.parseInt(keyVal[0]),Integer.parseInt(keyVal[1]));
        lruCache.get(Integer.parseInt(keyVal[0]));

    }
}
//2, [1,1]
