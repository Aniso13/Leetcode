class TimeMap {
    Node head;

    public TimeMap() {
        head = new Node();
    }

    public void set(String key, String value, int timestamp) {
        head = new Node(key, value, timestamp, head);
    }

    public String get(String key, int timestamp) {
        return dfs(key, timestamp, head);
    }

    private String dfs(String key, int timestamp, Node node) {
        if(node == null) return new String();
        if(key.equals(node.key) && timestamp >= node.timestamp) return node.value;

        return dfs(key, timestamp, node.prev);
    }

    class Node {
        String key, value;
        int timestamp;
        Node prev;

        Node(){}
        Node(String _key, String _value, int _timestamp, Node _prev) {
            key = _key;
            value = _value;
            timestamp = _timestamp;
            prev = _prev;
        }
    }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */