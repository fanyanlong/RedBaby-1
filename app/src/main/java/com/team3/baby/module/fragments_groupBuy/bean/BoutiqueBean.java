package com.team3.baby.module.fragments_groupBuy.bean;

import java.util.List;

/**
 * 类用途：
 * 作者：ShiZhuangZhuang
 * 时间：2017/5/21 20:01
 */

public class BoutiqueBean {
    private EnrollsBean enrolls;
    private Enrolls1Bean enrolls_1;
    private TopLogoBean topLogo;
    private Object ads_lanjie;
    private List<AdsBean> ads;
    private List<CatesBean> cates;
    private List<?> categories;

    public EnrollsBean getEnrolls() {
        return enrolls;
    }

    public void setEnrolls(EnrollsBean enrolls) {
        this.enrolls = enrolls;
    }

    public Enrolls1Bean getEnrolls_1() {
        return enrolls_1;
    }

    public void setEnrolls_1(Enrolls1Bean enrolls_1) {
        this.enrolls_1 = enrolls_1;
    }

    public TopLogoBean getTopLogo() {
        return topLogo;
    }

    public void setTopLogo(TopLogoBean topLogo) {
        this.topLogo = topLogo;
    }

    public Object getAds_lanjie() {
        return ads_lanjie;
    }

    public void setAds_lanjie(Object ads_lanjie) {
        this.ads_lanjie = ads_lanjie;
    }

    public List<AdsBean> getAds() {
        return ads;
    }

    public void setAds(List<AdsBean> ads) {
        this.ads = ads;
    }

    public List<CatesBean> getCates() {
        return cates;
    }

    public void setCates(List<CatesBean> cates) {
        this.cates = cates;
    }

    public List<?> getCategories() {
        return categories;
    }

    public void setCategories(List<?> categories) {
        this.categories = categories;
    }

    public static class EnrollsBean {

        private int realCount;
        private List<ListBean> list;

        public int getRealCount() {
            return realCount;
        }

        public void setRealCount(int realCount) {
            this.realCount = realCount;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * actId : 91c769a3
             * actType : 1
             * activityEndTime : 1495727999000
             * activityStartTime : 1495123200000
             * auditStatus : 1
             * cateId : 1001
             * categoryId : 0
             * enrollId : 14546
             * flag : 1
             * imgUrl : //image.suning.cn/uimg/sop/commodity/142043159194198218862020_x.jpg
             * itemDesc : 居家旅行 加班熬夜 宅男必备
             * itemName : 统一老坛酸菜牛肉味面121g*5袋 （五连包）
             * memberNum : 2
             * origin : 1
             * price : 9.9
             * productCode : 000000000158998985
             * sort : 0.0
             * venderCode : 0000000000
             */

            private String actId;
            private int actType;
            private long activityEndTime;
            private long activityStartTime;
            private int auditStatus;
            private int cateId;
            private int categoryId;
            private int enrollId;
            private int flag;
            private String imgUrl;
            private String itemDesc;
            private String itemName;
            private int memberNum;
            private String origin;
            private double price;
            private String productCode;
            private double sort;
            private String venderCode;

            public String getActId() {
                return actId;
            }

            public void setActId(String actId) {
                this.actId = actId;
            }

            public int getActType() {
                return actType;
            }

            public void setActType(int actType) {
                this.actType = actType;
            }

            public long getActivityEndTime() {
                return activityEndTime;
            }

            public void setActivityEndTime(long activityEndTime) {
                this.activityEndTime = activityEndTime;
            }

            public long getActivityStartTime() {
                return activityStartTime;
            }

            public void setActivityStartTime(long activityStartTime) {
                this.activityStartTime = activityStartTime;
            }

            public int getAuditStatus() {
                return auditStatus;
            }

            public void setAuditStatus(int auditStatus) {
                this.auditStatus = auditStatus;
            }

            public int getCateId() {
                return cateId;
            }

            public void setCateId(int cateId) {
                this.cateId = cateId;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public int getEnrollId() {
                return enrollId;
            }

            public void setEnrollId(int enrollId) {
                this.enrollId = enrollId;
            }

            public int getFlag() {
                return flag;
            }

            public void setFlag(int flag) {
                this.flag = flag;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getItemDesc() {
                return itemDesc;
            }

            public void setItemDesc(String itemDesc) {
                this.itemDesc = itemDesc;
            }

            public String getItemName() {
                return itemName;
            }

            public void setItemName(String itemName) {
                this.itemName = itemName;
            }

            public int getMemberNum() {
                return memberNum;
            }

            public void setMemberNum(int memberNum) {
                this.memberNum = memberNum;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getProductCode() {
                return productCode;
            }

            public void setProductCode(String productCode) {
                this.productCode = productCode;
            }

            public double getSort() {
                return sort;
            }

            public void setSort(double sort) {
                this.sort = sort;
            }

            public String getVenderCode() {
                return venderCode;
            }

            public void setVenderCode(String venderCode) {
                this.venderCode = venderCode;
            }
        }
    }

    public static class Enrolls1Bean {
        private int realCount;
        private List<ListBeanX> list;

        public int getRealCount() {
            return realCount;
        }

        public void setRealCount(int realCount) {
            this.realCount = realCount;
        }

        public List<ListBeanX> getList() {
            return list;
        }

        public void setList(List<ListBeanX> list) {
            this.list = list;
        }

        public static class ListBeanX {
            /**
             * actId : 41cb7614
             * actType : 1
             * activityEndTime : 1495468799000
             * activityStartTime : 1494864000000
             * auditStatus : 1
             * cateId : 2001
             * categoryId : 0
             * enrollId : 15044
             * flag : 1
             * imgUrl : //image.suning.cn/uimg/pgs/activity/149534922571056352.jpg
             * itemDesc : 德国工匠品质 全植物初配方 每人限购1份
             * itemName : 【多拍不发】谷斑 麦纤抽纸18包*300张
             * memberNum : 2
             * origin : 2
             * price : 19.99
             * productCode : 000000000619038542
             * sort : 0.1
             * venderCode : 70161296
             */

            private String actId;
            private int actType;
            private long activityEndTime;
            private long activityStartTime;
            private int auditStatus;
            private int cateId;
            private int categoryId;
            private int enrollId;
            private int flag;
            private String imgUrl;
            private String itemDesc;
            private String itemName;
            private int memberNum;
            private String origin;
            private double price;
            private String productCode;
            private double sort;
            private String venderCode;

            public String getActId() {
                return actId;
            }

            public void setActId(String actId) {
                this.actId = actId;
            }

            public int getActType() {
                return actType;
            }

            public void setActType(int actType) {
                this.actType = actType;
            }

            public long getActivityEndTime() {
                return activityEndTime;
            }

            public void setActivityEndTime(long activityEndTime) {
                this.activityEndTime = activityEndTime;
            }

            public long getActivityStartTime() {
                return activityStartTime;
            }

            public void setActivityStartTime(long activityStartTime) {
                this.activityStartTime = activityStartTime;
            }

            public int getAuditStatus() {
                return auditStatus;
            }

            public void setAuditStatus(int auditStatus) {
                this.auditStatus = auditStatus;
            }

            public int getCateId() {
                return cateId;
            }

            public void setCateId(int cateId) {
                this.cateId = cateId;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public int getEnrollId() {
                return enrollId;
            }

            public void setEnrollId(int enrollId) {
                this.enrollId = enrollId;
            }

            public int getFlag() {
                return flag;
            }

            public void setFlag(int flag) {
                this.flag = flag;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getItemDesc() {
                return itemDesc;
            }

            public void setItemDesc(String itemDesc) {
                this.itemDesc = itemDesc;
            }

            public String getItemName() {
                return itemName;
            }

            public void setItemName(String itemName) {
                this.itemName = itemName;
            }

            public int getMemberNum() {
                return memberNum;
            }

            public void setMemberNum(int memberNum) {
                this.memberNum = memberNum;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getProductCode() {
                return productCode;
            }

            public void setProductCode(String productCode) {
                this.productCode = productCode;
            }

            public double getSort() {
                return sort;
            }

            public void setSort(double sort) {
                this.sort = sort;
            }

            public String getVenderCode() {
                return venderCode;
            }

            public void setVenderCode(String venderCode) {
                this.venderCode = venderCode;
            }
        }
    }

    public static class TopLogoBean {
        /**
         * sort : 1
         * targetUrl : //m.suning.com
         * createTime : 1487683015000
         * id : 1
         * endTime : 1513862206000
         * lastModifier : 12074031
         * modifyTime : 1487904099000
         * tag : 顶部logo
         * imgUrl : //image.suning.cn/uimg/pgs/activity/148790409596611078.jpg
         * title : 顶部logo
         * startTime : 1487683003000
         * state : 1
         * creator : 12074031
         * areaId : LPGTopLogoImage
         * description : 顶部logo
         */

        private int sort;
        private String targetUrl;
        private long createTime;
        private int id;
        private long endTime;
        private String lastModifier;
        private long modifyTime;
        private String tag;
        private String imgUrl;
        private String title;
        private long startTime;
        private int state;
        private String creator;
        private String areaId;
        private String description;

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getTargetUrl() {
            return targetUrl;
        }

        public void setTargetUrl(String targetUrl) {
            this.targetUrl = targetUrl;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public String getLastModifier() {
            return lastModifier;
        }

        public void setLastModifier(String lastModifier) {
            this.lastModifier = lastModifier;
        }

        public long getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(long modifyTime) {
            this.modifyTime = modifyTime;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static class AdsBean {
        /**
         * areaId : LPGJingxuan1001
         * createTime : 1495075292000
         * creator : 17031871
         * description : 5.19购酒节
         * endTime : 1495382399000
         * id : 132
         * imgUrl : //image.suning.cn/uimg/pgs/activity/149507525895534518.jpg
         * lastModifier : 17031871
         * modifyTime : 1495155566000
         * sort : 2
         * startTime : 1495123200000
         * state : 1
         * tag :
         * targetUrl : //c.m.suning.com/pggjj.html
         * title : 5.19购酒节
         */

        private String areaId;
        private long createTime;
        private String creator;
        private String description;
        private long endTime;
        private int id;
        private String imgUrl;
        private String lastModifier;
        private long modifyTime;
        private int sort;
        private long startTime;
        private int state;
        private String tag;
        private String targetUrl;
        private String title;

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getLastModifier() {
            return lastModifier;
        }

        public void setLastModifier(String lastModifier) {
            this.lastModifier = lastModifier;
        }

        public long getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(long modifyTime) {
            this.modifyTime = modifyTime;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getTargetUrl() {
            return targetUrl;
        }

        public void setTargetUrl(String targetUrl) {
            this.targetUrl = targetUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class CatesBean {
        /**
         * bandCateId : -1
         * cateIconUrl : //image.suning.cn/uimg/pgs/activity/149532792596941437.jpg
         * cateId : 1001
         * cateName : 精选
         * cateTagIconUrl :
         * createTime : 1487682440000
         * promoteId : 1
         * sort : 1
         * status : 1
         * targetUrl :
         */

        private int bandCateId;
        private String cateIconUrl;
        private int cateId;
        private String cateName;
        private String cateTagIconUrl;
        private long createTime;
        private int promoteId;
        private int sort;
        private int status;
        private String targetUrl;

        public int getBandCateId() {
            return bandCateId;
        }

        public void setBandCateId(int bandCateId) {
            this.bandCateId = bandCateId;
        }

        public String getCateIconUrl() {
            return cateIconUrl;
        }

        public void setCateIconUrl(String cateIconUrl) {
            this.cateIconUrl = cateIconUrl;
        }

        public int getCateId() {
            return cateId;
        }

        public void setCateId(int cateId) {
            this.cateId = cateId;
        }

        public String getCateName() {
            return cateName;
        }

        public void setCateName(String cateName) {
            this.cateName = cateName;
        }

        public String getCateTagIconUrl() {
            return cateTagIconUrl;
        }

        public void setCateTagIconUrl(String cateTagIconUrl) {
            this.cateTagIconUrl = cateTagIconUrl;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getPromoteId() {
            return promoteId;
        }

        public void setPromoteId(int promoteId) {
            this.promoteId = promoteId;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTargetUrl() {
            return targetUrl;
        }

        public void setTargetUrl(String targetUrl) {
            this.targetUrl = targetUrl;
        }
    }
}
