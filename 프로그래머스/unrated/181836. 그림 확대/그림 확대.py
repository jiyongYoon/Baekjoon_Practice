def solution(picture, k):
    answer = []
    for _ in range(len(picture) * k):
        answer.append('')

    idx = 0
    for row in picture:
        add_row = ''
        for c in row:
            add_row = add_row + c * k
        for _ in range(k):
            answer[idx] = add_row
            idx = idx + 1

    return answer