import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static Scanner in = new Scanner(System.in);
    private static ServiceInterface serviceInterface = new ServiceImplemenntation();
    public static void main(String[] args) {
        System.out.println("Enter Option");
        System.out.println("1:Display All Product");
        System.out.println("2:Remove Product");
        System.out.println("3:Update Product");
        System.out.println("4:Place Order");
        System.out.println("5:Display Order");
        int ch = in.nextInt();
        switch (ch){
            case 1:
                displayAllProduct();
                break;
            case 2:
                removeProduct();
                break;
            case 3:
                updateProduct();
                break;
            case 4:
                placeOrder();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid Option!!");
        }

    }

    private static void placeOrder() {

        System.out.println("Enter Name");
        String name = in.next();
        System.out.println("Enter product Id");
        int pId = in.nextInt();
        System.out.println("Enter Order Quantity");
        int oQty = in.nextInt();
        Order order = new Order(name,pId,oQty);
        boolean sts = serviceInterface.placeOrder(order);
        if (sts){
            System.out.println("Order placed");
        }
        else {
            System.out.println("Order Not Placed");
        }
    }

    private static void updateProduct() {
        System.out.println("Enter Product Id");
        int pId = in.nextInt();
        System.out.println("Enter Product Name");
        String pName = in.next();
        System.out.println("Enter Product Qty");
        int pQty = in.nextInt();
        System.out.println("Enter Product Price ");
        double pPrice = in.nextDouble();
        Product product = new Product(pId,pName,pQty,pPrice);
        int n = serviceInterface.updateProductProduct(product);
        if (n == 1){
            System.out.println("Product Updated Successfully");
        }
        else {
            System.out.println("Product Update failed");
        }
    }

    private static void removeProduct() {
        System.out.println("Enter Product Name");
        String pName = in.next();
        int n = serviceInterface.removeProduct(pName);
        if (n == 1){
            System.out.println("Product Remove Successfully");
        }
        else {
            System.out.println("Some Error Occurred while removing");
        }
    }

    private static void displayAllProduct() {
        List<Product> productList = serviceInterface.displayAllProduct();
        for (Product p : productList){
            System.out.println(p.getProduct_id()+"\t");
            System.out.print(p.getProduct_name()+"\t");
            System.out.print(p.getProduct_price());

        }
        System.out.println("===============================");
    }
}
