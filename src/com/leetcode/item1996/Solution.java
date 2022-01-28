package com.leetcode.item1996;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1996. 游戏中弱角色的数量
 * 你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
 * 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。
 * 更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。
 * 返回 弱角色 的数量。
 *
 * 示例 1：
 * 输入：properties = [[5,5],[6,3],[3,6]]
 * 输出：0
 * 解释：不存在攻击和防御都严格高于其他角色的角色。
 *
 * 示例 2：
 * 输入：properties = [[2,2],[3,3]]
 * 输出：1
 * 解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
 *
 * 示例 3：
 * 输入：properties = [[1,5],[10,4],[4,3]]
 * 输出：1
 * 解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
 *
 * 提示：
 * 2 <= properties.length <= 105
 * properties[i].length == 2
 * 1 <= attacki, defensei <= 105
 */
public class Solution {

    public static void main(String[] args) {

        int[][] properties = {{4, 10}, {2, 2}, {8, 8}, {10, 2}, {5, 5}, {9, 10}, {2, 6}};

        System.out.println(numberOfWeakCharacters(properties));
    }

    public static int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]));
        int maxDef = 0;
        int result = 0;
        for (int[] property : properties) {
            if (property[1] < maxDef) {
                result++;
            } else {
                maxDef = property[1];
            }
        }
        return result;
    }

    /**
     * 我自己写的超时了
     *
     * @param properties
     * @return
     */
    public static int numberOfWeakCharacters2(int[][] properties) {
        // 长度
        int length = properties.length;
        int count = length % 2 == 0 ? length / 2 : length % 2 + 1;
        int result = 0;
        Map<Integer, int[]> temp = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (temp.containsKey(i)) {
                continue;
            }
            for (int j = i + 1; j < length; j++) {

                if (properties[i][0] > properties[j][0] && properties[i][1] > properties[j][1]) {
                    System.out.println(j + ":::" + Arrays.toString(properties[j]) + ";;;;1");
                    if (temp.put(j, properties[j]) == null) {
                        result++;
                        System.out.println(Arrays.toString(properties[j]));
                    }
                }
                if (properties[i][0] < properties[j][0] && properties[i][1] < properties[j][1]) {
                    System.out.println(i + ":::" + Arrays.toString(properties[i]) + ";;;;2");
                    if (temp.put(i, properties[i]) == null) {
                        System.out.println(Arrays.toString(properties[i]));
                        result++;
                    }
                }
            }
        }
        return result;
    }


}
