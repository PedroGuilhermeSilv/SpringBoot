CREATE TABLE tb_time (
                            id INTEGER DEFAULT nextval('tb_time_seq') PRIMARY KEY,
                            nome character varying(255),
                            estadio_id integer
);
