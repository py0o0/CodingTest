import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            String str1 = br.readLine();
            String str2 = br.readLine();

            Stack<Character> stk = new Stack<>();

            for(int i =0; i< str1.length(); i++){
                stk.push(str1.charAt(i));

                if(stk.size() >= str2.length() && stk.peek().equals(str2.charAt(str2.length() - 1))){
                    StringBuilder str3 = new StringBuilder();
                    for(int j = 0; j<str2.length(); j++){
                        str3.append(stk.pop());
                    }
                    str3 = str3.reverse();
                    if(!str2.equals(str3.toString())){
                        for(int j = 0; j<str3.length(); j++)
                            stk.push(str3.charAt(j));
                    }

                }
            }
            StringBuilder an = new StringBuilder();
            while(!stk.isEmpty())
                an.append(stk.pop());
            an = an.reverse();
            if(an.length() == 0)
                System.out.println("FRULA");
            else
                System.out.println(an);
        }


    }
