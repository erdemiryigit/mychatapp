create table if not exists 'user' (
    id integer primary key autoincrement,
    userId varchar(50) not null,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    email varchar(50) not null,
    encryptedPassword varchar(128) not null,
    emailVerificationToken varchar(128),
    emailVerificationStatus boolean default false
);