package tn.biat.biat.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;



@Service
@Slf4j
public class AnalyseService {

    //public static String DIRECTORY =  Paths.get("").toAbsolutePath()+ File.separator + "target" + File.separator + "static" + File.separator + "files" + File.separator;
    public static String DIRECTORY =  "C:\\Users\\onske\\Desktop\\biat_backend\\target\\static\\files\\";

    public String extractNumeroCompteFromPdf() { //makhdoum b java equivalent to python
        String filePath = "C:\\Users\\onske\\Desktop\\biat_backend\\target\\static\\files\\Extrait_de_compte.pdf";
        String nc = "";
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper textStripper = new PDFTextStripper();
            String text = textStripper.getText(document);

            // Extract the "Numéro de compte" using regex
            Pattern pattern = Pattern.compile("Numéro de compte:\\s*(\\w+)");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                String numero_compte = matcher.group(1);
                nc = numero_compte;
                System.out.println("Numéro de compte trouvé: " + nc);

            } else {
                System.out.println("Numéro de compte non trouvé.");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nc;
    }

    public String extractSoldeFinValuesFromPdf() { //makhdoum b java equivalent a python
        String filePath = "C:\\Users\\onske\\Desktop\\biat_backend\\target\\static\\files\\Extrait_de_compte.pdf";
        List<String> soldeFinValues = new ArrayList<>();
        String result = "";
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper textStripper = new PDFTextStripper();

            for (int pageNumber = 0; pageNumber < document.getNumberOfPages(); pageNumber++) {
                textStripper.setStartPage(pageNumber + 1);
                textStripper.setEndPage(pageNumber + 1);
                String text = textStripper.getText(document);

                // Find the line containing "Solde fin" and extract the value
                Pattern pattern = Pattern.compile("Solde fin au \\d{2} [A-Z]{3} \\d{2} à \\d{2}:\\d{2} (-?\\d[\\d ,]*)");
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {
                    String soldeFin = matcher.group(1);
                    soldeFinValues.add(soldeFin);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        result = soldeFinValues.get(0);
        System.out.println("Solde fin: " + result);
        return result;
    }


    public List<String> extractLinesWithReferenceFromPdf() { // execution script
        List<String> outputLines = new ArrayList<>();

        try {
            String pythonScriptPath = "src/main/python/scriptPdfR.py";

            // Build the command to execute the Python script
            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath);
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output from the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                outputLines.add(line);
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Python script executed successfully.");
            } else {
                System.out.println("Error executing Python script. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ref: " + outputLines);
        List<String> r = outputLines;
        r = extractStringsStartingWithNumber(outputLines);
        return r;
    }

    public static List<String> extractStringsStartingWithNumber(List<String> inputStrings) {
        List<String> result = new ArrayList<>();

        // Regular expression pattern to match strings starting with a number
        String pattern = "^[0-9].*";

        for (String inputString : inputStrings) {
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(inputString);
            if (matcher.find()) {
                result.add(inputString);
            }
        }

        return result;
    }


    public String extractNumeroCompteFromImg() {
        List<String> outputLines = new ArrayList<>();
        String reference = "";

        try {
            String pythonScriptPath = "src/main/python/scriptImgNc.py";

            // Build the command to execute the Python script
            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath);
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output from the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                outputLines.add(line);
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Python script executed successfully.");

                // Extract the reference from the output lines
                String referencePrefix = "um�ro de comple:";
                for (String outputLine : outputLines) {
                    if (outputLine.startsWith(referencePrefix)) {
                        reference = outputLine.substring(referencePrefix.length()).trim();
                        break;
                    }
                }
            } else {
                System.out.println("Error executing Python script. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return reference;
    }

    public String extractSoldeFinValuesFromImg() {
        String soldeFinValue = "";

        try {
            String pythonScriptPath = "src/main/python/scriptImgSF.py";

            // Build the command to execute the Python script
            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath);
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output from the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Solde fin:")) {
                    soldeFinValue = line.substring("Solde fin:".length()).trim();
                    break;
                }
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Python script executed successfully.");
            } else {
                System.out.println("Error executing Python script. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return soldeFinValue;
    }

   public List<String> extractLinesWithReferenceFromImg() { // execution script
        List<String> outputLines = new ArrayList<>();

        try {
            String pythonScriptPath = "src/main/python/scriptImgR.py";

            // Build the command to execute the Python script
            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath);
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output from the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                outputLines.add(line);
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Python script executed successfully.");
            } else {
                System.out.println("Error executing Python script. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
       System.out.println(outputLines);
       return outputLines;
    }



}




