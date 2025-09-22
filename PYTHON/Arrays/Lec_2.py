# Q1. Left Rotated array by one places
def leftRotateByOnePlace(arr):
    temp = arr[0]
    n = len(arr)
    for i in range(1,n):
        arr[i-1] = arr[i]
    arr[n-1] = temp
    return arr    

# Q2. Left Rotated array by k places (Brute)
def leftRotatedByD_Places(arr,k):
    n = len(arr)
    k = k % n
    temp =[]
    for i in range(0,k):
        temp.append(arr[i])

    for i in range(k,n):
        arr[i-k]= arr[i]

    for i in range(len(temp)):
        arr[(n-k)+i] = temp[i]

    return arr

# Q2. Left Rotated array by k places (Optimal)
def reverse(arr,start,end):
    while start < end:
        arr[start], arr[end] = arr[end], arr[start]
        start+= 1
        end -= 1

    return arr


def Opt_leftRotatedByD_Places(arr,k):
    n = len(arr)
    k = k % n
    reverse(arr,0,n-k-1)
    reverse(arr,n-k,n-1)
    reverse(arr,0,n-1)

    return arr

arr= [1,2,3,4,5,6,7,8]
One_place = leftRotateByOnePlace(arr)
print(One_place)
print(Opt_leftRotatedByD_Places(arr,2))