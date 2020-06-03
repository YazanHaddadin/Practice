def find_dup(A):
    for i,j in zip(A[:-1], A[1::]):
        if(i == j):
            print(i)


L = [1,2,3,4,4,5,6,7,8,9,10,10]
find_dup(L)