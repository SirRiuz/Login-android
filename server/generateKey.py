
import random

vector_x = ['1' , '2' , '3' , '4' , '5' , '6' , '7' , '8' , '9' , '0'  , 'q' , 'w' , 'e' , 'r' , 't' , 'y' , 'u' , 'i' , 'o' , 'p' , 'a' , 
            's' , 'd' , 'f' , 'g' , 'h' , 'j' , 'k' , 'l' , 'ñ' , 'z' , 'x' , 'c' , 'v' , 'b' , 'n' , 'm' , '/' , '%' , '$' , '#' , ')' , 
            '(' , 'Q' , 'W' , 'E' , 'R' , 'T' , 'Y' , 'U' , 'I' , 'O' , 'P' , 'A' , 'S' , 'D' , 'F' , 'G' , 'H' , 'J' , 'K' , 'L' , 'Ñ' , 
            'Z' , 'X' , 'C' , 'V' , 'B' , 'N' , 'M']

vector_y = []

def generateKey():
    for x in range(0,50):
        item = random.choice(vector_x)
        vector_y.append(item)

def generateToken ():
    generateKey()
    key = ""
    for y in vector_y:
        key += y
    return key
