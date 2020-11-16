import sys

def print_graph(graph, vertices):
    
    for i in range(len(graph)):
        print(vertices[i],":",end=" ")
        for u in range(len(graph)):
            if(graph[i][u] != 0):
                print (vertices[u], end=" ")
        print("")

def DFShelper(graph, i, visited,vertices): 

    visited[i] = True
    print(vertices[i], end = ' ') 

    for u in range(len(vertices)): 
        if graph[i][u]>0 and visited[u] == False: 
            DFShelper(graph, u, visited,vertices) 


def fill_order(graph,i,visited, stack): 
    
    visited[i]= True
    
    for u in range(len(graph)): 
        if graph[i][u] >0 and visited[u]==False: 
            fill_order(graph,u, visited, stack) 
    stack = stack.append(i) 

def get_transpose(graph): 

    gt = [[0 for i in range(len(graph))] for i in range(len(graph))]     

    for i in range(len(graph)): 
        for j in range(len(graph[i])): 
            gt[j][i]=graph[i][j] 
    return gt 

def printSCCs(graph,vertices): 
    
    print("SCC graph:")
    print_graph(graph, vertices)    

    stack = [] 
    
    visited =[False]*(len(vertices)) 
    
    gt = get_transpose(graph) 
    
    print("transpose graph")
    print_graph(gt, vertices)  
    
    for i in range(len(vertices)): 
        if visited[i]==False: 
            fill_order(graph,i, visited, stack) 
            
    print("finishing time order")
    for i in range(len(vertices)):
        print(vertices[stack[i]], end= " ")
    print("")
    
    visited =[False]*(len(vertices)) 

    print("SCC:")
    while stack: 
        u = stack.pop() 
        print(vertices[u], end=": ") 
        if visited[u]==False: 
            DFShelper(gt,u, visited,vertices) 
            print("") 
                
# make graph
graph = [[0, 0, 3, 7, 0, 0, 11, 0, 0, 0], #q 
         [0, 0, 0, 0, 5, 0, 0, 0, 9, 0], #r 
         [0, 0, 0, 0, 0, 5, 0, 0, 0, 0], #s 
         [0, 0, 0, 0, 0, 0, 0, 2, 6, 0], #t 
         [0, 0, 0, 0, 0, 0, 0, 0, 3, 0], #u 
         [0, 0, 0, 0, 0, 0, 4, 0, 0, 0], #v 
         [0, 0, 2, 0, 0, 0, 0, 0, 0, 0], #w 
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 4], #x 
         [12, 0, 0, 0, 0, 0, 0, 0, 0, 0], #y 
         [0, 0, 0, 0, 0, 0, 0, 5, 0, 0]  #z
   ]

# graph vertices
vertices = ['q','r','s','t','u','v','w','x','y','z']

# do SCC
printSCCs(graph,vertices)
