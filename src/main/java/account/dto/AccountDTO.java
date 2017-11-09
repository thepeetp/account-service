package account.dto;

import account.domain.Account;

import java.math.BigDecimal;

public class AccountDTO {
    private String name;
    private String description;
    private BigDecimal amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Account toEntity(String userRef) {
        return new Account(name, amount, description, userRef);
    }
}
