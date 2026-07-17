public class Transaction
{
    private String transactionType;
    private String stockName;
    private int quantity;
    private double totalAmount;

    public Transaction(String transactionType , String stockName , int quantity , double totalAmount)
    {
        this.transactionType = transactionType;
        this.stockName = stockName;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public String getTransactionType()
    {
        return transactionType;
    }
    public String getStockName()
    {
        return stockName;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public double getTotalCost()
    {
        return totalAmount;
    }
}