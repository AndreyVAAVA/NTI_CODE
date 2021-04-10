import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Total1Thread extends Thread {
    XSSFSheet sheet1;
    XSSFSheet sheet2;
    XSSFSheet sheet3;
    @Override
    public void run() {
        XSSFFormulaEvaluator formulaEvaluator =
                Main.workbook.getCreationHelper().createFormulaEvaluator();
        XSSFCell cell;
        for (int i = 1; i < 14; i++) {
            sheet1.createRow(i-1);
            cell = sheet1.getRow(i-1).createCell(0);
            cell.setCellFormula("'Group 1 Course ID 49185'!A" + i);
            formulaEvaluator.evaluateFormulaCell(cell);
        }
        cell = sheet1.getRow(0).createCell(1);
        cell.setCellValue("Visits, %");
        cell = sheet1.getRow(0).createCell(2);
        cell.setCellValue("Completed homework, %");
        for (int i = 2; i < 14; i++) {
            cell = sheet1.getRow(i-1).createCell(1);
            cell.setCellFormula("ROUND(COUNTIF('Group 1 Course ID 49185'!" + i + ":" + i + ",\"Attended\")/'Total amount 1'!A2* 100,0)\n");
            formulaEvaluator.evaluateFormulaCell(cell);
            cell = sheet1.getRow(i-1).createCell(2);
            cell.setCellFormula("ROUND(COUNTIF('Group 1 Course ID 49185'!" + i + ":" +i + ",\"Completed\")/'Total amount 1'!B2 * 100,0)");
            formulaEvaluator.evaluateFormulaCell(cell);
        }
        sheet1.createRow(13);
        cell = sheet1.getRow(13).createCell(0);
        cell.setCellValue("Result");
        cell = sheet1.getRow(13).createCell(1);
        cell.setCellFormula("ROUND(AVERAGE(B2:B13),1)");
        formulaEvaluator.evaluateFormulaCell(cell);
        cell = sheet1.getRow(13).createCell(2);
        cell.setCellFormula("ROUND(AVERAGE(C2:C13),1)");
        formulaEvaluator.evaluateFormulaCell(cell);
        for (int i = 1; i < 14; i++) {
            sheet2.createRow(i-1);
            cell = sheet2.getRow(i-1).createCell(0);
            cell.setCellFormula("'Group 1 Course ID 49187'!A" + i);
            formulaEvaluator.evaluateFormulaCell(cell);
        }
        cell = sheet2.getRow(0).createCell(1);
        cell.setCellValue("Visits, %");
        cell = sheet2.getRow(0).createCell(2);
        cell.setCellValue("Completed homework, %");
        for (int i = 2; i < 14; i++) {
            cell = sheet2.getRow(i-1).createCell(1);
            cell.setCellFormula("ROUND(COUNTIF('Group 1 Course ID 49187'!" + i + ":" + i + ",\"Attended\")/'Total amount 1'!C2* 100,0)\n");
            formulaEvaluator.evaluateFormulaCell(cell);
            cell = sheet2.getRow(i-1).createCell(2);
            cell.setCellFormula("ROUND(COUNTIF('Group 1 Course ID 49187'!" + i + ":" +i + ",\"Completed\")/'Total amount 1'!D2 * 100,0)");
            formulaEvaluator.evaluateFormulaCell(cell);
        }
        sheet2.createRow(13);
        cell = sheet2.getRow(13).createCell(0);
        cell.setCellValue("Result");
        cell = sheet2.getRow(13).createCell(1);
        cell.setCellFormula("ROUND(AVERAGE(B2:B13),1)");
        formulaEvaluator.evaluateFormulaCell(cell);
        cell = sheet2.getRow(13).createCell(2);
        cell.setCellFormula("ROUND(AVERAGE(C2:C13),1)");
        formulaEvaluator.evaluateFormulaCell(cell);
        for (int i = 1; i < 14; i++) {
            sheet3.createRow(i-1);
            cell = sheet3.getRow(i-1).createCell(0);
            cell.setCellFormula("'Group 1 Course ID 49191'!A" + i);
            formulaEvaluator.evaluateFormulaCell(cell);
        }
        cell = sheet3.getRow(0).createCell(1);
        cell.setCellValue("Visits, %");
        cell = sheet3.getRow(0).createCell(2);
        cell.setCellValue("Completed homework, %");
        for (int i = 2; i < 14; i++) {
            cell = sheet3.getRow(i-1).createCell(1);
            cell.setCellFormula("ROUND(COUNTIF('Group 1 Course ID 49191'!" + i + ":" + i + ",\"Attended\")/'Total amount 1'!E2* 100,0)\n");
            formulaEvaluator.evaluateFormulaCell(cell);
            cell = sheet3.getRow(i-1).createCell(2);
            cell.setCellFormula("ROUND(COUNTIF('Group 1 Course ID 49191'!" + i + ":" +i + ",\"Completed\")/'Total amount 1'!F2 * 100,0)");
            formulaEvaluator.evaluateFormulaCell(cell);
        }
        sheet3.createRow(13);
        cell = sheet3.getRow(13).createCell(0);
        cell.setCellValue("Result");
        cell = sheet3.getRow(13).createCell(1);
        cell.setCellFormula("ROUND(AVERAGE(B2:B13),1)");
        formulaEvaluator.evaluateFormulaCell(cell);
        cell = sheet3.getRow(13).createCell(2);
        cell.setCellFormula("ROUND(AVERAGE(C2:C13),1)");
        formulaEvaluator.evaluateFormulaCell(cell);
    }
    public void setSheets(XSSFSheet sheet1, XSSFSheet sheet2, XSSFSheet sheet3){
        this.sheet1 = sheet1;
        this.sheet2 = sheet2;
        this.sheet3 = sheet3;
        this.start();
    }
}
