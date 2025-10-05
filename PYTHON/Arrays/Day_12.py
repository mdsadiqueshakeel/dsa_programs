# 3 Sum (Better)
# def three_sum_better(arr):


# 3 Sum (Optimal)
def three_sum_Opt(arr):
    arr.sort()
    answer = []
    n = len(arr)
    for i in range(0,n):
        if(i > 0 and arr[i] == arr[i-1]):
            continue
        j = i+1
        k = n-1
        while(j < k):
            sum = arr[i] + arr[j] + arr[k]
            if(sum < 0):
                j+= 1
            elif(sum > 0):
                k-=1
            else:
                # temp.append([arr[i],arr[j],arr[k]])
                answer.append([arr[i],arr[j],arr[k]])
                j +=1
                k-=1
                while(j < k and arr[j] == arr[j-1]):
                    j+=1
                while(j < k and arr[k] == arr[k+1]):
                    k-=1
    return answer

def four_sum_Opt(arr,target):
    arr.sort()
    answer = []
    n = len(arr)
    for i in range(0,n-2):
        if(i > 0 and arr[i] == arr[i-1]):
            continue
        for j in range(i+1,n-1):
            if(j != i+1 and arr[j] == arr[j-1]):
                continue
            k = j+1
            l = n-1
            while(k < l):
                sum = arr[i] + arr[j] + arr[k] + arr[l]
                if(sum < target):
                    k+= 1
                elif(sum > target):
                    l-=1
                else:
                    # temp.append([arr[i],arr[j],arr[k]])
                    answer.append([arr[i],arr[j],arr[k],arr[l]])
                    k +=1
                    l-=1
                    while(k < l and arr[k] == arr[k-1]):
                        k+=1
                    while(k < l and arr[l] == arr[l+1]):
                        l-=1
    return answer
  

arr = [-1,0,1,2,-1,-4]
nums = [1,0,-1,0,-2,2]
print(three_sum_Opt(arr))
print(four_sum_Opt(nums,0))