# Lower bound with binary search
def lower_bound(arr,x):
    low = 0
    high = len(arr)-1
    ans = len(arr)
    while low <= high:
        mid = (low+high)//2
        if arr[mid] >= x:
            ans = mid
            high = mid-1
        else:
            low = mid+1
    return ans
# Upper bound with binary search
def upper_bound(arr,x):
    low = 0
    high = len(arr)-1
    ans = len(arr)
    while low <= high:
        mid = (low+high)//2
        if arr[mid] > x:
            ans = mid
            high = mid-1
        else:
            low = mid+1
    return ans

def pairs(arr):
    ans = []
    for i in range(0,len(nums)):
        cnt = 0
        for j in range(i+1,len(nums)):
            if nums[i] > nums[j]:
                cnt+=1
        ans.append(cnt)
    return ans
        

arr = [1,2,3,3,5,8,8,10,10,11]
print(lower_bound(arr,10))
print(upper_bound(arr,10))

nums = [5,2,6,1]
print(pairs(nums))

