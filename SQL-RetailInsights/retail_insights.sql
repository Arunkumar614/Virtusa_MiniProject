CREATE DATABASE retail_db;
USE retail_db;

CREATE TABLE Categories (
    category_id INT PRIMARY KEY,
    category_name VARCHAR(50)
);

CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100),
    category_id INT,
    expiry_date DATE,
    stock_count INT,
    price DECIMAL(10,2),
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);

CREATE TABLE SalesTransactions (
    sale_id INT PRIMARY KEY,
    product_id INT,
    quantity INT,
    sale_date DATE,
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

INSERT INTO Categories VALUES
(1, 'Dairy'),
(2, 'Snacks'),
(3, 'Beverages');

INSERT INTO Products VALUES
(1, 'Milk', 1, '2026-04-25', 100, 50),
(2, 'Cheese', 1, '2026-05-10', 40, 120),
(3, 'Chips', 2, '2026-06-01', 200, 20),
(4, 'Juice', 3, '2026-04-23', 60, 30),
(5, 'Butter', 1, '2026-04-24', 80, 70);

INSERT INTO SalesTransactions VALUES
(1, 1, 10, '2026-04-01'),
(2, 3, 5, '2026-03-15'),
(3, 3, 15, '2026-04-10'),
(4, 1, 20, '2026-04-15');

-- Expiring Soon Products
SELECT product_name, expiry_date, stock_count
FROM Products
WHERE expiry_date <= DATE_ADD(CURDATE(), INTERVAL 7 DAY)
AND stock_count > 50;

-- Dead Stock
SELECT p.product_name
FROM Products p
LEFT JOIN SalesTransactions s
ON p.product_id = s.product_id
AND s.sale_date >= DATE_SUB(CURDATE(), INTERVAL 60 DAY)
WHERE s.product_id IS NULL;

-- Revenue Contribution
SELECT c.category_name,
SUM(p.price * s.quantity) AS total_revenue
FROM SalesTransactions s
JOIN Products p ON s.product_id = p.product_id
JOIN Categories c ON p.category_id = c.category_id
WHERE MONTH(s.sale_date) = MONTH(CURDATE())
AND YEAR(s.sale_date) = YEAR(CURDATE())
GROUP BY c.category_name
ORDER BY total_revenue DESC;
