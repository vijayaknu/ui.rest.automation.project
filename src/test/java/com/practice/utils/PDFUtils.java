package com.practice.utils;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFUtils {

	public static void main(String[] args) throws InvalidPasswordException, IOException {
	      File file = new File("C:\\Users\\Narasimhamurthy.nl\\Documents\\TestPDF.pdf");
	      PDDocument document = PDDocument.load(file);
	      PDFTextStripper pdfStripper = new PDFTextStripper();
	      String text = pdfStripper.getText(document);
	      System.out.println(text);
	      document.close();
	}
}
