package me.redbaby.greendao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "TABLE_SHOPPING".
 */
public class Table_shopping {

    private Long id;
    /** Not-null value. */
    private String shopping_id;
    /** Not-null value. */
    private String shopping_name ;
    private float shopping_price;
    private String shopping_url;
    private String shopping_pic;
    private int shopping_count;
    private int shopping_state;

    public Table_shopping() {
    }

    public Table_shopping(Long id) {
        this.id = id;
    }

    public Table_shopping(Long id, String shopping_id, String shopping_name , float shopping_price, String shopping_url, String shopping_pic, int shopping_count, int shopping_state) {
        this.id = id;
        this.shopping_id = shopping_id;
        this.shopping_name  = shopping_name ;
        this.shopping_price = shopping_price;
        this.shopping_url = shopping_url;
        this.shopping_pic = shopping_pic;
        this.shopping_count = shopping_count;
        this.shopping_state = shopping_state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getShopping_id() {
        return shopping_id;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setShopping_id(String shopping_id) {
        this.shopping_id = shopping_id;
    }

    /** Not-null value. */
    public String getShopping_name () {
        return shopping_name ;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setShopping_name (String shopping_name ) {
        this.shopping_name  = shopping_name ;
    }

    public float getShopping_price() {
        return shopping_price;
    }

    public void setShopping_price(float shopping_price) {
        this.shopping_price = shopping_price;
    }

    public String getShopping_url() {
        return shopping_url;
    }

    public void setShopping_url(String shopping_url) {
        this.shopping_url = shopping_url;
    }

    public String getShopping_pic() {
        return shopping_pic;
    }

    public void setShopping_pic(String shopping_pic) {
        this.shopping_pic = shopping_pic;
    }

    public int getShopping_count() {
        return shopping_count;
    }

    public void setShopping_count(int shopping_count) {
        this.shopping_count = shopping_count;
    }

    public int getShopping_state() {
        return shopping_state;
    }

    public void setShopping_state(int shopping_state) {
        this.shopping_state = shopping_state;
    }

}
