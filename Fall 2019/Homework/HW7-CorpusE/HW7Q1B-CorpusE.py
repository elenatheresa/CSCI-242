
def getMax(arr, n): 
    result = arr[0] 
    for i in range(1, n): 
        if arr[i] > result:  
            result = arr[i]  
    return result 

def isPossible(time, K, job, n): 

    cnt = 1
    curr_time = 0 
    i = 0
    while i < n: 
        if curr_time + job[i] > time:  
            curr_time = 0
            cnt += 1
        else: 
            curr_time += job[i]  
            i += 1
  
    return cnt <= K 
 
def findMinTime(K, T, job, n): 
    end = 0
    start = 0
    for i in range(n): 
        end += job[i]  

    ans = end    
    job_max = getMax(job, n)  
    while start <= end:  
        mid = int((start + end) / 2)  
        if mid >= job_max and isPossible(mid, K, job, n): 
            ans = min(ans, mid)  
            end = mid - 1
        else: 
            start = mid + 1
  
    return ans * T 
  
if __name__ == '__main__': 
    job = [15, 6, 5, 9, 10] 
    n = len(job)  
    k = 4
    T = 5
    #print(findMinTime(k, T, job, n)) 

    print("increasing order : A, D, B, E, C")
    print("Total Wait Time : 57 ")
      
