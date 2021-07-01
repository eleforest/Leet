package eleforest.leet;

/*
一个数组存储了某股票过去几天每天的股价，一共可以买卖若干次，下一次买之前必须要把之前买的股票卖掉，求交易的最大收益额
例如：下述的价格序列下，最大收益为6，4买6卖，1买5卖
[4,4,6,1,1,4,5]
6
 */
public class MaxProfit {
    public static int maxProfit(int [] priceSeq){
        int buyPoint = 0;
        int sellPoint = 0;
        int profit = 0;
        if(priceSeq.length < 2){ // 无法买卖
            return profit;
        }
        for (int idx = 1; idx < priceSeq.length; idx ++){
            if(priceSeq[idx] <=  priceSeq[buyPoint] && buyPoint >= sellPoint){
                buyPoint = idx;
                continue;
            }
            if (priceSeq[idx] >= priceSeq[sellPoint]){
                sellPoint = idx;
            }
            if (priceSeq[idx] < priceSeq[sellPoint] || idx == priceSeq.length - 1){// 找到一组买卖点
                profit = profit + (priceSeq[sellPoint] - priceSeq[buyPoint]);
                System.out.println("buy:" + buyPoint + " sell:" + sellPoint);
                buyPoint = idx;
                sellPoint = idx;
            }
        }
        return profit;
    }
}
