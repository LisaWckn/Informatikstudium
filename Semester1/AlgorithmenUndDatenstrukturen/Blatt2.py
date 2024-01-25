# Algorithmen und Datenstrukturen
# Aufgabenblatt 2
# Aufgabe 3: Rekursion
# Autor: Lisa Weickenmeier
# Datum: 27.10.2023

# Programm zur Berechnung einer 2er Potenz bei eingegebenem Exponenten.


instruction = input("Bitte gibt eine positive, ganze Zahl ein: ")

i = int(instruction)

# Funktion zweiHochI, die die 2er Potenz berechnet. 
# Der Aufruf im Programm kann ohne Angabe des results erfolgen, da der Defaultwert und damit Startwert 1 beträgt.
def zweiHochI(i, result = 1):
    if i<=0:
        return result
    else:
        return zweiHochI(i-1, result*2)

result = zweiHochI(i)
print("Das Ergebnis von 2^", i, "ist", result)