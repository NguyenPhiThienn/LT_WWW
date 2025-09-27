package iuh.fit.se.bai2.models;

import java.util.ArrayList;

public class CartBean {
    private ArrayList<CartItemBean> alCartItems = new ArrayList<>();
    private double dblOrderTotal;

    public int getLineItemCount() {
        return alCartItems.size();
    }

    public void deleteCartItem(String strItemIndex){
        try {
            int iItemIndex = Integer.parseInt(strItemIndex.trim());
            if(iItemIndex > 0 && iItemIndex <= alCartItems.size()){
                alCartItems.remove(iItemIndex - 1);
                calculateOrderTotal();
            }
        } catch (NumberFormatException e){
            System.out.println("Error while deleting cart item: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateCartItem(String strItemIndex, String strQuantity){
        try {
            int iItemIndex = Integer.parseInt(strItemIndex.trim());
            int iQuantity = Integer.parseInt(strQuantity.trim());
            if(iQuantity > 0 && iItemIndex > 0 && iItemIndex <= alCartItems.size()){
                CartItemBean cartItem = alCartItems.get(iItemIndex - 1);
                cartItem.setQuantity(iQuantity);
                cartItem.setTotalCost(cartItem.getUnitCost() * iQuantity);
                calculateOrderTotal();
            }
        } catch (NumberFormatException e){
            System.out.println("Error while updating cart item: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void addCartItem(String strModelNo, String strDescription,String strUnitCost, String strQuantity){
        try{
            double dblUnitCost = Double.parseDouble(strUnitCost.trim());
            int iQuantity = Integer.parseInt(strQuantity.trim());
            if(iQuantity > 0){
                double dblTotalCost = dblUnitCost * iQuantity;
                CartItemBean cartItem = new CartItemBean();
                cartItem.setPartNumber(strModelNo.trim());
                cartItem.setModelDescription(strDescription.trim());
                cartItem.setUnitCost(dblUnitCost);
                cartItem.setQuantity(iQuantity);
                cartItem.setTotalCost(dblTotalCost);
                alCartItems.add(cartItem);
                calculateOrderTotal();
            }
        } catch (NumberFormatException e){
            System.out.println("Error while adding cart item: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public ArrayList<CartItemBean> getCartItems() {
        return alCartItems;
    }

    public double getOrderTotal() {
        return dblOrderTotal;
    }

    private void calculateOrderTotal(){
        dblOrderTotal = 0;
        for(CartItemBean item: alCartItems){
            dblOrderTotal += item.getTotalCost();
        }
    }
}
