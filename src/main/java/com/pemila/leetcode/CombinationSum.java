package com.pemila.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 月在未央
 * @date 2019/6/18 15:42
 */
public class CombinationSum {
    /*
        216 组合总和3
            找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
        说明：
            所有数字都是正整数。
            解集不能包含重复的组合。 
        示例 1:
            输入: k = 3, n = 7
            输出: [[1,2,4]]
        示例 2:
            输入: k = 3, n = 9
            输出: [[1,2,6], [1,3,5], [2,3,4]]
    */


    /**
     解题思路：
        使用递归
        1. 循环 1-9 依次加入 LinkedList
        2. 每次循环 k-1(LinkedList剩余数量)，n-i（n的剩余大小）
        3. k=0 && n==0 时，表示 已加入LinkedList中的 k 个数的和为 n
        4. n!=0或者k=0的情况下，将LinkedList的最后一个元素移除
     */

    private List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        traceBack(list,new LinkedList<>(),k,n,1);
        return list;
    }

    private void traceBack(List<List<Integer>> res, LinkedList<Integer> list, int k, int n, int start) {
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(list));
        } else if (n > 0 && k > 0) {
            for (int i = start; i <= 9; i++) {
                list.add(i);
                traceBack(res, list, k - 1, n - i, i + 1);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        int k = 3;
        int n = 15;
        List<List<Integer>> lists = sum.combinationSum3(k,n);
        System.out.println(lists.toString());
    }
}