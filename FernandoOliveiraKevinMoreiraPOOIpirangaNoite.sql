create or replace procedure sp_get_metas_conta(loginUser in usuario.login%type, tabela out sys_refcursor)
as
begin
open tabela for
select c.*, m.* from meta m, conta c where m.num_conta=c.num_conta and c.login=loginUser and m.DT_TERM_META >= sysdate ;
end;

