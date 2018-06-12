package a1TwoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * O(n^2) 48ms
     * @author ikonon
     * @param nums 数组
     * @param target 目标值
     * @return 下标
     */
    public int[] twoSumMe(int[] nums, int target) {

        for(int i = 0; i < nums.length;i++){
            for(int j = 0; j < nums.length;j++){
                if(nums[j] + nums[i] == target){
                    return new int[]{i, j};
                }
            }
        }

        throw  new IllegalArgumentException("没有这个结果");
    }

    /**
     * O(n)
     * @author jiaming2
     */
    public int[] twoSum1(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){//用map判断
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);//逐个把元素放进map
        }

        return new int[]{};
    }

    public static void main(String[] args) {

    }
}
