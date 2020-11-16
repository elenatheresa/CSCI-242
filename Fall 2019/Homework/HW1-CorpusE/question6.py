def findingSum(nums, c):    
    map = dict()
    for i, n in enumerate(nums):
        if c-n in map:
            return (map[c-n], i+1)
        else:
            map[c-n] = (i+1)
    return (0, 0)


nums = [30, 25, 10, 50, 35, 45, 40, 5, 15, 20]
c = 40
print(findingSum(nums, c))
