create table link
(
id                   serial
primary key,
link                 text not null,
level                int  not null,
"countsForeignLinks" int
)

create table site (
id                   serial primary key,
link                 text not null,
)

