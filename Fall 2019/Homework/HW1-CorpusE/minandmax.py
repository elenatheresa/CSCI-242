def findMaxMin(array, left, right):
    if right <= left + 1:
        if array[left] < array[right]:
            return array[left], array[right]
        else:
            return array[right], array[left]
    mid = (left + right) // 2
    (left_min, left_max) = findMaxMin(array, left, mid)
    (right_min, right_max) = findMaxMin(array, mid + 1, right)
    max_value = left_max
    min_value = left_min
    if right_max > max_value:
        max_value = right_max
    if right_min < min_value:
        min_value = right_min
    return min_value, max_value

array = [30, 50, 20, 70, 10, 80, 25, 100, 60, 40]
print(findMaxMin(array, 0, len(array) - 1))
