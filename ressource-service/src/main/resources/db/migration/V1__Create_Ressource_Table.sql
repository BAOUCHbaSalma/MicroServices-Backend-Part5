CREATE TABLE ressource (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           quantity INT NOT NULL,
                           picture VARCHAR(255),
                           info_fornisseur VARCHAR(255),
                           tache_id INT
);