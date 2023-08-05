answer = 0

ewsn = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]

def solution(board):
    global answer, ewsn

    n = len(board[0])

    for i, row in enumerate(board):
        for j, data in enumerate(row):
            for _ in ewsn:
                x = i - _[0]
                y = j - _[1]
                if x >= 0 and x < n and y >= 0 and y < n:
                    if board[x][y] == 1 and board[i][j] != 1:
                        board[i][j] = 2

    for i, row in enumerate(board):
        for j, data in enumerate(row):
            if board[i][j] == 0:
                answer += 1

    return answer