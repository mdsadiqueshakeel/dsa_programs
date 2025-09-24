
# Q1. Largest element on Array without Sort 
def Largest_element(arr):
    largest = arr[0]
    for i in range(1, len(arr)):
        if largest < arr[i]:
            largest = arr[i]

    return largest        

# Q2. 2nd Largest element on Array without Sort 
def Seconnd_Largest(arr):
    largest = arr[0]
    for i in range (1, len(arr)):
        if largest < arr[i]:
            largest = arr[i]
    
    s_largest = float("-inf")
    for j in range (0, len(arr)):
        if arr[j] != largest and s_largest < arr[j]:
            s_largest = arr[j]

    return s_largest

# Q3. Check the Arrays is Sorted 
def isSorted(arr):
    for i in range(1,len(arr)):
        if arr[i] <  arr[i-1]:
            return False
    return True

# Q4. Remove Duplicated in case of Sorted Array
def R_duplicates(arr):
    idx = 0
    s_arr = [arr[idx]]
    for i in range(1,len(arr)):
        if arr[i] != arr[idx]:
            arr[idx+1] = arr[i]
            idx+= 1
            s_arr.append(arr[idx])
    print(s_arr)
    return idx+1




arr = [2,1,8,1,10,11,5,4]
s_arr = [1,1,1,1,2,3,4,4,5,5,5,6,7,7,7,7,7]

largest_number = Largest_element(arr)
print(largest_number)
second_largest = Seconnd_Largest(arr)
print(second_largest)

print(isSorted(arr))
print(isSorted(s_arr))
print(R_duplicates(s_arr))