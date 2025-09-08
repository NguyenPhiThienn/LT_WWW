package iuh.fit.se.bai4.model;

import java.util.ArrayList;

public class CartBean {
    private ArrayList<CartBeanItem> alCartItems = new ArrayList<CartBeanItem>();
    private double dblOrderTotal;

    public int getLineItemCount (){
    }

    public void deleteCartItem(String strItemIndex){
    }
    public void updateCartItem(String strItemIndex, String strQuantity){
    }

    public void addCartItem(String strModelNo, String strDescription, String strUnitCost, String strQuantity){
    }

    public void addCartItem(CartBeanItem cartItem){

    }

    public CartBeanItem getCartItem(int iItemIndex){

    }

    public ArrayList<CartBeanItem> getCartItems(){

    }



    public double getDblOrderTotal() {
        return dblOrderTotal;
    }

    public void setDblOrderTotal(double dblOrderTotal) {
        this.dblOrderTotal = dblOrderTotal;
    }
}
