import java.util.*;
import java.io.*;

public class Main{


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        String boom = br.readLine();

        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            stk.push(str.charAt(i));
            if(stk.size() >= boom.length() && stk.peek() == boom.charAt(boom.length()-1)){
                int flag = 0;
                for(int j = 1; j <= boom.length(); j++){
                    if(stk.get(stk.size() - j) != boom.charAt(boom.length() - j)){
                        flag = 1; break;
                    }
                }
                if(flag == 0){
                    for(int j = 0; j < boom.length(); j++) stk.pop();
                }

            }
        }
        StringBuilder an = new StringBuilder();
        while(!stk.isEmpty()){
            an.append(stk.pop());
        }
        if(an.toString().isEmpty()) System.out.println("FRULA");
        else System.out.println(an.reverse());
    }
}