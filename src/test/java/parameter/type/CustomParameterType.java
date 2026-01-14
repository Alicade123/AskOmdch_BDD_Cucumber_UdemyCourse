package parameter.type;

import io.cucumber.java.ParameterType;
import object.Product;

public class CustomParameterType {
    @ParameterType(".*[Ss]hoes.*")
    public Product product(String productName){
        return new Product(productName);
    }
}
