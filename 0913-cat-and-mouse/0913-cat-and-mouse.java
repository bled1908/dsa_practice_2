import java.util.*;

class Solution {
    private int[][][] state;

    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        state = new int[n][n][2];
        for (int[][] arr : state) {
            for (int[] subArr : arr) {
                Arrays.fill(subArr, -1);
            }
        }
        
        dfs(graph, 1, 2, 0);

        List<int[]> revisit = new ArrayList<>();
        int lastRound = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    if (state[i][j][k] == 0) {
                        int[] v = {i, j, k};
                        revisit.add(v);
                    }
                }
            }
        }

        while (lastRound != revisit.size() && revisit.size() != 0) {
            lastRound = revisit.size();
            for (int[] v : revisit) {
                state[v[0]][v[1]][v[2]] = -1;
                dfs(graph, v[0], v[1], v[2]);
            }
            revisit.clear();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < 2; k++) {
                        if (state[i][j][k] == 0) {
                            int[] v = {i, j, k};
                            revisit.add(v);
                        }
                    }
                }
            }
        }

        if (state[1][2][0] == -1) {
            return 0;
        } else {
            return state[1][2][0];
        }
    }

    private int dfs(int[][] graph, int mouse, int cat, int turn) {
        if (state[mouse][cat][turn] != -1) {
            return state[mouse][cat][turn];
        }
        if (mouse == 0) {
            state[mouse][cat][turn] = 1;
            return 1;
        }
        if (mouse == cat) {
            state[mouse][cat][turn] = 2;
            return 2;
        }
        state[mouse][cat][turn] = 0;

        if (turn == 0) { // Mouse's turn
            boolean isDraw = false;
            for (int i = 0; i < graph[mouse].length; i++) {
                int nextTurn = dfs(graph, graph[mouse][i], cat, turn + 1);
                if (nextTurn == 1) {
                    isDraw = false;
                    state[mouse][cat][turn] = 1;
                    return 1;
                }
                if (nextTurn == 0) {
                    isDraw = true;
                }
            }
            if (isDraw) {
                state[mouse][cat][turn] = 0;
                return 0;
            }
            state[mouse][cat][turn] = 2;
            return 2;
        } else { // Cat's turn
            boolean isDraw = false;
            for (int i = 0; i < graph[cat].length; i++) {
                if (graph[cat][i] != 0) {
                    int nextTurn = dfs(graph, mouse, graph[cat][i], turn - 1);
                    if (nextTurn == 2) {
                        isDraw = false;
                        state[mouse][cat][turn] = 2;
                        return 2;
                    }
                    if (nextTurn == 0) {
                        isDraw = true;
                    }
                }
            }
            if (isDraw) {
                state[mouse][cat][turn] = 0;
                return 0;
            }
            state[mouse][cat][turn] = 1;
            return 1;
        }
    }
}