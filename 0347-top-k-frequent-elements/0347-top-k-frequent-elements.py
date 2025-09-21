class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqMap = {}

        for num in nums:
            freqMap[num] = freqMap.get(num, 0) + 1
        
        freq = [[] for i in range(len(nums) + 1)]

        for num, count in freqMap.items():
            freq[count].append(num)
        
        res = []

        for i in range(len(freq) - 1, 0, -1):
            for num in freq[i]:
                res.append(num)
                if len(res) == k:
                    return res