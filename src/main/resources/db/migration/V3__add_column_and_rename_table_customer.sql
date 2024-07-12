alter table customer
    add income decimal not null default 0;

alter table customer
    RENAME COLUMN firt_name TO first_name;