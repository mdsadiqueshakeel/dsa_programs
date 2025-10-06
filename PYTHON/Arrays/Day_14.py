def Max_Area(arr):
    maxi = 0
    i = 0
    j = len(arr) -1
    while i < j:
        width = j - i
        area = min(arr[i],arr[j]) * width
        maxi = max(area,maxi)
        if arr[i] < arr[j]:
            i+=1
        else:
            j-=1
    return maxi

height = [1,8,6,2,5,4,8,3,7]
print(Max_Area(height))