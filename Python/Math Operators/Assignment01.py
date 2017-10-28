#Assignment 01
# Phillip Byrd
# Aug. 29, 2016

import math







# Question01

def question01():

    sum = 0

    aSide = eval(input("Enter one side of the Triangle: "))

    bSide = eval(input("Enter one side of the Triangle: "))

    cSide = eval(input("Enter one side of the Triangle: "))

    for Element in range(aSide + bSide + cSide):

        s = (aSide + bSide + cSide)/2

        triArea = (s * (s - aSide) * (s - bSide) * (s - cSide))

    print(s)

    print(math.sqrt(triArea))







#question01()


def question02():

    xOne = eval(input("Enter X one Value: "))

    xTwo = eval(input("Enter X two Value: "))

    yOne = eval(input("Enter Y one Value: "))

    yTwo = eval(input("Enter Y two Value: "))

    for secondElement in range(xOne + xTwo + yOne + yTwo):

        answer = ((xTwo - xOne) **2) + ((yTwo - yOne) **2)

        print(secondElement)

    print(math.sqrt(answer))






#question02()


def question03():

    radius = eval(input("Please Enter the radius of the sphere: "))

    for thirdElement in range(radius):

        volume = (4/3) * math.pi * (radius) ** 3

        surfaceArea = 4 * math.pi *(radius) ** 2

    print(radius)

    print(volume)

    print(surfaceArea)

#question03()






def question04():

    neededExam = 0

    examOne = eval(input("What was the grade for Exam 1: "))

    examTwo = eval(input("What was the grade for Exam 2: "))

    examThree = eval(input("What was the grade for Exam 3: "))

    for fourthElement in range(0, 301):

        gradeAve = (examOne + examTwo + examThree)/ 3

        neededExam = (examOne + examTwo + examThree)- 360

        bestPossExam = (examOne + examTwo + examThree + 100)/ 4

    print("This is your grade in the class with all exams taken so far: ", round(gradeAve))

    # This is all extra stuff that I was playing with in this problem.
    print("This is the Score needed on the Final to get an A in the course: ", abs(neededExam))

    print("This is the best possible overall score you can make in this course: ", round(bestPossExam))

question04()