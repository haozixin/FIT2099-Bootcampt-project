public class Bid {
    private String bidId;
    private Buyer buyer;
    private float bidPrice;
    private String bidDate;

    public Bid(){};

    public Bid(String bidId, Buyer buyer, float bidPrice, String bidDate) {
        this.bidId = bidId;
        this.buyer = buyer;
        this.bidPrice = bidPrice;
        this.bidDate = bidDate;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setBidPrice(float bidPrice) {
        this.bidPrice = bidPrice;
    }

    public void setBidDate(String bidDate) {
        this.bidDate = bidDate;
    }

    public String getBidId() {
        return bidId;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public float getBidPrice() {
        return bidPrice;
    }

    public String getBidDate() {
        return bidDate;
    }
}
