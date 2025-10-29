def seclection_sort(arr):
    for i in range (len(arr) -1 ):
        min_idx = i
        for j in range(i+1, len(arr)):
            if arr[min_idx] > arr[j]:
                min_idx = j

        arr[min_idx], arr[i]= arr[i], arr[min_idx]

        

arr = [11, 3, 3,56, 109, 2]
seclection_sort(arr)
for i in range (0,len(arr)):
    print(arr[i])