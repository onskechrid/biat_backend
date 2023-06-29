import pdfplumber
import re

with pdfplumber.open('C:\\Users\\onske\\Desktop\\biat_backend\\target\\static\\files\\Extrait_de_compte.pdf') as pdf:
    solde_fin_values = []

    # Iterate over each page in the PDF
    for page in pdf.pages:
        # Extract the page text
        text = page.extract_text()

        # Find the line containing "Solde fin" and extract the value
        regex_solde_fin = r"Solde fin au \d{2} [A-Z]{3} \d{2} à \d{2}:\d{2} (-?\d[\d ,]*)"
        page_solde_fin = re.findall(regex_solde_fin, text)

        # Add the extracted solde fin values from the page to the overall list
        solde_fin_values.extend(page_solde_fin)

# Print the extracted solde fin values
if solde_fin_values:
    print("Solde fin values:")
    for solde_fin in solde_fin_values:
        print(solde_fin)
else:
    print("No Solde fin values found.")
