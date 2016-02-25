import java.util.HashMap;
import java.util.Map;

class CacheNode {
    int key;
    int value;
    CacheNode prev, next;
    CacheNode(int x, int y) {
        key = x;
        value = y;
        prev = null;
        next = null;
    }
}
public class LRUCache {
    private int capacity_ = 0;
    private Map<Integer, CacheNode> map;
    private CacheNode head, tail;
    public LRUCache(int capacity) {
        capacity_ = capacity;
        map = new HashMap<Integer, CacheNode>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        CacheNode cur = map.get(key);
        if (cur == tail) {
            return cur.value;
        } else if (cur == head) {
            head = head.next;
            head.prev = null;
        } else {
	        CacheNode pre = cur.prev, nxt = cur.next;
	        pre.next = nxt;
	        nxt.prev = pre;
        }
        tail.next = cur;
        cur.prev = tail;
        tail = tail.next;
        return cur.value;
    }
    
    public void set(int key, int value) {
    	if (head != null && tail != null)
        if (map.containsKey(key)) {
            CacheNode cur = map.get(key);
            if (cur == tail) {
                cur.value = value;
                return;
            } else if (cur == head) {
                head = head.next;
                head.prev = null;
            } else {
                CacheNode pre = cur.prev, nxt = cur.next;
                pre.next = nxt;
                nxt.prev = pre;
            }
            cur.value = value;
            tail.next = cur;
            cur.prev = tail;
            cur.next = null;
            tail = tail.next;

        } else { //check whether full
            if (map.size() == capacity_) {
                map.remove(head.key);
                head = head.next;
                if (head == null) {
                    tail = null;
                } else {
                    head.prev = null;
                }
            }
       
            CacheNode node = new CacheNode(key, value); 
            if (head == null && tail == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = tail.next;
            }
            map.put(key, node);
        }
        return;
    }
}