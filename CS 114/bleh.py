def solve (N, A):
    # Write your code here
    A.sort()
    last = N-1
    first = 0
    final = []
    max = 0
    while A[last] >= A[first] + 10:
        last-=1
    for x in range(0,N):
        if A[x] + 10 <= A[last+1]


    return len(final)

N = int(input())
A = list(map(int, input().split()))

out_ = solve(N, A)
print (out_)