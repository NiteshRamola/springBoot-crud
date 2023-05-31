create table if not exists photo (
    id bigint AUTO_INCREMENT primary key,
    file_name varchar(500),
    content_type varchar(500),
    data BINARY VARYING
);