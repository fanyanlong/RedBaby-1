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
     * CreateDateTime : 2017-05-31T21:05:03
     * CustomerId : 5e69475d-5135-4eb0-9215-068c2c10c747
     * Discount : 0
     * Freight : 0
     * Id : 6150cd17-f6c6-42f5-8c15-5501783a7bc7
     * OrderDetails : [{"ImageUrl":"/Images/Editor/cf277e420e5b4902b0176132f462e61c_640_640.jpeg","Price":0.01,"ProductId":"d0dfc5a5-b6b0-4050-b667-10277f41b59d","ProductName":"苏格兰蝴蝶夫人沐浴礼盒","Quantity":1,"Unit":"礼盒"},{"ImageUrl":"/Images/Editor/f3f24b2f5cd545b5ac6d5fb883c2a70b_360_360.jpeg","Price":1980,"ProductId":"e4b77948-00b3-48e5-b8ab-6cc943d0f276","ProductName":"UCAFE全自动胶囊咖啡机","Quantity":1,"Unit":"白色"}]
     * Status : Created
     * StatusText : 已创建
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
         * ImageUrl : /Images/Editor/cf277e420e5b4902b0176132f462e61c_640_640.jpeg
         * Price : 0.01
         * ProductId : d0dfc5a5-b6b0-4050-b667-10277f41b59d
         * ProductName : 苏格兰蝴蝶夫人沐浴礼盒
         * Quantity : 1
         * Unit : 礼盒
         */

        private String ImageUrl;
        private double Price;
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

        public double getPrice() {
            return Price;
        }

        public void setPrice(double Price) {
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
