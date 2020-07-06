package by.roman.shop.page;

public enum JSPPage {
    MAIN, PRODUCTS, CART, LOGIN;
    public String getPageName () {
      return this.toString().toLowerCase() + ".jsp";
    }

}
