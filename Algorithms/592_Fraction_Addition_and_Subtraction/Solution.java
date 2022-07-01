import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public String fractionAddition(String expression) {
		Matcher matcher = Pattern.compile("-?\\d+/\\d+").matcher(expression);
		List<Fraction> fractions = new ArrayList<>();
		while (matcher.find()) {
			String[] f = matcher.group().split("/");
			fractions.add(new Fraction(Long.parseLong(f[0]), Long.parseLong(f[1])));
		}
		return fractions.stream()
			.reduce((x, y) -> {
				long d = x.d * y.d;
				long n = x.n * y.d + y.n * x.d;
				Fraction f = new Fraction(n, d);
				return f;
			}).get()
			.toString();
	}

	private static class Fraction {
		long n, d;

		public Fraction(long n, long d) {
			long g = gcd(n, d);
			n = n / g + n % g;
			d = d / g + d % g;

			if (d < 0) {
				d = -d;
				n = -n;
			}

			this.n = n;
			this.d = d;
		}

		private long gcd(long a, long b) {
			if (a % b == 0) {
				return b;
			}
			return gcd(b, a % b);
		}

		@Override
		public String toString() {
			return String.format("%d/%d", n, d);
		}
	}
}
