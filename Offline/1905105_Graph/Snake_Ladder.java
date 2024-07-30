import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Snake_Ladder {

    static int[] fileReader(BufferedReader br) throws IOException {
        String line_2 = br.readLine();
        String[] s = line_2.split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int[] move = new int[x+1] ;
        move[0] = n;
        line_2 = br.readLine();
        int l = Integer.parseInt(line_2);
        for(int j=0; j<l; j++){
            String line_l = br.readLine();
            String[] s1 = line_l.split(" ");
            move[Integer.parseInt(s1[0])] = Integer.parseInt(s1[1]);
        }
        line_2 = br.readLine();
        int sn = Integer.parseInt(line_2);
        for(int j=0; j<sn; j++){
            String line_s = br.readLine();
            String[] s1 = line_s.split(" ");
            move[Integer.parseInt(s1[0])] = Integer.parseInt(s1[1]);
        }
        return move;
    }

    static Vertex getMinPath(int[] move, int[] visited, int[] prev, int x, int n){
        Queue<Vertex> q = new LinkedList<>();
        Vertex f_v = new Vertex();
        f_v.setDis(-1);
        int found = -1;
        Vertex u = new Vertex();
        u.setNo(1);
        u.setDis(0);
        visited[1] = 1;
        prev[1] = -1;
        q.add(u);
        while(!q.isEmpty()){
            u = q.remove();
            if(u.getNo() == x && found==-1){
                f_v = u;
                found = 1;
            }
            for(int k = u.getNo()+1; (k<= u.getNo() + n) && k<=x ; k++){
                if (visited[k] == 0){
                    Vertex v = new Vertex();
                    v.setDis(u.getDis()+1);
                    prev[k] = u.getNo();
//                    System.out.println(prev[k]);
                    visited[k] = 1;
                    int l;
                    if(move[k]!=0) {
                        l = move[k];
                        visited[l] = 1;
                        prev[l] = k;
//                        System.out.println(prev[l]);
                    }
                    else
                        l = k;
                    v.setNo(l);
                    q.add(v);
                }
            }
        }
        return f_v;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String line = br.readLine();
        int t = Integer.parseInt(line);
        for(int i=0; i<t; i++){
            int[] move = fileReader(br);
            int x = move.length - 1;
            int n = move[0];
            int[] visited= new int[x+1];
            int[] prev = new int[x+1];
            Vertex Result = getMinPath(move, visited, prev, x, n);
            System.out.println(Result.getDis());
            bw.write(String.valueOf(Result.getDis()));
            bw.newLine();

            boolean All_v = true;

            if(Result.getDis()!=-1) {
                Stack<Integer> path_out = new Stack<Integer>();
                path_out.push(x);
                for (int cc = x; cc > 1; ) {
                    path_out.push(prev[cc]);
                    cc = prev[cc];
                }
                while(!path_out.isEmpty()) {
                    int temp = path_out.pop();
                    System.out.print(temp);
                    bw.write(String.valueOf(temp));
                    if (!path_out.isEmpty()) {
                        System.out.print(" -> ");
                        bw.write(" -> ");
                    }
                }
                System.out.println();
                bw.newLine();
            }
            else{
                System.out.println("No solution");
                bw.write("No solution\n");
            }

            for(int cc=1; cc< visited.length; cc++) {
                if(visited[cc] == 0) {
                    System.out.print(cc + " ");
                    bw.write(cc + " ");
                    All_v = false;
                }
            }

            if(All_v) {
                System.out.print("All reachable");
                bw.write("All reachable");
            }
            System.out.println();
            bw.newLine();
            if(i!=t-1){
                System.out.println();
                bw.newLine();
            }
        }
        br.close();
        bw.close();
    }
}
