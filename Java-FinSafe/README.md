**FinSafe Transaction Validator (Java)**

**Overview**

This project is based on a digital wallet system called **FinSafe**.
The main goal is to avoid overdraft problems where users try to spend more than their balance.

I implemented a simple console-based application that checks every transaction before processing it and handles errors properly.

**Problem **

In real systems, users sometimes withdraw more money than they have.
So the system must:

* Check balance before every transaction
* Stop invalid transactions
* Keep track of recent activity

**What I implemented:**

### Account Class

* Created an `Account` class
* Used private variables:

  * balance
  * accountHolder

### Custom Exception

* Created `InsufficientFundsException`
* This is thrown when withdrawal amount is greater than balance

### Transaction Validation

* Method: `processTransaction(double amount)`
* If amount is negative → throws `IllegalArgumentException`
* If amount > balance → throws `InsufficientFundsException`
* Otherwise → transaction is successful


### Transaction History

* Used `ArrayList` to store last 5 transactions
* Created method `printMiniStatement()` to display them

## Features

* Deposit money
* Withdraw money with validation
* Prevent overdraft
* Show last 5 transactions
* Proper exception handling


**Output:**
Screenshots of the output are available in:
Output_Screenshots folder

## Conclusion

This project helped me understand how real financial systems validate transactions and handle errors.
It also improved my understanding of Java concepts like OOP, exceptions, and collections.

