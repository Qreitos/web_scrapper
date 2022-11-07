create table items
(
    item_id     bigint not null auto_increment,
    title       varchar(255),
    description longtext,
    price       varchar(255),
    primary key (item_id)
) engine = MyISAM