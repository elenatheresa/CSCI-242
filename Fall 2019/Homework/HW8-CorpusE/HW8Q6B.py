import sys
#import sys # Library for INT_MAX 
  
def printMST(graph,parent,vertices): 
    print ("Edge \tWeight")
    for v in range(1, len(parent)): 
        print (vertices[parent[v]], "-", vertices[v], "\t", graph[v][parent[v]] )
  
def minimum_key(vertices, key, mstSet): 
  
    # Initilaize min value 
    min = sys.maxsize
  
    for v in range(len(vertices)): 
        if key[v] < min and mstSet[v] == False: 
            min = key[v] 
            min_index = v 
  
    return min_index 
  
def primMST(graph,vertices): 
    
    print("Prims MST")     
  
    key = [sys.maxsize] * len(vertices)
    
    parent = [0] * len(vertices) 
    
    key[0] = 0 
    
    mstSet = [False] * len(vertices)
  
    parent[0] = -1 
  
    for v in range(len(vertices)): 
  
        u = minimum_key(vertices,key, mstSet) 
   
        mstSet[u] = True
  
        for v in range(len(vertices)): 
          
            if graph[u][v] > 0 and mstSet[v] == False and key[v] > graph[u][v]: 
                key[v] = graph[u][v] 
                parent[v] = u 
  
    printMST(graph,parent,vertices) 
  
#         a  b  c  d  e  f  h   i  j  k 
graph = [[0, 4, 0, 8, 11, 0, 0, 0, 0, 0], #a 
         [4, 0, 17, 6, 15, 10, 0, 0, 0, 0], #b 
         [0, 17, 0, 0, 13, 3, 0, 0, 0, 0], #c 
         [8, 6, 0, 0, 13, 0, 7, 4, 0, 0], #d 
         [11, 15, 13, 13, 0, 5, 8, 10, 14, 0], #e 
         [0, 10, 3, 0, 5, 0, 0, 6, 12, 0], #f 
         [0, 0, 0, 7, 8, 0, 0, 12, 0, 11], #h
         [0, 0, 0, 4, 10, 6, 12, 0, 2, 9], #i 
         [0, 0, 0, 0, 14, 12, 0, 2, 0, 10], #j 
         [0, 0, 0, 0, 0, 0, 11, 9, 10, 0]  #k
   ]  

vertices = ['a','b','c','d','e','f','h','i','j','k']

# do print mst
primMST(graph,vertices)  
