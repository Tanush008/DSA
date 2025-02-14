class ProductOfNumbers {
    Stack<Integer> st = new Stack<>();

    public ProductOfNumbers() {

    }

    public void add(int num) {
        st.push(num);
    }

    public int getProduct(int k) {
        int res = 1;
        if (st.size() >= k) {
            List<Integer> list = new ArrayList<>(st);
            for (int i = list.size() - k; i < list.size(); i++) {
                res *= list.get(i);
            }
        }
        return res;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */