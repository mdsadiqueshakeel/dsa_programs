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


arr = [1,2,3,3,5,8,8,10,10,11]
print(lower_bound(arr,10))
print(upper_bound(arr,10))