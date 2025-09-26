# Q1. majority element (N/2 times) _(Better) <----- Nested Loop can be brute approcah ------>

def Majority_element(arr):
    map= {}
    for i in range(0,len(arr)):
        if arr[i] in map:
            map[arr[i]]+=1
        else:
            map[arr[i]] =1

    for key, value in map.items():
        if(value > len(arr)//2):
            return key
        
    return -1

# Q1. majority element (N/2 times) _(Optimal)
def Majority_element_Opt(arr):
    element = None
    count = 0
    for i in range(0,len(arr)):
        if count == 0:
            count = 1
            element = arr[i]
        elif arr[i] == element:
            count += 1
        else:
            count-=1
    
    cnt1 = 0
    for i in range(0,len(arr)):
        if(arr[i] == element): cnt1 += 1
    if cnt1 > (len(arr)//2):
        return element

    return -1


        

arr = [2,3,3,3,2,3,3,2,1]
print(Majority_element_Opt(arr))