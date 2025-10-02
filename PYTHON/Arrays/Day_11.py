# Hard questions are started


def getRow(rowIndex):
    answer = []
    ans = 1
    answer.append(ans)
    n = rowIndex +1
    for i in range(1,n):
        ans *= n-i
        ans /= i
        answer.append(ans)
    return answer

def generate(numRows):
    answer = []
    for i in range(0,numRows):
        answer.append(getRow(i))
    return answer

print(generate(10))
        
        