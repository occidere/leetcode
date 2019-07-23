class Solution:
    def countAndSay(self, n: int) -> str:
        sequence = '1'
        for i in range(2, n + 1):
            cache: dict[int: int] = {}
            seq, pre_ch = '', ''
            for j, ch in enumerate(sequence):
                cache[ch] = cache.get(ch, 0) + 1
                if j > 0 and ch != pre_ch:
                    seq += str(cache.get(pre_ch, '')) + str(pre_ch)
                    del cache[pre_ch]
                pre_ch = ch
            sequence = seq + str(cache.get(pre_ch, '')) + str(pre_ch)
        return sequence
