{\rtf1\ansi\ansicpg949\cocoartf2821
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 import java.io.BufferedReader;\
import java.io.IOException;\
import java.io.InputStreamReader;\
import java.util.Collections;\
import java.util.PriorityQueue;\
import java.util.StringTokenizer;\
\
public class Main \{\
    public static void main(String[] args) throws IOException \{\
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));\
        StringBuilder sb = new StringBuilder();\
        int n = Integer.parseInt(br.readLine());\
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());\
        for (int i = 0; i < n; i++) \{\
            StringTokenizer st = new StringTokenizer(br.readLine());\
            int a = Integer.parseInt(st.nextToken());\
            if (a == 0) \{\
                sb.append(q.isEmpty() ? -1 : q.poll()).append("\\n");\
                continue;\
            \}\
\
            for (int k = 0; k < a; k++) \{\
                q.add(Integer.parseInt(st.nextToken()));\
            \}\
        \}\
\
        System.out.print(sb);\
    \}\
\}}