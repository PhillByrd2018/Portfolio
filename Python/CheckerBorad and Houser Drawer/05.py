from graphics import *
from random import randint



def drawCheckerBoard(squareWidthSize, imageFileName, numOfRows):

    #creates checkerboard image, creates lower y limit for top edge of first row
    checkerBoard = Image(Point(100,100), imageFileName)
    previousYCoordinate = 0

    #for every horizontal row of squares...
    for squareYCoordinate in range(1, numOfRows + 1):

        #the bottom of the row is set to the bottom of previous row + width, previous x is set to 0 for this iteration of
            #the loop (to start at the left edge again)
        newYCoordinate = previousYCoordinate + int(squareWidthSize / numOfRows)
        previousXCoordinate = 0

        #for every square in the row
        for squareXCoordinate in range(1, numOfRows + 1):

            #right side of the square is set to previous x (0 at the start of each iteration) + square width
            newXCoordinate = previousXCoordinate + int(squareWidthSize / numOfRows)

            #if x coordinate of the square + y coordinate of the square is odd, all pixels within the sides are set to black
            if (squareXCoordinate + squareYCoordinate) % 2 == 1:
                for xCoordinate in range(previousXCoordinate, newXCoordinate):

                    for yCoordinate in range(previousYCoordinate, newYCoordinate):
                        
                        checkerBoard.setPixel(xCoordinate, yCoordinate, color_rgb(0,0,0))
                print('(',previousXCoordinate,',',previousYCoordinate,')''(',newXCoordinate,',',newYCoordinate,')','black')



            #if x + y is even, pixels are set to white
            elif (squareXCoordinate + squareYCoordinate) % 2 == 0:
                for xCoordinate in range(previousXCoordinate, newXCoordinate):

                    for yCoordinate in range(previousYCoordinate, newYCoordinate):

                        checkerBoard.setPixel(xCoordinate, yCoordinate, color_rgb(255,255,255))
                print('(',previousXCoordinate,',',previousYCoordinate,')''(',newXCoordinate,',',newYCoordinate,')','white')

            #the new squares left side is set to the previous squares right side
            previousXCoordinate = newXCoordinate

        #previous y is set to new y, (the top of the next row is set to the bottom of the current row)
        previousYCoordinate = newYCoordinate

    checkerBoard.save(imageFileName)


def drawHouse():
    #opens new window, gets first and second click
    houseWindow = GraphWin(width = 1000, height = 1000)

    firstClick = houseWindow.getMouse()
    secondClick = houseWindow.getMouse()

    #sorts xCoordinate and yCoordinates into a list and makes the p1 and p2 of the rectangle topleft and bottomright
    #  so that the filling of the house color is simpler later
    xCoordinates = [firstClick.getX(), secondClick.getX()]
    xCoordinates.sort()
    yCoordinates = [firstClick.getY(), secondClick.getY()]
    yCoordinates.sort()

    houseTopLeft = Point(xCoordinates[0],yCoordinates[0])
    houseBottomRight = Point(xCoordinates[1], yCoordinates[1])

    houseFrame = Rectangle(p1=houseTopLeft, p2=houseBottomRight)
    houseFrame.setFill("white")
    houseFrame.draw(houseWindow)


    #gets door width by getting abs value of difference in x of clicks, gets the center of the top of the door by user click
    doorWidth = abs(firstClick.getX() - secondClick.getX()) // 5
    doorTopCenter = houseWindow.getMouse()
    doorTopRight = Point(doorTopCenter.getX() + doorWidth // 2, doorTopCenter.getY())

    #if first y > second y (the first click was lower than the second) then it makes the bottom corner on first click y
    if firstClick.getY() > secondClick.getY():
        doorBottomLeft = Point(doorTopCenter.getX() - doorWidth // 2, firstClick.getY())

    #else (the second click is lower) the bottom corner is on the second click y
    else:
        doorBottomLeft = Point(doorTopCenter.getX() - doorWidth // 2, secondClick.getY())

    #makes door object and draws, fill is set to white
    door = Rectangle(doorBottomLeft,doorTopRight)
    door.setFill("white")
    door.draw(houseWindow)

    #calculates window width, gets window center, creates corners, and finally creates the window
    windowWidth = doorWidth // 2
    windowCenter = houseWindow.getMouse()
    windowTopLeft = Point(windowCenter.getX() - windowWidth // 2, windowCenter.getY() - windowWidth // 2)
    windowBottomRight = Point(windowCenter.getX() + windowWidth // 2, windowCenter.getY() + windowWidth // 2)
    window = Rectangle(windowTopLeft, windowBottomRight)




    #window is drawn, fill is set to white
    window.setFill("white")
    window.draw(houseWindow)

    colorList = ["black", "white", "red", "blue", "yellow", "orange", "purple", "green", "pink"]

    while True:
        mouseClick = houseWindow.getMouse()
        print(windowTopLeft.getX() , mouseClick.getX() , windowBottomRight.getX())
        print(windowTopLeft.getY(), mouseClick.getY() , windowBottomRight.getY())


        if int(mouseClick.getX()) in range(int(windowTopLeft.getX()), int(windowBottomRight.getX())) and int(mouseClick.getY()) in range(int(windowTopLeft.getY()), int(windowBottomRight.getY())):
            window.setFill(colorList[randint(0, len(colorList) - 1)])

        elif int(mouseClick.getX()) in range(int(doorBottomLeft.getX()), int(doorTopRight.getX())) and int(mouseClick.getY()) in range(int(doorTopRight.getY()), int(doorBottomLeft.getY())):
            door.setFill(colorList[randint(0, len(colorList) - 1)])

        elif int(mouseClick.getX()) in range(int(houseTopLeft.getX()), int(houseBottomRight.getX())) and int(mouseClick.getY()) in range(int(houseTopLeft.getY()), int(houseBottomRight.getY())):
            houseFrame.setFill(colorList[randint(0, len(colorList) - 1)])
        else:
            break







imageWidth = 1000
#drawCheckerBoard(imageWidth, "newImage.ppm", 8)
drawHouse()