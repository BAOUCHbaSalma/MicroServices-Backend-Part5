CREATE TABLE projet (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        description TEXT,
                        dateCreation DATE,
                        dateFin DATE,
                        budget INT
);
