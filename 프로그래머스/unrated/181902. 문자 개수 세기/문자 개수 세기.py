def solution(my_string):
    answer = []
    for i in range(0, 52):
        answer.append(0)

    for s in my_string:
        if (s.isupper()) :
            idx = ord(s) - 65
        else:
            idx = ord(s) - 71
        answer[idx] = answer[idx] + 1

    return answer