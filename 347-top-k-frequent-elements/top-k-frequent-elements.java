class Number implements Comparable<Number> {
    int element, freq;

    Number(int element, int freq) {
        this.element = element;
        this.freq = freq;
    }

    public int compareTo(Number that) {
        // max Heap
        // return that.freq - this.freq;
        // min Heap
        return this.freq - that.freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Map is used to store the freq of number
        HashMap<Integer, Integer> map = new HashMap<>();
        // sort the freq
        PriorityQueue<Number> pq = new PriorityQueue<>();
        int n = nums.length;
        // O(N) putting the element in map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // TC:(TLogT) putting the element in queue from map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Number number = new Number(entry.getKey(), entry.getValue());
            pq.add(number);
            // this can be use when we create the min heap
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int index = 0;
        int res[] = new int[k];
        while (index < k) {
            Number number = pq.poll();
            res[index] = number.element;
            index++;
        }
        return res;
    }
}