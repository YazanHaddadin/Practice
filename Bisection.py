def bisection(X, val, lo=0, hi=None):
    """
        gets the position in which you can insert an element to the leftmost point in which
        the list will remain sorted (if you want rightmost then do X[mid+1])
    """

    if(hi is None):
        hi = len(X)

    mid = (lo+hi)//2
    
    if(val < X[mid] and val > X[mid-1]):
        return lo+1
    
    if(val > X[mid]):
        lo = mid + 1
        return bisection(X, val, lo, hi)

    else:
        hi = mid
        return bisection(X, val, lo, hi)

X = [1,2,4,6,23,55,65,66,77,78,79,85,99,100,101,102,110,111,130,133,140,145]

print(bisection(X, 22))