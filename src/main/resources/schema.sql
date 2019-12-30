create table parties (
    party_id                varchar(36),
    party_name              varchar(40),
    party_holding_date_time datetime,
    primary key (party_id)
);

create table members (
    member_id    varchar(36),
    party_id     varchar(36),
    member_name  varchar(40),
    payment_type varchar(40),
    member_type  varchar(40),
    primary key (member_id),
    foreign key (party_id) references parties (party_id)
);
