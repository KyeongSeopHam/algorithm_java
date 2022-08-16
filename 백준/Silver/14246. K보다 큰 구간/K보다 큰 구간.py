import sys
n = int(sys.stdin.readline())
s = list(map(int,sys.stdin.readline().strip().split(" ")))
k = int(sys.stdin.readline())
oo = [0 for i in range(n + 1)]
oo[0] = 0
for i in range(1, n + 1):
    oo[i] = oo[i - 1] + s[i - 1]
fp = 0
ep = 1
ans = 0

try:
    while True:
        if ep > n or fp > n:
            break
        if oo[ep] - oo[fp] <= k:
            ep += 1
        else:
            ans += (n - ep + 1)
            fp += 1
            ep = fp + 1
except Exception:
        pass
print(ans)