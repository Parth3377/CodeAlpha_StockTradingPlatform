import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        Portfolio portfolio = new Portfolio();

        int choice;

        while(true)
        {
            System.out.println("\n========================================");
            System.out.println("           STOCK TRADING PLATFORM       ");
            System.out.println("========================================");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");
            System.out.println("========================================");

            System.out.print("Enter Your Choice : ");
            choice = input.nextInt();

            switch(choice)
            {
                case 1:
                    portfolio.viewMarket();
                    break;

                case 2:
                    System.out.print("Enter Stock ID : ");
                    int buyID = input.nextInt();

                    System.out.print("Enter Quantity : ");
                    int buyQty = input.nextInt();

                    portfolio.buyStock(buyID, buyQty);
                    break;

                case 3:
                    System.out.print("Enter Stock ID : ");
                    int sellID = input.nextInt();

                    System.out.print("Enter Quantity : ");
                    int sellQty = input.nextInt();

                    portfolio.sellStock(sellID, sellQty);
                    break;

                case 4:
                    portfolio.viewPortfolio();
                    break;

                case 5:
                    portfolio.viewTransactions();
                    break;

                case 6:
                    System.out.println("\n=====================================");
                    System.out.println("Thank You For Using ");
                    System.out.println("Stock Trading Platform");
                    System.out.println("=======================================");

                    input.close();
                    return;

                default:
                    System.out.println("\nInvalid Choice! Please Try Again.");
            }
        }
    }
        
}
