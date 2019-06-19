package com.pemila.leetcode;

import java.util.Arrays;

/**
 * @author 月在未央
 * @date 2019/6/19 11:56
 */
public class ThiefRob {

    /*
        198 打家劫舍
            你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
            影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
            如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

            给定一个代表每个房屋存放金额的非负整数数组，
            计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

            示例：
                输入: [1,2,3,1]
                输出: 4
                解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
                     偷窃到的最高金额 = 1 + 3 = 4 。
    */

    /*
        解题思路：
            只有一间房时，输出为第一间房的金额 ，记为 a[0]
            两间房时，输出为 金额较多的房间金额, 记为 a[1]
            第三间房时，可偷房间为 1 3，将 1+3的金额与 a[1] 比较较大的数记为 a[2]
            ....
            第n间房时，可偷房间为 n+ (n-i)+..., 将其与 a[n-1]比较，记为a[n]

            则 a[n]为最大可偷金额
     */

    private int rob(int[] nums) {
        int res = 0;
        switch (nums.length) {
            case 0:
                break;
            case 1:
                res = nums[0];
                break;
            case 2:
                res = Math.max(nums[0], nums[1]);
                break;
            default:
                int[] result = new int[nums.length];
                result[0] = nums[0];
                result[1] = Math.max(nums[0], nums[1]);

                for (int index = 2; index < result.length; index++) {
                    result[index] = Math.max(nums[index] + result[index - 2], result[index - 1]);
                }
                res = result[nums.length - 1];
                break;
        }
        return res;
    }



    /*

       思路：
         先对奇偶分别求和，求和过程中发现对方为更优解时复制对方方案
     */
    private int rob2(int [] nums){
        int a = 0;
        int b = 0;

        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                a += nums[i];
                a = Math.max(a,b);
            }else {
                b += nums[i];
                b = Math.max(a,b);
            }
        }
        return Math.max(a,b);
    }




    public static void main(String[] args) {
        ThiefRob thiefRob = new ThiefRob();
        int[] nums = {1,5,85,6526,4584,1546,44564};
        System.out.println(thiefRob.rob(nums));
        System.out.println(thiefRob.rob2(nums));
    }
}
