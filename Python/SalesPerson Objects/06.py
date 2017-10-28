#Phillip Byrd
#Assignment 06
#11.06.2016



class SalesPerson():
    def __init__(self, id, name):
        self.id = id
        self.name = name
        self.sales = []

    def setName(self, name):
        self.name = name

    def getName(self):
        return self.name

    def getID(self):
        return self.id

    def getSales(self):
        return self.sales

    def enterSales(self, aSale):
        self.sales.append(aSale)
        

    def totalSales(self):
        total = 0
        for el in self.sales:
            total = total + float(el)
        return total


    def metQuota(self, quota):
        if self.totalSales() >= quota:
            return True
        else:
            return False



    def compareTo(self, otherEmployee):
        if self.totalSales() > otherEmployee.totalSales():
            return (self.name, "Has the greater Sales in this period.")
        else:
            return (otherEmployee.name, "Has the greater Sales in this period.")


    def __str__(self):
        return "ID#:"+ str(self.getID()) + " " + \
                "Name:" + str(self.getName()) + " " + \
                "Sales List:" + str(self.getSales()) + \
               "\n************************\n"


myEmp01 = SalesPerson("123", "Chad Cheddar")
myEmp02 = SalesPerson("234", "Brad Brie")
myEmp03 = SalesPerson("345", "Maddie Muenster")
myEmp04 = SalesPerson("456", "Tradd Tilsit")
myEmp05 = SalesPerson("567", "Vlad Velveeta")

#question02


class SalesForce():
    def __init__(self):
        self.salesForce = []

    def addData(self, data):
        self.data = open(data, "r")
        self.allLines = self.data.readlines()


        for el in self.allLines:
            allWords = el.split(" ")
            name = str(allWords[1] + " " + allWords[2])
            myEmp = SalesPerson(allWords[0],  name)
            self.salesForce.append(myEmp)

            for sale in allWords[3:]:
                sale=sale.rstrip()
                myEmp.enterSales(sale)


    def quotaReport(self, quota):
        for el in self.salesForce:
            if el.totalSales() >= quota:
                print(el.getID(), el.getName(), el.totalSales(), "YES" )
                print()
            else:
                print(el.getID(), el.getName(), el.totalSales(), "NO" )
                print()

    def topSalesPerson(self):
        max = 0
        for el in self.salesForce:
            if el.totalSales() >= max:
                max = el.totalSales()
                topEmployee = el.getName()

        return topEmployee

    def individualSales(self, id):
        flag = 0
        for el in self.salesForce:
            temp = el.getID()

            if float(temp) == float(id):
                print("Sales Record: ", el.getSales())
                print("Total Sales: ", el.totalSales())
                flag = 1
                break
        if flag == 0:
            print("Employee does not exist")


    def __str__(self):
        teamList= ''
        for item in self.salesForce:
            teamList = teamList + str(item) + "\n\n"
        return teamList



def main():
    theSalesForce = SalesForce()
    theSalesForce.addData("salesdata.txt")



    print ("Quota report:")
    theSalesForce.quotaReport(750)
    print ("\n************************\n")

    topSales = theSalesForce.topSalesPerson()
    print ("Top sales person:")
    print (topSales)
    print ("\n************************\n")

    theSalesForce.individualSales(123)
    print ()
    theSalesForce.individualSales(999)
    print ()
    theSalesForce.individualSales(456)
    print ()
    theSalesForce.individualSales(345)

main()

