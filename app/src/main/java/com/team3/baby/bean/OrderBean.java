package com.team3.baby.bean;

import java.util.List;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/6/2  20:32
 */

public class OrderBean {

    /**
     * Amount : 0
     * BalanceAmount : 0
     * CouponDiscount : 0
     * CouponTitle :
     * CreateDateTime : 2017-06-06T08:38:26
     * CustomerId : 5e69475d-5135-4eb0-9215-068c2c10c747
     * Discount : 0
     * Freight : 0
     * Id : 7c9ae4ae-bf9d-4a76-b05c-f7486840a415
     * OrderDate : 2017-06-06T08:38:42
     * OrderDetails : [{"ImageUrl":"/Images/Editor/96a34cac654f47e9acb46c4ca0ca169a_360_360.jpeg","Price":34,"ProductId":"205338e7-33de-46aa-ad79-4ac56dfdc9ef","ProductName":"合禾果枇杷蜜","Quantity":2,"Unit":"300g"}]
     * Remark :
     * Serial : 20170606083842
     * Status : Paid
     * StatusText : 已付款
     * Sum : 0
     */

    private int Amount;
    private int BalanceAmount;
    private int CouponDiscount;
    private String CouponTitle;
    private String CreateDateTime;
    private String CustomerId;
    private int Discount;
    private int Freight;
    private String Id;
    private String OrderDate;
    private String Remark;
    private String Serial;
    private String Status;
    private String StatusText;
    private int Sum;
    private List<OrderDetailsBean> OrderDetails;

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public int getBalanceAmount() {
        return BalanceAmount;
    }

    public void setBalanceAmount(int BalanceAmount) {
        this.BalanceAmount = BalanceAmount;
    }

    public int getCouponDiscount() {
        return CouponDiscount;
    }

    public void setCouponDiscount(int CouponDiscount) {
        this.CouponDiscount = CouponDiscount;
    }

    public String getCouponTitle() {
        return CouponTitle;
    }

    public void setCouponTitle(String CouponTitle) {
        this.CouponTitle = CouponTitle;
    }

    public String getCreateDateTime() {
        return CreateDateTime;
    }

    public void setCreateDateTime(String CreateDateTime) {
        this.CreateDateTime = CreateDateTime;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int Discount) {
        this.Discount = Discount;
    }

    public int getFreight() {
        return Freight;
    }

    public void setFreight(int Freight) {
        this.Freight = Freight;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String Remark) {
        this.Remark = Remark;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String Serial) {
        this.Serial = Serial;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getStatusText() {
        return StatusText;
    }

    public void setStatusText(String StatusText) {
        this.StatusText = StatusText;
    }

    public int getSum() {
        return Sum;
    }

    public void setSum(int Sum) {
        this.Sum = Sum;
    }

    public List<OrderDetailsBean> getOrderDetails() {
        return OrderDetails;
    }

    public void setOrderDetails(List<OrderDetailsBean> OrderDetails) {
        this.OrderDetails = OrderDetails;
    }

    public static class OrderDetailsBean {
        /**
         * ImageUrl : /Images/Editor/96a34cac654f47e9acb46c4ca0ca169a_360_360.jpeg
         * Price : 34
         * ProductId : 205338e7-33de-46aa-ad79-4ac56dfdc9ef
         * ProductName : 合禾果枇杷蜜
         * Quantity : 2
         * Unit : 300g
         */

        private String ImageUrl;
        private int Price;
        private String ProductId;
        private String ProductName;
        private int Quantity;
        private String Unit;

        public String getImageUrl() {
            return ImageUrl;
        }

        public void setImageUrl(String ImageUrl) {
            this.ImageUrl = ImageUrl;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public String getProductId() {
            return ProductId;
        }

        public void setProductId(String ProductId) {
            this.ProductId = ProductId;
        }

        public String getProductName() {
            return ProductName;
        }

        public void setProductName(String ProductName) {
            this.ProductName = ProductName;
        }

        public int getQuantity() {
            return Quantity;
        }

        public void setQuantity(int Quantity) {
            this.Quantity = Quantity;
        }

        public String getUnit() {
            return Unit;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }
    }
}
