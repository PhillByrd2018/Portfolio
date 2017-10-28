#Phillip Byrd
#11.30.2016
#Assignment08

#question01


myList=[]
for el in range(101):
    myList.append(el)

print()

def binarySearchRecursive(_list, _num,_startingIndex ,_endingIndex):
   if _endingIndex== 0:
       print("Not found! -1")
       return
   if _endingIndex - _startingIndex == 1:
       if myList[_startingIndex] == _num:
           print("Found at index: "+str(_startingIndex))
           return
       elif myList[_endingIndex] == _num:
           print("Found at index: "+str(_endingIndex))
           return
       else:
           print('Sorry, Number not found -1')
           return
   midIndex = (_startingIndex + _endingIndex) // 2
   if myList[midIndex] == _num:
       print("Number Found at index: " + str(midIndex))
   elif myList[midIndex] > _num:
       binarySearchRecursive(myList, _num, _startingIndex, midIndex)
   elif myList[midIndex] < _num:
       binarySearchRecursive(myList, _num, midIndex, _endingIndex)



binarySearchRecursive(myList, 10000, 0, (len(myList)-1))

print()


#################################################################################


def binarySearchInterative(num, startIdx, endIdx):

    while True:
        midIdx = (startIdx + endIdx) // 2

        if midIdx == num:
            print("Found!")
            return
        elif (endIdx - startIdx) == 1:
            if startIdx == num:
                print("Found")
                return
            elif endIdx == num:
                print("Found")
                return
            else:
                print("Not Found")
                return
        elif midIdx > num:
            endIdx = midIdx
            continue
        elif midIdx < num:
            startIdx = midIdx
            continue
        else:
            print("Not Found")
            return

binarySearchInterative(3, 0, (len(myList)-1))