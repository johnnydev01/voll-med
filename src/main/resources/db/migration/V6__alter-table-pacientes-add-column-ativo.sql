alter table pacientes add ativo tinyint(20);
update pacientes set ativo = 1;