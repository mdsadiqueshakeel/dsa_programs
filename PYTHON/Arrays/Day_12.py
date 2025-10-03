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


arr = [-1,0,1,2,-1,-4]
print(three_sum_Opt(arr))