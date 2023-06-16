
CREATE TABLE tb_jogador (
                            id INTEGER DEFAULT nextval('tb_jogador_seq') PRIMARY KEY,
                            nome character varying(255),
                            altura real,
                            data_nascimento date,
                            time_id integer

);
