/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class PatternLock {
    public static boolean CheckPattern(String lock){
        if (lock.length() < 4 || lock.length() >9) return false; // Quy tắc 1

        boolean[] visited = new boolean[9];
        int[][] middle = new int[9][9];

        // Thiết lập các điểm trung gian
        middle[0][2] = 1; middle[2][0] = 1; // Giữa 1 và 3 là 2
        middle[0][6] = 3; middle[6][0] = 3; // Giữa 1 và 7 là 4
        middle[2][8] = 5; middle[8][2] = 5; // Giữa 3 và 9 là 6
        middle[6][8] = 7; middle[8][6] = 7; // Giữa 7 và 9 là 8
        middle[0][8] = 4; middle[8][0] = 4; // Giữa 1 và 9 là 5
        middle[1][7] = 4; middle[7][1] = 4; // Giữa 2 và 8 là 5
        middle[3][5] = 4; middle[5][3] = 4; // Giữa 4 và 6 là 5
        middle[2][6] = 4; middle[6][2] = 4; // Giữa 3 và 7 là 5

        // Duyệt qua từng cặp điểm trong chuỗi pattern
        for (int i = 0; i < lock.length() - 1; i++) {
            int start = lock.charAt(i) - '1'; // Điểm bắt đầu (0-based index)
            int end = lock.charAt(i + 1) - '1'; // Điểm kết thúc (0-based index)

            if (visited[end]) return false; // Quy tắc 2: Mỗi điểm chỉ đi qua một lần

            int mid = middle[start][end]; // Lấy điểm trung gian giữa hai điểm
            if (mid != 0 && !visited[mid]) return false; // Quy tắc 3: Đi qua điểm trung gian chưa ghé thăm

            visited[start] = true; // Đánh dấu điểm đã ghé thăm
        }

        return true; // Mẫu hợp lệ
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1 ; tc <= T ; tc++){
            int n= sc.nextInt(); // so luong chuoi lock
            sc.nextLine();
            int [] result = new int[n];
            for(int i=0;i<n;i++){
                String lock = sc.nextLine();
                if(CheckPattern(lock))
                    result[i] = 1;
                else
                    result[i] = 0;
            }
            System.out.print("\n#"+tc+" ");
            for(int i=0;i<n;i++){
                System.out.print(result[i]);
            }
        }
    }

}
