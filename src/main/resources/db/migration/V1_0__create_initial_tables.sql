create table marca (
    id serial not null primary key,
    nome varchar(255)
);

create table modelo (
    id serial not null primary key,
    nome varchar(255),
    valor_fipe decimal(12,2),
    id_marca int,
    foreign key (id_marca) references marca (id)
);

create table carro (
    id serial not null primary key,
    data_cadastro timestamp,
    ano int,
    combustivel varchar (50),
    num_portas int,
    cor varchar (50),
    modelo_id int,
    foreign key (modelo_id) references modelo (id)
);