import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
	if (s.length() == 0) {
	    return 0;
	}

	Set<Character> set = new HashSet<>();
	int l = 0, r = 0, len = s.length(), maxLen = 1;
	char lc = s.charAt(l), rc;
	set.add(s.charAt(l));

	do {
	    r++;
	    if (r >= len) {
		break;
	    }

	    rc = s.charAt(r);
	    if (set.contains(rc)) {
		while (set.contains(rc)) {
		    lc = s.charAt(l);
		    set.remove(lc);
		    l++;
		}
	    }
	    set.add(rc);
	    maxLen = Math.max(maxLen, r - l + 1);
	} while (true);
	return maxLen;
    }
}
