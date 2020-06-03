def find_sum(X, res):

    F = []

    for i in X:
        for j in X[1::]:
            if(i+j == res):
                F.append((i,j))
    print(set(F))

L = [1,2,3,54,6,4,23,5,7,3]
R = 9

find_sum(L,R)