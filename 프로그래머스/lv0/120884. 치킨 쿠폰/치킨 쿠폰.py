answer = 0

def solution(chicken):
    global answer
    coupon_chicken = chicken // 10
    answer += coupon_chicken
    remain = chicken % 10
    if remain + coupon_chicken >= 10:
        solution(remain + coupon_chicken)
        
    return answer