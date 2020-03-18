-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 18 mars 2020 à 18:17
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion_impots`
--

-- --------------------------------------------------------

--
-- Structure de la table `habitation`
--

DROP TABLE IF EXISTS `habitation`;
CREATE TABLE IF NOT EXISTS `habitation` (
  `champhabitation` varchar(31) NOT NULL,
  `code_habitation` bigint(20) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `proprietaire` varchar(255) DEFAULT NULL,
  `surface` double DEFAULT NULL,
  `nbrpiece` int(11) DEFAULT NULL,
  `piscine` bit(1) DEFAULT NULL,
  `nbremploye` int(11) DEFAULT NULL,
  PRIMARY KEY (`code_habitation`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `habitation`
--

INSERT INTO `habitation` (`champhabitation`, `code_habitation`, `adresse`, `proprietaire`, `surface`, `nbrpiece`, `piscine`, `nbremploye`) VALUES
('individuelle', 30, 'Dakar, Médina ', 'Massiré DIA', 1200, 1, b'0', NULL),
('individuelle', 31, 'Ouakam cité ASECNA', 'Abibatou DIOP', 200, 12, b'0', NULL),
('professionnelle', 34, 'Fadia Parcelles Assénies', 'Abdou Faye', 1, NULL, NULL, 11),
('professionnelle', 16, 'Dakar Rond point Parcelles', 'Oulimatou DIAGNE', 50, NULL, NULL, 500),
('individuelle', 14, 'Thiés Quartier médina fall', 'Mamadou GOUDIABY', 300, 4, b'0', NULL),
('professionnelle', 20, 'Saint-Louis goxumbathie villa 14', 'Moussa DIALLO', 800, NULL, NULL, 422);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(45),
(45);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `ref_prod` varchar(10) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  PRIMARY KEY (`ref_prod`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`ref_prod`, `designation`, `prix`, `quantite`) VALUES
('REF001', 'ORDINATEUR', 350000, 12),
('REF002', 'ECRAN', 75250, 20),
('REF003', 'SCANER', 55333, 32),
('REF004', 'CLAVIER', 433466, 15),
('REF005', 'IMPRIMANTE', 65543, 100),
('REF006', 'SOURIS', 1122, 100);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER'),
(3, 'ROLE_DECLARANT'),
(4, 'ROLE_INSPECTEUR');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`user_id`, `active`, `email`, `last_name`, `name`, `password`) VALUES
(3, 1, 'admin@test.com', 'admin', 'admin', '$2a$10$U0LR49roJCiTSwUROsdZIuPp3tweZ/MXAeeUxGfLdlXmaItI3ugOO'),
(41, 1, 'mdia@test.com', 'DIA', 'Massiré', '$2a$10$fsWoFaj/GyAb7PgqDx35mO.PJw7wdG60y71n.WPgxjvpZoh29Qsby');

-- --------------------------------------------------------

--
-- Structure de la table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(3, 1),
(41, 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
