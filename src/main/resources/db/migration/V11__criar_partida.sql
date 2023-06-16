CREATE TABLE tb_partida (
                               id INTEGER DEFAULT nextval('tb_partida_seq') PRIMARY KEY,
                               data date,
                               campeonato_id Integer,
                                time_mandante_id Integer,
                                time_visitante_id Integer,
                                id_resultado Integer


);
