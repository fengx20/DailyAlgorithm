package leetcode.linked_list;

/**
 * @author Fengx
 * @date 2021/3/25 0025
 * @description: 2、两数相加
 *
 * 标签：递归、链表、数学
 *
 * 题目：
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 **/
public class Solution2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        // 根节点
        ListNode root = new ListNode(0);
        // 答案链表(表示和的链表)根节点
        ListNode cursor = root;
        // 进位值
        int carry = 0;
        // 遍历两个链表
        while(l1 != null || l2 != null ||carry != 0){
            // l1节点赋值
            int l1Val = l1 != null ? l1.val : 0;
            // l2节点赋值
            int l2Val = l2 != null ? l2.val : 0;
            // 两个链表同一个位置数字和当前位置进位值相加(这个进位值是上一个位置两个链表数字相加除以10的值)
            int sumVal = l1Val + l2Val + carry;
            // 答案链表处相应位置的节点数字
            ListNode sumNode = new ListNode(sumVal % 10);
            // 新的进位值
            carry = sumVal / 10;
            // 答案链表下一个节点数字
            cursor.next = sumNode;
            // 答案链表当前位置数字
            cursor = sumNode;

            // 到下一个位置计算
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return root;
    }

    /**
     * 自定义单向链表
     */
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
}
