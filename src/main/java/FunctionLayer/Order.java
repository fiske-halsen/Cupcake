package FunctionLayer;

public class Order {

    private String date;
    private int customer_Id;


    public Order(String date, int customer_Id) {
        this.date = date;
        this.customer_Id = customer_Id;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        this.customer_Id = customer_Id;
    }
}
