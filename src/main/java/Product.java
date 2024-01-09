public class Product {
    private int product_id;
    private String product_name;
    private int product_qty;
    private double product_price;

    public Product(int product_id, String product_name, int product_qty, double product_price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_qty = product_qty;
        this.product_price = product_price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_qty() {
        return product_qty;
    }

    public void setProduct_qty(int product_qty) {
        this.product_qty = product_qty;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }
}
