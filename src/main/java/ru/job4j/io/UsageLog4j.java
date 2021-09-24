package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        byte byteNum = 5;
        short shNum = 3235;
        Long longNum = 424239495246456575L;
        float flNum = 3456345635.225335456f;
        char chNum = 'u';
        boolean bo = false;
        double dbleNum = 234.45;
        LOG.debug("User info name : {}, age : {}, byte : {}, short : {}, Long : {},"
                 + " float : {}, char : {}, boolean : {}, double : {}", name, age, byteNum,
                shNum, longNum, flNum, chNum, bo, dbleNum);
    }
}
