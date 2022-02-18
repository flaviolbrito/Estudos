create table TB_USUARIO(
    id BIGINT auto_increment primary key,
    nome VARCHAR(200),
    senha VARCHAR(255),
    data_criacao timestamp not null,
    data_ultima_atualizacao timestamp
)