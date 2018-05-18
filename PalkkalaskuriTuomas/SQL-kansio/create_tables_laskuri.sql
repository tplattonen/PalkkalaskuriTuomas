CREATE TABLE laskuri(
palkkaid int auto_increment not null,
nimi varchar(50),
brutto decimal(18,6),
netto decimal(18,6),
primary key (palkkaid)
)engine=innoDB;