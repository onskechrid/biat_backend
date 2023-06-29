import re

text = '''Extrait de compte Edite le : 16 JUN 23
Numéro de compte: A220060610

Agence du compte: 102 AGENCE ALYSSA (A2)
TND
08110010022006061022
Catégorie compte: 1010 COMPTE CHEQUE EN TND
Adresse:
Date valeur Libellé opération Référence Date opération Montant
Solde départ au 31 MAR 23 228.185
01 APR 23 TVA sur Com 8918288261-202303 31 MAR 23 -3.990
01 APR 23 Frais de Tenue de Compte 8918288261 - 202303 31 MAR 23 -21,000
01 APR 23 Interets Debiteurs 8918288261-20230331 31 MAR 23 7.530
27 APR 23 Virement tunisie meme banque FT23117076670508\AN1 27 APR 23 1 000,000
REF : DE Mr BOURAOUI SAHBI *
27 APR 23 TVA sur Com CHG23117KCOGD\AN1 =. 27 APR 23 -0,380
REF :
27 APR 23 Com TVA Virement CHG23117KCOGD\AN1 =. 27 APR 23 -2.000
5294244
26 MAY 23 Com TVA Virement FT23146510071406\TN1 26 MAY 23 1.190
REF : MYBT211184364102
26 MAY 23 Virement tunisie meme banque FT23146510071406\TN1 26 MAY 23 -150.000
MYBT211184364102
Solde fin au 16 JUN 23 a 16:12 585,725
Solde disponible au 16 JUN 23 16:12 585,725

Sauf erreur ou omission de notre part

F F F B 3333'''

lines = text.split('\n')
table = []

header_index = lines.index('Date valeur Libellé opération Référence Date opération Montant')

for line in lines[header_index + 1:]:
    if line.strip():
        columns = re.split(r'\s+', line.strip())
        for i in columns:
            if i.startswith('FT') :  # Check the third last column
                text = ' '.join(columns)
                print(text)

