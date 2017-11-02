package z_leetcode.bloomberg_onsite;

public class train {
    String[] stop = new String[10];
    carriage[] ca ;
    public train() {
        ca = new carriage[10];
    }
    public boolean check(int start, int end, int number) {
        for(carriage cur : ca) {
            for(room rm : cur.rooms) {
                boolean flag = true;
                for(int i = start; i <= end; i++) {
                    if(rm.takenSeats[i] < number) {
                        flag = false;
                    }
                }
                if(flag == true) {
                    return true;
                }
            }
        }
        return false;
    }
}

class carriage {
    room[] rooms;
    public carriage() {
        rooms = new room[10];
    }

}

class room {
    int[] takenSeats = new int[10];
}
