-- PUBLIC.AR_CART definition

-- Drop table

-- DROP TABLE PUBLIC.AR_CART;

CREATE TABLE IF NOT exists PUBLIC.AR_CART (
	ID BIGINT NOT NULL,
	CREATED_DATE TIMESTAMP,
	MODIFIED_DATE TIMESTAMP,
	CART_TOTAL INTEGER,
	STATUS VARCHAR(255),
	CONSTRAINT CONSTRAINT_F PRIMARY KEY (ID)
);
CREATE UNIQUE INDEX IF NOT exists PRIMARY_KEY_F ON PUBLIC.AR_CART (ID);



-- PUBLIC.AR_USER definition

-- Drop table

-- DROP TABLE PUBLIC.AR_USER;

CREATE TABLE IF NOT exists PUBLIC.AR_USER (
	ID BIGINT NOT NULL,
	CREATED_DATE TIMESTAMP,
	MODIFIED_DATE TIMESTAMP,
	EMAIL VARCHAR(255),
	USER_TYPE VARCHAR(255),
	CART_ID BIGINT,
	USER_TYPE VARCHAR(100),
	CONSTRAINT CONSTRAINT_FF PRIMARY KEY (ID),
	CONSTRAINT FK6UMLDYYOEBLRHKU4V6HH6W250 FOREIGN KEY (CART_ID) REFERENCES PUBLIC.AR_CART(ID) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX IF NOT exists FK6UMLDYYOEBLRHKU4V6HH6W250_INDEX_F ON PUBLIC.AR_USER (CART_ID);
CREATE UNIQUE  INDEX IF NOT exists PRIMARY_KEY_FF ON PUBLIC.AR_USER (ID);

alter table PUBLIC.AR_USER add column if not exists UNAME VARCHAR(255);

-- PUBLIC.AR_ORDER definition

-- Drop table

-- DROP TABLE PUBLIC.AR_ORDER;

CREATE TABLE IF NOT exists PUBLIC.AR_ORDER (
	ID BIGINT NOT NULL,
	CREATED_DATE TIMESTAMP,
	MODIFIED_DATE TIMESTAMP,
	STATUS INTEGER,
	USER_ID BIGINT NOT NULL,
	ADDRESS VARCHAR(200),
	CONSTRAINT CONSTRAINT_F8 PRIMARY KEY (ID),
	CONSTRAINT FK9NPRRW8JR58TQGRYLKKGX4URS FOREIGN KEY (USER_ID) REFERENCES PUBLIC.AR_USER(ID) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX IF NOT exists FK9NPRRW8JR58TQGRYLKKGX4URS_INDEX_F ON PUBLIC.AR_ORDER (USER_ID);
CREATE UNIQUE  INDEX IF NOT exists PRIMARY_KEY_F8 ON PUBLIC.AR_ORDER (ID);


-- PUBLIC.AR_PAINTING definition

-- Drop table

-- DROP TABLE PUBLIC.AR_PAINTING;

CREATE TABLE IF NOT exists PUBLIC.AR_PAINTING (
	ID BIGINT NOT NULL,
	CREATED_DATE TIMESTAMP,
	MODIFIED_DATE TIMESTAMP,
	TITLE VARCHAR(255),
	USER_ID BIGINT NOT NULL,
	CONSTRAINT CONSTRAINT_7 PRIMARY KEY (ID),
	CONSTRAINT FKNM6O66FBO0IDPSURDY2AI837C FOREIGN KEY (USER_ID) REFERENCES PUBLIC.AR_USER(ID) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX IF NOT exists FKNM6O66FBO0IDPSURDY2AI837C_INDEX_7 ON PUBLIC.AR_PAINTING (USER_ID);
CREATE UNIQUE INDEX IF NOT exists PRIMARY_KEY_7 ON PUBLIC.AR_PAINTING (ID);


-- PUBLIC.AR_CART_PAINTINGS definition

-- Drop table

-- DROP TABLE PUBLIC.AR_CART_PAINTINGS;

CREATE TABLE IF NOT exists PUBLIC.AR_CART_PAINTINGS (
	AR_CART_ID BIGINT NOT NULL,
	PAINTINGS_ID BIGINT NOT NULL,
	CONSTRAINT FK1KDSEQIAITBKBWJPGB2BCSHGY FOREIGN KEY (PAINTINGS_ID) REFERENCES PUBLIC.AR_PAINTING(ID) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK5JG8B13IODFG9DSAJBE1JX4KI FOREIGN KEY (AR_CART_ID) REFERENCES PUBLIC.AR_CART(ID) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX IF NOT exists FK5JG8B13IODFG9DSAJBE1JX4KI_INDEX_E ON PUBLIC.AR_CART_PAINTINGS (AR_CART_ID);
--CREATE UNIQUE  INDEX IF NOT exists UK_13Q6OD0GR44MK5M54DNLWHEUM_INDEX_E ON PUBLIC.AR_CART_PAINTINGS (PAINTINGS_ID);

-- auth schemas
create table if not EXISTS users(username varchar_ignorecase(50) not null primary key,password varchar_ignorecase(500) not null,enabled boolean not null);
create table if not exists authorities (username varchar_ignorecase(50) not null,authority varchar_ignorecase(50) not null,constraint fk_authorities_users foreign key(username) references users(username));

create unique index if not exists ix_auth_username on authorities (username,authority);

CREATE SEQUENCE IF NOT EXISTS HIBERNATE_SEQUENCE START with 101 
INCREMENT BY 1 
MAXVALUE 9223372036854775807; 
