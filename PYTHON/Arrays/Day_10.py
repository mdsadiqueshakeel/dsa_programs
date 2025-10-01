# Number of SubArray with Sum of k (Better)
def SubArray_Sum(arr,k):
    cnt = 0
    for i in range(0,len(arr)):
        sum = 0
        for j in range(i,len(arr)):
            sum += arr[j]
            if(sum == k):   
                cnt+=1
    
    return cnt

# Number of SubArray with Sum of k (Optimal) using Prefix Sum & HasMap
def SubArray_Sum_Opt(arr,k):
    mpp = {}
    preFix = 0
    cnt = 0
    mpp[0] = 1
    for i in range(0,len(arr)):
        preFix += arr[i]
        remove = preFix - k
        if remove in mpp:
            cnt += mpp[remove]
        mpp[preFix] = mpp.get(preFix, 0) + 1

    return cnt


arr = [1,2,3,-3,1,1,1,4,2,-3]
print(SubArray_Sum_Opt(arr,3))