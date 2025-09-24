 # Q1. Maxmium length of Subarray sum of k (Optimal)

def Max_length(arr, k):
    n = len(arr)
    right = 0
    left = 0
    sum = arr[0]
    maxLen = 0
    while right < n:
        while(left <= right and sum > k):
            sum -= arr[left]
            left +=1
        if sum == k:
            maxLen = max(maxLen, (right - left)+1)
        right += 1
        if right < n:
            sum += arr[right]

    return maxLen

arr = [1,2,3,1,1,1,1,1,3,3]
print(Max_length(arr, 5))