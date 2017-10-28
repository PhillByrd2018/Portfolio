# SalesTestDriver.py
# Author: Pharr

# SalesTestDriver - creates a SalesForce object and uses it
# to determine aspects of the sales force.

class SalesForce():
    def __init__(self):
        self.salesForce = []



    def addData(self, data):
        self.data = open(data, "r")
        self.allLines = self.data.readlines()
        print(self.allLines)

        for el in self.allLines:
            allWords = el.split(" ")
            print(allWords[0])
            #myEmp = SalesPerson(el[0], el[1] + el[2])











def main():
    theSalesForce = SalesForce()
    theSalesForce.addData("salesdata.txt")
    
    # print ("Quota report:")
    # theSalesForce.quotaReport(750)
    # print ("\n************************\n")
    #
    # topSales = theSalesForce.topSalesPerson()
    # print ("Top sales person:")
    # print (topSales)
    # print ("\n************************\n")
    #
    # theSalesForce.individualSales(123)
    # print ()
    # theSalesForce.individualSales(999)
    # print ()
    # theSalesForce.individualSales(456)
    # print ()
    # theSalesForce.individualSales(345)

main()
