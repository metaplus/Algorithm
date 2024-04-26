package problem.search.binary;

public class Lc1533GetIndex {

    public int getIndex(ArrayReader reader) {
        return dfs(reader, 0, reader.length() - 1);
    }

    public int dfs(ArrayReader reader, int left, int right) {
        if (left == right) {
            return left;
        }
        int len = right - left + 1;
        if (len % 2 == 1) {
            int cmp = reader.compareSub(left, left + len / 2 - 1, left + len / 2 + 1, right);
            if (cmp == 0) {
                return left + len / 2;
            }
            if (cmp > 0) {
                return dfs(reader, left, left + len / 2 - 1);
            }
            return dfs(reader, left + len / 2 + 1, right);
        }
        int cmp = reader.compareSub(left, left + len / 2 - 1, left + len / 2, right);
        if (cmp == 0) {
            return -1;
        }
        if (cmp > 0) {
            return dfs(reader, left, left + len / 2 - 1);
        }
        return dfs(reader, left + len / 2, right);
    }

    // This is ArrayReader's API interface.
    // You should not implement it, or speculate about its implementation
    interface ArrayReader {
        // Compares the sum of arr[l..r] with the sum of arr[x..y]
        // return 1 if sum(arr[l..r]) > sum(arr[x..y])
        // return 0 if sum(arr[l..r]) == sum(arr[x..y])
        // return -1 if sum(arr[l..r]) < sum(arr[x..y])
        public int compareSub(int l, int r, int x, int y);

        // Returns the length of the array
        public int length();
    }
}
