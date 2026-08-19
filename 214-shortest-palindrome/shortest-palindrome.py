class Solution:
    def shortestPalindrome(self, s: str) -> str:
        if not s or len(s) <= 1:
            return s
        n = len(s)
        for i in range(n, 0, -1):
            prefix = s[:i]

            if prefix == prefix[::-1]:

                remaining_part = s[i:]
                return remaining_part[::-1] + s

        return s