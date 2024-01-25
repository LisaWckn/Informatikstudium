F=[3, 4, 0 ,35, 2, 5, 7]

for i in range(1,7):
    m=F[i]
    j=i
    fertig = False

    while not fertig:
        if F[j-1]>m:
            F[j] = F[j-1]
            j=j-1
            if j<=0:
                fertig = True
        else:
            fertig = True
    F[j]=m

print(F)
