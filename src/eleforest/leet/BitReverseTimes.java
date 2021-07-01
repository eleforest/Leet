package eleforest.leet;

public class BitReverseTimes {
    /*
    求翻转a，b的bit值的最少次数，目标是使得a|b=c。
     */
    public static int bitReverseTimesCalc(int a, int b, int c){
        int idx = 0;
        int count = 0;
        System.out.printf("%010x\n",a);
        System.out.printf("%010x\n",b);
        System.out.printf("%010x\n",c);
        while (idx < 32){
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;
            if (bitC == 1){
                if (bitA == 0 && bitB == 0){
                    count ++ ;
                }
            } else{
                if (bitA == 1){
                    if (bitB == 1){
                        count = count + 2;
                    } else {
                        count ++;
                    }
                } else {
                    if (bitB == 1){
                        count ++;
                    }
                }
            }
            idx ++;
            a = a >>> 1;
            b = b >>> 1;
            c = c >>> 1;
        }
        return count;
    }
}
