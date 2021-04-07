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

        ParsingThread thread = new ParsingThread();

        var url = "https://userapi.webinar.ru/v3/organization/courses";
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
//            if (x.isPublish())
                requestsById.add(finalUrl + x.getId());
        });
        for (var elem:requestsById) {
            connectionStream(elem);
            System.out.println(response.toString());
            courses.add(g.fromJson(response.toString(), Course.class));
        }


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
        String[] what1 = {"Sochinenie", "Lecture", "Lesson", "HomeWork", "Task"};
        String[] what2 = {"Lecture", "Lesson", "HomeWork", "Task", "Exam"};
        String[] what3 = {"Lecture", "HomeWork", "Exam"};
        String[] what4 = {"Lecture", "HomeWork", "Task", "Exam"};
        var list = new ArrayList<ArrayList<Object[]>>();
        var list1 = new ArrayList<Object[]>();
        int courseId1 = 7;
        int courseId2 = 15;
        int courseId3 = 23;
        var int_list = new ArrayList<Integer>(3);
        int_list.add(courseId1);
        int_list.add(courseId2);
        int_list.add(courseId3);
        int aver_cool = 95;
        int count = 0;
        int counter1 = 0;
        int true_counter = 0;
        boolean state = true;
        for (var elem:int_list) {
            for (int id = 0; id < 12; id++) {
//                true_counter++;
                /*if (true_counter == Math.random()*12)
                    state = false;
                else
                    state = true;*/
                if (count == 0) {
                    if (counter1 >= what1.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what1[counter1], aver_cool, elem, state});
                } else if (count == 1) {
                    if (counter1 >= what2.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what2[counter1], aver_cool, elem, state});
                } else if (count == 2) {
                    if (counter1 >= what3.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what3[counter1], aver_cool, elem, state});
                } else if (count == 4) {
                    if (counter1 >= what4.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what4[counter1], aver_cool, elem, state});
                }
                if (aver_cool < 90)
                    aver_cool += 7;
                else
                    aver_cool -= 2;
                counter1++;

            }
//            true_counter = 0;
            counter1 = 0;
            count++;
            list.add((ArrayList<Object[]>) list1.clone());
            list1.clear();
        }
        count = 0;
        int aver_mid = 67;
        true_counter = 0;
        for (var elem:int_list) {
            for (int id = 24; id < 360; id+=24) {
//                true_counter++;
                // We checking if he attended classes
                /*if (true_counter == Math.random()*15 || true_counter == 12 || true_counter == 6)
                    state = false;
                else
                    state = true;*/
                if (count == 0) {
                    if (counter1 >= what1.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what1[counter1], aver_mid, elem, state});
                }
                else if (count == 1) {
                    if (counter1 >= what2.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what2[counter1], aver_mid, elem, state});
                }
                else if (count == 2) {
                    if (counter1 >= what3.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what3[counter1], aver_mid, elem, state});
                }
                else if (count == 4) {
                    if (counter1 >= what4.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what4[counter1], aver_mid, elem, state});
                }
                if (aver_mid < 55)
                    aver_mid += 25;
                else if (aver_mid < 62)
                    aver_mid += 6;
                else if (aver_mid > 70)
                    aver_mid -= 8;
                else
                    aver_mid -= 3;
                counter1++;
            }
//            true_counter = 0;
            counter1 = 0;
            count++;
            list.add((ArrayList<Object[]>) list1.clone());
            list1.clear();
        }
        count = 0;
        int aver_low = 50;
        for (var elem:int_list) {
            for (int id = 137; id < 233; id+=5) {
//                true_counter++;
                // We checking if he attended classes
                /*if (true_counter == Math.random()*19 || true_counter == Math.random()*19 || true_counter == Math.random()*3 || true_counter == Math.random()*5 || true_counter == 4 || true_counter == 7)
                    state = false;
                else
                    state = true;*/
                if (count == 0) {
                    if (counter1 >= what1.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what1[counter1], aver_low, elem, state});
                }
                else if (count == 1) {
                    if (counter1 >= what2.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what2[counter1], aver_low, elem, state});
                }
                else if (count == 2) {
                    if (counter1 >= what3.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what3[counter1], aver_low, elem, state});
                }
                else if (count == 4) {
                    if (counter1 >= what4.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what4[counter1], aver_low, elem, state});
                }
                if (aver_low < 30)
                    aver_low += 12;
                else if (aver_low < 37)
                    aver_low += 17;
                else if (aver_low > 50)
                    aver_low -= 9;
                else
                    aver_low -= 2;
                counter1++;
            }
//            true_counter = 0;
            counter1 = 0;
            count++;
            list.add((ArrayList<Object[]>) list1.clone());
            list1.clear();
        }
        count = 0;
        int aver_chaos = 50;
        for (var elem:int_list) {
            for (int id = 50; id < 211; id+=7) {
//                true_counter++;
                // We checking if he attended classes
                /*if (true_counter == Math.random()*19 || true_counter == Math.random()*19 || true_counter == Math.random()*3 || true_counter == Math.random()*5 || true_counter == 16 || true_counter == 23)
                    state = false;
                else
                    state = true;*/
                if (count == 0) {
                    if (counter1 >= what1.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what1[counter1], aver_chaos, elem, state});
                }
                else if (count == 1) {
                    if (counter1 >= what2.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what2[counter1], aver_chaos, elem, state});
                }
                else if (count == 2) {
                    if (counter1 >= what3.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what3[counter1], aver_chaos, elem, state});
                }
                else if (count == 4) {
                    if (counter1 >= what4.length)
                        counter1 = 0;
                    list1.add(new Object[]{id, what4[counter1], aver_chaos, elem, state});
                }
                if (aver_chaos < 20)
                    aver_chaos += 75;
                else if (aver_chaos < 30 )
                    aver_chaos -= 15;
                else if (aver_chaos < 62 && aver_chaos > 56)
                    aver_chaos -= 14;
                else if (aver_chaos > 70 && aver_chaos < 93)
                    aver_chaos -= 24;
                else if (aver_chaos > 63 && aver_chaos < 67)
                    aver_chaos += 18;
                else if (aver_chaos < 50 & aver_chaos > 35)
                    aver_chaos -= 15;
                else
                    aver_chaos -= 3;
                counter1++;
            }
//            true_counter = 0;
            counter1 = 0;
            count++;
            list.add((ArrayList<Object[]>) list1.clone());
            list1.clear();
        }
        int counter_group = 1;
        int counter_course = 1;
        for (var elem:list) {
            write(workbook.createSheet( "Group "+ counter_group + " Course " + counter_course), elem);
            counter_group++;
            if (counter_group == 4) {
                counter_course += 1;
                counter_group = 1;
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
