def solution(spell, dic):
    map = {}
    for s in spell:
        if s in map:
            val = map.get(s)
            val = val + 1
            map[s] = val
        else:
            map[s] = 1

    false_flag = False

    for word in dic:
        map2 = {}

        for k, v in map.items():
            map2[k] = v

        print(word)

        for s in word:
            if s in map2:
                val = map2.get(s)
                val = val - 1
                if (val < 0):
                    false_flag = True
                else:
                    map2[s] = val
            else:
                false_flag = True

        if false_flag:
            false_flag = False
            continue
        else:
            values = map2.values()
            for value in values:
                if value > 0:
                    false_flag = True
                    break

            if false_flag:
                false_flag = False
                continue
            else:
                return 1

    return 2