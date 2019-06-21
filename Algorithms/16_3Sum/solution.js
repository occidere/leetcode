/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function (nums, target) {
    nums.sort(function (a, b) { return a - b });
    var minDiff = 0x3f3f3f3f, ans = 0;

    var len = nums.length;
    for (var i = 0; i < len - 2; i++) {
	for (var l = i + 1, r = len - 1; l < r;) {
	    var sum = nums[i] + nums[l] + nums[r];
	    var diff = Math.abs(target - sum);
	    if (diff <= minDiff) {
		minDiff = diff;
		ans = sum;
	    }

	    if (sum > target) {
		r--;
	    } else {
		l++;
	    }
	}
    }
    return ans;
};
