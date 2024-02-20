queryyyy3  ::: select * from (select periode,eng_global from tb_fiche_final where unite = 'B5' and periode like '31/12%' or periode like '%/01/%' order by periode DESC) where ROWNUM <= 4 ;
java.sql.SQLSyntaxErrorException: ORA-00911: caractère non valide
