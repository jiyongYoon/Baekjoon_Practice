def solution(cards1, cards2, goal):

    idx_1 = 0
    idx_2 = 0
    idx_g = 0

    for _ in range(len(goal)):

        if idx_1 < len(cards1) and cards1[idx_1] == goal[idx_g]:
            idx_1 = idx_1 + 1
        elif idx_2 < len(cards2) and cards2[idx_2] == goal[idx_g]:
            idx_2 = idx_2 + 1
        else:
            return 'No'
        idx_g = idx_g + 1

    if idx_g == len(goal):
        return 'Yes'