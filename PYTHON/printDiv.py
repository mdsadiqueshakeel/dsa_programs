import math
n = 36
arr =[]
for i in range(1, int(math.sqrt(n))):
    if n % i == 0:
        arr.append(i)
        if (n//i)!=i:
            arr.append(n//i)

arr.sort()
print(arr)