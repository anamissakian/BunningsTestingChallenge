package data;

public class Product {
    private String productName;
    private String Category;


    public Product(String productName, String category) {
        this.productName = productName;
        Category = category;
    }

    public Product(String productName) {
        this.productName = productName;

    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getCategory() {
        return Category;
    }


}
