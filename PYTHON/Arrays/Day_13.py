# count number of subarrays with given xor k  (Better)
def SubArray_Xor(arr,target): 
    count = 0
    for i in range(0,len(arr)):
        xor = 0
        for j in range(i,len(arr)):
            xor = xor ^ arr[j]
            if(xor == target):
                count+=1
    return count

# count number of subarrays with given xor k  (Optimal)
def SubArray_Xor_Opt(arr,target):
    xor = 0
    mpp = {}
    mpp[xor] = mpp.get(xor, 0) + 1
    cnt = 0
    for i in range(0,len(arr)):
        xor ^= arr[i]
        x = xor ^ target
        if x in mpp:
            cnt += mpp[x]
        mpp[xor] = mpp.get(xor, 0) + 1

    return cnt

arr = [4,2,2,6,4]
print(SubArray_Xor_Opt(arr,6))