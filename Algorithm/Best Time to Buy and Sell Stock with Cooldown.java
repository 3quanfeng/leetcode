/*
 * buy[i]��ʾ�ڵ�i��֮ǰ���һ���������򣬴�ʱ��������档

	sell[i]��ʾ�ڵ�i��֮ǰ���һ��������������ʱ��������档
	
	rest[i]��ʾ�ڵ�i��֮ǰ���һ���������䶳�ڣ���ʱ��������档
	
	����д������ʽΪ��
	
	buy[i]  = max(rest[i-1] - price, buy[i-1]) 
	sell[i] = max(buy[i-1] + price, sell[i-1])
	rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
	
	��������ʽ�ܺõı�ʾ������֮ǰ���䶳�ڣ���֮ǰҪ����֮ǰ�Ĺ�Ʊ��һ��С��������α�֤[buy, rest, buy]�����������֣���������buy[i] <= rest[i]�� ��rest[i] = max(sell[i-1], rest[i-1])���Ᵽ֤��[buy, rest, buy]������֡�
	
	���⣬�����䶳�ڵĴ��ڣ����ǿ��Եó�rest[i] = sell[i-1]�����������ǿ��Խ�������������ʽ����������
	
	buy[i]  = max(sell[i-2] - price, buy[i-1]) 
	sell[i] = max(buy[i-1] + price, sell[i-1])
	 
	
	���ǻ���������һ���Ż�������iֻ������i-1��i-2���������ǿ�����O(1)�Ŀռ临�Ӷ�����㷨
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int pre_buy = 0;
        int sell = 0;
        int pre_sell = 0;
        for (int price : prices) {
            pre_buy = buy;
            buy = Math.max(pre_sell - price, pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy + price, pre_sell);
        }
        return sell;
    }
}