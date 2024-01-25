""" 
Algorithmen und Datenstrukturen - Aufgabenblatt 3

Exercise 2: QuickSort
Author: Lisa Weickenmeier
Date: 31.10.2023

Program for sorting a given list F.
"""

#List to sort.
F=[3, 4, 0 ,35, 2, 5, 20]

#Function for changing two elements of F.
def TauscheInF(i,j):
    m=F[i]
    F[i]=F[j]
    F[j]=m

#Function to sort the list F from index u to index o and return the index of the pivotelement.
def Zerlege(F,u,o,p):
    print("F:",F,", u:",u,", o: ", o, ", p:", p)
    pn=u
    pv=F[p]

    TauscheInF(o,p)

    for i in range(u,o):
        if F[i]<=pv:
            TauscheInF(pn,i)
            pn = pn+1
    
    TauscheInF(o,pn)

    return pn

#Recursive QuickSort function.
def QuickSort(F,u,o):
    if o>u:
        p=o
        pn=Zerlege(F,u,o,p)
        QuickSort(F,u,pn-1)
        QuickSort(F,pn+1,o)

QuickSort(F,0,6)
print("Endergebnis:", F)