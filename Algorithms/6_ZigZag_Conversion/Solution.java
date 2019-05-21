import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String convert(String s, int numRows) {
	if (numRows == 1) {
	    return s;
	}

	StringBuilder[] zigzag = new StringBuilder[numRows];
	for (int i = 0; i < numRows; i++) {
	    zigzag[i] = new StringBuilder();
	}

	int x = 0, y = 0, dx, dy, d = numRows - 1;
	for (int i = 0; i < s.length(); i++) {
	    zigzag[x].append(s.charAt(i));
	    if (y % d == 0 && x < d) {
		dx = 1;
		dy = 0;
	    } else {
		dx = -1;
		dy = 1;
		for (int k = 0; k < numRows; k++) {
		    if (k != y + dy) {
			zigzag[k].append(" ");
		    }
		}
	    }
	    x += dx;
	    y += dy;
	}

	return Arrays.stream(zigzag)
	    .map(StringBuilder::toString)
	    .map(z -> z.replace(" ", ""))
	    .collect(Collectors.joining());
    }
}
