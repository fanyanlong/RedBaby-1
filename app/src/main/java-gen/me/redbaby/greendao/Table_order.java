package me.redbaby.greendao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "TABLE_ORDER".
 */
public class Table_order {

    private Long id;
    /** Not-null value. */
    private String order_id;

    public Table_order() {
    }

    public Table_order(Long id) {
        this.id = id;
    }

    public Table_order(Long id, String order_id) {
        this.id = id;
        this.order_id = order_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getOrder_id() {
        return order_id;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

}
