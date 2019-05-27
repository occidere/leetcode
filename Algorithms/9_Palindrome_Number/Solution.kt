import kotlin.math.max

/**
 * @author occidere
 * @since 2019-05-26
 * Blog: https://blog.naver.com/occidere
 * Github: https://github.com/occidere
 */
class Solution {
    fun isPalindrome(x: Int): Boolean {
	return if (x < 0) {
	    false
	} else {
	    var k: Int = pow(getDigit(x))
	    var l = 10
	    var num1: Int = x
	    var num2: Int = x
	    while (num1 > 0 && num2 > 0) {
	        if (num1 / k != num2 % l) {
		   return false
	        }
	        num1 %= k
	    	num2 /= l
	    	k /= 10
	    }

	    return true
	}
    }

    fun getDigit(x: Int): Int {
	var digit: Int = 10
	    var k: Int = 1000000000
	    return if (x > k) {
		digit
	    } else {
		while (digit > 0 && x / k <= 0) {
		    digit--
		    k /= 10
		}
		max(1, digit)
	    }
    }

    fun pow (k: Int): Int {
	var p: Int = 1
        for (i in 1 until k) {
	    p *= 10
	}
	return p
    }
}
