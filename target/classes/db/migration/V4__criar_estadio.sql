CREATE TABLE tb_estadio (
                            id INTEGER DEFAULT nextval('tb_estadio_seq') PRIMARY KEY,
                            endereco character varying(255),
                            nome character varying(255)
);
