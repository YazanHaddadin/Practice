def bubb(X):
    n = len(X)
    for i in range(n):
        swapped = False
        for j in range(0, n-i-1):
            if(X[j] > X[j+1]):
                X[j], X[j+1] = X[j+1], X[j]
                swapped = True
        if swapped == False:
            break

def insertion(X):
    for i in range(1, len(X)):
        key = X[i]

        j = i-1

        while (j>=0 and X[j] > key):
            X[j+1] = X[j]
            j -= 1
        X[j+1] = key 

L=[2,5,6,7,32,1,4,65,3]

insertion(L)
print(L)
        