import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Room> rooms = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            Player p = new Player();
            p.l = l; p.name = name;
            if(rooms.size()==0){               // 방이 없을 시 방 만듬
                rooms.add(new Room(p,l));
                continue;
            }

            int flag = 0;
            for(int j = 0; j < rooms.size(); j++){ // 만들어진 방 조회
                int x = rooms.get(j).l;
                if(p.l <= x + 10 && p.l >= x-10 ){
                    if(rooms.get(j).p.size() < k){ // 입장 가능한 방이 있을 시 입장
                        rooms.get(j).p.add(p);
                        flag = 1;
                        break;
                    }
                }
            }

            if(flag == 0){ //입장 가능한 방 없을 시 방 만듬
                rooms.add(new Room(p,l));
            }
        }

        for(int i = 0; i < rooms.size(); i++){
            Collections.sort(rooms.get(i).p, (a,b)->a.name.compareTo(b.name));
            if(rooms.get(i).p.size() == k) System.out.println("Started!");
            else System.out.println("Waiting!");

            for(int j = 0; j < rooms.get(i).p.size(); j++)
                System.out.println(rooms.get(i).p.get(j).l + " " + rooms.get(i).p.get(j).name);
        }


    }
    static class Room{
        ArrayList<Player> p;
        int l;
        Room(Player p, int l){
            this.p = new ArrayList<>();
            this.p.add(p);
            this.l = l;
        }
    }
    static class Player{
        String name;
        int l;
    }

}