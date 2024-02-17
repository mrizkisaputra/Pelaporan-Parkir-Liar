-- password: admin
-- username: admin
insert into s_users(id, account_non_expired, account_non_locked, active, password, username)
values ('Wrpdzs2iCbmR1JzFBY7T', true, true, true, '$2a$12$oF.cMRscelbCDNHz2JDRS.R3H7wAG9AWkcxxS3aXAzlhwkYc5KKAO', 'admin');

insert into s_users_roles(id_user, id_role)
values ('Wrpdzs2iCbmR1JzFBY7T', 'NMD99UoP3alkKUU1eRMY');