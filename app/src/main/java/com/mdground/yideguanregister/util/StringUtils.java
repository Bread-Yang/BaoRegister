package com.mdground.yideguanregister.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mdground.yideguanregister.R;
import com.mdground.yideguanregister.bean.Drug;
import com.mdground.yideguanregister.bean.OperateInventory;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Years;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static boolean isEmpty(String string) {
        if (string == null || "".equals(string) || TextUtils.isEmpty(string) || "[]".equals(string) || "null".equals(string) || "[null]".equals(string)) {
            return true;
        }
        return false;
    }

    public static String trimUnit(String beTrimedString) {
        String regEx = "[^0-9.]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(beTrimedString);
        return m.replaceAll("").trim();
    }

    public static String addYuanUnit(String beAddString) {
        if (StringUtils.isEmpty(beAddString)) {
            return "0.00元";
        } else{
            float price = Float.valueOf(beAddString);
//            if (price == (int) price) {
//                return ((int) price) + "元";
//            } else {
//                return String.format("%.2f", price) + "元";
//            }
            return String.format("%.2f", price) + "元";
        }
    }

    public static String getUnitByUnitType(int unitType, Drug drug) {
        String unit = "";
        if (unitType == 1) {
            unit = drug.getUnitGeneric();
        } else {
            unit = drug.getUnitSmall();
        }
        return unit;
    }

    public static String formatCurrency(double currency) {
        NumberFormat defaultFormat = NumberFormat.getInstance();
        defaultFormat.setMaximumFractionDigits(2);
        defaultFormat.setMinimumFractionDigits(2);

        return defaultFormat.format(currency);
    }

    public static void showInventoryQuantityAndUnit(Context context, Drug mDrug, TextView tv_total_inventory) {
        // 如100瓶/100瓶，则总库存只需要显示：100瓶即可
        if (mDrug.getUnitSmall().equals(mDrug.getUnitGeneric())) {
            String smallUnitQuantityText = String.valueOf(mDrug.getInventoryQuantity());
            String showText = smallUnitQuantityText + mDrug.getUnitSmall();

            SpannableStringBuilder builder = new SpannableStringBuilder(showText);
            builder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.color_206ef0)), 0, smallUnitQuantityText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.setSpan(new RelativeSizeSpan(1.2f), 0, smallUnitQuantityText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            tv_total_inventory.setText(builder);
        } else {
            String smallUnitQuantityText = String.valueOf(mDrug.getInventoryQuantity());
            String genericUnitQuantityText = String.valueOf(mDrug.getInventoryQuantity() / mDrug.getUnitConvert());

            String showText = smallUnitQuantityText + mDrug.getUnitSmall() + "/" + genericUnitQuantityText + mDrug.getUnitGeneric();

            SpannableStringBuilder builder = new SpannableStringBuilder(showText);

            builder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.color_206ef0)), 0, smallUnitQuantityText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.setSpan(new RelativeSizeSpan(1.2f), 0, smallUnitQuantityText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            builder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.color_206ef0)), smallUnitQuantityText.length() + mDrug.getUnitSmall().length() + 1, showText.length() - mDrug.getUnitGeneric().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.setSpan(new RelativeSizeSpan(1.2f), smallUnitQuantityText.length() + mDrug.getUnitSmall().length() + 1, showText.length() - mDrug.getUnitGeneric().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            tv_total_inventory.setText(builder);
        }
    }

    public static String getReturnPrice(OperateInventory inventory) {
        float dividend = 1;
        if (inventory.getPurchaseUnitType() == 1) {
            dividend = inventory.getUnitConvert();
        }
        float returnTotalPrice = inventory.getQuantityReturn() * inventory.getPurchasePrice() / 100f / dividend;
        return StringUtils.addYuanUnit(String.valueOf(returnTotalPrice));
    }

    public static String getPatientGenderStr(int gender) {
        if (gender == 1) {
            return "男";
        } else if (gender == 2) {
            return "女";
        }

        return "";
    }

    public static String getAge(String dob) {
        try {
            getAge(simpleDateFormat.parse(dob));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static String getAge(Date dob) {
        DateTime ageDateTime = new DateTime(dob);
        DateTime currentDateTime = new DateTime();

        Years years = Years.yearsBetween(ageDateTime, currentDateTime);

        Months months = Months.monthsBetween(ageDateTime.withDayOfMonth(1), currentDateTime.withDayOfMonth(1));

        Days days = Days.daysBetween(ageDateTime, currentDateTime);

        int yearsDifference = years.getYears();

        int monthsDifference = months.getMonths();

        int daysDifference = days.getDays();

        if (yearsDifference >= 5) { // 不小于5年时,返回X岁
            return yearsDifference + "岁";
        } else if (yearsDifference >= 1) {
            if (monthsDifference == 0) {
                return yearsDifference + "岁";
            } else {
                return yearsDifference + "岁" + (monthsDifference - yearsDifference * 12)  + "个月";
            }
        } else if (0 == yearsDifference) {
            if (monthsDifference > 0) {
                return monthsDifference + "个月";
            } else if (monthsDifference == 0) {
                if (daysDifference > 0) {
                    return daysDifference + "天";
                } else {
                    return "今天";
                }
            }
        }

        return "1天";

//        long oldtime = ageCalendar.getTime().getTime();
//        long newtime = System.currentTimeMillis();
//        long monthcur = (long) 24 * (long) 3600 * (long) 30 * (long) 1000;
//        long yearcur = monthcur * 12;
//        long timecur = newtime - oldtime;
//        if (timecur > 3 * yearcur) {
//            return ((int) (timecur / yearcur)) + "岁";
//        } else if ((newtime - oldtime) < (3 * yearcur) && (newtime - oldtime) > yearcur) {
//            int sui = (int) (timecur / yearcur);
//            int yue = (int) ((timecur - yearcur * sui) / monthcur);
//            if (yue == 0) {
//                return sui + "岁";
//            } else {
//                return sui + "岁" + yue + "月";
//            }
//
//        } else if (timecur < yearcur && timecur > monthcur) {
//            int yue = (int) (timecur / monthcur);
//            return yue + "月";
//        } else if (timecur < monthcur) {
//            int tian = (int) (timecur / ((long) 24 * (long) 3600 * (long) 1000));
//            if (tian == 0) {
//                return "今天";
//            }
//            return tian + "天";
//        }
//        return "1天";
    }

    public static int getDobYear(String dob) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(dob));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int oldYear = calendar.get(Calendar.YEAR);
        return oldYear;
    }

    public static int getDobMONTH(String dob) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(dob));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int MONTH = calendar.get(Calendar.MONTH);
        return MONTH;
    }

    public static int getDobDay(String dob) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(dob));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);
        return DAY_OF_MONTH;
    }

    public static long getDateMILL(String dob) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(dob));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return calendar.getTimeInMillis();
    }

    static SimpleDateFormat simpleDateFormatdayTime = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
    static SimpleDateFormat simpleDateFormatday = new SimpleDateFormat("yyyy年MM月dd日");

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String getViewString(String dobString) {
        try {
            return simpleDateFormatdayTime.format(simpleDateFormat.parse(dobString));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static String getViewStringNoTime(String dobString) {
        try {
            return simpleDateFormatday.format(simpleDateFormat.parse(dobString));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static String getDOBString(String viewString) {
        try {
            return simpleDateFormat.format(simpleDateFormatday.parse(viewString));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static Date getDOB(String viewString) {
        try {
            return simpleDateFormatday.parse(viewString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static String getDOBString(long cur) {
        try {
            return simpleDateFormat.format(cur);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static String getPhotoString(String clinicID, String fileID) {
        return "/yideguan?clinicID=" + clinicID + "&fileID=" + fileID;
    }

    /**
     * 获取UUID
     *
     * @return 32UUID小写字符串
     */
    public static String gainUUID() {
        String strUUID = UUID.randomUUID().toString();
        strUUID = strUUID.replaceAll("-", "").toLowerCase();
        return strUUID;
    }

    /**
     * 判断字符串是否非空非null
     *
     * @param strParm 需要判断的字符串
     * @return 真假
     */
    public static boolean isNoBlankAndNoNull(String strParm) {
        return !((strParm == null) || (strParm.equals("")));
    }

    /**
     * 将流转成字符串
     *
     * @param is 输入流
     * @return
     * @throws Exception
     */
    public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    /**
     * 将文件转成字符串
     *
     * @param file 文件
     * @return
     * @throws Exception
     */
    public static String getStringFromFile(File file) throws Exception {
        FileInputStream fin = new FileInputStream(file);
        String ret = convertStreamToString(fin);
        // Make sure you close all streams.

        fin.close();
        return ret;
    }

    /**
     * 字符全角化
     *
     * @param input
     * @return
     */
    public static String ToSBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    // 首字母转大写
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    public static String getVersionName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName(),0);
            if (packInfo != null) {
                return packInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void printJson(String tag, String msg) {

        String message;

        try {
            if (msg.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(msg);
                message = jsonObject.toString(4);
            } else if (msg.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(msg);
                message = jsonArray.toString(4);
            } else {
                message = msg;
            }
        } catch (JSONException e) {
            message = msg;
        }

        Log.e(tag, message);
    }

    public static <T> T getInstanceByJsonString(String jsonString, TypeToken<T> type) {
        if (type == null) {
            return null;
        }
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        if (jsonString == null) {
            return null;
        } else {
            return gson.fromJson(jsonString, type.getType());
        }
    }
}
