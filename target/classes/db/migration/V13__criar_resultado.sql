CREATE TABLE tb_resultado (
                            id INTEGER DEFAULT nextval('tb_resultado_seq') PRIMARY KEY,
                            id_partida Integer,
                            num_gols_mandante Integer,
                            num_gols_visitante Integer


);
