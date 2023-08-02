class RET:
    mode = 0
    ret = ''


def solution(code):
    result = RET()
    for i in range(len(code)):
        letter = code[i]
        if letter == '1':
            result.mode = 1 if result.mode == 0 else 0
            continue
        else:
            if result.mode == 0:
                if i % 2 == 0:
                    result.ret += letter
            else:
                if i % 2 == 1:
                    result.ret += letter

    return result.ret if result.ret != '' else "EMPTY"
