import math

# Q1. Find the missing element in Sorted Array
def Missing_Element(arr,k):
    sum = (k * (k+1))/2
    arr_sum = 0
    for i in range (0,len(arr)):
        arr_sum += arr[i]
    
    missing_element = sum - arr_sum
    return missing_element


# Q2. Maximum Consecutives One's
def Consecitive_Ones(arr):
    count = 0
    maxi = 0
    for i in range(0,len(arr)):
        if arr[i] == 1:
            count += 1
            maxi = max(count, maxi)
        else:
            count = 0
    return maxi    

# Q3. Find the number that apperas once in other number Twice
def Appears_Once_Time(arr):
    xor = 0
    for i in range(0, len(arr)):
        xor = xor ^ arr[i]
    return xor


arr = [1,2,3,5]
Cons_arr = [1,1,0,1,1,1,0,0,1,1,1,1,0]
arr3= [1,1,2,3,3,4,4]
print(Missing_Element(arr,5))
print(Consecitive_Ones(Cons_arr))
print(Appears_Once_Time(arr3))