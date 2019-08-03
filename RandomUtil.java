
/**
 * How do I generate a 6-bit random number
 *
 * @author appoleo
 */
public class RandomUtil {

    /**
     * make a double random number to String, then use the method
     * substring(int beginIndex, int endIndex) to get a 6-bit random
     * number after the decimal point
     *
     * @return 6-bit random number with type String
     * @see String#substring(int, int)
     */
    public static String getRandomNumber() {
        return ((Double) Math.random()).toString().substring(2, 8);
    }
}
