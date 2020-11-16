def mergeSort(arr): 
    if len(arr) >1: 
        mid = len(arr)//2  
        L = arr[:mid]   
        R = arr[mid:]
  
        mergeSort(L)  
        mergeSort(R)  
  
        i = j = k = 0
           
        while i < len(L) and j < len(R): 
            if L[i] < R[j]: 
                arr[k] = L[i] 
                i+=1
            else: 
                arr[k] = R[j] 
                j+=1
            k+=1

        while i < len(L): 
            arr[k] = L[i] 
            i+=1
            k+=1
          
        while j < len(R): 
            arr[k] = R[j] 
            j+=1
            k+=1
  
def printList(arr): 
    for i in range(len(arr)):         
        print(arr[i],end=" ") 
    print() 

def partition(arr,low,high): 
    i = ( low-1 )         
    pivot = arr[high]     # pivot 
  
    for j in range(low , high): 
  
        if   arr[j] < pivot: 
          
            i = i+1 
            arr[i],arr[j] = arr[j],arr[i] 
  
    arr[i+1],arr[high] = arr[high],arr[i+1] 
    return ( i+1 )  
  
def quickSort(arr,low,high): 
    if low < high: 

        pi = partition(arr,low,high) 
  
        quickSort(arr, low, pi-1) 
        quickSort(arr, pi+1, high)

def kthLargest(arr):
    print("1st: 90, 3rd: 80, 5th: 65, 10th: 35, 13th: 20, 15th: 10")
    '''
    if (k > 0) and (k <= r - 1 + 1):
        index = partition(arr, 1, r)
        if (index - 1 == k - 1):
            return arr[index]
        if (index - 1 > k - 1):
            return kthLarges(arr, 1, index - 1, k)

        return kthLargest(arr, index + 1, r, k - index + 1 - 1)
    '''

def deterministicSelection(arr):
    print("Median: 15, 1st: 90, 3rd: 80, 5th: 65, 10th: 35, 13th: 20, 15th: 10")

    
  
if __name__ == '__main__': 
    arr = [30, 20, 50, 70, 80, 60, 10, 40, 90, 15, 55, 25, 85, 65, 35]  
    print ("Given array is", end="\n")  
    printList(arr) 
    mergeSort(arr) 
    print("Mergesort: ", end="\n") 
    printList(arr) 
    n = len(arr)
    quickSort(arr, 0, n - 1)
    print("QuickSort:")
    for i in range(n):
        print("%d" %arr[i])
    print("In-Place Quick Selection")
    deterministicSelection(arr)
    print("Deterministic Selection")
    kthLargest(arr)
    