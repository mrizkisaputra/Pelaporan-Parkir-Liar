CREATE TABLE s_roles
(
    id        character varying(255) NOT NULL,
    authority character varying(255) NOT NULL,
    CONSTRAINT s_roles_authority_check CHECK (((authority)::text = ANY ((ARRAY['USER_PELAPOR':: character varying, 'USER_PENGAWAS':: character varying])::text[])
) )
);

CREATE TABLE s_users
(
    id                  character varying(255) NOT NULL,
    account_non_expired boolean,
    account_non_locked  boolean,
    active              boolean,
    password            character varying(255),
    username            character varying(255) NOT NULL
);

CREATE TABLE s_users_roles
(
    id_user character varying(255) NOT NULL,
    id_role character varying(255) NOT NULL
);

CREATE TABLE report_parking
(
    id          character varying(255) NOT NULL,
    description character varying(255),
    latitude    character varying(255),
    longitude   character varying(255),
    photo_url   character varying(255) NOT NULL,
    plat_number character varying(255) NOT NULL
);

CREATE TABLE users_report_parking
(
    id_report_parking character varying(255) NOT NULL,
    id_user           character varying(255) NOT NULL
);


ALTER TABLE ONLY s_roles
    ADD CONSTRAINT s_roles_pkey PRIMARY KEY (id);

ALTER TABLE ONLY s_users
    ADD CONSTRAINT s_users_pkey PRIMARY KEY (id);

ALTER TABLE ONLY s_users_roles
    ADD CONSTRAINT s_users_roles_pkey PRIMARY KEY (id_user, id_role);

ALTER TABLE ONLY users_report_parking
    ADD CONSTRAINT users_report_parking_pkey PRIMARY KEY (id_report_parking, id_user);

ALTER TABLE ONLY s_users
    ADD CONSTRAINT uk_g6w3g55j7mm7jfji66cc4w16q UNIQUE (username);

ALTER TABLE ONLY s_roles
    ADD CONSTRAINT uk_oek4y6t66880yeypk4scq4tfn UNIQUE (authority);

ALTER TABLE ONLY report_parking
    ADD CONSTRAINT report_parking_pkey PRIMARY KEY (id);

ALTER TABLE ONLY report_parking
    ADD CONSTRAINT uk_7kcymyj06j7obaxqycdqrh4st UNIQUE (photo_url);

ALTER TABLE ONLY report_parking
    ADD CONSTRAINT uk_8o2g8fu7ef8rauii9vb6an4y9 UNIQUE (plat_number);

ALTER TABLE ONLY s_users_roles
    ADD CONSTRAINT fkoagdmqoi90xc2rxkn9lr3rggi FOREIGN KEY (id_user) REFERENCES s_users(id);

ALTER TABLE ONLY s_users_roles
    ADD CONSTRAINT fkq9y2ug56h2rxe51psk7x08u6r FOREIGN KEY (id_role) REFERENCES s_roles(id);

ALTER TABLE ONLY users_report_parking
    ADD CONSTRAINT fkbngudhnf9w9cyku73w004joxn FOREIGN KEY (id_user) REFERENCES s_users(id);

ALTER TABLE ONLY users_report_parking
    ADD CONSTRAINT fkd81qfvcvnhl7q5bm05ct8xyyb FOREIGN KEY (id_report_parking) REFERENCES report_parking(id);



