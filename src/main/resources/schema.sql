DROP TABLE IF EXISTS ECOMP_PROD_CATEGORY;
DROP TABLE IF EXISTS ECOMP_PROD_SUB_CATEGORY;
DROP TABLE IF EXISTS ECOMP_TAG;
DROP TABLE IF EXISTS ECOMP_PRODUCT_TAG;
DROP TABLE IF EXISTS ECOMP_PRODUCT;
DROP TABLE IF EXISTS ECOMP_PRODUCT_CATEGORY;
DROP TABLE IF EXISTS ECOMP_PRODUCT_SUB_CATEGORY;


create table ECOMP_PROD_CATEGORY (
CATEGORY_ID  integer not null,
CATEGORY_NM varchar(255) not null,
DEFUNCT_F varchar(1) not null,
primary key (CATEGORY_ID)
);


create table ECOMP_PROD_SUB_CATEGORY (
SUB_CATEGORY_ID integer not null,
SUB_CATEGORY_NM varchar(255) not null,
CATEGORY_ID  integer not null, 
DEFUNCT_F varchar(1) not null,
primary key (SUB_CATEGORY_ID),
foreign key (CATEGORY_ID) references ECOMP_PROD_CATEGORY(CATEGORY_ID)
);

create table ECOMP_PRODUCT (
PRODUCT_ID integer not null,
PRODUCT_NM varchar2(255) not null,
primary key (PRODUCT_ID)
);


create table ECOMP_TAG (
TAG_ID integer not null,
TAG_NM varchar2(255) not null,
primary key (TAG_ID)
);

create table ECOMP_PRODUCT_TAG (
PRODUCT_ID integer not null,
TAG_ID integer not null,
primary key (PRODUCT_ID,TAG_ID),
foreign key (PRODUCT_ID) references ECOMP_PRODUCT(PRODUCT_ID),
foreign key (TAG_ID) references ECOMP_TAG(TAG_ID)
);


create table ECOMP_PRODUCT_CATEGORY (
CATEGORY_ID integer not null,
PRODUCT_ID integer not null,
primary key (PRODUCT_ID, CATEGORY_ID),
foreign key (PRODUCT_ID) references ECOMP_PRODUCT(PRODUCT_ID),
foreign key (CATEGORY_ID) references ECOMP_PROD_CATEGORY(CATEGORY_ID)
);

create table ECOMP_PRODUCT_SUB_CATEGORY (
PRODUCT_ID integer not null,
SUB_CATEGORY_ID integer not null,
primary key (PRODUCT_ID, SUB_CATEGORY_ID),
foreign key (PRODUCT_ID) references ECOMP_PRODUCT(PRODUCT_ID),
foreign key (SUB_CATEGORY_ID) references ECOMP_PROD_SUB_CATEGORY(SUB_CATEGORY_ID)
);

