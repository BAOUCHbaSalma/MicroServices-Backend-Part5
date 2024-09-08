CREATE TABLE person (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        username VARCHAR(100) NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        email VARCHAR(100) NOT NULL,
                        role ENUM('ADMIN', 'CUSTOMER') NOT NULL,
                        dtype VARCHAR(31) NOT NULL
);