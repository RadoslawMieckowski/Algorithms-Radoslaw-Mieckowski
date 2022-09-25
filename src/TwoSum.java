import java.util.*;
import java.util.stream.Collectors;

public class TwoSum {

    public static void main(String[] args) {
        int table[] = {1, 2, 3, 4, 6};
        System.out.println(Arrays.toString(twoSum(table, 5)));
    }
    public static int[] twoSum(int[] nums, int target) {
        Set<Integer> complement =  new LinkedHashSet<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!complement.contains(nums[i])) {
                complement.add(target - nums[i]);
            } else {
                result[0] = complement.stream().collect(Collectors.toList()).indexOf(nums[i]);
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
