import sys

def print_graph(graph, vertices):

        for i in range(len(graph)):
                print(vertices[i],":",end=" ")
                for u in range(len(graph)):
                        if(graph[i][u] != 0):
                                print (vertices[u], end=" ")
                print("")
                

def topological_sort_helper(graph,i,visited,stack): 

        visited[i] = True

        for u in range(len(graph)):
                if graph[i][u] != 0 and visited[u] == False: 
                    topological_sort_helper(graph,u,visited,stack) 

        stack.append(i) 

def print_path(path,src,vertices):

        if path[src] != -1:
                print(vertices[path[src]],end=" ")
                print_path(path,path[src],vertices)
        
def print_solution(graph, dist, vertices, src, path):
        print ("Vertex Path  Distance from Source",vertices[src])
        for node in range(len(vertices)):
                print (vertices[node],end = "\t")
                print_path(path,node,vertices)
                print ("\t", dist[node]) 


def shortest_path(graph, src, vertices): 
        
        print("Graph:")
        print_graph(graph,vertices)

        visited = [False]*len(vertices)
        stack =[] 

        for u in range(len(vertices)): 
            if visited[u] == False: 
                topological_sort_helper(graph,src,visited,stack) 
                
        print("toplogical sort:")
        for i in range(len(stack)-3,-1,-1):
                print(vertices[stack[i]],end=" ")
        print("")

        dist = [sys.maxsize] * (len(vertices)) 
        dist[src] = 0
        
        path = [-1] * (len(vertices))
        
        while stack: 

            i = stack.pop() 

            for u in range(len(graph[i])): 
                if graph[i][u] != 0:
                        weight = graph[i][u]
                        
                        if dist[u] > dist[i] + weight: 
                                dist[u] = dist[i] + weight 
                                path[u] = i

        print_solution(graph, dist, vertices, src, path)
            
        
                   
# Graph 
#         q  r  s  t  u  v  w   x  y  z
graph = [[0, 0, 1, 4, 0, 0, 7, 0, 0, 8], #q 
         [0, 0, 0, 0, 1, 0, 0, 0, 6, 0], #r 
         [0, 0, 0, 0, 0, 2, 4, 0, 0, 0], #s 
         [0, 0, 0, 0, 0, 0, 0, 3, 6, 0], #t 
         [0, 0, 0, 0, 0, 0, 0, 0, 4, 0], #u 
         [0, 0, 0, 0, 0, 0, -1, 0, 0, 0], #v 
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 5], #w 
         [0, 0, 0, 0, 0, 0, 0, 0, 2, -2], #x 
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 0], #y 
         [0, 0, 0, 0, 0, 0, 0, 0, 3, 0]  #z
   ]

vertices = ['q','r','s','t','u','v','w','x','y','z']

# q = 0
shortest_path(graph,0,vertices)  
