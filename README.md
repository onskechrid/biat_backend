queryyyy4  ::: select * from (select distinct(periode) from tb_fiche_final where unite = 'B5' and periode like '31/12%' or periode like '31/01/%' order by periode DESC) where ROWNUM <= 4
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by net.minidev.asm.DynamicClassLoader (file:/C:/Users/06159/.m2/repository/net/minidev/accessors-smart/2.4.8/accessors-smart-2.4.8.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int)
WARNING: Please consider reporting this to the maintainers of net.minidev.asm.DynamicClassLoader
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[{"PERIODE":{"nanos":0}},{"PERIODE":{"nanos":0}},{"PERIODE":{"nanos":0}},{"PERIODE":{"nanos":0}}]
