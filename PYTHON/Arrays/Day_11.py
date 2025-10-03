# Hard questions are started

# Pascal Rectangle II
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


def majorityElement( nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        
        cnt1 = 0
        el1 = float("-inf")
        cnt2 = 0
        el2 = float("-inf")
        for num in nums:
            if(cnt1 == 0 and num != el2):
                cnt1 = 1
                el1 = num
            elif(cnt2 == 0 and num != el1):
                cnt2 = 1
                el2 = num
            elif(el1 == num):
                cnt1+=1
            elif(el2 == num):
                cnt2+=1
            else:
                cnt1-=1
                cnt2-=1

        ans = []
        cnt1 = 0
        cnt2 = 0
        for num in nums:
            if(el1 == num): 
                cnt1+=1
            if(el2 == num): 
                cnt2+=1

        mini = len(nums)//3
        if(cnt1 > mini): ans.append(el1)
        if(cnt2 > mini): ans.append(el2)

        return ans 

arr = [1,1,1,2,2,3,3,3]
print(majorityElement(arr))

print(generate(4))
        
        