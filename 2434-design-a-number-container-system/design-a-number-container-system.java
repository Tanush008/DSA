class NumberContainers {
    // Stack<Integer,Integer>st = new Stack<>();
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, TreeSet<Integer>> numToidx = new HashMap<>();

    public NumberContainers() {
        // NumberContainers nc = new NumberContainers();
    }

    public void change(int index, int number) {
        if (map.containsKey(index)) {
            int oldNum = map.get(index);
            numToidx.get(oldNum).remove(index);
            if (numToidx.get(oldNum).isEmpty()) {
                numToidx.remove(oldNum);
            }
        }
        map.put(index, number);
        numToidx.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        if (!numToidx.containsKey(number)) {
            return -1;
        }
        return numToidx.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */