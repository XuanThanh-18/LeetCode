package SW.Advance1;

import java.io.*;
import java.util.*;

public class HotGirl_CoolBoy {
    static int T, N, M, R1, C1, R2, C2, R3, C3;
    static int[][] graph;
    // visited[girlRow][girlCol][boyRow][boyCol]
    static boolean[][][][] visited;
    static int[] dr = {-1, 0, 1, 0}; // up, right, down, left
    static int[] dc = {0, 1, 0, -1};

    static class Node {
        int rg, cg, rb, cb, step;
        Node(int rg, int cg, int rb, int cb, int step) {
            this.rg = rg; this.cg = cg; this.rb = rb; this.cb = cb; this.step = step;
        }
    }

    static boolean inside(int r, int c) {
        return r >= 1 && r <= N && c >= 1 && c <= M;
    }

    static boolean open(int r, int c) {
        return inside(r, c) && graph[r][c] == 0;
    }

    public static void main(String[] args) {
        try {
            InputStream is = HotGirl_CoolBoy.class.getResourceAsStream("/HotGirl_CoolBoy.txt");
            if (is == null) throw new IOException("Không tìm thấy file input trong resources");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            T = Integer.parseInt(br.readLine().trim());
            StringTokenizer st;

            for (int tc = 1; tc <= T; tc++) {
                st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());
                R1 = Integer.parseInt(st.nextToken());
                C1 = Integer.parseInt(st.nextToken());
                R2 = Integer.parseInt(st.nextToken());
                C2 = Integer.parseInt(st.nextToken());
                R3 = Integer.parseInt(st.nextToken());
                C3 = Integer.parseInt(st.nextToken());

                graph = new int[N + 1][M + 1];
                for (int i = 1; i <= N; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 1; j <= M; j++) graph[i][j] = Integer.parseInt(st.nextToken());
                }

                visited = new boolean[N + 1][M + 1][N + 1][M + 1];
                int ans = bfs();
                if (ans >= 0) System.out.println("Case #" + tc + ": Min steps = " + ans);
                else System.out.println("Case #" + tc + ": Impossible");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static int bfs() {
        // nếu bắt đầu đã ở đích
        if (R1 == R3 && C1 == C3 && R2 == R3 && C2 == C3) return 0;

        Queue<Node> q = new LinkedList<>();
        visited[R1][C1][R2][C2] = true;
        q.add(new Node(R1, C1, R2, C2, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                // Girl cố đi theo d
                int ngr = cur.rg + dr[d];
                int ngc = cur.cg + dc[d];
                if (!open(ngr, ngc)) { ngr = cur.rg; ngc = cur.cg; } // đứng yên nếu không thể

                // Boy đi ngược
                int nrb = cur.rb - dr[d];
                int ncb = cur.cb - dc[d];
                if (!open(nrb, ncb)) { nrb = cur.rb; ncb = cur.cb; }

                // Nếu cả hai chiếm cùng ô và đó không phải đích -> invalid
                if (ngr == nrb && ngc == ncb) {
                    if (!(ngr == R3 && ngc == C3)) continue; // không cho cùng ô ngoài đích
                }

                // Không cho hoán đổi (swap): Girl đi vào ô của Boy trước đó và Boy đi vào ô của Girl trước đó
                boolean swap = (ngr == cur.rb && ngc == cur.cb) && (nrb == cur.rg && ncb == cur.cg);
                if (swap) {
                    // nếu swap là cùng ô đích (cả hai chạm đích nhưng trên swap)...
                    // thường vẫn nên cấm swap; cho đơn giản: continue
                    continue;
                }

                if (!visited[ngr][ngc][nrb][ncb]) {
                    if (ngr == R3 && ngc == C3 && nrb == R3 && ncb == C3) {
                        return cur.step + 1;
                    }
                    visited[ngr][ngc][nrb][ncb] = true;
                    q.add(new Node(ngr, ngc, nrb, ncb, cur.step + 1));
                }
            }
        }
        return -1;
    }
}
