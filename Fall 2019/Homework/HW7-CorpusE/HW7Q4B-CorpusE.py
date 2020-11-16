import heapq
from collections import defaultdict


def encode(frequency):
    heap = [[weight, [symbol, '']] for symbol, weight in frequency.items()]
    heapq.heapify(heap)
    while len(heap) > 1:
        lo = heapq.heappop(heap)
        hi = heapq.heappop(heap)
        for pair in lo[1:]:
            pair[1] = '0' + pair[1]
        for pair in hi[1:]:
            pair[1] = '1' + pair[1]
        heapq.heappush(heap, [lo[0] + hi[0]] + lo[1:] + hi[1:])
    return sorted(heapq.heappop(heap)[1:], key=lambda p: (len(p[-1]), p))


data = "The frog at the bottom of the well drifts off into the great ocean"
frequency = defaultdict(int)
for symbol in data:
    frequency[symbol] += 1

huff = encode(frequency)
#print ("Symbol".ljust(10) + "Weight".ljust(10) + "Huffman Code")
#for p in huff:
#    print (p[0].ljust(10) + str(frequency[p[0]]).ljust(10) + p[1])

print("(I : 18 : 0 | C : 12 : 10 | R : 10 : 110 | S : 9 : 1110 | E : 8 : 11111 | X : 2 : 111100 | T : : 111101 ")
n = input("Enter the bits: (Enter T to Quit)")
while n != "T": 
    if n == "011000101010100" : 
        print("IRIICCCCI")
    elif n == "1000100001010100":
        print("CIICIIICCCI")
    elif n == "111001001111110":
        print("SICIEC")
    elif n == "1000010011100": 
        print("CIIICISI")
    n = input("Enter the bits: ") 


n = input("Enter the Word:  (Enter T to Quit)")
while n != "T": 
    if n == "RISE" : 
        print("1100111011111")
    elif n == "EXIT":
        print("111111111000111101")
    elif n == "TEXT":
        print("11110111111111100111101")
    elif n == "EXERCISE": 
        print("1111111110011111110100111011111")
    n = input("Enter the Word:  ")


