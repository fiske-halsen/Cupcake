package FunctionLayer;

public class OrderLine {

private int customer_Id;
private int buttom_Id;
private int topping_Id;
private double total_Price;
private int quantity;

    public OrderLine(int customer_Id, int buttom_Id, int topping_Id, double total_Price, int quantity) {
        this.customer_Id = customer_Id;
        this.buttom_Id = buttom_Id;
        this.topping_Id = topping_Id;
        this.total_Price = total_Price;
        this.quantity = quantity;
    }

    public int getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        this.customer_Id = customer_Id;
    }

    public int getButtom_Id() {
        return buttom_Id;
    }

    public void setButtom_Id(int buttom_Id) {
        this.buttom_Id = buttom_Id;
    }

    public int getTopping_Id() {
        return topping_Id;
    }

    public void setTopping_Id(int topping_Id) {
        this.topping_Id = topping_Id;
    }

    public double getTotal_Price() {
        return total_Price;
    }

    public void setTotal_Price(double total_Price) {
        this.total_Price = total_Price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
