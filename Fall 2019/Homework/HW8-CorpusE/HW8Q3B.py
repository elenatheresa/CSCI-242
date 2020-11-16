import sys

def print_graph(graph, vertices):
    
    for i in range(len(graph)):
        print(vertices[i],":",end=" ")
        for u in range(len(graph)):
            if(graph[i][u] != 0):
                print (vertices[u], end=" ")
        print("")

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

def minimumDistance(graph, dist, visited):

    mindist = sys.maxsize 
    minimumIndex = -1

    for i in range(len(vertices)): 
        if dist[i] < mindist and visited[i] == False: 
            mindist = dist[i] 
            minimumIndex = i 

    return minimumIndex 

def dijkstra(graph, vertices, src): 
    
    print("Dikstra's algorithm")
    
    print("Graph:")
    print_graph(graph, vertices)

    dist = [sys.maxsize] * len(vertices) 
    
    dist[src] = 0
    
    visited = [False] * len(vertices)
    
    # path set to no path (-1)
    path = [-1] * len(vertices) 

    # for all vertices
    for i in range(len(vertices)): 
   
        u = minimumDistance(graph,dist, visited) 

        visited[u] = True


        for i in range(len(vertices)):
            if graph[u][i] != 0 and visited[i] == False and dist[i] > dist[u] + graph[u][i]:
                dist[i] = dist[u] + graph[u][i]
                path[i] = u 

    print_solution(graph,dist,vertices,src,path)
   

graph = [[0, 0, 3, 7, 0, 0, 11, 0, 0, 0], #q 
         [0, 0, 0, 0, 5, 0, 0, 0, 9, 0], #r 
         [0, 0, 0, 0, 0, 5, 0, 0, 0, 0], #s 
         [0, 0, 0, 0, 0, 0, 0, 2, 6, 0], #t 
         [0, 0, 0, 0, 0, 0, 0, 0, 3, 0], #u 
         [0, 0, 0, 0, 0, 0, 4, 0, 0, 0], #i 
         [0, 0, 2, 0, 0, 0, 0, 0, 0, 0], #w 
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 4], #x 
         [12, 0, 0, 0, 0, 0, 0, 0, 0, 0], #y 
         [0, 0, 0, 0, 0, 0, 0, 5, 0, 0]  #z
   ]

vertices = ['q','r','s','t','u','v','w','x','y','z']

# do dikdtra's
dijkstra(graph,vertices, 0)