# Smallest Missing Non-Negetive Integer After Operation

def MEX(arr,value):
    lst = []
    for i in range(0,len(arr)):
        lst.append(arr[i]%value)
    
    lst.sort()
    cnt = 1
    for i in lst:
        if i+1 not in lst:
            return i    
        else:
            break
    
    return cnt

arr = [1,-10,7,13,6,8]
print(MEX(arr,5))

k = 2
for delta in range(-k,k+1):
    print(delta)

