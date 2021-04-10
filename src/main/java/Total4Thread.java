import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Total4Thread extends Thread {
    XSSFSheet sheet1;
    XSSFSheet sheet2;
    XSSFSheet sheet3;
    @Override
    public void run() {
        XSSFFormulaEvaluator formulaEvaluator =
                Main.workbook.getCreationHelper().createFormulaEvaluator();
        XSSFCell cell;
        for (int i = 1; i < 25; i++) {
            sheet1.createRow(i-1);
            cell = sheet1.getRow(i-1).createCell(0);
            cell.setCellFormula("'Group 4 Course ID 49185'!A" + i);
            formulaEvaluator.evaluateFormulaCell(cell);
        }
        cell = sheet1.getRow(0).createCell(1);
        cell.setCellValue("Visits, %");
        cell = sheet1.getRow(0).createCell(2);
        cell.setCellValue("Completed homework, %");
        for (int i = 2; i < 25; i++) {
            /*            sheet.createRow(i-1);*/
            cell = sheet1.getRow(i-1).createCell(1);
            cell.setCellFormula("ROUND(COUNTIF('Group 4 Course ID 49185'!" + i + ":" + i + ",\"Attended\")/'Total amount 4'!A2* 100,0)\n");
            formulaEvaluator.evaluateFormulaCell(cell);
            cell = sheet1.getRow(i-1).createCell(2);
            cell.setCellFormula("ROUND(COUNTIF('Group 4 Course ID 49185'!" + i + ":" +i + ",\"Completed\")/'Total amount 4'!B2 * 100,0)");
            formulaEvaluator.evaluateFormulaCell(cell);
        }
        sheet1.createRow(24);
        cell = sheet1.getRow(24).createCell(0);
        cell.setCellValue("Result");
        cell = sheet1.getRow(24).createCell(1);
        cell.setCellFormula("ROUND(AVERAGE(B2:B13),1)");
        formulaEvaluator.evaluateFormulaCell(cell);
        cell = sheet1.getRow(24).createCell(2);
        cell.setCellFormula("ROUND(AVERAGE(C2:C13),1)");
        formulaEvaluator.evaluateFormulaCell(cell);
        for (int i = 1; i < 25; i++) {
            sheet2.createRow(i-1);
            cell = sheet2.getRow(i-1).createCell(0);
            cell.setCellFormula("'Group 4 Course ID 49187'!A" + i);
            formulaEvaluator.evaluateFormulaCell(cell);
        }
        cell = sheet2.getRow(0).createCell(1);
        cell.setCellValue("Visits, %");
        cell = sheet2.getRow(0).createCell(2);
        cell.setCellValue("Completed homework, %");
        for (int i = 2; i < 25; i++) {
            /*            sheet.createRow(i-1);*/
            cell = sheet2.getRow(i-1).createCell(1);
            cell.setCellFormula("ROUND(COUNTIF('Group 4 Course ID 49187'!" + i + ":" + i + ",\"Attended\")/'Total amount 4'!C2* 100,0)\n");
            formulaEvaluator.evaluateFormulaCell(cell);
            cell = sheet2.getRow(i-1).createCell(2);
            cell.setCellFormula("ROUND(COUNTIF('Group 4 Course ID 49187'!" + i + ":" +i + ",\"Completed\")/'Total amount 4'!D2 * 100,0)");
            formulaEvaluator.evaluateFormulaCell(cell);
        }
        sheet2.createRow(24);
        cell = sheet2.getRow(24).createCell(0);
        cell.setCellValue("Result");
        cell = sheet2.getRow(24).createCell(1);
        cell.setCellFormula("ROUND(AVERAGE(B2:B13),1)");
        formulaEvaluator.evaluateFormulaCell(cell);
        cell = sheet2.getRow(24).createCell(2);
        cell.setCellFormula("ROUND(AVERAGE(C2:C13),1)");
        formulaEvaluator.evaluateFormulaCell(cell);
        for (int i = 1; i < 25; i++) {
            sheet3.createRow(i-1);
            cell = sheet3.getRow(i-1).createCell(0);
            cell.setCellFormula("'Group 4 Course ID 49191'!A" + i);
            formulaEvaluator.evaluateFormulaCell(cell);
        }
        cell = sheet3.getRow(0).createCell(1);
        cell.setCellValue("Visits, %");
        cell = sheet3.getRow(0).createCell(2);
        cell.setCellValue("Completed homework, %");
        for (int i = 2; i < 25; i++) {
            /*            sheet.createRow(i-1);*/
            cell = sheet3.getRow(i-1).createCell(1);
            cell.setCellFormula("ROUND(COUNTIF('Group 4 Course ID 49191'!" + i + ":" + i + ",\"Attended\")/'Total amount 4'!E2* 100,0)\n");
            formulaEvaluator.evaluateFormulaCell(cell);
            cell = sheet3.getRow(i-1).createCell(2);
            cell.setCellFormula("ROUND(COUNTIF('Group 4 Course ID 49191'!" + i + ":" +i + ",\"Completed\")/'Total amount 4'!F2 * 100,0)");
            formulaEvaluator.evaluateFormulaCell(cell);
        }
        sheet3.createRow(24);
        cell = sheet3.getRow(24).createCell(0);
        cell.setCellValue("Result");
        cell = sheet3.getRow(24).createCell(1);
        cell.setCellFormula("ROUND(AVERAGE(B2:B13),1)");
        formulaEvaluator.evaluateFormulaCell(cell);
        cell = sheet3.getRow(24).createCell(2);
        cell.setCellFormula("ROUND(AVERAGE(C2:C13),1)");
        formulaEvaluator.evaluateFormulaCell(cell);
    }
    public void setSheets(XSSFSheet sheet1, XSSFSheet sheet2, XSSFSheet sheet3){
        this.sheet1 = sheet1;
        this.sheet2 = sheet2;
        this.sheet3 = sheet3;
        this.start();
        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
