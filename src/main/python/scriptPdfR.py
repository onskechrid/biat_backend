import pdfplumber
import re

with pdfplumber.open('C:\\Users\\onske\\Desktop\\biat_backend\\target\\static\\files\\Extrait_de_compte.pdf') as pdf:
    lines_with_reference = []

    # Iterate over each page in the PDF
    for page in pdf.pages:
        # Extract the page text
        text = page.extract_text()

        # Find all lines containing "Référence" and starting with "PD"
        regex_lines = r"((?:.*Référence.*\n)?.*PD\S+(?:.*\n)?)"
        page_lines = re.findall(regex_lines, text)

        # Add the extracted lines from the page to the overall list
        lines_with_reference.extend(page_lines)

# Print the extracted lines with "Référence" starting with "PD"
if lines_with_reference:
    print("Lines with Référence starting with 'PD':")
    for line in lines_with_reference:
        print(line)
else:
    print("No lines found with Référence starting with 'PD'.")
