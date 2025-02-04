import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s1 = br.readLine();
        String s2 = br.readLine();

        Stack<Character> s = new Stack<>();

        for(int i = 0; i<s2.length();i++)
            s.push(s2.charAt(i));

        while(s.size() >= s1.length()){
            if(s.size() == s1.length()){
                StringBuilder sb = new StringBuilder();
                while(!s.isEmpty()){
                    sb.append(s.pop());
                }
                String s3 = sb.reverse().toString();
                if(s3.equals(s1)){
                    System.out.println(1);
                    return;
                }
                break;
            }

            char x = s.pop();
            if(x == 'B'){
                Stack<Character> temp = new Stack<>();
                while(!s.isEmpty())
                    temp.push(s.pop());
                s = temp;
            }

        }
        System.out.println(0);


    }



}