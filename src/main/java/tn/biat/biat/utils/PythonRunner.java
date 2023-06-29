package tn.biat.biat.utils;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class PythonRunner {
    public static void executePythonCode(String pythonCode) {
        try (PythonInterpreter pyInterp = new PythonInterpreter()) {
            pyInterp.exec(pythonCode);
        }
    }

    public static PyObject executePythonFunction(String functionName, PyObject... args) {
        try (PythonInterpreter pyInterp = new PythonInterpreter()) {
            pyInterp.execfile("src/main/python/scriptPdfR.py");
            PyObject pyObj = pyInterp.get(functionName);
            return pyObj.__call__(args);
        }
    }
}
