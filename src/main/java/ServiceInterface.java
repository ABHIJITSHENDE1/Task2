import java.util.List;

public interface ServiceInterface {
    List<Product> displayAllProduct();

    int removeProduct(String pName);

    int updateProductProduct(Product product);

    boolean placeOrder(Order order);
}
