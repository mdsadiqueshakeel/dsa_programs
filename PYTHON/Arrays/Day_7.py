# Q1. Best Time Buy & Sell Stocks (Optimal)
def BuyAndSell(arr):
    maxProfit = 0
    buy = arr[0]
    for i in range(0,len(arr)):
        cost = arr[i] - buy
        maxProfit = max(maxProfit,cost)
        buy = min(arr[i],buy)
    
    return maxProfit

# Q2. Rearrange the Array by Sign (Brute)
def Rearange_Brute(arr):
    pos = []
    neg = []
    for i in range(0,len(arr)):
        if arr[i] > 0:
            pos.append(arr[i])
        else: 
            neg.append(arr[i])

    for i in range(0,len(arr)//2):
        arr[i*2] = pos[i]
        arr[i*2+1]= neg[i]
    return arr

# Q2. Rearrange the Array by Sign (optimal)
def Rearange_Optimal(arr):
    posIndex =0
    negIndex = 1
    ans = [0] * len(arr)
    for i in range(0,len(arr)):
        if arr[i] > 0:
            ans[posIndex] = arr[i]
            posIndex += 2
        else:
            ans[negIndex] = arr[i] 
            negIndex +=2
    return ans

# Q2. Alternative Rearrange the Array by Sign 
def Rearrange_Alternative(arr):
    pos = []
    neg = []
    for i in range(0,len(arr)):
        if arr[i] > 0:
            pos.append(arr[i])
        else:
            neg.append(arr[i])
    
    if len(pos) > len(neg):
        for i in range(len(neg)):
            arr[i*2] = pos[i]
            arr[i*2+1] = neg[i]
        
        index = len(neg) *2
        for i in range(len(neg),len(pos)):
            arr[index] = pos[i]
            index +=1
    else:
        for i in range(len(pos)):
            arr[i*2] = pos[i]
            arr[i*2+1] = neg[i]
        
        index = len(pos) *2
        for i in range(len(pos),len(neg)):
            arr[index] = neg[i]
            index +=1

    return arr


# Q3. Next Permutation (Optimal)
def reverse(arr,start,end):
    while (start < end):
        arr[start], arr[end] = arr[end],arr[start]
        start+=1
        end-=1

    return arr

def Next_Permutation_Opt(arr):
    idx = -1
    for i in range(len(arr)-2,-1,-1):
        if arr[i] < arr[i+1]:
            idx = i
            break

    print(arr[idx])
    print(idx)
    if idx == -1:
        reverse(arr,0,len(arr)-1)
        return arr
    
    for i in range(len(arr)-1,-1,-1):
        if arr[idx] < arr[i]:
            arr[idx], arr[i] = arr[i], arr[idx]
            break

    # print(arr)
    reverse(arr,idx+1,len(arr)-1)

    return arr



arr = [7,1,5,3,6,4] 
print(BuyAndSell(arr))

arr2 = [3,1,-2,-5,2,-4]
print(Rearange_Optimal(arr2))

arr3 = [-3,1,-1,-2,-5,2,-4,3,9-8,-2]
print(Rearrange_Alternative(arr3))

arr4 = [2,1,5,4,3,0,0]
print(Next_Permutation_Opt(arr4))

