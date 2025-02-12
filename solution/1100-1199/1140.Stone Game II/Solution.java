class Solution {
    private int[] s;
    private Integer[][] f;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        s = new int[n + 1];
        f = new Integer[n][n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + piles[i];
        }
        return dfs(0, 1);
    }

    private int dfs(int i, int m) {
        if (m * 2 >= n - i) {
            return s[n] - s[i];
        }
        if (f[i][m] != null) {
            return f[i][m];
        }
        f[i][m] = 0;
        for (int x = 1; x <= m * 2; ++x) {
            int t = s[n] - s[i] - dfs(i + x, Math.max(m, x));
            f[i][m] = Math.max(f[i][m], t);
        }
        return f[i][m];
    }
}