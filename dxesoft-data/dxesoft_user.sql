#create user
CREATE USER 'dxeuser'@'localhost' IDENTIFIED BY 'dxeuser';

CREATE USER 'dxeuser'@'%' IDENTIFIED BY 'dxeuser';

GRANT ALL PRIVILEGES ON * . * TO 'dxeuser'@'localhost';

GRANT ALL PRIVILEGES ON * . * TO 'dxeuser'@'%';

