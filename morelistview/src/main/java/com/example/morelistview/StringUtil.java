package com.example.morelistview;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理工具
 */
public class StringUtil {
    /**
     * 判断给定字符串是否空白串, 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input)) {
            return true;
        }
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\n' && c != '\r') {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断TextView是不是null
     */
    public static boolean isEmptyTv(TextView tv) {
        return isEmpty(tv.getText().toString().trim());
    }


    /**
     * 字符串拆分
     *
     * @param string   ,需要拆分的字符串，以"@"为例
     * @param splitter ,分割字符集"@"
     */
    public static List<String> getStringList(String string, String splitter) {
        List<String> list = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(string, splitter);
        while (st.hasMoreElements()) {
            list.add(st.nextToken());
        }
        return list;
    }

    /**
     * 截取一个字符串中最后一个splitter之前的所有字符串
     *
     * @param splitter
     */
    public static String getStrBeforeSplitter(String oriStr, String splitter) {
        if (! isEmpty(oriStr)) {
            return oriStr.substring(0, oriStr.lastIndexOf(splitter));
        }
        return "";
    }

    public static String getStrLeSplitter(String oriStr, String splitter) {
        if (! isEmpty(oriStr)) {
            return oriStr.substring(oriStr.lastIndexOf(splitter) + 1, oriStr.length());
        }
        return "";
    }

    public static String trimHTTP(String originStr) {
        if (isEmpty(originStr)) {
            return "";
        }
        String newStr = originStr.replace("http://", "");
        newStr = newStr.replace("https://", "");
        if (newStr.length() > 15) {
            newStr = newStr.substring(0, 15);
        }
        return newStr;
    }

    /** 截取从// 开始以后的15个字符 */
    public static String getStr15(String oriStr, String splitter) {
        if (! isEmpty(splitter)) {
            int i = splitter.indexOf(oriStr) + 2;
//            if (splitter.length() > 15) {
//                return splitter.substring(i, 15 + i);
//            } else {
                return splitter.substring(i, splitter.length() - 1);
//            }
        }
        return "";
    }


    /**
     * 两个文本值比较
     *
     * @param one
     * @param two
     * @return 如果有null 则直接返回false，成功返回true
     */
    public static boolean sameStr(String one, String two) {
        return one == null || two == null ? false : one.equals(two);
    }

    /**
     * 验证手机号是否匹配
     *
     * @param phone
     * @param isPhone：是否支持固话验证
     * @return ：true 手机号是正确的，false 手机号不正确
     */
    public static boolean mobilePhone(String phone, boolean isPhone) {
        String regStr;
        if (isPhone == true) {
            regStr = moblie1;
        } else {
            regStr = moblie2;
        }
        return phone == null || phone.trim().equals("") ? false : phone.replaceAll(regStr, "").equals("");
    }

    public static boolean isSex(String string) {
        return string == null ? false : string.equalsIgnoreCase("W") ? false : true;
    }

    /**
     * 验证是否有中文
     *
     * @param pwd
     * @return true 有  false 没有
     */
    public static boolean hasChinese(String pwd) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(pwd);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否含有特殊字符
     *
     * @param str
     * @return true为包含，false为不包含
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 判断是否属于标准的网址
     *
     * @return
     */
    public static boolean httpUrl(String date) {
        return isEmpty(date) ? false : date.replaceAll(url, "").equals("");
    }

    private static final String moblie1 = "^(0\\d{2,3}\\d{7,8})|(((13[0-9])|(15([0-3]|[5-9]))|(18[0-9])|(17[0-9])|(14[0-9]))\\d{8})$";
    private static final String moblie2 = "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0-9])|(17[0-9])|(14[0-9]))\\d{8})$";
    private static final String email   = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

    private static final String url = "^(http|https|ftp)\\://([a-zA-Z0-9\\.\\-]+(\\:[a-zA-Z0-9\\.&%\\$\\-]+)*@)?((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|([a-zA-Z0-9\\-]+\\.)*[a-zA-Z0-9\\-]+\\.[a-zA-Z]{2,4})(\\:[0-9]+)?(/[^/][a-zA-Z0-9\\.\\,\\?\\'\\\\/\\+&%\\$\\=~_\\-@]*)*$";

    public static final String imageType = ".*(.jpg|.jpeg|.png|.gif|.bmp)$";
    public static final String videoType = ".*(.avi|.mp4|.mpeg|.mpg|.mov|.flv|.swf|.rmvb)$";
    public static final String audioType = ".*(.mp3|.wma)$";
    public static final String pdfType   = ".*(.pdf)$";
    public static final String wordType  = ".*(.doc|.docx)$";
    public static final String pptType   = ".*(.ppt|.pptx|.dps)$";
    public static final String excleType = ".*(.xls|.xlsx)$";
    public static final String wpsType   = ".*(.wps)$";
    public static final String txtType   = ".*(.txt)$";
    public static final String swfType   = ".*(.swf)$";

    //判断文件格式
    public static boolean isFileType(String file, String fileType) {
        if (file == null)
            return false;
        return Pattern.matches(fileType, file.toLowerCase());
    }

    public static String isImageUrl(String imageUrl) {
        return imageUrl.replaceAll("#[0-9#]+$", "");
    }

    /**
     * 提取一个字符串中的所有数字
     *
     * @param dayofmonth
     */
    public static List<String> getNumbers(String dayofmonth) {
        List<String> digitList = new ArrayList<String>();
        String[] nums = dayofmonth.split("\\D+");
        for (String num : nums) {
            digitList.add(num);
        }
        return digitList;
    }


    /**
     * 周历中显示日期
     *
     * @param start
     * @param end
     * @param month
     * @return
     */
    public static List<Integer> getDayOfMonth(int start, int end, int month) {
        List<Integer> days = new ArrayList<Integer>();
        if (start == end)
            return days;

        if (start - end < 0) {
            for (int i = start; i < end + 1; i++) {
                days.add(i);
            }
            return days;
        } else {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                //31天
                for (int i = start; i <= end + 31; i++) {
                    int j = i;
                    if (i > 31) {
                        j = i - 31;
                    }
                    days.add(j);
                }
                return days;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                //30天
                for (int i = start; i <= end + 30; i++) {
                    int j = i;
                    if (i > 30) {
                        j = i - 30;
                    }
                    days.add(j);
                }
                return days;
            } else {
                //2月
                if (end + 29 - start == 6) {
                    //29天
                    for (int i = start; i <= end + 29; i++) {
                        int j = i;
                        if (i > 29) {
                            j = i - 29;
                        }
                        days.add(j);
                    }
                    return days;
                } else if (end + 28 - start == 6) {
                    //28天
                    for (int i = start; i <= end + 28; i++) {
                        int j = i;
                        if (i > 28) {
                            j = i - 28;
                        }
                        days.add(j);
                    }
                    return days;
                }
            }
        }
        return days;
    }

    /**
     * 判断是不是邮箱
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (StringUtil.isEmpty(email))
            return false;
        Pattern p = Pattern.compile(StringUtil.email);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * URL检查<br>
     * <br>
     *
     * @param pInput 要检查的字符串<br>
     * @return boolean   返回检查结果<br>
     */
    public static boolean isUrl(String pInput) {
        if (pInput == null) {
            return false;
        }
        Pattern p = Pattern.compile(url);
        Matcher matcher = p.matcher(pInput);
        return matcher.matches();
    }
}
