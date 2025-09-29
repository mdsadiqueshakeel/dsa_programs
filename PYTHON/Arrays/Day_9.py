
def reverse(arr,start,end):
    while (start < end):
        arr[start], arr[end] = arr[end],arr[start]
        start+=1
        end-=1

    return arr

def Rotate_Matrix(arr):
    n = len(arr)
    for i in range(0,len(arr)-1):
        for j in range(i+1,len(arr)):
            arr[i][j],arr[j][i] = arr[j][i], arr[i][j]

    for i in range(0,n):
        reverse(arr[i],0,n-1)

    return arr

arr2d = [[1,2,3,4],[5,6,7,8,],[9,10,11,12],[13,14,15,16]]
print(arr2d)
print(Rotate_Matrix(arr2d))