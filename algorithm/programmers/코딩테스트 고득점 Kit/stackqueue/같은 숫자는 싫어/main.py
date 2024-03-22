def solution(arr):
    answer = []
    prev = None
    
    for val in arr:
        if val != prev:
            answer.append(val)
            prev = val
    
    return answer