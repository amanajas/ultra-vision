CREATE TABLE card_types ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	description          text NOT NULL    
 );

CREATE TABLE membership_type ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	description          text NOT NULL    
 );

CREATE TABLE memberships ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	description          text NOT NULL    ,
	type_id              integer NOT NULL    ,
	FOREIGN KEY ( type_id ) REFERENCES membership_type( id )  
 );

CREATE TABLE rental_category ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	description          text NOT NULL    
 );

CREATE TABLE rentals ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	title                text NOT NULL    ,
	created              datetime NOT NULL DEFAULT CURRENT_TIMESTAMP   ,
	category_id          integer NOT NULL    ,
	FOREIGN KEY ( category_id ) REFERENCES rental_category( id )  
 );

CREATE TABLE users ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	name                 text NOT NULL    ,
	member_id            integer NOT NULL    ,
	FOREIGN KEY ( member_id ) REFERENCES memberships( id )  
 );

CREATE TABLE access ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	password             text NOT NULL    ,
	user_id              integer NOT NULL    ,
	FOREIGN KEY ( user_id ) REFERENCES users( id )  
 );

CREATE TABLE cards ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	user_id              integer NOT NULL    ,
	type_id              integer NOT NULL    ,
	FOREIGN KEY ( user_id ) REFERENCES users( id ),
	FOREIGN KEY ( type_id ) REFERENCES card_types( id ) 
 );

CREATE TABLE loyalty ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	points               integer NOT NULL DEFAULT 0   ,
	user_id              integer NOT NULL    ,
	FOREIGN KEY ( user_id ) REFERENCES users( id )  
 );

CREATE TABLE rental_status ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	created              datetime  DEFAULT CURRENT_TIMESTAMP   ,
	updated              datetime  DEFAULT CURRENT_TIMESTAMP   ,
	status               boolean NOT NULL    ,
	user_id              integer NOT NULL    ,
	rental_id            integer NOT NULL    ,
	FOREIGN KEY ( user_id ) REFERENCES users( id )  ,
	FOREIGN KEY ( rental_id ) REFERENCES rentals( id )  
 );

INSERT INTO card_type( id, description ) VALUES ( 1, 'Credit' ); 
INSERT INTO card_type( id, description ) VALUES ( 2, 'Debit' ); 
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
INSERT INTO users( id, name, member_id ) VALUES ( 1, 'admin', 4 );
INSERT INTO access( id, password, user_id) VALUES ( 1, '12345', 1);
INSERT INTO loyalty ( id, points, user_id) VALUES ( 1, 0, 1);