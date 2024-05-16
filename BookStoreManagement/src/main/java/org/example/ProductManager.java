package org.example;

public interface ProductManager {
    boolean changeTitle(Product product, String title);
    boolean changeSellPrice(Product product, double sellPrice);
    boolean changePurchasePrice(Product product, double purchasePrice);
    boolean changeReleaseDate(Product product, String releaseDate);
    boolean changeQuantity(Product product, int quantity);

}
