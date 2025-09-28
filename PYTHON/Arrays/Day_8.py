# Q1. Leaders Array
def Leaders_array_Opt(arr):
    j = len(arr) -1
    i = len(arr) - 1
    print(arr[i])
    ans = []
    while j >= 0:
        if  j == i:
            ans.append(arr[j])
        if arr[i] < arr[j]:
            ans.append(arr[j])
            i = j
        print(j)
        j-=1

    return ans

def Leaders_array_Opt2(arr):
    maxi = float('-inf')
    ans = []
    for i in range(len(arr)-1, -1, -1):
        if arr[i] > maxi:
            ans.append(arr[i])
        maxi = max(maxi,arr[i])
    return ans

# Q2. Longest Consecutive element
def Longest_consecutive_Opt(arr):
    n = len(arr)
    if (n == 0): return 0
    st = set(arr)
    length = 0

    for it in st:
        if it-1 not in st:
            cnt = 1
            x = it
            while x+1 in st:
                x += 1
                cnt +=1 
            length = max(length,cnt)

    return length


arr = [10,22,12,3,0,6]
print(Leaders_array_Opt2(arr))

arr2 = [102,4,100,1,101,3,2,1]
print(Longest_consecutive_Opt(arr2))