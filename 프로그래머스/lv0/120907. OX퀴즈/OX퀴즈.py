def solution(quiz):
    list = []

    for q in quiz:
        new_q = q.replace(" ","")
        left, right = new_q.split('=')
        for i, num in enumerate(left):
            flag = False
            if left[i] in ['+', '-']:
                if i == 0:
                    continue
                else:
                    flag = True
                    print('i = ' + str(i))
                    a = int(left[:i])
                    cal = left[i:i + 1]
                    b = int(left[i + 1:])

            if flag:
                break

        if cal == '+':
            result = a + b
        else:
            result = a - b

        if result == int(right):
            list.append('O')
        else:
            list.append('X')

    return list