CREATE TABLE du.meetings (
	id BIGINT auto_increment NOT NULL,
	place varchar(100) NOT NULL,
	description varchar(100) NULL,
	start_event TIMESTAMP NULL,
	end_event TIMESTAMP NULL,
	CONSTRAINT meetings_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
CREATE UNIQUE INDEX meetings_id_IDX USING BTREE ON du.meetings (id);
