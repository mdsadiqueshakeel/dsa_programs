
# Q1. Two Sum 
def TwoSum(arr,k):
    map = {}
    for i in range(0, len(arr)):
        a = arr[i]
        remain = target - a
        if remain in map:
            return {map[remain], i}
        map[a]= i
    return -1

# Q2. Sort an Array of 0s, 1s and 2s (Better) -----> Brute was the merge sort <------
def Sort_ZOT_Better(arr):
    count0 = 0
    count1 = 0
    count2 = 0
    for i in range(0,len(arr)):
        if arr[i] == 0:
            count0 += 1
        elif arr[i] == 1:
            count1 += 1
        else: 
            count2 += 1    
    for i in range(0,count0):
        arr[i] = 0
    for i in range(count0, count0 + count1):
        arr[i] = 1 
    for i in range(count0 + count1 ,len(arr)):
        arr[i] = 2

    return arr

# Q2. Sort an Array of 0s, 1s and 2s (Optimal) <<---- Dutch National Algorithm ---->>
def DNF_Algo_ZOT(arr):
    low = 0
    mid = 0
    high = len(arr)
    while(mid < high):
        if(arr[mid]==0):
            arr[mid], arr[low] = arr[low],arr[mid]
            low += 1
            mid += 1
        elif(arr[mid]==1):
            mid += 1
        else:
            arr[mid],arr[high-1] = arr[high-1], arr[mid]
            high -= 1    
    return arr



arr = [1,2,3,6,1,2,8,10]
print(len(arr))
target = 14
print(TwoSum(arr,target))

arr2 = [0,1,2,0,2,0,1,0,2,1,2,1,1]
# print(Sort_ZOT_Better(arr2))
print(DNF_Algo_ZOT(arr2))