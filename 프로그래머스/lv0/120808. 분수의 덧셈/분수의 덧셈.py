from math import gcd

def solution(numer1, denom1, numer2, denom2):
    
    answer = []

    denom_lcm = (denom1 * denom2) // gcd(denom1, denom2)
    x_num1 = denom_lcm / denom1
    x_num2 = denom_lcm / denom2

    num = int(numer1 * x_num1 + numer2 * x_num2)

    _gcd = gcd(num, denom_lcm)

    answer.append(int(num / _gcd))
    answer.append(int(denom_lcm / _gcd))

    return answer