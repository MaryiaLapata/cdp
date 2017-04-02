LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Minsk','Novaya',1,1),(2,'Minsk','Staraya',10,115),(3,'Minsk','Street1',111,10),(4,'Minsk','Street1',111,10),(5,'Minsk','Street1',111,10),(6,'Minsk','Street1',111,10),(7,'Minsk','Street1',111,10);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT INTO `group` VALUES (1,'Group1'),(2,'Group2');
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `group_permission` WRITE;
/*!40000 ALTER TABLE `group_permission` DISABLE KEYS */;
INSERT INTO `group_permission` VALUES (1,1,1),(2,2,1),(3,2,2);
/*!40000 ALTER TABLE `group_permission` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,'Permission1','000'),(2,'Permission2','111');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Martin','Michael','Martin.Machael@kronos.com',2,NULL),(2,'Holly','Ivan','Holly.Ivan@kronos.com',1,NULL),(3,'firstNameN','lastNameN','emailN@dot.com',1,NULL),(4,'firstNameN','lastNameN','emailN@dot.com',3,NULL),(5,'firstNameN','lastNameN','emailN@dot.com',6,'12345673');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `user_group` WRITE;
/*!40000 ALTER TABLE `user_group` DISABLE KEYS */;
INSERT INTO `user_group` VALUES (1,1,1),(2,2,1),(3,2,2);
/*!40000 ALTER TABLE `user_group` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `user_permission` WRITE;
/*!40000 ALTER TABLE `user_permission` DISABLE KEYS */;
INSERT INTO `user_permission` VALUES (1,1,1),(2,2,1),(3,2,2);
/*!40000 ALTER TABLE `user_permission` ENABLE KEYS */;
UNLOCK TABLES;