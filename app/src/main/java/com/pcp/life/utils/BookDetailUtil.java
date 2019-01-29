package com.pcp.life.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookDetailUtil {

    public static String setContent(String content){

        StringBuffer buffer = new StringBuffer("");

        if (content.length() != 0 && content != null){
            String[] authorContentArr = content.split("\n");
            for (String subText : authorContentArr) {
//                SpannableStringBuilder span = new SpannableStringBuilder("缩进"+subText);
//                span.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFF")), 0, 2,
//                        Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

                buffer.append("\u3000\u3000" + subText+"\n");
            }

            return buffer.toString();

        }else {
            buffer.append("无");

            return buffer.toString();
        }
    }

    public static String formatListToString(List<String> list){

        StringBuffer stringBuffer = new StringBuffer("");

        if (list.size() == 0){

            return stringBuffer.append("无记录").toString();

        }else if(list.size() == 1){

            return stringBuffer.append(list.get(0)).toString();

        }else{//有2个以上

            for (String string : list) {

                stringBuffer.append(string + " ");

            }
            return stringBuffer.toString();

        }
    }

    public static boolean isNumeric(String str) {

        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }


}
