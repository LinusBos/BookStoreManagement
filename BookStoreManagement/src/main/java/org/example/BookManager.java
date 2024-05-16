package org.example;

public class BookManager implements ProductManager{
    @Override
    public boolean changeTitle(Product product, String title) {
        product.setTitle(title);
        return true;
    }

    @Override
    public boolean changeSellPrice(Product product, double sellPrice) {
        if (sellPrice >= 0) {
            product.setSellPrice(sellPrice);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean changePurchasePrice(Product product, double purchasePrice) {
        if (purchasePrice >= 0) {
            product.setPurchasePrice(purchasePrice);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean changeReleaseDate(Product product, String releaseDate) {
        product.setReleaseDate(releaseDate);
        return true;
    }

    @Override
    public boolean changeQuantity(Product product, int quantity) {
        if (quantity >= 0) {
            product.setQuantity(quantity);
            return true;
        } else {
            return false;
        }
    }
}
