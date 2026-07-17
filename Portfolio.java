public class Portfolio
{
    private double balance;
    private Stock[] marketStocks;
    private int[] ownedShares;
    
    private Transaction[] transactions;
    private int transactionCount;

    // Constructor
    public Portfolio()
    {
        balance = 100000;

        marketStocks = new Stock[5];
        ownedShares = new int[5];

        transactions = new Transaction[100];
        transactionCount = 0;

        marketStocks[0] = new Stock(1 , "TCS" , 3500);
        marketStocks[1] = new Stock(2 , "Infosys" , 1600);
        marketStocks[2] = new Stock(3 , "Reliance", 2900);
        marketStocks[3] = new Stock(4 , "HDFC Bank" , 1700);
        marketStocks[4] = new Stock(5 , "Wipro" , 250);
    }

    public void viewMarket()
    {
        System.out.println("\n================================================");
        System.out.println("                  STOCK MARKET");
        System.out.println("================================================");
        System.out.printf("%-5s %-20s %-10s%n" , "ID" , "Stock Name" , "Price (Rs.)");
        System.out.println("------------------------------------------------");

        for(int i=0; i<marketStocks.length; i++)
        {
            System.out.printf("%-5d %-20s Rs. %.2f%n" , 
                marketStocks[i].getId(),
                marketStocks[i].getName(),
                marketStocks[i].getPrice());
        }
        System.out.println("================================================");
    }

    public void buyStock(int stockID , int quantity)
    {
        if(stockID < 1 || stockID > marketStocks.length)
        {
            System.out.println("\nInvalid Stock ID!");
            return;
        }

        if(quantity <= 0)
        {
            System.out.println("\nQuantity must be greater than zero.");
            return;
        }

        Stock stock = marketStocks[stockID - 1];
        double totalCost = stock.getPrice() * quantity;

        balance = balance - totalCost;

        ownedShares[stockID - 1] = ownedShares[stockID - 1] + quantity;

        transactions[transactionCount] = 
            new Transaction(
                "BUY",
                stock.getName(),
                quantity,
                totalCost
            );

        transactionCount++;

        System.out.println("\n=================================");
        System.out.println("Stock Purchased Successfully!");
        System.out.println("=================================");
        System.out.println("Stock             : " + stock.getName());
        System.out.println("Quantity          : " + quantity);
        System.out.printf("Total Cost : Rs. %.2f%n" , totalCost);
        System.out.printf("Balance    : Rs. %.2f%n" , balance);
    }

    public void sellStock(int stockID , int quantity)
    {
        if(stockID < 1 || stockID > marketStocks.length)
        {
            System.out.println("\nInvalid Stock ID!");
            return;
        }

        if(quantity <= 0)
        {
            System.out.println("\nQuantity must be greater than zero.");
            return;
        }

        if(ownedShares[stockID - 1] < quantity)
        {
            System.out.println("\nNot enough shares to sell!");
            return;
        }

        Stock stock = marketStocks[stockID - 1];
        double totalAmount = stock.getPrice() * quantity;

        balance = balance + totalAmount;

        ownedShares[stockID - 1] = ownedShares[stockID - 1] - quantity;

        transactions[transactionCount] = 
            new Transaction(
                "SELL",
                stock.getName(),
                quantity,
                totalAmount
            );

        transactionCount++;

        System.out.println("\n=====================================");
        System.out.println("Stock Sold Successfully!");
        System.out.println("=====================================");
        System.out.println("Stock    : " + stock.getName());
        System.out.println("Quantity : " + quantity);
        System.out.printf("Amount   : Rs. %.2f%n" , totalAmount);
        System.out.printf("Balance  : Rs. %.2f%n" , balance);
    }

    public void viewPortfolio()
    {
        double portfolioValue = 0;

        System.out.println("\n==========================================================");
        System.out.println("                     MY PORTFOLIO");
        System.out.println("==========================================================");
        System.out.printf("%-20s %-10s %-12s %-15s%n",
                "Stock Name", "Shares", "Price(Rs.)", "Total Value");

        System.out.println("----------------------------------------------------------");

        boolean hasStocks = false;

        for(int i=0; i<marketStocks.length; i++)
        {
            if(ownedShares[i] > 0)
            {
                hasStocks = true;

                double stockValue = ownedShares[i] * marketStocks[i].getPrice();
                portfolioValue = portfolioValue + stockValue;

                System.out.printf("%-20s %-10d %-12.2f %-15.2f%n",
                        marketStocks[i].getName(),
                        ownedShares[i],
                        marketStocks[i].getPrice(),
                        stockValue
                );
            }
        }

        if(!hasStocks)
        {
            System.out.println("No stocks purchased yet.");
        }

        System.out.println("----------------------------------------------------------");

        System.out.printf("Portfolio Value   : Rs. %.2f%n" , portfolioValue);
        System.out.printf("Available Balance : Rs. %.2f%n" , balance);

        System.out.println("==========================================================");
    }

    public void viewTransactions()
    {
        System.out.println("\n========================================================");
        System.out.println("                  TRANSACTION HISTORY");
        System.out.println("========================================================");

        if(transactionCount == 0)
        {
            System.out.println("No transactions found.");
            System.out.println("========================================================");
            return;
        }

        System.out.printf("%-10s %-20s %-10s %-15s%n",
                "Type",
                "Stock Name",
                "Shares",
                "Amount(Rs.)"
        );

        System.out.println("--------------------------------------------------------");

        for(int i=0; i<transactionCount; i++)
        {
            System.out.printf("%-10s %-20s %-10d Rs. %-15.2f%n",
                    transactions[i].getTransactionType(),
                    transactions[i].getStockName(),
                    transactions[i].getQuantity(),
                    transactions[i].getTotalCost()
            );
        }

        System.out.println("========================================================");
    }
}
