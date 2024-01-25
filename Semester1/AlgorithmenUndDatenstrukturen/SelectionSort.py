F=[3, 4, 0 ,35, 2, 5, 7]

p=6

while p>0:
    g=0
    for i in range(1,p+1):
        if F[i]>F[g]:
            g=i
    m=F[p]
    F[p]=F[g]
    F[g]=m
    p=p-1

print(F)