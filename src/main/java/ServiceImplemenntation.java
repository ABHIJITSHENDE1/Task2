import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceImplemenntation implements ServiceInterface{
    private static Connection conn = null;
    static {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/task2","root","tiger");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    @Override
    public List<Product> displayAllProduct() {
        List<Product> productList = new ArrayList<>();
        String query = "select * from product_info";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                Product product = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return productList;
    }

    @Override
    public int removeProduct(String pName) {
        int n = 0;
        String removeQuery = "delete from product_info where product_name = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(removeQuery);
            pstmt.setString(1,pName);
            n = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    @Override
    public int updateProductProduct(Product product) {
        int n = 0;
        String upQuery = "update product_info set product_name = ?, product_qty = ?, product_price = ? " +
                "where product_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(upQuery);
            pstmt.setString(1,product.getProduct_name());
            pstmt.setInt(2,product.getProduct_qty());
            pstmt.setDouble(3,product.getProduct_price());
            pstmt.setInt(4,product.getProduct_id());
            n = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    @Override
    public boolean placeOrder(Order order) {
        boolean sts = false;
        int n = 0;
        try {
            CallableStatement cstmt = conn.prepareCall("{call placeOrder(?,?,?,?)}");
            cstmt.setString(1,order.getCustName());
            cstmt.setInt(2,order.getProduct_id());
            cstmt.setInt(3,order.getOrder_qty());
            cstmt.registerOutParameter(4, Types.BOOLEAN);
            cstmt.execute();
            sts = cstmt.getBoolean(4);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sts;
    }

    @Override
    public List<Order> displayAllOrder(String name) {
        List<Order> orderList = new ArrayList<>();

        try {
            CallableStatement cstmt = conn.prepareCall("{CALL displayAllOrder(?, ?)}");
            cstmt.setString(1,name);
            cstmt.registerOutParameter(2, Types.DOUBLE);
            cstmt.execute();
            ResultSet rs = cstmt.getResultSet();
            while (rs.next()) {
                String cName = rs.getString(2);
                int productId = rs.getInt(3);
                int orderQty = rs.getInt(4);
                double totalAmount = rs.getDouble(5);
                Order order = new Order(cName,productId,orderQty,totalAmount);
                orderList.add(order);
            }
            double totalBill = cstmt.getDouble(2);
            System.out.println("Total Bill: " + totalBill);
            System.out.println("=================================================================================================");
        } catch (SQLException e) {
            System.out.println(e);
        }

        return orderList;

    }
}
