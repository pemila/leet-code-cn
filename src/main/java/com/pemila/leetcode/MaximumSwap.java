package com.pemila.leetcode;

import java.util.Arrays;

/**
 * @author 月在未央
 * @date 2019/6/18 16:55
 */
public class MaximumSwap {

    /*
        670 最大交换
            给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
        示例 1 :
            输入: 2736
            输出: 7236
            解释: 交换数字2和数字7。
        示例 2 :
            输入: 9973
            输出: 9973
            解释: 不需要交换。
        注意:
            给定数字的范围是 [0, 10E8]
    */

    /*
        解题思路
            要求获得最大交换，
            首先确定给定的数字序列可排序成的最大数，
            然后使用给定数字与最大数按位进行比较，
            一旦某位上的数字不一致，则说明交换该位上的数字即可实现最大交换

            例如：
               给定数字 2736
               从大到小排序可得 7263
               使用2736与7263按位比较，
               首位数字不同，则说明要交换给定数字2736中的2与7.
               交换后可得 7236，即输出7236
     */


    private int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        char[] array = numStr.toCharArray();

        // 对给定数字序列重排序从小到大
        char[] newChars = numStr.toCharArray();
        Arrays.sort(newChars);

        int length = numStr.length();

        // 找到需要交换的第一个数字
        int index = -1;
        for(int i=0;i<length;i++){
            if(array[i] != newChars[length-i-1]){
                index = i;
                break;
            }
        }
        if(index >0 ){
            // 查找需要交换的第二个数字
            for(int i = length -1;i>=index;i--){
                if(array[i] == newChars[length -1 -index]){
                    swap(array,index,i);
                    break;
                }
            }
            return Integer.parseInt(new String(array));
        } else {
            return num;
        }
    }

    private void swap(char[] chars, int lo, int hi) {
        char tmp = chars[lo];
        chars[lo] = chars[hi];
        chars[hi] = tmp;
    }

    public static void main(String[] args) {
        MaximumSwap ms = new MaximumSwap();
        int num = 7564154;
        System.out.println(ms.maximumSwap(num));

    }
}