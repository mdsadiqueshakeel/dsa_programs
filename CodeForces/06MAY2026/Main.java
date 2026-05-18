import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int[] a = new int[n + 1];
            List<Integer>[] bucket = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) bucket[i] = new ArrayList<>();
            
            for (int i = 1; i <= n; i++) {
                a[i] = fr.nextInt();
                bucket[a[i]].add(i);
            }

            // 1. Check Strong Connectivity (Critical for Hamiltonian Cycle)
            int minSuffix = Integer.MAX_VALUE;
            boolean possible = true;
            int[] sufMin = new int[n + 1];
            sufMin[n] = a[n];
            for (int i = n - 1; i >= 1; i--) sufMin[i] = Math.min(a[i], sufMin[i+1]);
            
            for (int k = 1; k < n; k++) {
                if (sufMin[k + 1] > k) { possible = false; break; }
            }
            if (a[1] > n && n > 1) possible = false; // Corner case for reachability

            if (!possible) {
                out.println("No");
                continue;
            }

            // 2. Greedy Matching
            int[] nxt = new int[n + 1];    // source -> target
            int[] sourceOf = new int[n + 1]; // target -> source
            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.a - o1.a);
            
            for (int j = 1; j <= n; j++) {
                for (int id : bucket[j]) pq.add(new Node(id, a[id]));
                if (pq.isEmpty()) { possible = false; break; }
                Node best = pq.poll();
                nxt[best.id] = j;
                sourceOf[j] = best.id;
            }

            if (!possible) {
                out.println("No");
                continue;
            }

            // 3. Merge Cycles using DSU
            DSU dsu = new DSU(n);
            for (int i = 1; i <= n; i++) dsu.union(i, nxt[i]);

            for (int j = 1; j < n; j++) {
                int u = sourceOf[j];
                int v = sourceOf[j+1];
                if (dsu.find(u) != dsu.find(v) && a[v] <= j) {
                    // Swap targets to merge cycles
                    nxt[u] = j + 1;
                    nxt[v] = j;
                    sourceOf[j] = v;
                    sourceOf[j+1] = u;
                    dsu.union(u, v);
                }
            }

            if (dsu.size[dsu.find(1)] < n) {
                out.println("No");
            } else {
                out.println("Yes");
                int curr = 1;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(curr).append(i == n - 1 ? "" : " ");
                    curr = nxt[curr];
                }
                out.println(sb.toString());
            }
        }
        out.flush();
    }

    static class Node {
        int id, a;
        Node(int id, int a) { this.id = id; this.a = a; }
    }

    static class DSU {
        int[] parent, size;
        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) { parent[i] = i; size[i] = 1; }
        }
        int find(int i) { return parent[i] == i ? i : (parent[i] = find(parent[parent[i]])); }
        void union(int i, int j) {
            int rootI = find(i), rootJ = find(j);
            if (rootI != rootJ) { parent[rootI] = rootJ; size[rootJ] += size[rootI]; }
        }
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int nextInt() throws IOException {
            while (st == null || !st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}