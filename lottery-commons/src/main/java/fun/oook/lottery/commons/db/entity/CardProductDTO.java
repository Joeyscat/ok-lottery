package fun.oook.lottery.commons.db.entity;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
public class CardProductDTO extends CardProduct{
    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(final Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CardProductDTO{" +
                "amount=" + amount +
                "} " + super.toString();
    }
}
