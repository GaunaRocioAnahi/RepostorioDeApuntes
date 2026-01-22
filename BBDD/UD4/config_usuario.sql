drop user if exists 'user'@'localhost';

create user if not exists 'user'@'localhost' identified by '1234';


grant all privileges on techcorp_db.* to 'user'@'localhost';


grant all privileges on EJERCICIO42.* to 'user'@'localhost';


grant all privileges on basketball_db.* to 'user'@'localhost';

grant all privileges on nevadashopping.* to 'user'@'localhost';

grant all privileges on Gobierno.* to 'user'@'localhost';



grant all privileges on cine_db.* to 'user'@'localhost';

grant all privileges on semana_santa.* to 'user'@'localhost';

grant all privileges on andalucia_db.* to 'user'@'localhost';
