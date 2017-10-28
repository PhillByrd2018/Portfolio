# this is assignment #3
# Phillip Byrd 09.16.2016

def checkIfPrime():
    flag = 1
    userNum = eval(input("Give me a number to check if it is prime: "))
    while userNum <= 1:
        print("Invaild Input")
        userNum = eval(input("Give me a another number: "))
        print()
    for el in range(2 , userNum):
        #print(el)
        if (userNum % el) == 0:
            print("this is not a Prime number!")
            flag = 0
            print()
            break
    if flag == 1:
        print("This is a prime number")


checkIfPrime()

#question02

def checkIfEven():
    print("Enter a Negative number or a 0 to exit this loop.")
    userInput = (input("Give me a Number: "))
    while userInput == "":
        print("This is an invalid input... Please try again.")
        userInput = (input("Give me a Number: "))
    userInput = int(userInput)

        #this is the checking part of the function.
    while userInput > 0:
        if (userInput % 2) == 0:
           print(userInput,"is an Even Number.")
           userInput = eval(input("Give me Another Number: "))
        else:
           print(userInput,"is an Odd Number.")
           userInput = eval(input("Give me Another Number: "))

checkIfEven()


#question03

#2-- (240) -0b1111 0000
#3-- (??)
#4-- (250)- 0b1111 1010
#5--(255)- 0b1111 1111
#6-- (-35)- N/A
#7-- (128)- 0b1000 0000
#8--(105)- 0b0110 1001

#9--(-112)-0b1111 0000
#10--(250) N/A
#11--(-127)- 0b1111 1111
#12--(-35)- 0b1010 0011
#13--(128)- N/A
#14--(105)- 0b0110 1001