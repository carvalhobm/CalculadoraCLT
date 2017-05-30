package com.brunocarvalho.calculadoraclt.util;


import android.util.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StringUtil {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));

    private static final NumberFormat df = NumberFormat.getInstance();
    private static final NumberFormat intF = NumberFormat.getIntegerInstance();

    static {
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        df.setRoundingMode(RoundingMode.HALF_UP);
    }


    public static String formatNumberToString(final Object number) {
        String formatedNumber = "0,0";

        if (number instanceof BigDecimal) {
            final BigDecimal bdNumber = (BigDecimal) number;
            formatedNumber = df.format(bdNumber);
        } else if (number instanceof Integer) {
            final Integer intNumber = (Integer) number;
            formatedNumber = intF.format(intNumber);
        }

        return formatedNumber;
    }

    public static String formatDateToString(final Date dateToFormat) {
        return sdf.format(dateToFormat);
    }

    public static Date formatStringToDate(final String date) {
        Date dateFormated = new Date();

        try {
            dateFormated = sdf.parse(date);
        } catch (ParseException e) {
            Log.e("#CalcCLT:StringUtil", e.getLocalizedMessage());
        }

        return dateFormated;
    }

}
