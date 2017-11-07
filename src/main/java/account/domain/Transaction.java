package account.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.math.BigDecimal;
import java.util.UUID;

public class Transaction {

    @Id
    private String id = UUID.randomUUID().toString();
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    private Type type;
    @JoinColumn
    private Account account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public enum Type {
        DEPOSIT, WITHDRAW
    }
}
