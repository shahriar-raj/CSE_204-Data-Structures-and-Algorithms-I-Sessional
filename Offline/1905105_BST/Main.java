import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BST obj = new BST();
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] s = line.split(" ");
            switch (s[0]){
                case "I":
                    obj.Insert(Integer.parseInt(s[1]));
                    obj.Print();
                    break;
                case "F":
                    if(obj.Find(Integer.parseInt(s[1])))
                        System.out.println("True");
                    else
                        System.out.println("False");
                    break;
                case "D":
                    if(!obj.Delete(Integer.parseInt(s[1])))
                        System.out.println("Invalid Operation");
                    else
                        obj.Print();
                    break;
                case "T":
                    int[] arr = obj.Traversal(s[1]);
                    for(int i:arr)
                        System.out.print(i+" ");
                    System.out.println();
                    break;
                default:
                    break;
            }
        }
        br.close();
    }
}
