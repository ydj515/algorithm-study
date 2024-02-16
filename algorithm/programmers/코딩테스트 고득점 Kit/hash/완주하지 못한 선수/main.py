from collections import Counter

def solution(participant, completion):
    result_count = Counter(participant) - Counter(completion)

    return list(result_count.keys())[0]