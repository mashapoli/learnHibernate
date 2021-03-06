//package inheritance.manyToOne;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.validation.constraints.NotNull;
//
//@Entity
//public class CreditCard extends BillingDetails {
//
//
//    @NotNull
//    @Column(name = "card_number")
//    protected String cardNumber;
//
//
//    @NotNull
//    @Column(name = "exp_month")
//    protected String expMonth;
//
//
//    @NotNull
//    @Column(name = "exp_year")
//    protected String expYear;
//
//    public CreditCard() {
//        super();
//    }
//
//    public CreditCard(String owner, String cardNumber, String expMonth, String expYear) {
//        super(owner);
//        this.cardNumber = cardNumber;
//        this.expMonth = expMonth;
//        this.expYear = expYear;
//    }
//
//    public String getCardNumber() {
//        return cardNumber;
//    }
//
//    public void setCardNumber(String cardNumber) {
//        this.cardNumber = cardNumber;
//    }
//
//    public String getExpMonth() {
//        return expMonth;
//    }
//
//    public void setExpMonth(String expMonth) {
//        this.expMonth = expMonth;
//    }
//
//    public String getExpYear() {
//        return expYear;
//    }
//
//    public void setExpYear(String expYear) {
//        this.expYear = expYear;
//    }
//
//}