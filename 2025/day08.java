import java.util.*;

public class JunctionBoxConnections {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ----------------------------
        // 1. Citire coordonate
        // ----------------------------
        long[] X = new long[10000];
        long[] Y = new long[10000];
        long[] Z = new long[10000];
        int n = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.equals("")) continue;

            String[] p = line.split(",");
            X[n] = Long.parseLong(p[0].trim());
            Y[n] = Long.parseLong(p[1].trim());
            Z[n] = Long.parseLong(p[2].trim());
            n++;
        }

        if (n == 0) {
            System.out.println(0);
            return;
        }

        // ----------------------------
        // 2. Construim lista tuturor distanțelor dintre perechi
        // ----------------------------
        int totalPairs = n * (n - 1) / 2;
        int[] U = new int[totalPairs];   // primul punct al perechii
        int[] V = new int[totalPairs];   // al doilea punct
        long[] D = new long[totalPairs]; // distanța la pătrat
        int m = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                long dx = X[i] - X[j];
                long dy = Y[i] - Y[j];
                long dz = Z[i] - Z[j];

                long dist2 = dx*dx + dy*dy + dz*dz;

                U[m] = i;
                V[m] = j;
                D[m] = dist2;
                m++;
            }
        }

        // ----------------------------
        // 3. Sortăm toate perechile după distanță
        // ----------------------------
        Integer[] order = new Integer[m];
        for (int i = 0; i < m; i++) order[i] = i;

        Arrays.sort(order, (a, b) -> Long.compare(D[a], D[b]));

        // ----------------------------
        // 4. Construim graf neorientat cu primele 1000 perechi
        // ----------------------------
        int K = 1000;
        if (K > m) K = m;

        boolean[][] adj = new boolean[n][n];

        for (int i = 0; i < K; i++) {
            int idx = order[i];
            int a = U[idx];
            int b = V[idx];

            adj[a][b] = true;
            adj[b][a] = true;
        }

        // ----------------------------
        // 5. Determinăm componentele conexe prin DFS
        // ----------------------------
        boolean[] visited = new boolean[n];
        ArrayList<Integer> componentSizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int size = dfs(i, adj, visited);
                componentSizes.add(size);
            }
        }

        // ----------------------------
        // 6. Sortăm componentele descrescător și calculăm produsul primelor trei
        // ----------------------------
        componentSizes.sort(Collections.reverseOrder());

        long result = 1;
        int limit = Math.min(3, componentSizes.size());

        for (int i = 0; i < limit; i++) {
            result *= componentSizes.get(i);
        }

        System.out.println(result);
    }

    // DFS pentru aflarea dimensiunii unei componente
    static int dfs(int start, boolean[][] adj, boolean[] visited) {
        int n = adj.length;
        int count = 0;

        Stack<Integer> st = new Stack<>();
        st.push(start);
        visited[start] = true;

        while (!st.isEmpty()) {
            int node = st.pop();
            count++;

            for (int v = 0; v < n; v++) {
                if (adj[node][v] && !visited[v]) {
                    visited[v] = true;
                    st.push(v);
                }
            }
        }

        return count;
    }
}
