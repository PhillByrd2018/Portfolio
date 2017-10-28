# Assignment 02
    # Loops and If/else
# Phillip Byrd



def question01():
    sum = 0
    natRoot = eval(input("Give me a number to find the summation of the cube of the number of Values: "))
    for firstElement in range(1, natRoot + 1):
        sum = sum + (firstElement ** 3)
    print(sum)

question01()


def question02():

    fibNum = eval(input("Give me a number to Sum up to in the Fibonacci sequence: "))

    firstNum = 1
    secNum = 1

    for secElement in range(1, fibNum ):

        temp = secNum

        secNum = secNum + firstNum

        firstNum = temp


    print(firstNum)


question02()




def question03():
    print("The hourly rate is $10 per hour up to 40 hours in a pay period.")
    userHours = eval(input("How many hours have you worked in the pay period? "))

    if userHours <= 40:
        standardPayRate = (userHours * 10)
    else:
        standardPayRate = (40 * 10) + ((userHours - 40) * 15)

    print("This is the amount to be paid for this period: $",standardPayRate)


question03()



def question04():

    userExamGrade = eval(input("What grade did you make on the Exam?"))
    while userExamGrade > 100 or userExamGrade < 1:
        print("Invalid Exam Grade")
        userExamGrade = eval(input("Give me another Exam Score: "))


    if userExamGrade >= 90 and userExamGrade <= 100:
        print("You got an A")

    elif userExamGrade <= 89 and userExamGrade >= 80:
        print("You got a B")

    elif userExamGrade <= 79 and userExamGrade >= 70:
        print("You got a C")

    elif userExamGrade <=69 and userExamGrade >= 60:
        print("You got a D")

    elif userExamGrade <=59 and userExamGrade >= 50:
        print("You got an F")

    elif userExamGrade <= 49 and userExamGrade >=1:
        print("You got such a bad such that you should reconsider this major")


question04()

