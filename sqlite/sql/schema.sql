CREATE TABLE IF NOT EXISTS  card_types ( 
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	description TEXT NOT NULL    
 );

CREATE TABLE IF NOT EXISTS  membership_type ( 
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	description          text NOT NULL    
 );

CREATE TABLE IF NOT EXISTS  memberships ( 
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	description          text NOT NULL    ,
	type_id              integer NOT NULL    ,
	FOREIGN KEY ( type_id ) REFERENCES membership_type( id )  
 );

CREATE TABLE IF NOT EXISTS  rental_category ( 
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	description          text NOT NULL    
 );

CREATE TABLE IF NOT EXISTS  rentals ( 
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	title                text NOT NULL    ,
	created              INTEGER NOT NULL DEFAULT CURRENT_TIMESTAMP   ,
	category_id          integer NOT NULL    ,
	FOREIGN KEY ( category_id ) REFERENCES rental_category( id )  
 );

CREATE TABLE IF NOT EXISTS  users ( 
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	name                 text NOT NULL    ,
	member_id            integer NOT NULL    ,
	FOREIGN KEY ( member_id ) REFERENCES memberships( id )  
 );

CREATE TABLE IF NOT EXISTS  access ( 
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	password             text NOT NULL    ,
	user_id              integer NOT NULL    ,
	FOREIGN KEY ( user_id ) REFERENCES users( id )  
 );

CREATE TABLE IF NOT EXISTS  cards ( 
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	user_id              integer NOT NULL    ,
	type_id              integer NOT NULL    ,
        number               text NOT NULL       ,
        expiration              INTEGER NOT NULL    ,
	FOREIGN KEY ( user_id ) REFERENCES users( id ),
	FOREIGN KEY ( type_id ) REFERENCES card_types( id ) 
 );

CREATE TABLE IF NOT EXISTS  loyalty ( 
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	points               integer NOT NULL DEFAULT 0   ,
	user_id              integer NOT NULL    ,
	FOREIGN KEY ( user_id ) REFERENCES users( id )  
 );

CREATE TABLE IF NOT EXISTS  rental_status ( 
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	created              INTEGER  DEFAULT CURRENT_TIMESTAMP   ,
	updated              INTEGER  DEFAULT CURRENT_TIMESTAMP   ,
	status               INTEGER NOT NULL    ,
	user_id              integer NOT NULL    ,
	rental_id            integer NOT NULL    ,
	FOREIGN KEY ( user_id ) REFERENCES users( id )  ,
	FOREIGN KEY ( rental_id ) REFERENCES rentals( id )  
 );

INSERT INTO card_types( id, description ) VALUES ( 1, 'Credit' ); 
INSERT INTO card_types( id, description ) VALUES ( 2, 'Debit' ); 
INSERT INTO membership_type( id, description ) VALUES ( 1, 'ML' ); 
INSERT INTO membership_type( id, description ) VALUES ( 2, 'VL' ); 
INSERT INTO membership_type( id, description ) VALUES ( 3, 'TV' ); 
INSERT INTO membership_type( id, description ) VALUES ( 4, 'PR' ); 
INSERT INTO memberships( id, description, type_id ) VALUES ( 1, 'Music Lovers', 1 ); 
INSERT INTO memberships( id, description, type_id ) VALUES ( 2, 'Movie', 2 ); 
INSERT INTO memberships( id, description, type_id ) VALUES ( 3, 'Boxset', 3 ); 
INSERT INTO memberships( id, description, type_id ) VALUES ( 4, 'Premium', 4 ); 
INSERT INTO rental_category( id, description ) VALUES ( 1, 'ML' ); 
INSERT INTO rental_category( id, description ) VALUES ( 2, 'VL' ); 
INSERT INTO rental_category( id, description ) VALUES ( 3, 'TV' ); 
INSERT INTO users( id, name, member_id ) VALUES ( 1, 'james', 4 );
INSERT INTO access( id, password, user_id) VALUES ( 1, '12345', 1);
INSERT INTO loyalty ( id, points, user_id) VALUES ( 1, 0, 1);
INSERT INTO rentals ( id, title, category_id, created) VALUES ( 1, 'Matrix Revolution', 1, 1588856353);
INSERT INTO rentals ( id, title, category_id, created) VALUES ( 2, 'Matrix', 2, 1588856353);
INSERT INTO rentals ( id, title, category_id, created) VALUES ( 3, 'Back to the future', 3, 1588856353);
INSERT INTO rental_status( id, status, user_id, rental_id, created, updated) VALUES ( 1, 1, 1, 2, 1588856353, 1588856353);
INSERT INTO rental_status( id, status, user_id, rental_id, created, updated) VALUES ( 2, 0, 1, 1, 1588856353, 1588856353);