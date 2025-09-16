package com.mepro.appname.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.StringJoiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionUtil {
    private static final Logger logger = LoggerFactory.getLogger(TransactionUtil.class);
    
    public static String dateToString(Date date, String defaultFormat) {
        String dateString = null;
        DateFormat format = new SimpleDateFormat(defaultFormat);
        if (date == null) {
            dateString = null;
        } else {
            dateString = format.format(date);
        }
        return dateString;
    }
    
    public static String dateToString(LocalDate date, String defaultFormat) {
        String dateString = null;
        DateFormat format = new SimpleDateFormat(defaultFormat);
        if (date == null) {
            dateString = null;
        } else {
            dateString = format.format(date);
        }
        return dateString;
    }

    public static Date stringToDate(String dateString, String defaultFormat) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(defaultFormat);
        Date date = format.parse(dateString);
        return date;
    }

    public static long getDayDiff(Date startDate, Date endDate) {
        long diff = startDate.getTime() - endDate.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        return diffDays;
    }

    public static Double parseDouble(String value) {
        Double dValue = null;
        if (value != null) {
            if (value.trim().length() > 0) {
                try {
                    dValue = Double.valueOf(value);
                } catch (NumberFormatException e) {
                    logger.error("Runtime exception while parsing Double parseDouble(" + value + "): " + e.getMessage());
                }
            }
        }
        return dValue;
    }

    public static Integer parseInt(String value) {
        Integer iValue = null;
        if (value != null) {
            if (value.trim().length() > 0) {
                try {
                    iValue = Integer.valueOf(value);
                } catch (NumberFormatException e) {
                    logger.error("Runtime exception while parsing Integer parseInt(" + value + "): " + e.getMessage());
                }
            }
        }
        return iValue;
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.JAVA_DATETIME_FORMAT, Locale.getDefault());
        Calendar nowDate = Calendar.getInstance();
        nowDate.add(Calendar.DATE, +0);
        String nowDateString = dateFormat.format(nowDate.getTime());
        return nowDateString;
    }

    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.JAVA_DATE_FORMAT, Locale.getDefault());
        Calendar nowDate = Calendar.getInstance();
        nowDate.add(Calendar.DATE, +0);
        String nowDateString = dateFormat.format(nowDate.getTime());
        return nowDateString;
    }

    public static String getCurrenMonth() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.JAVA_MONTH_FORMAT, Locale.getDefault());
        Calendar nowDate = Calendar.getInstance();
        nowDate.add(Calendar.DATE, +0);
        String nowDateString = dateFormat.format(nowDate.getTime());
        return nowDateString;
    }
    
    public static String getFullNameCurrenMonth() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.JAVA_FULLNAME_MONTH_FORMAT, Locale.getDefault());
        Calendar nowDate = Calendar.getInstance();
        nowDate.add(Calendar.DATE, +0);
        String nowDateString = dateFormat.format(nowDate.getTime());
        return nowDateString;
    }

    public static String getCurrentYear() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.JAVA_YEAR_FORMAT, Locale.getDefault());
        Calendar nowDate = Calendar.getInstance();
        nowDate.add(Calendar.DATE, +0);
        String nowDateString = dateFormat.format(nowDate.getTime());
        return nowDateString;
    }

    public static long booleanCode(boolean state) {
        if (state == true) {
            return 1;
        } else {
            return 0;
        }
    }

    public static boolean booleanState(long code) {
        if (code == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static String getDueDate(int days, String date) {
        String dueDate = "";
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.JAVA_DATE_FORMAT, Locale.getDefault());
            Date invoiceDate = dateFormat.parse(date);

            Calendar calendarDate = Calendar.getInstance();
            calendarDate.setTime(invoiceDate);
            calendarDate.add(Calendar.DATE, +days);
            dueDate = dateFormat.format(calendarDate.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dueDate;
    }

    public static LinkedHashMap<Integer, Integer> getListDiffMonth() {
        LinkedHashMap<Integer, Integer> listDiffMonth = new LinkedHashMap<>();
        for (int i = 1; i <= 14; i++) {
            listDiffMonth.put(i, i);
        }
        return listDiffMonth;
    }

    public static LinkedHashMap<String, String> getListBulan() {
        LinkedHashMap<String, String> listBulan = new LinkedHashMap<>();
        listBulan.put("Januari", "1");
        listBulan.put("Februari", "2");
        listBulan.put("Maret", "3");
        listBulan.put("April", "4");
        listBulan.put("Mei", "5");
        listBulan.put("Juni", "6");
        listBulan.put("Juli", "7");
        listBulan.put("Agustus", "8");
        listBulan.put("September", "9");
        listBulan.put("Oktober", "10");
        listBulan.put("November", "11");
        listBulan.put("Desember", "12");
        return listBulan;
    }

    public static String getMonthByNumber(int numOfMMonth) {
        String nameOfMonth = "";
        switch (numOfMMonth) {
            case 1:
                nameOfMonth = "Januari";
                break;
            case 2:
                nameOfMonth = "Februari";
                break;
            case 3:
                nameOfMonth = "Maret";
                break;
            case 4:
                nameOfMonth = "April";
                break;
            case 5:
                nameOfMonth = "Mei";
                break;
            case 6:
                nameOfMonth = "Juni";
                break;
            case 7:
                nameOfMonth = "Juli";
                break;
            case 8:
                nameOfMonth = "Agustus";
                break;
            case 9:
                nameOfMonth = "September";
                break;
            case 10:
                nameOfMonth = "Oktober";
                break;
            case 11:
                nameOfMonth = "November";
                break;
            case 12:
                nameOfMonth = "Desember";
                break;
            default:
                break;
        }
        return nameOfMonth;
    }

    public static String arrayIntegerToString(List<Integer> listObj) {
        StringJoiner joiner = new StringJoiner(",");
        for (Integer id : listObj) {
            joiner.add(id.toString());
        }
        return joiner.toString();
    }

    public static String arrayLongToString(List<Long> listObj) {
        StringJoiner joiner = new StringJoiner(",");
        for (Long id : listObj) {
            joiner.add(id.toString());
        }
        return joiner.toString();
    }

    public static String arrayToString(List<String> listObj) {
        StringJoiner joiner = new StringJoiner(",");
        for (String id : listObj) {
            joiner.add(id);
        }
        return joiner.toString();
    }

    public static Date getLastDateInMonth(int bulan, int tahun) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, tahun);
        calendar.set(Calendar.MONTH, bulan - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date lastDayOfMonth = calendar.getTime();
        return lastDayOfMonth;
    }

    public static String getIntervalByYear(String tanggal, int interval) {
        LocalDate currentDate = LocalDate.parse(tanggal, DateTimeFormatter.ofPattern(Constants.JAVA_DATE_FORMAT));
        LocalDate newDate = currentDate.plusYears(interval);
        return newDate.format(DateTimeFormatter.ofPattern(Constants.JAVA_DATE_FORMAT));
    }

    public static String getIntervalByMonth(String tanggal, int interval) {
        LocalDate currentDate = LocalDate.parse(tanggal, DateTimeFormatter.ofPattern(Constants.JAVA_DATE_FORMAT));
        LocalDate newDate = currentDate.plusMonths(interval);
        return newDate.format(DateTimeFormatter.ofPattern(Constants.JAVA_DATE_FORMAT));
    }

    public static String checkDueDateStatus(String dueDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.JAVA_DATE_FORMAT);
        String dueDateStatus = null;
        try {
            String sysDate = getCurrentDate();
            LocalDate dueDate = LocalDate.parse(dueDateStr, formatter);
            LocalDate currentDate = LocalDate.now();
            if (dueDate.isBefore(currentDate) || dueDate.isEqual(currentDate)) {
                dueDateStatus = Constants.OVERUEDATE_STATUS;
            } else {
                dueDateStatus = Constants.SOON_STATUS;
            }
        } catch (Exception e) {
            logger.error("checkDueDateStatus() : " + e.getMessage(), e);
            e.printStackTrace();
        }
        return dueDateStatus;
    }

    public static LinkedHashMap<String, String> getListEdStatus() {
        LinkedHashMap<String, String> listEdStatus = new LinkedHashMap<>();
        listEdStatus.put(Constants.OVERUEDATE_STATUS, Constants.OVERUEDATE_STATUS);
        listEdStatus.put(Constants.SOON_STATUS, Constants.SOON_STATUS);
        return listEdStatus;
    }
    
    public static String getCurrentNumberFormated(Long currentCounter) {
        if (currentCounter < 1 || currentCounter > 9999) {
            throw new IllegalArgumentException("Number only between 1 - 9999");
        }
        return String.format("%04d", currentCounter);
    }
}
