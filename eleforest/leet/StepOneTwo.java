package eleforest.leet;

import java.io.InputStream;
import java.util.Scanner;

/*
小人从1号位置出发，每次可以走一步或者两步，走一步可以得到下一个位置分数的一半，走两步可以得到下一个位置分数的全部，小人最终可以走到位置n
求拿到分数的最大值。
输入数据：
2 // 2个测试数据组
3 // n=3，最多可以走到位置3
0 2 4 // 3个位置，以及每个位置的分数
3 // 第二组测试数据
0 4 2
 */
public class StepOneTwo {
    public static int maxPoints(int [] locations, int n){
        int [] dp = new int[locations.length];
        dp[0] = locations[0];
        dp[1] = locations[0] + locations[1]/2;
        for (int i = 2; i < dp.length; i ++){
            dp[i] = Math.max(dp[i-1] + locations[i]/2, dp[i-2] + locations[i]);
        }
        return dp[dp.length - 1];
    }

    public static String stepOneTwo(InputStream inputStream){
        Scanner scanner = new Scanner(inputStream);
        int total = 0;
        if(scanner.hasNextLine()){ // get count of student
            total = Integer.parseInt(scanner.nextLine());
        }
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < total; idx ++){
            int count = Integer.parseInt(scanner.nextLine());
            String [] lStr = scanner.nextLine().split(" ");
            int [] locations = new int[lStr.length];
            for(int j = 0; j < lStr.length; j++){
                locations[j] = Integer.parseInt(lStr[j]);
            }
            int point = maxPoints(locations, count);
            System.out.println(point);
            sb.append(point).append(" ");
        }
        return sb.toString();
    }
}
