import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
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
    public static void main(String[] args) throws IOException {
        var url = "https://userapi.webinar.ru/v3/organization/courses";
/*        var webinarParser = new WebinarParser();*/
        connectionStream(url);
        System.out.println(response.toString());
        var g = new Gson();
        CourseList courseList = g.fromJson(response.toString(), CourseList.class);
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
        var list = new ArrayList<ArrayList<Object[]>>();
        var list1 = new ArrayList<Object[]>();
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
        int counter_group = 1;
        int counter_course = 1;
        for (var elem:list) {
            write(workbook.createSheet( "Group "+ counter_course + " Course " + counter_group), elem);
            counter_course++;
            if (counter_course == 4) {
                counter_group += 1;
                counter_course = 1;
            }
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

    public static void write(XSSFSheet sheet, ArrayList<Object[]> objects) throws IOException {
        int rowCount = 0;
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Student ID");
        cell = row.createCell(1);
        cell.setCellValue("Type");
        cell = row.createCell(2);
        cell.setCellValue("Score");
        cell = row.createCell(3);
        cell.setCellValue("Course ID");
        cell = row.createCell(4);
        cell.setCellValue("Attendance");
        for (Object[] aBook : objects) {
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
                    cell.setCellValue((boolean) field);
                }/* else if (field instanceof LocalDate) {
                    cell.setCellValue(java.sql.Date.valueOf((LocalDate) field));
                }*/
            }
        }
        try (FileOutputStream outputStream = new FileOutputStream("Stats.xlsx")) {
            workbook.write(outputStream);
        }
    }

}
