create table directory_metadata
(
    id             int unsigned auto_increment
        primary key,
    user_id        int unsigned null,
    directory_name varchar(255) null,
    pid            int unsigned null,
    status         int          null,
    create_time    datetime     null,
    update_time    datetime     null
);

create index directory_info_directory_name_index
    on directory_info (directory_name);

create index directory_info_pid_index
    on directory_info (pid);

create index directory_info_update_time_index
    on directory_info (update_time);

create index directory_info_user_id_index
    on directory_info (user_id);


