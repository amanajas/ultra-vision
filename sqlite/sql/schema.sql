CREATE TABLE membership_type ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	description          text NOT NULL    
 );

CREATE TABLE memberships ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	description          text NOT NULL    ,
	type_id                   integer NOT NULL ,
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
	category_id                   integer NOT NULL ,
	FOREIGN KEY ( category_id ) REFERENCES rental_category( id )  
 );

CREATE TABLE users ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	name                 text NOT NULL    ,
	member_id                   integer NOT NULL ,
	FOREIGN KEY ( member_id ) REFERENCES memberships( id )  
 );

CREATE TABLE cards ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	user_id              integer NOT NULL ,
	type_id              integer NOT NULL ,
	FOREIGN KEY ( type_id ) REFERENCES cards_type( id ) ,
	FOREIGN KEY ( user_id ) REFERENCES users( id )  
 );

CREATE TABLE loyalty ( 
	id                   integer NOT NULL  PRIMARY KEY autoincrement ,
	points               integer NOT NULL DEFAULT 0   ,
	user_id              integer NOT NULL ,
	FOREIGN KEY ( user_id ) REFERENCES users( id )  
 );

CREATE TABLE rental_status ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	created              datetime  DEFAULT CURRENT_TIMESTAMP   ,
	updated              datetime  DEFAULT CURRENT_TIMESTAMP   ,
	status               boolean NOT NULL    ,
	user_id              integer NOT NULL ,
	rental_id              integer NOT NULL ,
	FOREIGN KEY ( user_id ) REFERENCES users( id )  ,
	FOREIGN KEY ( rental_id ) REFERENCES rentals( id )  
 );

CREATE TABLE card_type ( 
	id                   integer NOT NULL  PRIMARY KEY  ,
	description          text NOT NULL
 );

INSERT INTO "card_type"("id","description") VALUES (1,'Credit');
INSERT INTO "card_type"("id","description") VALUES (2,'Debit');
INSERT INTO "membership_type"("id","description") VALUES (1,'ML');
INSERT INTO "membership_type"("id","description") VALUES (2,'VL');
INSERT INTO "membership_type"("id","description") VALUES (3,'TV');
INSERT INTO "membership_type"("id","description") VALUES (4,'PR');
INSERT INTO "rental_category"("id","description") VALUES (1,'ML');
INSERT INTO "rental_category"("id","description") VALUES (2,'VL');
INSERT INTO "rental_category"("id","description") VALUES (3,'TV');


