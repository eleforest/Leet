package eleforest.leet;

import java.io.InputStream;
import java.util.Scanner;

/*
n个学生排队取餐，第一行输入为多少个学生，之后每行第一个字符代表到达的时间，到达时间按照升序排列
第二个字符代表能够等到的时间，学生在这个时刻没法拿到餐就会离开队伍。
计算输出每个学生在哪个时刻能拿到饭，如果没拿到就输出0。
input：
2
1 4
2 4
output：
1 2

input：
3
1 5
1 1
2 4
output：
1 0 2
 */
public class QueueGetFood {
    public static int time2GetFood(int curr, int arrive, int leave){
        int ret;
        if(curr < arrive){//还没有到
            ret = -1; //学生还没有进队列
        } else {
            if (curr < leave){//学生还没有离开，那么当前时间拿到饭
                ret = curr;
            } else { //超过了学生离开的时间，拿不到了
                ret = 0;
            }
        }
        return ret;
    }
    public static String calcTime2Food (InputStream inputStream){
        int curr = 1;
        Scanner scanner = new Scanner(inputStream);
        int count = 0;
        int total = 0;
        if(scanner.hasNextLine()){ // get count of student
            total = Integer.parseInt(scanner.nextLine());
        }
        StringBuilder sb = new StringBuilder();

        while (count < total){
            String [] alArr = scanner.nextLine().split(" ");
            if (alArr.length == 2) {
                sb.append(time2GetFood(curr, Integer.parseInt(alArr[0]), Integer.parseInt(alArr[1]))).append(" ");
            } else { // invalid input
                sb.append(-1).append(" ");
            }
            curr ++;
            count ++;
        }
        // System.out.println(sb);
        scanner.close();
        return sb.toString();
    }
}
