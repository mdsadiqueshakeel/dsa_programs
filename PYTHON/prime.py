import math
n = 7
cnt = 0
for i in range (1, int(math.sqrt(n))+1):
    if n % i ==0:
        cnt+=1
        if (n//i)!=i:
            cnt +=1
if cnt ==2:
    print("this is the prime")
else:
    print("this is not a prime")

    
a = 25
b = 10

while a > 0 and b > 0:
    if a > b:
        a = a % b
    else: 
        b = b % a
print(b if a == 0 else a)



