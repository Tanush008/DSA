class Solution {
    public boolean reorderedPowerOf2(int n) {
        int arr[] = getDigit(n);
        for (int i = 0; i < 31; i++) {
            int power = 1 << i;
            int powerArr[] = getDigit(power);
            if (Arrays.equals(arr, powerArr)) {
                return true;
            }
        }
        return false;
    }

    public int[] getDigit(int n) {
        int[] arr = new int[10];
        while (n > 0) {
            int digit = n % 10;
            arr[digit]++;
            n /= 10;
        }
        return arr;
    }
}