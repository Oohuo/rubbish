DELETE FROM zanghua.`lajihuamax` 
WHERE id IN 
(SELECT id FROM (SELECT id FROM zanghua.`lajihuamax`  GROUP BY msg HAVING COUNT(*) > 1)e);

DELETE FROM zanghua.`lajihuamin` 
WHERE id IN 
(SELECT id FROM (SELECT id FROM zanghua.`lajihuamin`  GROUP BY msg HAVING COUNT(*) > 1)e);

ALTER TABLE zanghua.`lajihuamax` ADD id INT(11) PRIMARY KEY AUTO_INCREMENT FIRST;

ALTER TABLE zanghua.`lajihuamin` ADD id INT(11) PRIMARY KEY AUTO_INCREMENT FIRST;

DELETE FROM zanghua.`lajihuamax` WHERE id >=691;

