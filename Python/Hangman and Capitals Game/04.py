#Phillip Byrd
#assignment 04
#09.25.2016

import random



#question01

def randomword():
    myFile = open("words02.txt", "r")
    ranNum = (random.randint(0, 30))
    #print(ranNum)
    for el in myFile:
         #print(el)
        words = el.split(" ")
        return(words[ranNum])
    myFile.close()

    secWord = randomword()
    copyWord = secWord

(randomword())

def hangManGame():

    secWord = randomword()
    copyWord = secWord


    print("Welcome to the Hangman Game. You have 6 Tries to guess the word.")
    print("The number of Characters in the word is:", len(secWord))
    #print(secWord)

    showWord = ("_" * len(secWord))
    showWordFirst=(" _ " * len(secWord))
    print(showWordFirst)


    userGuess = input("Guess a letter: ")
    userGuess = userGuess.lower()


    while userGuess.isalpha() == False or len(userGuess) > 1:
        print("not a valid entry. Try again.")
        userGuess = input("Enter a Letter: ")
    #else:
        #print(userGuess)




    def hangMan(secWord, userGuess, showWord):
        flag = 1
        guessedLetters = []



        for el in range(0, 24):
            if flag == 7:
                print("I'm sorry but you have lost. Thank you for playing.")
                print("The word was:",secWord)
                return
            elif secWord.find(userGuess) == -1:
                print("I'm Sorry but that is not correct. Try again.")
                print("\nYou have", (6-flag),"tries left.")
                flag = flag + 1
                guessedLetters.append(userGuess)
                print(showWord)
                print(guessedLetters)



            elif secWord.find(userGuess) != -1:
                copyWord = secWord.replace(userGuess, "*")
                #print(copyWord)
                position = copyWord.find("*")

                while position != -1:
                    copyWord = copyWord[:position] + '$' + copyWord[position + 1:]
                    showWord = showWord[:position] + userGuess + showWord[position + 1:]
                    position = copyWord.find("*")
                print(showWord)

            if showWord == secWord:
                print("\n" + "Congratulations! You have Won the game!")
                print("The word was: ",secWord)
                return
            #print(guessedLetters)
            userGuess = input("\nGuess another letter: ")
            while userGuess.isalpha() == False or len(userGuess) > 1:
                print("not a valid entry. Try again.")
                userGuess = input("Enter a Letter: ")


    hangMan(secWord, userGuess, showWord)
hangManGame()




#####################################
#question02


def countryGame():
    #this part opens and reads the TXT doc
    myFile=open("capitals.txt", "r")
    myArray = myFile.readlines()



    #This part starts the # of rounds and begins the game
    numOfTries = 6
    while numOfTries > 0:

        #this part counts down the rounds
        numOfTries = numOfTries - 1
        print("There are", numOfTries,"rounds remaining in this game.")
        print()

        #This part selects a random word and splits it
        ranNum1 = random.randrange(0, 16, 1)
        #print(ranNum)
        #print(myArray[ranNum1])

        guess = myArray[ranNum1]. split(":")


        #This part tells us how many countries there are to be guessed
        counter = 0
        for el in range(len(myArray)):
            counter = counter + 1


        #this part talks to the user about what to guess for
        print("There are", counter,"Capitals to guess.")
        print()

        country = guess[0]
        print("The Country for this round is:",country)

        #userTry = input("What is the Capital of %s:" % country)
        userTry = input("What is the Capital of "+country+":")
        userTry = userTry.lower()
        print()


        #This part trims the answer to a workable length
        ans = guess[1].replace("\n","")
        ans = ans.replace(" ", "")
        ans = ans.lower()
        #print(userTry)
        #print(ans)


        #this part check for the correct answer and completes the loop
        while userTry != ans:
            print()
            print("Sorry, That is not correct! Try Again.")
            userTry = input("What is the Capital: ")
            print()
        else:
            print()
            print("That is correct! You Win!")
            print()
    else:
        print()
        print("Game over! Thanks for playing!")
        print()








countryGame()