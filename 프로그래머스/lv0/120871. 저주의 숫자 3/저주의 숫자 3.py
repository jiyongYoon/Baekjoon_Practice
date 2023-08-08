def solution(n):
    answer = 0
    x_list = []
    idx = 1
    while len(x_list) < 101:
        num = idx
        if num % 3 == 0:
            idx = idx + 1
            continue
        else:
            flag = False
            for x in str(num):
                if x in ['3']:
                    flag = True
                    idx = idx + 1
                    break
            if not flag:
                x_list.append(num)
                idx = idx + 1

    print(x_list)

    return x_list[n - 1]