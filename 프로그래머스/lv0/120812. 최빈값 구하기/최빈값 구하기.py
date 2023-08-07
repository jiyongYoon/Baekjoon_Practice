def solution(array):
    num_list = []
    for _ in range(1001):
        num_list.append(0)

    answer = 0
    result = 0
    flag = False
    for num in array:
        num_list[num] = num_list[num] + 1
        if num_list[num] > result:
            result = num_list[num]
            answer = num
            flag = False
        elif num_list[num] == result:
            flag = True

    if flag:
        return -1
    else:
        return answer