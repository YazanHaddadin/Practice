class UF():
    id = []

    def __init__(self, N):
        self.N = N
        if(N<2): N=2
        for i in range(N):
            self.id.append(i)
        
        self.id[3] = 1
        self.id[2] = 3
        self.id[4] = 3

    def root(self, p):
        while(p != self.id[p]):
            self.id[p] = self.id[self.id[p]]
            p = self.id[p]
        
        return p

    def connected(self, p, q):
        if (self.root(p) == self.root(q)):
            return 1
        else: return 0

   

u = UF(5)
