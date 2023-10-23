# Spring Boot Transaction Management

**Definition:**
An operation or set of operations performed on the database.
A single logical unit of work that may access or modify the content of a database.

**Examples:**
- Employee Registration
- Bank transaction.

**Operations:**
- **Begin**
- **Commit/Rollback**

**A Transaction Looks Like:**
```
Start
Query 1
Query 2
Query 3
Commit
```

## @Transactional

`@Transactional` is an annotation provided by the Spring framework that allows you to declaratively control transaction behavior.

- **Method level**
- **Class level**

- **Begin**: When the execution of method starts
- **Commit**: When the execution of method completes successfully
- **Rollback**: When any exception is thrown

### Attributes of @Transactional

1. **Propagation**: Determines how a transaction behaves within the context of an existing transaction.

    - **REQUIRED**:
        - If there is an existing transaction, the method will participate in that transaction. If there isn't an existing transaction, a new one will be started. (Default propagation type)

    - **SUPPORTS**:
        - If there is an existing transaction, the method will participate in that transaction. If there isn't an existing transaction, the method will execute non-transactionally.

    - **MANDATORY**:
        - The method must be called within an existing transaction. If no transaction exists, an exception will be thrown.

    - **REQUIRES_NEW**:
        - The method will always start a new transaction, suspending the current transaction if one exists.

    - **NOT_SUPPORTED**:
        - The method will always execute non-transactionally, even if there's an existing transaction.

    - **NEVER**:
        - The method must execute without a transaction. If a transaction exists, an exception will be thrown.

    - **NESTED**:
        - The method will start a new transaction but will use the current transaction as a parent. If an exception occurs, only the current transaction will be rolled back.

2. **Usage Examples**:

    - **REQUIRED**:
        - Use when you want to ensure that a transaction is always available. It's the most common propagation type.

    - **SUPPORTS**:
        - Use when you want a method to participate in a transaction if one exists, but don't want to start a new one.

    - **MANDATORY**:
        - Use when a method absolutely must run within a transaction. It throws an exception if there isn't an existing transaction.

    - **REQUIRES_NEW**:
        - Use when a method needs to run in its own transaction, independent of any existing transactions.

    - **NOT_SUPPORTED**:
        - Use when you want to ensure that a method does not run within a transaction, even if one exists.

    - **NEVER**:
        - Use when you want to ensure that a method never runs within a transaction.

    - **NESTED**:
        - Use when you want to create a nested transaction within the scope of a current transaction.

3. **Isolation**: Defines the extent to which the changes made by one transaction are visible to other transactions.

    - **Read Uncommitted**:
        - Allows a transaction to read uncommitted changes made by other transactions. Highest concurrency but least strict in data consistency.

    - **Read Committed**:
        - A transaction can only read committed changes made by other transactions. Provides higher data consistency compared to "Read Uncommitted".

    - **Repeatable Read**:
        - Guarantees a consistent snapshot of the data, even if other transactions are modifying it. Prevents "phantom reads".

    - **Serializable**:
        - Strictest isolation level. Ensures a consistent snapshot of the data and prevents anomalies. Lower concurrency.

    - **Default Isolation Level**:
        - Determined by the database management system being used.

4. **readOnly**: Indicates or hints Transaction Manager that the method only accesses the data and doesn't modify it, allowing for optimization.

5. **timeout**: Transaction will roll back after the specified duration of time.

6. **rollBackFor**: Specifies which exception types should trigger a rollback of the transaction. If an exception raised is not specified, no rollback occurs.

### Other Annotations used for Transaction Management in Spring Boot

1. **@EnableTransactionManagement**
2. **@TransactionManagementConfigurer**
3. **@TransactionalEventListener**

---
