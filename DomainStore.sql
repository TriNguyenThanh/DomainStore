CREATE DATABASE DOMAINSTORE;
USE DOMAINSTORE;

CREATE TABLE Customer (
    id CHAR(10) PRIMARY KEY NOT NULL,
    name NVARCHAR(50) NOT NULL,
    birthday DATE NOT NULL,
    personal_id CHAR(12) NOT NULL,
    address NVARCHAR(50) NOT NULL,
    email CHAR(30) NOT NULL,
    phone CHAR(12) NOT NULL,
    password CHAR(16) NOT NULL,
    role ENUM('user', 'admin')  DEFAULT 'user'
);
INSERT INTO Customer (id, name, birthday, personal_id, address, email, phone, password, role)
VALUES 
('KH001', 'Nguyễn Thành Trí', '2000-05-07', '082205013763', 'Hà Nội', 'nguyenthanhtri0705@gmail.com', '0912345678', 'pass07052000', 'admin'),
('KH002', 'Âu Dương Tấn', '1998-12-14', '082265284758', 'Tp. Hồ Chí Minh', 'auduongtan1412@gmail.com', '0987654321', 'pass14121998', 'admin'),
('KH003', 'Lê Nguyễn Anh Dự', '2002-06-22', '082274651836', 'Đà Nẵng', 'lenguyenanhdu2206@gmail.com', '0909090909', 'pass22062002', 'admin'),
('KH004', 'Trần Thanh Thúy Vy', '2001-12-12', '082346587634', 'Tiền Giang', 'tranthanhthuyvy1212@gmail.com', '0965645284', 'pass12122001', 'user'),
('KH005', 'Trịnh Lê Phương Tuấn', '1997-03-03', '082265718564', 'Bến Tre', 'ttpt1997@gmail.com', '0327876533', 'pass03031997', 'user');

CREATE TABLE TopLevelDomain (
    TLD_text CHAR(10) PRIMARY KEY NOT NULL,
    price INT UNSIGNED NOT NULL
);
INSERT INTO TopLevelDomain (TLD_text, price)
VALUES 
('.com', 299000),
('.net', 39000),
('.site', 39000),
('.xyz', 49000),
('.info', 179000),
('.vn', 449000),
('.io.vn', 49000);

CREATE TABLE Domain (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    MD_text CHAR(50) NOT NULL,
    TLD_text CHAR(10) NOT NULL,
    domain_status ENUM('available','working', 'outOfDate') DEFAULT 'available',
    domain_date DATE,
    
    FOREIGN KEY (TLD_text) REFERENCES TopLevelDomain(TLD_text)    
);
INSERT INTO Domain (MD_text, TLD_text, domain_status, domain_date)
VALUES 
('example', '.com', 'working', '2027-03-02'),
('mydomain', '.vn', 'working', '2026-03-02'),
('tailieujava', '.site', 'working', '2026-01-01'),
('khotailieu', '.net', 'working', '2026-05-01'),
('website', '.site', 'working', '2025-05-01'),
('baitapjava', '.io.vn', 'available', null);

CREATE TABLE Cart (
    cus_id CHAR(10) NOT NULL,
    domain_id INT NOT NULL,
    domain_years INT NOT NULL,
    FOREIGN KEY (cus_id) REFERENCES Customer(id),
    FOREIGN KEY (domain_id) REFERENCES Domain(id),
    
    PRIMARY KEY(cus_id, domain_id)
); 
INSERT INTO Cart (cus_id, domain_id, domain_years)
VALUES
('KH004', 6, 2);

CREATE TABLE Transactions (
    id CHAR(10) PRIMARY KEY NOT NULL,
    cus_id CHAR(10) NOT NULL,
    transaction_date DATE NOT NULL,
    FOREIGN KEY (cus_id) REFERENCES Customer(id)
);
INSERT INTO Transactions (id, cus_id, transaction_date)
VALUES 
('HD001', 'KH001', '2025-03-02'),
('HD002', 'KH002', '2025-01-01'),
('HD003', 'KH003', '2024-05-01');

CREATE TABLE Transactions_info (
    transactions_id CHAR(10) NOT NULL,
    domain_id INT NOT NULL,
    domain_years INT NOT NULL,
    price INT UNSIGNED NOT NULL,
    
    FOREIGN KEY (transactions_id) REFERENCES Transactions(id),
    FOREIGN KEY (Domain_id) REFERENCES Domain(id),
    PRIMARY KEY(Domain_id, transactions_id)
);
INSERT INTO Transactions_info (Transactions_id, Domain_id, Domain_years, price)
VALUES 
('HD001', 1, 2, 598000),
('HD001', 2, 1, 449000),
('HD002', 3, 1, 39000),
('HD003', 4, 2, 78000),
('HD003', 5, 1, 39000);

CREATE TABLE PaymentMethod (
    id INT AUTO_INCREMENT PRIMARY KEY,
    method ENUM('VNPay', 'MoMo', 'CreditCard', 'ZaloPay')
);
INSERT INTO PaymentMethod (method)
VALUES
('VNPay'),
('MoMo'),
('CreditCard'),
('ZaloPay');

CREATE TABLE PaymentHistory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    transaction_id CHAR(10) NOT NULL,
    payment_id CHAR(10) NOT NULL,
    payment_method INT,
    payment_status ENUM('completed', 'failed'),  
    payment_date DATE,
    
    FOREIGN KEY (transaction_id) REFERENCES Transactions(id),
    FOREIGN KEY (payment_method) REFERENCES PaymentMethod(id)
);

INSERT INTO PaymentHistory (transaction_id, payment_id, payment_method, payment_status, payment_date)
VALUES
('HD001', '68765486', 1, 'completed', '2025-03-02'),
('HD002', '65847353', 1, 'completed', '2025-01-01'),
('HD003', '94346326', 1, 'completed', '2024-05-01');