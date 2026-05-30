import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Solution {
    private int[] tree;
    private int n;

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        }
        else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    private int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        int p1 = query(2 * node, start, mid, l, r);
        int p2 = query(2 * node + 1, mid + 1, end, l, r);
        return Math.max(p1, p2);
    }

    public List<Boolean> getResults(int[][] queries) {
        int max_x = 0;
        for (int[] q : queries) {
            max_x = Math.max(max_x, q[1]);
        }
        max_x = Math.max(max_x, 50000);
        
        n = max_x + 1;
        tree = new int[4 * n];
        
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        
        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];

            if (type == 1) {
                Integer prev = obstacles.floor(x);
                Integer next = obstacles.ceiling(x);

                obstacles.add(x);
                update(1, 0, n - 1, x, x - prev);

                if (next != null) {
                    update(1, 0, n - 1, next, next - x);
                }
            } else {
                int sz = q[2];
                
                int maxCompleteGap = query(1, 0, n - 1, 0, x);
                Integer prevObstacle = obstacles.floor(x);
                int lastGap = x - prevObstacle;
                if (maxCompleteGap >= sz || lastGap >= sz) {
                    ans.add(true);
                }
                else {
                    ans.add(false);
                }
            }
        }

        return ans;
    }
}