SELECT 
    rcp.cpte,
    i.idbct,
    i.id24,
    substr(rcp.cpte,1,2) as codeagence,
    rcp.NOM,
    rcp.risk_brut,
    rcp.risk_net,
    rcp.garded,
    rcp.agios_res,
    rcp.prov_req,
    rcp.classe,
    rcp.motif,
    rcl.clasimp,
    rcl.clasgel,
    rcl.classub,
    rcl.clascon 
FROM 
    (SELECT * 
     FROM risk_cpte 
     WHERE TO_DATE(SUBSTR('31 DÉC. 23', 1, 2) || ' ' ||
                   CASE 
                       WHEN SUBSTR('31 DÉC. 23', 4, 4) = 'MARS' THEN '03'
                       WHEN SUBSTR('31 DÉC. 23', 4, 4) = 'JUIN' THEN '06'
                       WHEN SUBSTR('31 DÉC. 23', 4, 4) = 'SEPT' THEN '09'
                       WHEN SUBSTR('31 DÉC. 23', 4, 3) = 'DÉC' THEN '12'
                   END || ' ' ||
                   '20' || SUBSTR('31 DÉC. 23', -2),'DD MM RR') = TO_DATE('31/12/23', 'DD/MM/RR')
    ) rcp,
    risk_classe rcl,
    identite i 
WHERE 
    rcp.cpte = rcl.cpte 
    AND rcp.periode = rcl.periode 
    AND rcp.cpte = i.cpte 
    AND rownum <= 10;
