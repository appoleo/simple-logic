/**
 * <p>1. 二分查找也称折半查找，每次都能将查找区间缩小为原来的一半，所以这种算法
 * 的时间复杂度为O（logN）
 * 
 * <p>2. 计算中值的算法有两种
 * middle = (low + high) / 2;
 * middle = low + (high - low) / 2;
 * 推荐使用第二种，因为减法不会涉及到数据相加导致溢出的问题
 *
 * @author appoleo
 */
public class Dichotomy {

    /**
     * 计算并返回x的平方根，其中x是非负整数，结果保留整数部分
     *
     * @param x 非负整数
     * @return x的平方根
     */
    public static int getSquareBoot(int x) {
        if (x <= 1) {
            return x;
        }
        int low = 0;
        int high = x;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (x / middle == middle) {
                return middle;
            } else if (x / middle > middle) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return low;
    }

    /**
     * 寻找比目标字母大的最小字母
     *
     * @param letters 只包含小写字母的有序数组，数组里字母的顺序是循环的。举个例子，如果
     *                目标字母target = 'z'，并且有序数组为letters = ['a', 'b']，
     *                则答案返回'a'。
     * @param target  目标字母
     * @return 有序数组里面比目标字母大的最小字母
     */
    public static char getLetterLessThanTarget(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (letters[middle] == target) {
                return middle == letters.length - 1 ? letters[0] : letters[middle + 1];
            } else if (letters[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return high == letters.length - 1 ? letters[0] : letters[low];
    }

    /**
     * 对2进行开方，精确到指定小数点位数
     *
     * @param epsinon 精度，如精确到小数点后十位，取0.0000000001
     * @return 开方后结果
     */
    public static double sqrt2(double epsinon) {
        double low = 1.4;
        double high = 1.5;
        double mid = (low + high) / 2;
        while (high - low > epsinon) {
            if (mid * mid < 2) {
                low = mid;
            } else {
                high = mid;
            }
            mid = (high + low) / 2;
        }
        return mid;
    }
}
