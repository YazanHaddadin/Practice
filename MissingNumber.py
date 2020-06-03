def find_missing(A):
    A = sorted(A)

    for i,j in zip(A[:-1], A[1::]):
        if not abs(j-i) == 1:
            print(i+1)


L = [-5,-3,-2,-1,1,3,4,5,6,7,8,9,10]

find_missing(L)