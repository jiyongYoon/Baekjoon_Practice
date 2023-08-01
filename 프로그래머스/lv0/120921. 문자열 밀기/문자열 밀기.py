def solution(A, B):

    if len(A) != len(B):
        return -1
    elif A == B:
        return 0

    lang = len(A)

    for _ in range(lang):
        A2 = str(A[lang - 1:] + A[:lang - 1])
        if A2 == B:
            return _ + 1
        else:
            print(A2)
            A = A2
            continue

    return -1