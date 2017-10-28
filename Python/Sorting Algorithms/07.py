#Phillip Byrd
#11.17.2016
#assignment 3


import datetime
from random import randint



a = datetime.datetime.now()

#this part starts the list and gives it a starting value of 1000

list01 = []
limit = 1000

for el in range(0, limit):
    list01.append(randint(0,limit))


#here is the functions that will use the bubble sort

def sortList(list):
    flag = -1
    while flag == -1:
        flag = 1
        for el in range(0,len(list)-1):
            if list[el] > list[el+1]:
                flag = -1
                temp = list[el+1]
                list[el+1] = list[el]
                list[el] = temp
    b = datetime. datetime.now()
    print("Bubble Sort of Size " + str(len(list)) + " took " + str(b-a) + " Milliseconds")


    #this part is to check to see if list is in order.
    for el in range(len(list)):
        if list01[el] < list01[el+1]:
            return True
        else:
            return False


#this is where we loop ten times to sort a list that
# will be over 500,000 elements on the last loop
for reps in range(0, 10):
    sortList(list01)
    list01 = list01*2











