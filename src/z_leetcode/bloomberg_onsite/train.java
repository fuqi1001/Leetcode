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
/*
1）设计一个火车票订票系统，一辆车有若干节车厢，
一节车厢有若干个房间，一个房间里有一些座位。
暴露给用户的api要求上下车的站名，以及买几张票，其余的先不考虑。
要求这几张票要在一个房间里，但是具体哪几个座位无所谓。
和面试官讨论了一会儿，最后是在room的class里面建一个int[] seatsTaken的数组，
长度由这趟线路有多少站来决定。

 */