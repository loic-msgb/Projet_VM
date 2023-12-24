-- Créer la base de données
CREATE DATABASE IF NOT EXISTS FLOP_DATABASE;
USE FLOP_DATABASE;

-- Créer la table order
CREATE TABLE IF NOT EXISTS `order` (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       activationFee INT DEFAULT 10,
                                       monthFee FLOAT DEFAULT 20.0,
                                       carbonFP FLOAT DEFAULT 300.0,
                                       projectId BIGINT,
                                       contactId BIGINT
);

-- Insérer quelques lignes de données
INSERT INTO `order` (activationFee, monthFee, carbonFP, projectId, contactId) VALUES
                                                                                  (15, 25.0, 350.0, 1, 101),
                                                                                  (12, 22.5, 310.0, 2, 102),
                                                                                  (8, 18.0, 280.0, 3, 103);
