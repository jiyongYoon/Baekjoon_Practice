def solution(arr, query):
    idx = 0
    for i in query:
        if idx % 2 == 0:
            del arr[i + 1:]
        else:
            del arr[:i]
        idx += 1

    return arr