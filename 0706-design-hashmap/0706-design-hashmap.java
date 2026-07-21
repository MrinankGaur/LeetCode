class MyHashMap {
    
    boolean[] keySet;
    int[] valueSet;
    public MyHashMap() {
        keySet = new boolean[1000001];
        valueSet = new int[1000001];
    }
    public void put(int key, int value) {
        keySet[key] = true;
        valueSet[key] = value;         
    }
    
    public int get(int key) {
        return keySet[key]? valueSet[key] : -1;
    }
    
    public void remove(int key) {
        keySet[key] = false;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */