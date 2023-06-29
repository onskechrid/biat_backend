import PyPDF2
import re

with open('C:\\Users\\onske\\Desktop\\biat_backend\\target\\static\\files\\Extrait_de_compte.pdf', 'rb') as file:
    reader = PyPDF2.PdfReader(file, strict=False)
    num_pages = len(reader.pages)

    text = ''
    for page in reader.pages:
        text += page.extract_text()

    # Extract the "Numéro de compte" using regex
    regex_numero_compte = r'Numéro de compte:\s*(\w+)'
    matches_numero_compte = re.search(regex_numero_compte, text)
    numero_compte = matches_numero_compte.group(1) if matches_numero_compte else None

    # Print the extracted information
    if numero_compte:
        print("Numéro de compte trouvé:", numero_compte)
    else:
        print("Numéro de compte non trouvé.")
