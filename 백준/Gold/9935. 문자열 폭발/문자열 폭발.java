import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        String ch = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
            if(stack.size() >= ch.length()){
                int cnt=0;
                for(int j = 0; j < ch.length(); j++){
                    if(ch.charAt(j)==stack.get(stack.size() -(ch.length()-j)))
                        cnt++;
                    if(cnt == ch.length()){
                        while(cnt > 0){
                            cnt--;
                            stack.pop();
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i< stack.size(); i++)
            sb.append(stack.get(i));

        if(sb.toString().equals(""))
            System.out.println("FRULA");
        else
            System.out.println(sb);

    }

}
