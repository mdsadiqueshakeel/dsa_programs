# print ('helloworld')
import math
# count = int(math.log10(n))
n = 371
dup = n
reverse_number = 0

while n > 0:
    ld = n % 10
    reverse_number = reverse_number+ (ld*ld*ld)
    n = n//10
    # count+=1

print(reverse_number)
if dup == reverse_number:
    print("Armstrong")
else:
    print("Not an Armstrong")