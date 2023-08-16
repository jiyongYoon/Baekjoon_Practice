def solution(n, m, section):
    answer = 0
    idx = 0
    num = 0
    for i in range(n):
        if section[idx] > num and section[idx] == i + 1:
            num = section[idx] + m - 1
            answer = answer + 1
            if num > n:
                break
            while idx < len(section) and section[idx] <= num:
                idx = idx + 1
            if idx == len(section):
                break

    return answer