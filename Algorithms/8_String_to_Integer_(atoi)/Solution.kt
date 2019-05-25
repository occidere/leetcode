import java.lang.StringBuilder

class Solution {
    fun myAtoi(str: String): Int {
	var strNum = str.trim()
	    if (strNum.isBlank()) {
		return 0
	    }

	val isNegative = when (val sign = strNum[0]) {
	    '+', '-' -> {
		strNum = strNum.substring(1)
		    sign == '-'
	    }
	    else -> false
	}
	if (strNum.isBlank() || strNum[0] !in '0'..'9') {
	    return 0
	}

	var isIgnorable = true
	    val sb = StringBuilder()
	    for (c in strNum) {
		if (c == '0') {
		    if (!isIgnorable) {
			sb.append(c)
		    }
		} else if (c in '1'..'9') {
		    sb.append(c)
			isIgnorable = false
		} else {
		    break
		}
	    }
	strNum = sb.toString()

	    return if (strNum.length > 10) {
		if (isNegative) Int.MIN_VALUE else Int.MAX_VALUE
	    } else {
		if (strNum.isBlank()) {
		    return 0
		}
		val num: Long = ((if (isNegative) "-" else "") + strNum).toLong()
		    return if (num !in Int.MIN_VALUE..Int.MAX_VALUE) {
			if (num < Int.MIN_VALUE) Int.MIN_VALUE else Int.MAX_VALUE
		    } else {
			num.toInt()
		    }
	    }
    }
}
