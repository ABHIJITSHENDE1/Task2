public class Order {
    private int order_id;
    private String custName;
    private int product_id;
    private int  order_qty;
    private double total_amt;

    public Order(String custName, int product_id, int order_qty, double total_amt) {
        this.custName = custName;
        this.product_id = product_id;
        this.order_qty = order_qty;
        this.total_amt = total_amt;
    }

    public Order(String custName, int product_id, int order_qty) {
        this.custName = custName;
        this.product_id = product_id;
        this.order_qty = order_qty;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrder_qty() {
        return order_qty;
    }

    public void setOrder_qty(int order_qty) {
        this.order_qty = order_qty;
    }

    public double getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(double total_amt) {
        this.total_amt = total_amt;
    }
}
