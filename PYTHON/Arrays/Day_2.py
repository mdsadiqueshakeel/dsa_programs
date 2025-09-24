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

# Q3. Move Zero to end (Brute)
def ZeroOnLast(arr):
    temp = []
    for i in range(0,len(arr)):
        if arr[i] != 0:
            temp.append(arr[i])

    print(temp)
    
    for i in range(0,len(temp)):
        arr[i] = temp[i]
    
    size = len(temp)

    for i in range(size,len(arr)):
        arr[i] = 0

    return arr

# Q3. Move Zero to end (Optimal)
def Opt_ZeroOnLast(arr):

    j = -1
    for i in range(0,len(arr)):
        if arr[i] == 0:
            j = i
            break
    
    if j == -1:
        return arr
    
    for i in range(j+1,len(arr)):
        if arr[i] != 0:
            arr[i], arr[j] = arr[j], arr[i]
            j+=1

    return arr


# Q4. Linear Search
def Linear_Search(arr,k):
    for i in range(0,len(arr)):
        if(arr[i]==k):
            return i

# Q5. Union in Two Sorted Arrays
def Uninon(arr1,arr2):
    n1 = len(arr1)
    n2 = len(arr2)
    i = 0
    j = 0
    temp = []
    while(i < n1 and j < n2):
        if arr1[i] <= arr2[j]:
            if len(temp) == 0 or temp[-1] != arr1[i]:
                temp.append(arr1[i])
            i += 1
        else:
            if len(temp) == 0 or temp[-1] != arr2[j]:
                temp.append(arr2[j])
            j += 1
     # remain part 
    while(i < n1):
        if len(temp) == 0 or temp[-1] != arr1[i]:
            temp.append(arr1[i])
        i += 1

    while(j < n2):
        if len(temp) == 0 or temp[-1] != arr2[j]:
            temp.append(arr2[j])
        j += 1
    
    return temp

# Q6. Intersection in two Sorted Arrays
def Intersection(arr1,arr2):
    temp =[]
    i = 0
    j = 0
    while(i < len(arr1) and j < len(arr2)):
        if(arr1[i] < arr2[j]):
            i +=1
        elif(arr1[i] > arr2[j]):
            j+=1
        else:
            temp.append(arr1[i])
            i +=1
            j +=1 

    return temp


arr= [1,2,3,4,5,6,7,8]
zero_arr = [1,0,2,3,4,0,0,6,7]
One_place = leftRotateByOnePlace(arr)
print(One_place)
print(Opt_leftRotatedByD_Places(arr,2))
print(Opt_ZeroOnLast(zero_arr))
print(Linear_Search(arr,4))

arr1 =[1,2,3,4,5,6]
arr2 =[2,3,3,5,6,6,8,9]
print(Uninon(arr1,arr2))
print(Intersection(arr1, arr2))