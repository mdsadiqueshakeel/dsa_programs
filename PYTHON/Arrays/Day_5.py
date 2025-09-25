

def TwoSum(arr,k):
    map = {}
    for i in range(0, len(arr)):
        a = arr[i]
        remain = target - a
        if remain in map:
            return {map[remain], i}
        map[a]= i
    return -1

arr = [1,2,3,6,1,2,8,10]
target = 14
print(TwoSum(arr,target))