-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               8.0.29 - MySQL Community Server - GPL
-- Операционная система:         Win64
-- HeidiSQL Версия:              12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Дамп структуры базы данных recipedb
CREATE DATABASE IF NOT EXISTS `recipedb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `recipedb`;

-- Дамп структуры для таблица recipedb.cart
CREATE TABLE IF NOT EXISTS `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `total_in_cents` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы recipedb.cart: ~0 rows (приблизительно)
DELETE FROM `cart`;
INSERT INTO `cart` (`id`, `total_in_cents`) VALUES
	(1, 150),
	(2, 33);

-- Дамп структуры для таблица recipedb.cart_item
CREATE TABLE IF NOT EXISTS `cart_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cart_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `recipe_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1uobyhgl1wvgt1jpccia8xxs3` (`cart_id`),
  KEY `FKjcyd5wv4igqnw413rgxbfu4nv` (`product_id`),
  KEY `FK_cart_item_recipe` (`recipe_id`),
  CONSTRAINT `FK1uobyhgl1wvgt1jpccia8xxs3` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`),
  CONSTRAINT `FK_cart_item_recipe` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`id`),
  CONSTRAINT `FKjcyd5wv4igqnw413rgxbfu4nv` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы recipedb.cart_item: ~0 rows (приблизительно)
DELETE FROM `cart_item`;
INSERT INTO `cart_item` (`id`, `cart_id`, `product_id`, `recipe_id`) VALUES
	(1, 1, 1, 1),
	(2, 1, 2, 1),
	(3, 2, 3, 1),
	(4, 2, 4, 1);

-- Дамп структуры для таблица recipedb.cart_recipe
CREATE TABLE IF NOT EXISTS `cart_recipe` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cart_id` int NOT NULL,
  `recipe_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы recipedb.cart_recipe: ~0 rows (приблизительно)
DELETE FROM `cart_recipe`;
INSERT INTO `cart_recipe` (`id`, `cart_id`, `recipe_id`) VALUES
	(1, 1, 1);

-- Дамп структуры для таблица recipedb.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price_in_cents` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы recipedb.product: ~0 rows (приблизительно)
DELETE FROM `product`;
INSERT INTO `product` (`id`, `name`, `price_in_cents`) VALUES
	(1, 'dish', 50),
	(2, 'fork', 100),
	(3, 'table', 30),
	(4, 'spoon', 3);

-- Дамп структуры для таблица recipedb.product_seq
CREATE TABLE IF NOT EXISTS `product_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы recipedb.product_seq: ~1 rows (приблизительно)
DELETE FROM `product_seq`;
INSERT INTO `product_seq` (`next_val`) VALUES
	(1);

-- Дамп структуры для таблица recipedb.recipe
CREATE TABLE IF NOT EXISTS `recipe` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `cart_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы recipedb.recipe: ~3 rows (приблизительно)
DELETE FROM `recipe`;
INSERT INTO `recipe` (`id`, `name`, `cart_id`) VALUES
	(1, 'set1', 0),
	(2, 'set2', 0),
	(3, 'set3', 0);

-- Дамп структуры для таблица recipedb.recipe_product
CREATE TABLE IF NOT EXISTS `recipe_product` (
  `id` int DEFAULT NULL,
  `recipe_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  KEY `FK935n2g21lw35urnpf7vwcyp0w` (`product_id`),
  KEY `FKb3poss884qc7j3wsvbq63aad3` (`recipe_id`),
  CONSTRAINT `FK935n2g21lw35urnpf7vwcyp0w` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKb3poss884qc7j3wsvbq63aad3` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы recipedb.recipe_product: ~0 rows (приблизительно)
DELETE FROM `recipe_product`;
INSERT INTO `recipe_product` (`id`, `recipe_id`, `product_id`) VALUES
	(NULL, 1, 1),
	(NULL, 1, 2);

-- Дамп структуры для таблица recipedb.recipe_seq
CREATE TABLE IF NOT EXISTS `recipe_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы recipedb.recipe_seq: ~1 rows (приблизительно)
DELETE FROM `recipe_seq`;
INSERT INTO `recipe_seq` (`next_val`) VALUES
	(1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
