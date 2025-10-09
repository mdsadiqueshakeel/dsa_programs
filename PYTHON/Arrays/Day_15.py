def findErrorNums(nums):
    n = len(nums)
    sn = (n * (n+1))/2
    sn2 = (n * (n+1)* (2*n+1))/6
    s, s2 = 0,0
    for num in nums:
        s += num
        s2 += num * num
    val1 = s - sn # x - y
    val2 = s2 - sn2
    val2 = val2 // val1 # x + y
    x = (val1 + val2)//2
    y = x - val1
    return [x,y]


nums = [1,2,2,4]
print(findErrorNums(nums))