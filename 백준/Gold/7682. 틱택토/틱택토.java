import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] m = new char[3][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            String s = br.readLine();
            if(s.equals("end"))
                break;
            int x = 0, o = 0;
            for(int i= 0; i<9;i++) {
                m[i / 3][i % 3] = s.charAt(i);
                if(s.charAt(i) == 'X')
                    x++;
                if(s.charAt(i) == 'O')
                    o++;
            }

            boolean winX = winx();
            boolean winO = wino();
            int fail = 0;
            
            if(x - o > 1 || x - o < 0)          // 말 수가 잘못 됨
                fail = 1;
            else if(winX && winO || x+o < 9 && !winX && !winO ) //둘다 승 or 게임이 종료되지 않음
                fail = 1;

            else if(winX && x-o != 1 || winO && x - o != 0) // 게임이 종료 되엇으나 말 수 이상
                fail = 1;
            
            
            if(fail == 1)
                System.out.println("invalid");
            else
                System.out.println("valid");
        }
    }
    static boolean winx() {
        if(m[1][1] == 'X' && m[0][0] == 'X' && m[2][2] == 'X')
            return true;
        if(m[1][1] == 'X' && m[0][2] == 'X' && m[2][0] == 'X')
            return true;

        for(int i= 0; i<3;i++) {
            if (m[i][0] == 'X' && m[i][1] == 'X' && m[i][2] == 'X')
                return true;

            if(m[0][i] == 'X' && m[1][i] == 'X' && m[2][i] == 'X')
                return true;
        }
        return false;
    }
    static boolean wino() {
        if(m[1][1] == 'O' && m[0][0] == 'O' && m[2][2] == 'O')
            return true;
        if(m[1][1] == 'O' && m[0][2] == 'O' && m[2][0] == 'O')
            return true;

        for(int i= 0; i<3;i++) {
            if (m[i][0] == 'O' && m[i][1] == 'O' && m[i][2] == 'O')
                return true;

            if(m[0][i] == 'O' && m[1][i] == 'O' && m[2][i] == 'O')
                return true;
        }
        return false;
    }


}
