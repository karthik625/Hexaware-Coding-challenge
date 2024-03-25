create database insurance;
use insurance;
create table User(
userid int primary key,
username varchar(30),
Password varchar(30),
role varchar(30)
);

create table Client (
    clientId int primary key,
    clientName varchar(100) not null,
    contactInfo varchar(255) not null,
    policyId int,
    foreign key (policyId) references Policy(policyId)
);

create table Policy (
    policyId int primary key,
    policyName varchar(300),
    PolicyType varchar(300),
    coverageAmount Decimal(10,2)
);

create table Claim (
    claimId int primary key,
    claimNumber varchar(20) not null,
    dateFiled Date not null,
    claimAmount Decimal(10,2) not null,
    status varchar(20) not null,
    policyId int,
    clientId int,
    foreign key (policyId) references Policy(policyId),
    foreign key (clientId) references Client(clientId)
);

create table Payment (
    paymentId int primary key,
    paymentDate Date not null,
    paymentAmount Decimal(10,2) not null,
    clientId int,
    foreign key(clientId) references Client(clientId)
);
