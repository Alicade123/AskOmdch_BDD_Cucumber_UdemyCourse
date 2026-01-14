package object;

public class Product {
    private String productName;
    //Todo: Getter
    public String getProductName() {
        return productName;
    }
    //Todo: Setter
    public void setProductName(String productName) {
        this.productName = productName;
    }
    //Todo: Constructor
    public Product(String productName) {
        setProductName(productName);
    }
}
