package account.domain;

import account.dto.AccountDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Account {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    @Column(nullable = false)
    @NotNull
    private BigDecimal balance = BigDecimal.ZERO;
    private String description;
    @Column(nullable = false)
    private String userRef;
    private LocalDateTime createdDate = LocalDateTime.now();

    public Account() {
    }

    public Account(String name, BigDecimal balance, String description, String userRef) {
        this.name = name;
        this.balance = balance;
        this.description = description;
        this.userRef = userRef;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getUserRef() {
        return userRef;
    }

    public void setUserRef(String userRef) {
        this.userRef = userRef;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account fetch(AccountDTO dto) {
        balance = dto.getAmount();
        return this;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
