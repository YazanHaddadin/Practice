def findLSUnsorted(X):

    max = -100000000
    min = 1000000000

    for i in X:
        if(i > max):
            max = i
        if(i < min):
            min = i
    print(max)
    print(min)

L = [-11,4,6,3,6,8,55,25,4,745,3,2,746,33]

findLSUnsorted(L)