import java.util.PriorityQueue;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	PriorityQueue<Integer> pq = new PriorityQueue<>();
	int l1 = nums1.length, l2 = nums2.length, maxLen = Math.max(l1, l2);

	for (int i = 0; i < maxLen; i++) {
	    if (i < l1) {
		pq.add(nums1[i]);
	    }
	    if (i < l2) {
		pq.add(nums2[i]);
	    }
	}

	int totalLen = l1 + l2, prePollCount = totalLen / 2, medianPollCount = 1;
	if (totalLen % 2 == 0) {
	    prePollCount = totalLen / 2 - 1;
	    medianPollCount = 2;
	}

	int pollCount = 0;
	while (pollCount < prePollCount) {
	    pq.poll();
	    pollCount++;
	}

	pollCount = 0;
	double d = 0;
	while (pollCount < medianPollCount) {
	    d += pq.poll();
	    pollCount++;
	}

	return d / medianPollCount;
    }
}
