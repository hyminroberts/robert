package com.hymin.practice

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagOperationUtil {
    /**
     * To replace the specified attribute value of the specified HTML tag.
     * @param str source string
     * @param tag tag name
     * @param tagAttrib attribute name
     * @param oldAttrValue old attribute value
     * @param newAttrValue new value of the specified attribute
     * @return new replaced string
     */
    public static String replaceHtmlTagAttrValue(String str, String tag, String tagAttrib, String oldAttrValue, String newAttrValue) {
        String regxpForTag = "<\\s*" + tag + "\\s+([^>]*)\\s*";
        String regxpForTagAttrib = tagAttrib + "=\\s*\"([^\"]+)\"";
        Pattern patternForTag = Pattern.compile(regxpForTag, Pattern.CASE_INSENSITIVE);
        Pattern patternForAttrib = Pattern.compile(regxpForTagAttrib, Pattern.CASE_INSENSITIVE);   
        Matcher matcherForTag = patternForTag.matcher(str);
        StringBuffer sb = new StringBuffer();
        boolean result = matcherForTag.find();
        while (result) {
            StringBuffer sbreplace = new StringBuffer("<" + tag + " ");
            Matcher matcherForAttrib = patternForAttrib.matcher(matcherForTag.group(1));
            if (matcherForAttrib.find()) {
                String attributeStr = matcherForAttrib.group(1);
                matcherForAttrib.appendReplacement(sbreplace, tagAttrib + "=\\\"" + (oldAttrValue.equalsIgnoreCase(attributeStr) ? newAttrValue  : attributeStr) + "\"");
            }
            matcherForAttrib.appendTail(sbreplace);
            matcherForTag.appendReplacement(sb, sbreplace.toString());
            result = matcherForTag.find();
        }
        matcherForTag.appendTail(sb);         
        return sb.toString();
    }

}