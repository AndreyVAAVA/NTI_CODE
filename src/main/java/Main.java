import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {

    public static URL obj;
    public static HttpURLConnection connection;
    public static BufferedReader in;
    public static StringBuffer response;
    public static String inputLine;
    public static XSSFWorkbook workbook = new XSSFWorkbook();
    public static int lessns_am = (int) Math.round(Math.random()*10 + 11);
    /*public static CourseList courseList;
    public static ArrayList<String> requestsById = new ArrayList<>();*/
    public static ArrayList<String> list_names = new ArrayList<>();
    public static ArrayList<String> list_0 = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        var url = "https://userapi.webinar.ru/v3/organization/courses";
/*        var webinarParser = new WebinarParser();*/
        connectionStream(url);
        System.out.println(response.toString());
        var g = new Gson();
        var courseList = g.fromJson(response.toString(), CourseList.class);
        System.out.println(courseList.getData().get(0).getId()); //John

        url = "https://userapi.webinar.ru/v3/courses/";
        var requestsById = new ArrayList<String>();
        var courses = new ArrayList<Course>();
        var finalUrl = url;
        int groupid;
        courseList.getData().forEach(x -> {
            if (x.isPublish())
                requestsById.add(finalUrl + x.getId());
        });
        for (var elem:requestsById) {
            connectionStream(elem);
            System.out.println(response.toString());
            courses.add(g.fromJson(response.toString(), Course.class));
        }
        System.out.println(courses.get(0).getId());


        // Maybe it will be used later
        /*url = "https://userapi.webinar.ru/v3/courses/";
        var finUrl = url;
        requestsById.clear();
        courses.forEach(x -> {
            x.getGroups().forEach(z -> {
                requestsById.add(finUrl + x.getId() + "/groups/" + z.getId() + "/statistics");
            });
        });
        requestsById.forEach(System.out::println);
        var courseGroup = new ArrayList<CourseGroup>();
        var objects = new ArrayList<Object[]>();
        String sheetName = org.apache.commons.lang3.StringEscapeUtils.unescapeJava("\\u0421\\u0442\\u0430\\u0442\\u0438\\u0441\\u0442\\u0438\\u043a\\u0430\\u0020\\u043f\\u043e\\u0020\\u0433\\u0440\\u0443\\u043f\\u043f\\u0435\\u0020\\u043a\\u0443\\u0440\\u0441\\u0430");
        AtomicInteger counter = new AtomicInteger();
        for (var elem:requestsById) {
            connectionStream(elem);
            System.out.println(response.toString());
            Collections.addAll(courseGroup, g.fromJson(response.toString(), CourseGroup[].class));
            courseGroup.forEach(x -> {
                counter.getAndIncrement();
                x.getLessonsPassing().forEach(z -> {
                    if (z.getDate() != null)
                        objects.add(new Object[]{z.getId(), z.getName(), z.getType(), z.getScore(), z.getDate().getDate()LocalDate.parse(z.getDate().getDate(), dtf)});
                    else
                        objects.add(new Object[]{z.getId(), z.getName(), z.getType(), z.getScore(), org.apache.commons.lang3.StringEscapeUtils.unescapeJava("\\u041d\\u0435\\u0020\\u043f\\u0440\\u043e\\u0448\\u0451\\u043b")});

                });
                try {
                    write(workbook.createSheet(sheetName + counter.get()), objects);
                    objects.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            courseGroup.clear();
        }*/



        var list = new ArrayList<ArrayList<ArrayList<Object>>>();
        int courseId1 = (int) courses.get(0).getId();
        int courseId2 = (int) courses.get(1).getId();
        int courseId3 = (int) courses.get(2).getId();
        var int_list = new ArrayList<Integer>(3);
        int_list.add(courseId1);
        int_list.add(courseId2);
        int_list.add(courseId3);
        Group1 group1 = new Group1();
        try {
            list = group1.write(int_list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Group2 group2 = new Group2();
        try {
            list = group2.write(list, int_list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Group3 group3 = new Group3();
        try {
            list = group3.write(list, int_list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Group4 group4 = new Group4();
        try {
            list = group4.write(list, int_list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list_names = new ArrayList<String>();
        int counter_group = 1;
        int counter_course = 1;
        for (var elem:list) {
            var sheet_name = "Group "+ counter_group + " Course ID " + (counter_course == 1 ? courseId1 : counter_course == 2 ? courseId2 : courseId3);
            list_names.add(sheet_name);
            write(workbook.createSheet(sheet_name), elem);
            counter_course++;
            if (counter_course == 4) {
                counter_group += 1;
                counter_course = 1;
            }
        }
        Writer writer = new Writer();
        writer.start();
        XSSFSheet sheet = workbook.createSheet("Total amount 1");
        sheet.createRow(0);
        list_0 = new ArrayList<String>();
        for (int i = 1; i < 4; i++) {
            list_0.add("Amount of exercises for course " + i);
            list_0.add("Amount of homeworks for course " + i);
        }
        XSSFCell cell;
        for (int i = 0; i < list_0.size(); i++) {
            cell = sheet.getRow(0).createCell(i);
            cell.setCellValue(list_0.get(i));
        }
        int sec_counter = 0;
        sheet.createRow(1);
        for (int i = 0; i < 3; i++) {
            cell = sheet.getRow(1).createCell(sec_counter);
            cell.setCellFormula("COUNTIF('"+ list_names.get(i) + "'!1:1000, \"Lesson\") + COUNTIF('" + list_names.get(i) + "'!1:1000, \"Webinar\")");
            XSSFFormulaEvaluator formulaEvaluator =
                    workbook.getCreationHelper().createFormulaEvaluator();
            formulaEvaluator.evaluateFormulaCell(cell);
            cell = sheet.getRow(1).createCell(sec_counter+1);
            cell.setCellFormula("COUNTIF('" + list_names.get(i) + "'!1:1000, \"Homework\")");
            formulaEvaluator =
                    workbook.getCreationHelper().createFormulaEvaluator();
            formulaEvaluator.evaluateFormulaCell(cell);
            sec_counter += 2;
        }
        Total1Thread thread = new Total1Thread();
        XSSFSheet sheet1 = workbook.createSheet("Group 1 Course 1");
        XSSFSheet sheet2 = workbook.createSheet("Group 1 Course 2");
        XSSFSheet sheet3 = workbook.createSheet("Group 1 Course 3");
        thread.setSheets(sheet1, sheet2, sheet3);
        sheet = workbook.createSheet("Total amount 2");
        sheet.createRow(0);
        for (int i = 0; i < list_0.size(); i++) {
            cell = sheet.getRow(0).createCell(i);
            cell.setCellValue(list_0.get(i));
        }
        sec_counter = 0;
        sheet.createRow(1);
        for (int i = 3; i < 6; i++) {
            cell = sheet.getRow(1).createCell(sec_counter);
            cell.setCellFormula("COUNTIF('"+ list_names.get(i) + "'!1:1000, \"Lesson\") + COUNTIF('" + list_names.get(i) + "'!1:1000, \"Webinar\")");
            XSSFFormulaEvaluator formulaEvaluator =
                    workbook.getCreationHelper().createFormulaEvaluator();
            formulaEvaluator.evaluateFormulaCell(cell);
            cell = sheet.getRow(1).createCell(sec_counter+1);
            cell.setCellFormula("COUNTIF('" + list_names.get(i) + "'!1:1000, \"Homework\")");
            formulaEvaluator =
                    workbook.getCreationHelper().createFormulaEvaluator();
            formulaEvaluator.evaluateFormulaCell(cell);
            sec_counter += 2;
        }
//        sec_counter = 0;
        ////////////////////////////////////////////////////////////////////////////////////////////////
        sheet1 = workbook.createSheet("Group 2 Course 1");
        sheet2 = workbook.createSheet("Group 2 Course 2");
        sheet3 = workbook.createSheet("Group 2 Course 3");
        Total2Thread total2Thread = new Total2Thread();
        total2Thread.setSheets(sheet1, sheet2, sheet3);
        sheet = workbook.createSheet("Total amount 3");
        sheet.createRow(0);
        for (int i = 0; i < list_0.size(); i++) {
            cell = sheet.getRow(0).createCell(i);
            cell.setCellValue(list_0.get(i));
        }
        sec_counter = 0;
        sheet.createRow(1);
        for (int i = 6; i < 9; i++) {
            cell = sheet.getRow(1).createCell(sec_counter);
            cell.setCellFormula("COUNTIF('"+ list_names.get(i) + "'!1:1000, \"Lesson\") + COUNTIF('" + list_names.get(i) + "'!1:1000, \"Webinar\")");
            XSSFFormulaEvaluator formulaEvaluator =
                    workbook.getCreationHelper().createFormulaEvaluator();
            formulaEvaluator.evaluateFormulaCell(cell);
            cell = sheet.getRow(1).createCell(sec_counter+1);
            cell.setCellFormula("COUNTIF('" + list_names.get(i) + "'!1:1000, \"Homework\")");
            formulaEvaluator =
                    workbook.getCreationHelper().createFormulaEvaluator();
            formulaEvaluator.evaluateFormulaCell(cell);
            sec_counter += 2;
        }
//        sec_counter = 0;
        ////////////////////////////////////////////////////////////////////////////////////////////////
        sheet1 = workbook.createSheet("Group 3 Course 1");
        sheet2 = workbook.createSheet("Group 3 Course 2");
        sheet3 = workbook.createSheet("Group 3 Course 3");
        Total3Thread total3Thread = new Total3Thread();
        total3Thread.setSheets(sheet1, sheet2, sheet3);
        sheet = workbook.createSheet("Total amount 4");
        sheet.createRow(0);
        for (int i = 0; i < list_0.size(); i++) {
            cell = sheet.getRow(0).createCell(i);
            cell.setCellValue(list_0.get(i));
        }
        sec_counter = 0;
        sheet.createRow(1);
        for (int i = 9; i < 12; i++) {
            cell = sheet.getRow(1).createCell(sec_counter);
            cell.setCellFormula("COUNTIF('"+ list_names.get(i) + "'!1:1000, \"Lesson\") + COUNTIF('" + list_names.get(i) + "'!1:1000, \"Webinar\")");
            XSSFFormulaEvaluator formulaEvaluator =
                    workbook.getCreationHelper().createFormulaEvaluator();
            formulaEvaluator.evaluateFormulaCell(cell);
            cell = sheet.getRow(1).createCell(sec_counter+1);
            cell.setCellFormula("COUNTIF('" + list_names.get(i) + "'!1:1000, \"Homework\")");
            formulaEvaluator =
                    workbook.getCreationHelper().createFormulaEvaluator();
            formulaEvaluator.evaluateFormulaCell(cell);
            sec_counter += 2;
        }
//        sec_counter = 0;
        ////////////////////////////////////////////////////////////////////////////////////////////////
        sheet1 = workbook.createSheet("Group 4 Course 1");
        sheet2 = workbook.createSheet("Group 4 Course 2");
        sheet3 = workbook.createSheet("Group 4 Course 3");
        Total4Thread total4Thread = new Total4Thread();
        total4Thread.setSheets(sheet1, sheet2, sheet3);
        try (FileOutputStream outputStream = new FileOutputStream("Stats.xlsx")) {
            workbook.write(outputStream);
        }
    }

    /**
     * By variable "connection"
     * This method sets the values of the "response" variable that we receive from the server.
     * @param url
     * @throws IOException
     */
    public static void connectionStream(String url) throws IOException {
        obj = new URL(url);
        connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("x-auth-token", "b540bd407852678c0af5b11105dcde14");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
    }

    public static void write(XSSFSheet sheet, ArrayList<ArrayList<Object>> objects) throws IOException {
        int rowCount = 0;
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Student ID");
        var lst = new ArrayList<String>();
        lst.add("Lesson");
        lst.add("Webinar");
        lst.add("HomeWork");
        String prev = "";
        for (int i = 1; i < lessns_am; i++) {
            cell = row.createCell(i);
            var item = lst.get((int) Math.round(Math.random()*2));
            if (i == 1)
                cell.setCellValue(lst.get((int) Math.round(Math.random()*1)));
            else if (prev.equals(item))
                cell.setCellValue(lst.get((int) Math.round(Math.random()*1)));
            else
                cell.setCellValue(item);
            prev = item;
        }
        for (ArrayList<Object> aBook : objects) {
            row = sheet.createRow(++rowCount);
            int columnCount = 0;
            for (Object field : aBook) {
                cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Long) {
                    cell.setCellValue((Long) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((int) field);
                } else if (field instanceof Boolean) {
                    var up_cell = sheet.getRow(0).getCell(columnCount-1).toString();
                    if (up_cell.equals("HomeWork"))
                        cell.setCellValue(((boolean) field) ? "Completed" : "Not Completed");
                    else
                        cell.setCellValue((boolean) field ? "Attended" : "Absence");
                }/* else if (field instanceof LocalDate) {
                    cell.setCellValue(java.sql.Date.valueOf((LocalDate) field));
                }*/
            }
        }


        /*try (FileOutputStream outputStream = new FileOutputStream("Stats.xlsx")) {
            workbook.write(outputStream);
        }*/
    }

}
