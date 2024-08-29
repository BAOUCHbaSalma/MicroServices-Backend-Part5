CREATE TABLE tache (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       description VARCHAR(255) NOT NULL,
                       date_creation DATE,
                       date_fin DATE,
                       status ENUM('A_FAIRE', 'EN_COURS', 'TERMINER') NOT NULL,
                       projet_id INT
);
