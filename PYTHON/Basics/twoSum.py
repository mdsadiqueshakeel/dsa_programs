def twoSum(nums, target):
    for i in range(len(nums)):
        for j in range(i+1, len(nums)):
            if nums[i]+ nums[j] == target:
                return [i,j]


def SellStock(arr):
    buy = arr[0]
    profit = 0
    for i in range(1, len(arr)):
        if arr[i] < buy:
            buy = arr[i]
        elif arr[i] - buy < profit:
            profit = arr[i]- buy
    return profit


arr = [2,1, 5,8,9,11]
key = 13

print(twoSum(arr, key))
print(SellStock(arr))