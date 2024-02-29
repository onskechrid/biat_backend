TO_CHAR(
           TO_DATE(
               SUBSTR('31 DÉC. 23', 1, 2) || ' ' ||
               CASE 
                   WHEN SUBSTR('31 DÉC. 23', 4, 3) = 'JAN' THEN '01'
                   WHEN SUBSTR('31 DÉC. 23', 4, 3) = 'FÉV' THEN '02'
                   WHEN SUBSTR('31 DÉC. 23', 4, 3) = 'MAR' THEN '03'
                   WHEN SUBSTR('31 DÉC. 23', 4, 3) = 'AVR' THEN '04'
                   WHEN SUBSTR('31 DÉC. 23', 4, 3) = 'MAI' THEN '05'
                   WHEN SUBSTR('31 DÉC. 23', 4, 3) = 'JUN' THEN '06'
                   WHEN SUBSTR('31 DÉC. 23', 4, 3) = 'JUL' THEN '07'
                   WHEN SUBSTR('31 DÉC. 23', 4, 3) = 'AOÛ' THEN '08'
                   WHEN SUBSTR('31 DÉC. 23', 4, 3) = 'SEP' THEN '09'
                   WHEN SUBSTR('31 DÉC. 23', 4, 3) = 'OCT' THEN '10'
                   WHEN SUBSTR('31 DÉC. 23', 4, 3) = 'NOV' THEN '11'
                   WHEN SUBSTR('31 DÉC. 23', 4, 3) = 'DÉC' THEN '12'
               END || ' ' ||
               '20' || SUBSTR('31 DÉC. 23', -2),
               'DD MM RR'
           ),
           'DD/MM/RR'
       )
