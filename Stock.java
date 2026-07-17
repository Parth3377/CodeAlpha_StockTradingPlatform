public class Stock
{
    private int id;
    private String name;
    private double price;

    // Constructor
    public Stock(int id , String name , double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }    
}
