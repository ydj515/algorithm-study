def solution(clothes):
    
    clothes_dict = {} 
    for item, cloth_type in clothes:
        if cloth_type in clothes_dict.keys():
            clothes_dict[cloth_type] += [item]
        else:
            clothes_dict[cloth_type] = [item]
    
    answer = 1
    for _, value in clothes_dict.items():
        answer *= (len(value) + 1)
        
    return answer -1