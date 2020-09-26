#!/usr/bin/env python3
import random

randNo=random.randint(1,10)
chances=6

print('guess a no between 1 and 10 ')

def guessNos(no):
      if no==randNo:
        print('you win whooo !')
        return True
      elif no<randNo:
        print('try again guess is low')
        return False
      elif no>randNo:
        print('try again guess is high')
        return False 


while True:
    try:
        guessNo=(input('enter the guess no - '))

        if guessNo=='exit':
            break
        else:
            if chances==0:
                print('chances are over')
                break
            chances=chances-1
            if guessNos(int(guessNo)):
                break
    except Exception as e:
        print(e)
        print('please only numbers')
