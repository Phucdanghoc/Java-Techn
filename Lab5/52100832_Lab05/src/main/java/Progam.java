import DAO.ProductDAO;
import DAO.UserDAO;
import Interface.Generic;
import POJO.Product;
import POJO.User;

public class Progam {
    public static void main(String[] args) {
//        UserDAO.getInstance().getAll().forEach(p -> System.out.println(p.toString()));
        Product product =  ProductDAO.getInstance().get(Integer.parseInt("5"));
        product.setName("23");
        product.setPrice(Integer.parseInt("122121"));
        ProductDAO.getInstance().update(product);
        System.out.println(ProductDAO.getInstance().update(product));
    }
}
