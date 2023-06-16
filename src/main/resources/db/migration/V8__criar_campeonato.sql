CREATE TABLE tb_campeonato (
                         id INTEGER DEFAULT nextval('tb_campeonato_seq') PRIMARY KEY,
                         ano integer,
                         nome character varying(255)

);
